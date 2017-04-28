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
		
	    // ���������  
	    poolConfig.setMaxTotal(10);  
	    // ��������  
	    poolConfig.setMaxIdle(3);  
	    // �������ȴ�ʱ�䣬����������ʱ�仹δ��ȡ�����ӣ���ᱨJedisException�쳣��  
	    // Could not get a reso-urce from the pool  
	    poolConfig.setMaxWaitMillis(1000); 
	    poolConfig.setTestOnBorrow(true);
	    
	    //�������ӳ�
	    //��ConectInfo�������ӳؽڵ㼯��
	    ConectInfo conectInfo=new ConectInfo();
	    Set<HostAndPort> nodes=conectInfo.setHostPort();
	    
	    //����cluster����
	   return new JedisCluster(nodes,poolConfig);
	}
}
