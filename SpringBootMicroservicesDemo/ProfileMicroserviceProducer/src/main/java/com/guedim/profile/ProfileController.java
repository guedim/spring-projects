package com.guedim.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@RequestMapping("/profiles")
	public Profile[] all() {
		List<Profile> profiles = profileRepository.getAllProfiles();
		return profiles.toArray(new Profile[profiles.size()]);
	}
	
	@RequestMapping("/profiles/{id}")
	public Profile byId(@PathVariable("id") String userId) {
		Profile profile = profileRepository.getProfile(userId);
		return profile;
	}
}