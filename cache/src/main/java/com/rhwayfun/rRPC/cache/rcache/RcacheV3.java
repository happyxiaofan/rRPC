package com.rhwayfun.rRPC.cache.rcache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 
 * @ClassName: RcacheV3
 * @Description: TODO
 * @author rhwayfun
 * @date 2016年7月26日 下午4:55:26
 * @version V3.0
 */
public class RcacheV3<K, V> {

	private final ConcurrentHashMap<K, Future<V>> localCache = new ConcurrentHashMap<K, Future<V>>();

	/**
	 * 根据key返回缓存中的数据 
	 * @Title: getCache 
	 * @Description: TODO 
	 * @param keyValue
	 * @param currentThread 
	 * @return Object
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public Object getCache(K keyValue, String currentThread) {
		System.out.println(currentThread + "------获取缓存------");
		Future<V> cacheObject = null;
		// 从缓存中获取数据
		cacheObject = localCache.get(keyValue);
		try {
			// 如果缓存中没有找到相应的数据，则把从数据源获取的数据放入缓存中
			if (cacheObject == null) {
				cacheObject =  putCache(keyValue, currentThread);
				return cacheObject.get();
			}
			return cacheObject.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Future<V> putCache(K keyValue, final String currentThread) {
		Future<V> value = null;
		// 用dataValue表示从数据源返回的数据
		Callable<V> callable = new Callable<V>() {
			public V call() throws Exception {
				System.out.println(currentThread + "------从数据源获取数据------");
				return (V) "dataValue";
			}
		};
		FutureTask<V> task = new FutureTask<V>(callable);
		value = localCache.putIfAbsent(keyValue, task);
		if(value == null){
			value = task;
			task.run();
		}
		return value;
	}
}
