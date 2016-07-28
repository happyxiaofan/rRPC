package com.rhwayfun.rRPC.common.redis.impl;

import org.springframework.stereotype.Service;

import com.rhwayfun.rRPC.service.RedisTestService;

/**
 * RedisTestService实现类
 * @ClassName: RedisTestServiceImpl 
 * @Description: TODO
 * @author rhwayfun
 * @date 2016年7月28日 下午5:37:05 
 *
 */
@Service
public class RedisTestServiceImpl implements RedisTestService {

	@Override
	public String getTimeStamp(String param) {
		Long time = System.currentTimeMillis();
		return time.toString();
	}

}
