package com.thewarriors.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thewarriors.us.service.PhotoService;

@RestController
@CrossOrigin(origins = { "https://www.warrior.town" })
public class UploadController {

	@Autowired
	PhotoService photoService;
	
	@GetMapping(path = "/summary")
	public String  getUserSummary() {
		return "yash";
	}
	
}
