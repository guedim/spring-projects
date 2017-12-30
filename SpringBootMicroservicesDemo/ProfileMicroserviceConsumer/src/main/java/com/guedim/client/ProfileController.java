package com.guedim.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/userProfiles")
	public String profileList(Model model) {
		model.addAttribute("profiles", profileRepository.getAllProfiles());
		return "userProfiles";
	}
	
	@RequestMapping("/userDetails")
	public String profileDetails(@RequestParam("id") String userId, Model model) {
		model.addAttribute("profile", profileRepository.getProfile(userId));
		return "userDetails";
	}
}
