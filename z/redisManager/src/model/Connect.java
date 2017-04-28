package model;

import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class Connect {
	public Connect(){
		
	}
	
	public JedisCluster getCluster(){
		JedisPoolConfig poolConfig = new JedisPoolConfig(); 
		
	    // 最大连接数  
	    poolConfig.setMaxTotal(10);  
	    // 最大空闲数  
	    poolConfig.setMaxIdle(3);  
	    // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：  
	    // Could not get a reso-urce from the pool  
	    poolConfig.setMaxWaitMillis(1000); 
	    poolConfig.setTestOnBorrow(true);
	    
	    //设置连接池
	    //用ConectInfo构造连接池节点集合
	    ConectInfo conectInfo=new ConectInfo();
	    Set<HostAndPort> nodes=conectInfo.setHostPort();
	    
	    //创建cluster对象
	   return new JedisCluster(nodes,poolConfig);
	}
}
