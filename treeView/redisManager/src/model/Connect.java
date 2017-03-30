//提供货给前端连接的接口
package model;

import java.io.IOException;
import java.util.ArrayList;
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
	    //用ConectInfo构造连接池节点集合
	    ConectInfo conectInfo=new ConectInfo();
	    Set<HostAndPort> nodes=conectInfo.setHostPort();
	    
	    //创建cluster对象
	    JedisCluster cluster = new JedisCluster(nodes,poolConfig);
	    Set s=cluster.hkeys("*");
	    System.out.println("1");
	    	System.out.println(s.toString());

		    System.out.println("1");
	    //用jedis 获取cluster nodes 信息
	    Jedis jedis=conectInfo.getJedis();
	    String clusterNodes=jedis.clusterNodes();
	    Set ss=jedis.keys("*");
	    System.out.println(ss.toString());
	    //对信息进行整理
	    CollectData coll=new CollectData(clusterNodes); 
	    
	    this.nodeinfomation=coll.getInfo();
	   
	    try {  
	    	//jedis.close();
	        cluster.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
	public List<NodeInfomation> getInfomation(){
		return this.nodeinfomation;
	}
}
