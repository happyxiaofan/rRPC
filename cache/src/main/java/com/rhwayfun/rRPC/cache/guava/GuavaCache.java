package com.rhwayfun.rRPC.cache.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * Guava cache本地缓存实例
 * @ClassName: GuavaCache 
 * @Description: TODO
 * @author rhwayfun
 * @date 2016年7月27日 下午1:38:22 
 *
 */
public class GuavaCache<K,V> {

	private Cache<K, V> guavaCache = CacheBuilder.newBuilder()
			.maximumSize(2)	// 设置条目数
			.expireAfterWrite(10, TimeUnit.SECONDS) // 设置失效时间
			.expireAfterAccess(10, TimeUnit.MINUTES) // 设置时效时间，如果超过这个时间没有被访问，会被移除缓存
			.removalListener(new RemovalListener<K, V>() {	// 移除缓存监听器
				public void onRemoval(RemovalNotification<K, V> notification) {
					System.out.println("----------有缓存数据被移除了-----------");
				} 
			})
			.build(
					/*new CacheLoader<K, V>(){ //通过回调加载缓存
		                @SuppressWarnings("unchecked")
						@Override
		                public V load(K key) throws Exception {
		                    return (V)(key + "-" + "cache");
		                }
		        }*/
					);
	
	/**
	 * 使用Guava cache获取数据
	 * @Title: getCache 
	 * @Description: TODO
	 * @param keyValue
	 * @param threadName
	 * @return
	 * @throws
	 */
	public Object getCache(K keyValue, final String threadName){
		System.out.println(threadName + "------获取缓存------");
		Object value = null;
		try {
			// 从缓存中获取数据
			value = guavaCache.get(keyValue, new Callable<V>(){
				public V call() {
					System.out.println(threadName + "------从数据源获取数据------");
					return (V) "dataValue";
				}
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args){
		GuavaCache<String, String> gcache = new GuavaCache<String, String>();
		Object cache1 = gcache.getCache("key","t1");
		Object cache2 = gcache.getCache("key","t2");
		Object cache3 = gcache.getCache("key","t3");
		System.out.println("t1---cache---:" + cache1);
		System.out.println("t2---cache---:" + cache2);
		System.out.println("t3---cache---:" + cache3);
	}
}
