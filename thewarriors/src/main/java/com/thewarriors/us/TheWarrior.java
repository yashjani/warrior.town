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

import com.thewarriors.us.entity.Photo;
import com.thewarriors.us.repo.PhotoRepository;
import com.thewarriors.us.repo.SumoLayerRepository;
import com.thewarriors.us.service.MetadataService;
import com.thewarriors.us.service.PhotoService;
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
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		
		SpringApplication.run(TheWarrior.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//photoService.saveName();
	//	metadataService.addNewLayers();
		//svgCreationService.dfs(0, new HashSet<>(), ColorConstants.bronzeOrder, new Stack<>(), "", "","Bronze");
		svgCreationService.dfs(0, new HashSet<>(), ColorConstants.silverOrder, new Stack<>(), "", "","Silver");	
		//svgCreationService.dfs(0, new HashSet<>(), ColorConstants.goldOrder, new Stack<>(), "", "","Gold");
		
	}

}
