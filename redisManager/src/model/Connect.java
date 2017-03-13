package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class Connect {
	private List<NodeInfomation> nodeinfomation=new ArrayList<NodeInfomation>();
	public Connect(){
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
	    
	    Set<HostAndPort> nodes=new LinkedHashSet<HostAndPort>();
	    nodes.add(new HostAndPort("10.9.1.25", 8000));  
	    nodes.add(new HostAndPort("10.9.1.25", 8001));  
	    nodes.add(new HostAndPort("10.9.1.25", 8002));  
	    nodes.add(new HostAndPort("10.9.1.25", 8003));  
	    nodes.add(new HostAndPort("10.9.1.25", 8004));  
	    nodes.add(new HostAndPort("10.9.1.25", 8005));   
	    JedisCluster cluster = new JedisCluster(nodes,poolConfig);
	    //用jedis 获取cluster nodes 信息
	    Jedis jedis=new Jedis("10.9.1.25",8000);
	    String clusterNodes=jedis.clusterNodes();
	    //对信息进行整理
	    CollectData coll=new CollectData(clusterNodes); 
	    
	    this.nodeinfomation=coll.getInfo();
	    	
	    try {  
	    	jedis.close();
	        cluster.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
	public List<NodeInfomation> getInfomation(){
		return this.nodeinfomation;
	}
}
