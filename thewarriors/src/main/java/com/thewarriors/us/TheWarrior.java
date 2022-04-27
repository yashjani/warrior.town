package com.thewarriors.us;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thewarriors.us.repo.PhotoRepository;
import com.thewarriors.us.repo.SumoLayerRepository;
import com.thewarriors.us.service.MetadataService;
import com.thewarriors.us.service.PhotoService;
import com.thewarriors.us.service.QRCodeService;
import com.thewarriors.us.service.SVGCreationService;
import com.thewarriors.us.utility.ColorConstants;

@SpringBootApplication
public class TheWarrior implements ApplicationRunner {

	@Autowired
	PhotoService photoService;
	
	@Autowired
	SVGCreationService svgCreationService;
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	SumoLayerRepository sumoLayerRepository;
	
	@Autowired
	MetadataService metadataService;
	
	@Autowired
	QRCodeService codeService;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		
		SpringApplication.run(TheWarrior.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//String qr = codeService.getQRCodeSvg("255,255,255", "www.google.com", 150, 150, true);
		//photoService.saveName();
	   // metadataService.addNewLayers();
		//new File("./sumo/Bronze/output/aws").mkdir();
		//new File("./sumo/Bronze/output/opensea").mkdir();
	//	svgCreationService.dfs(0, new HashSet<>(), ColorConstants.bronzeOrder, new Stack<>(), "", "","Bronze");
//	    new File("./sumo/Silver/output").mkdir();
//		new File("./sumo/Silver/output/aws").mkdir();
//		new File("./sumo/Silver/output/opensea").mkdir();
//		svgCreationService.dfs(0, new HashSet<>(), ColorConstants.silverOrder, new Stack<>(), "", "","Silver");	
//		new File("./sumo/Gold/output/aws").mkdir();
//		new File("./sumo/Gold/output/opensea").mkdir();
//		svgCreationService.dfs(0, new HashSet<>(), ColorConstants.goldOrder, new Stack<>(), "", "","Gold");
		
	}

}
