package com.zdy.service;

import java.util.List;

import com.zdy.entity.Resources;

public interface ResourceManager {

	public List<Resources> getResourceAll(Long userId);

}
