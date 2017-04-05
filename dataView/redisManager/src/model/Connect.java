//�ṩ����ǰ�����ӵĽӿ�
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
	//���þ�̬���ӣ����رգ�����Ƶ�����ӣ�����漰��ӽڵ���ܳ�������
	public static  JedisCluster cluster;
	public Connect(){
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
	    cluster = new JedisCluster(nodes,poolConfig);
	    
	    //��jedis ��ȡcluster nodes ��Ϣ
	    Jedis jedis=conectInfo.getJedis();
	    String clusterNodes=jedis.clusterNodes();
	   
	    //����Ϣ���н���,�洢��Collection�ľ�̬������
	    @SuppressWarnings("unused")
		CollectData coll=new CollectData(clusterNodes); 
	    	   
	    try {  
	    	jedis.close();
	        //cluster.close();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } 
	}
}
