package com.thewarriors.us;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;

import com.thewarriors.us.dto.LayerDto;
import com.thewarriors.us.dto.LayersDto;
import com.thewarriors.us.repo.PhotoRepository;
import com.thewarriors.us.repo.SumoLayerRepository;
import com.thewarriors.us.service.MetadataService;
import com.thewarriors.us.service.PhotoService;

@SpringBootApplication
@EnableCaching
public class TheWarrior implements ApplicationRunner {

	@Autowired
	PhotoService photoService;

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
	

	}
	
	
	public void setUpCache() {
		photoRepository.findByIsUsed(true);
		List<LayersDto> layers = metadataService.getLayers();
		for(LayersDto layersDto : layers) {
			for(LayerDto layerDto : layersDto.getLayers()) {
				sumoLayerRepository.findByTypeAndDescription(layersDto.getLayerType(), layerDto.getLayerName());
			}
		}
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("hello world, I have just started up");
		setUpCache();
	}
}
