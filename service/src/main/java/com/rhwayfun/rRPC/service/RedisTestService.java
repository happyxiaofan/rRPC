package com.rhwayfun.rRPC.service;

/**
 * Redis测试接口
 * @ClassName: RedisTestService 
 * @Description: TODO
 * @author rhwayfun
 * @date 2016年7月28日 下午5:35:30 
 *
 */
public interface RedisTestService {

	/**
	 * 根据传入的参数返回时间戳的字符串表示
	 * @Title: getTimeStamp 
	 * @Description: TODO
	 * @param param
	 * @return
	 * @throws
	 */
	String getTimeStamp(String param);
}
