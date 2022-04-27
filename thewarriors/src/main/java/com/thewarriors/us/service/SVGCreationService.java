package com.thewarriors.us.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewarriors.us.dto.SkinToneDto;
import com.thewarriors.us.entity.Photo;
import com.thewarriors.us.utility.ColorConstants;

@Service
public class SVGCreationService {

	@Autowired
	MetadataService metadataService;
	
	@Autowired
	QRCodeService qrCodeService;
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	ImageTransparency imageTransparency;

	public String backGroundColor;
	
	public void dfs(int index, Set<String> visited, List<String> order, Stack<Map.Entry<String, String>> stack,
			String result, String path, String type) {
		if (index >= order.size()) {
			visited.add(path);
			File file = new File("./sumo/" + type + "/output/");
			if (file.mkdir()) {
				System.out.println("The new directory is created.");
			}
			colorSvg(result, "./sumo/" + type + "/output/", stack, type);
			return;
		}
		File root = new File("./sumo/" + type + "/layer/" + order.get(index));
		File[] listOfFilesAndDirectory = root.listFiles();
		if (listOfFilesAndDirectory != null) {
			for (File file : listOfFilesAndDirectory) {
				if(file == null || file.isHidden()) { 
					file.delete();
        			continue;
        		}
				if (file.getAbsoluteFile().toString().contains("Background")) {
					backGroundColor = ColorConstants.backGroundColorMap.get(file.getName());
				}
				if (visited.contains(file.getPath())) {
					continue;
				}
				try {
					result += "<!-- Remove me " + order.get(index) + "-->";
					result += Files.readString(Path.of(file.getPath()));
					String separator = "\\";
					String[] arr = file.getPath().replaceAll(Pattern.quote(separator), "\\\\").split("/");
					int length = arr.length;
					Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<String, String>(arr[length - 2],
							arr[length - 1]);
					stack.push(entry);
				} catch (Exception e) {
					e.printStackTrace();
				}
				path += order.get(index) + "/" + file.getName();
				dfs(1 + index, visited, order, stack, result, new String(path), type);
				int remove = result.indexOf("<!-- Remove me " + order.get(index) + "-->");
				result = result.substring(0, remove);
				if (!stack.isEmpty())
					stack.pop();
			}

		}
	}

	public void colorSvg(String result, String outputPath, Stack<Map.Entry<String, String>> stack, String type) {
		String header = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" "
				+ "viewBox=\"0 0 1800 1800\">";
		String footer = "</svg>";
		
		// creates a file object with specified path
		File file = new File(outputPath + "/svg");
		if (file.mkdir()) {
			System.out.println("The new directory is created.");
		} 

		file = new File(outputPath + "/json");
		if (file.mkdir()) {
			System.out.println("The new directory is created.");
		} 
		List<SkinToneDto> colorList = ColorConstants.skinColorTone.get(type);
		for (int i = 0; i < colorList.size(); i++) {
			Photo photo = photoService.getUnUsedPhoto(type);
			String tempResult = qrCodeService.getQRCodeSvg(backGroundColor, 
					"https://www.warrior.town/gallery/details?id=" + photo.getId(), 150, 150, true);
			String content = header + result + tempResult +footer;
			String name = photo.getId()+"_" + photo.getName().split(" ")[1] +"_"+ photo.getType();
			Path fileName = Path.of(outputPath + "/svg/" + name + ".svg");
			Path jsonFile = Path.of(outputPath + "/json/" + name + ".json");
			String[] stringColor = colorList.get(i).getRgbColor().split(",");
			int[] intColor = new int[3];
			for (int j = 0; j < stringColor.length; j++) {
				intColor[j] = Integer.valueOf(stringColor[j]);
			}

			String skin = "rgb(" + Arrays.toString(intColor).replace("[", "").replace("]", "") + ")";
			content = content.replaceAll("#f2a184", skin);

			int[] skin_dark_color = { intColor[0] - 25, intColor[1] - 25, intColor[2] - 25 };
			String skin_dark = "rgb(" + Arrays.toString(skin_dark_color).replace("[", "").replace("]", "") + ")";
			content = content.replaceAll("#df9276", skin_dark);

			int[] skin_darker_color = { intColor[0] - 40, intColor[1] - 40, intColor[2] - 40 };
			String skin_darker = "rgb(" + Arrays.toString(skin_darker_color).replace("[", "").replace("]", "") + ")";
			content = content.replaceAll("#ac6951", skin_darker);

			int[] skin_darkest_color = { intColor[0] - 50, intColor[1] - 50, intColor[2] - 50 };
			String skin_darkest = "rgb(" + Arrays.toString(skin_darkest_color).replace("[", "").replace("]", "") + ")";
			content = content.replaceAll("#8c3515", skin_darkest);
			String json = metadataService.createJSONObject(photo, stack, type,colorList.get(i).getColorName());
			try {
				Files.writeString(fileName, content);
			    Files.writeString(jsonFile, json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("One round completed");
	}

}
