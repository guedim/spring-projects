package com.guedim.client;

import java.util.List;

public interface ProfileRepository {
	List<Profile> getAllProfiles();
	Profile getProfile(String userId);
}