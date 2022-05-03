package com.thewarriors.us.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thewarriors.us.dto.SkinToneDto;

public class LayerConstants {
	
	public static List<String> goldOrder = new ArrayList<>();
	public static List<String> silverOrder = new ArrayList<>();
	public static List<String> bronzeOrder = new ArrayList<>();
	public static Map<String, List<SkinToneDto>> skinColorTone = new HashMap<>();
	public static String[] types = {"GOLD", "SILVER", "BRONZE"};
	public static String TYPE = "TYPE";
	public static String COLOR = "COLOR";


	public static Map<String, String> backGroundColorMap = new HashMap<>();

	static {
		goldOrder.add("Background");
		goldOrder.add("Back_Weapon");
		goldOrder.add("Right_leg");
		goldOrder.add("Left_leg");
		goldOrder.add("Weapon");
		goldOrder.add("Right_hand");
		goldOrder.add("Tummy");
		goldOrder.add("Chest");
		goldOrder.add("Nipple");
		goldOrder.add("Face");
		goldOrder.add("Eye");
		goldOrder.add("Clothing");
		goldOrder.add("Scar");
		goldOrder.add("Belt");
		goldOrder.add("Beard");
		goldOrder.add("Hairstyle");
		goldOrder.add("Body_glow");
		
		silverOrder.add("Background");
		silverOrder.add("Back_Weapon");
		silverOrder.add("Right_leg");
		silverOrder.add("Left_leg");
		silverOrder.add("Weapon");
		silverOrder.add("Right_hand");
		silverOrder.add("Tummy");
		silverOrder.add("Chest");
		silverOrder.add("Nipple");
		silverOrder.add("Face");
		silverOrder.add("Eye");
		silverOrder.add("Clothing");
		silverOrder.add("Belt");
		silverOrder.add("Beard");
		silverOrder.add("Hairstyle");
		silverOrder.add("Body_glow");
		
		bronzeOrder.add("Background");
		bronzeOrder.add("Back_Weapon");
		bronzeOrder.add("Right_leg");
		bronzeOrder.add("Left_leg");
		bronzeOrder.add("Weapon");
		bronzeOrder.add("Right_hand");
		bronzeOrder.add("Tummy");
		bronzeOrder.add("Chest");
		bronzeOrder.add("Nipple");
		bronzeOrder.add("Face");
		bronzeOrder.add("Eye");
		bronzeOrder.add("Clothing");
		bronzeOrder.add("Belt");
		bronzeOrder.add("Beard");
		bronzeOrder.add("Hairstyle");
		bronzeOrder.add("Body_glow");
		
		backGroundColorMap.put("Mountain.svg", "146,196,246");
		backGroundColorMap.put("Sun.svg", "161,220,244");
		backGroundColorMap.put("Tree.svg", "148,219,255");
		backGroundColorMap.put("Night in desert.svg", "12,67,111");
		backGroundColorMap.put("Mountain desert.svg", "239,196,138");
		backGroundColorMap.put("Sea.svg", "105,164,255");
		
		List<SkinToneDto> goldSkin = new ArrayList<>();
		
//		goldSkin.add(new SkinToneDto("Bismark", "77,110,129"));
//		goldSkin.add(new SkinToneDto("Vogue", "34,60,75"));
//		goldSkin.add(new SkinToneDto("Bisque", "255,223,196"));
//		goldSkin.add(new SkinToneDto("Champagne", "240,213,190"));
//		goldSkin.add(new SkinToneDto("Desert Sand", "238,206,179"));
//		goldSkin.add(new SkinToneDto("Pancho", "225,184,153"));
		goldSkin.add(new SkinToneDto("Colonial White", "229,194,152"));
//		goldSkin.add(new SkinToneDto("Navajo White", "255,220,178"));
//		goldSkin.add(new SkinToneDto("Maize", "229,184,135"));
//		goldSkin.add(new SkinToneDto("Dark Salmon", "229,160,115"));
//		goldSkin.add(new SkinToneDto("Copper", "219,144,101"));
//		goldSkin.add(new SkinToneDto("Feldspar", "206,150,124"));
//		goldSkin.add(new SkinToneDto("Japonica", "198,120,86"));
//		goldSkin.add(new SkinToneDto("Blue Lighter", "77,110,129"));
//		goldSkin.add(new SkinToneDto("Flame Pea", "186,108,73"));
//		goldSkin.add(new SkinToneDto("Au Chico", "165,114,87"));
//		goldSkin.add(new SkinToneDto("Petite Orchid", "221,168,160"));
//		goldSkin.add(new SkinToneDto("Brandy Rose", "185,124,109"));
//		goldSkin.add(new SkinToneDto("Coral Tree", "168,117,108"));
//		goldSkin.add(new SkinToneDto("Sante Fe", "173,100,82"));
//		goldSkin.add(new SkinToneDto("Dark Brown", "92,56,54"));
//		goldSkin.add(new SkinToneDto("Peru", "203,132,66"));
//		goldSkin.add(new SkinToneDto("Brandy Punch", "189,114,60"));
		goldSkin.add(new SkinToneDto("Bole", "112,65,57"));
//		goldSkin.add(new SkinToneDto("Sandal", "163,134,106"));		
		
		List<SkinToneDto> silverSkin = new ArrayList<>();

		silverSkin.add(new SkinToneDto("Sunset", "191,75,84"));
		silverSkin.add(new SkinToneDto("Red Berry", "120,31,38"));
		silverSkin.add(new SkinToneDto("Blue Lighter", "77,110,129"));
		silverSkin.add(new SkinToneDto("Bisque", "255,223,196"));
		silverSkin.add(new SkinToneDto("Champagne", "240,213,190"));
		silverSkin.add(new SkinToneDto("Desert Sand", "238,206,179"));
		silverSkin.add(new SkinToneDto("Pancho", "225,184,153"));
		silverSkin.add(new SkinToneDto("Colonial White", "229,194,152"));
		silverSkin.add(new SkinToneDto("Navajo White", "255,220,178"));
		silverSkin.add(new SkinToneDto("Maize", "229,184,135"));
		silverSkin.add(new SkinToneDto("Dark Salmon", "229,160,115"));
		silverSkin.add(new SkinToneDto("Copper", "219,144,101"));
//		silverSkin.add(new SkinToneDto("Feldspar", "206,150,124"));
//		silverSkin.add(new SkinToneDto("Japonica", "198,120,86"));
//		silverSkin.add(new SkinToneDto("Flame Pea", "186,108,73"));
//		silverSkin.add(new SkinToneDto("Au Chico", "165,114,87"));
//		silverSkin.add(new SkinToneDto("Petite Orchid", "221,168,160"));
//		silverSkin.add(new SkinToneDto("Brandy Rose", "185,124,109"));
//		silverSkin.add(new SkinToneDto("Coral Tree", "168,117,108"));
//		silverSkin.add(new SkinToneDto("Sante Fe", "173,100,82"));
//		silverSkin.add(new SkinToneDto("Dark Brown", "92,56,54"));
//		silverSkin.add(new SkinToneDto("Peru", "203,132,66"));
//		silverSkin.add(new SkinToneDto("Brandy Punch", "189,114,60"));
//		silverSkin.add(new SkinToneDto("Bole", "112,65,57"));
//		silverSkin.add(new SkinToneDto("Sandal", "163,134,106"));	

		List<SkinToneDto> bronzeSkin = new ArrayList<>();
		
		bronzeSkin.add(new SkinToneDto("Lusty", "120,46,44"));
//		bronzeSkin.add(new SkinToneDto("Pixie Green", "184,211,169"));
		bronzeSkin.add(new SkinToneDto("Olivetone", "116,113,40"));
//		bronzeSkin.add(new SkinToneDto("Blue Lighter", "77,110,129"));
//		bronzeSkin.add(new SkinToneDto("Blue Darker", "34,60,75"));
//		bronzeSkin.add(new SkinToneDto("Bisque", "255,223,196"));
		bronzeSkin.add(new SkinToneDto("Champagne", "240,213,190"));
//		bronzeSkin.add(new SkinToneDto("Desert Sand", "238,206,179"));
		bronzeSkin.add(new SkinToneDto("Pancho", "225,184,153"));
//		bronzeSkin.add(new SkinToneDto("Colonial White", "229,194,152"));
		bronzeSkin.add(new SkinToneDto("Navajo White", "255,220,178"));
//		bronzeSkin.add(new SkinToneDto("Maize", "229,184,135"));
		bronzeSkin.add(new SkinToneDto("Dark Salmon", "229,160,115"));
//		bronzeSkin.add(new SkinToneDto("Copper", "219,144,101"));
		bronzeSkin.add(new SkinToneDto("Feldspar", "206,150,124"));
//		bronzeSkin.add(new SkinToneDto("Japonica", "198,120,86"));
		bronzeSkin.add(new SkinToneDto("Blue Lighter", "77,110,129"));
//		bronzeSkin.add(new SkinToneDto("Flame Pea", "186,108,73"));
		bronzeSkin.add(new SkinToneDto("Au Chico", "165,114,87"));
//		bronzeSkin.add(new SkinToneDto("Petite Orchid", "221,168,160"));
//		bronzeSkin.add(new SkinToneDto("Brandy Rose", "185,124,109"));
//		bronzeSkin.add(new SkinToneDto("Coral Tree", "168,117,108"));
//		bronzeSkin.add(new SkinToneDto("Sante Fe", "173,100,82"));
//		bronzeSkin.add(new SkinToneDto("Dark Brown", "92,56,54"));
//		bronzeSkin.add(new SkinToneDto("Peru", "203,132,66"));
//		bronzeSkin.add(new SkinToneDto("Brandy Punch", "189,114,60"));
//		bronzeSkin.add(new SkinToneDto("Bole", "112,65,57"));
//		bronzeSkin.add(new SkinToneDto("Sandal", "163,134,106"));	

		
		skinColorTone.put("GOLD", goldSkin);
		skinColorTone.put("BRONZE", bronzeSkin);
		skinColorTone.put("SILVER", silverSkin);

	}
}
