package com.edubridge.mixergrinder.dao;

import java.util.List;

import com.edubridge.mixergrinder.model.MixerGrinder;


public interface MixerGrinderDao {
	int addMixer(MixerGrinder m);
	List<MixerGrinder> getAllMixer();
	MixerGrinder getMixer(String name);
	int updateMixer(MixerGrinder m);
	MixerGrinder searchMixer(String name);
}
