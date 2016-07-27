package com.rhwayfun.rRPC.cache.rcache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个基于ConcurrentHashMap的本地缓存实现
 * @ClassName: Rcache 
 * @Description: TODO
 * @author rhwayfun
 * @date 2016年7月26日 下午4:18:55 
 * @version V1.0
 */
public class Rcache<K,V> {

	private final ConcurrentHashMap<K, V> localCache = new ConcurrentHashMap<K, V>();
	
	/**
	 * 根据key返回缓存中的数据
	 * @Title: getCache 
	 * @Description: TODO
	 * @param keyValue
	 * @param currentThread
	 * @return
	 * @throws
	 */
	public Object getCache(K keyValue, String currentThread){
		System.out.println(currentThread + "------获取缓存------");
		Object cacheObject = null;
		// 从缓存中获取数据
	    cacheObject = localCache.get(keyValue);
	    // 如果缓存中没有找到相应的数据，则把从数据源获取的数据放入缓存中
	    if(cacheObject == null){
	    	return putCache(keyValue, currentThread);
	    }
		return cacheObject;
	}

	private Object putCache(K keyValue, String currentThread) {
		System.out.println(currentThread + "------从数据源获取数据------");
		// 用dataValue表示从数据源返回的数据
		@SuppressWarnings("unchecked")
		V value = (V) "dataValue";
		localCache.put(keyValue, value);
		return value;
	}
}
