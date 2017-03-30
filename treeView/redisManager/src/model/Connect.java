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
	private List<NodeInfomation> nodeinfomation=new ArrayList<NodeInfomation>();
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
	    JedisCluster cluster = new JedisCluster(nodes,poolConfig);
	    Set s=cluster.hkeys("*");
	    System.out.println("1");
	    	System.out.println(s.toString());

		    System.out.println("1");
	    //��jedis ��ȡcluster nodes ��Ϣ
	    Jedis jedis=conectInfo.getJedis();
	    String clusterNodes=jedis.clusterNodes();
	    Set ss=jedis.keys("*");
	    System.out.println(ss.toString());
	    //����Ϣ��������
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
