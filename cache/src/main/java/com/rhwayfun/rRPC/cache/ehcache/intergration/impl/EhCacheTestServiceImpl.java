package com.rhwayfun.rRPC.cache.ehcache.intergration.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rhwayfun.rRPC.service.EhcacheTestService;

@Service
public class EhCacheTestServiceImpl implements EhcacheTestService {

	@Cacheable(value="cacheTest", key="#param")
	public String getTimestamp(String param) {
		Long currentTimeMillis = System.currentTimeMillis();
		return currentTimeMillis.toString();
	}

}
