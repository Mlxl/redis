package model;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class S{
	public S(){
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
	    
	    Set<HostAndPort> nodes=new LinkedHashSet<HostAndPort>();
	    nodes.add(new HostAndPort("10.9.1.25", 8000));  
	    nodes.add(new HostAndPort("10.9.1.25", 8001));  
	    nodes.add(new HostAndPort("10.9.1.25", 8002));  
	    nodes.add(new HostAndPort("10.9.1.25", 8003));  
	    nodes.add(new HostAndPort("10.9.1.25", 8004));  
	    nodes.add(new HostAndPort("10.9.1.25", 8005));   
	    JedisCluster cluster = new JedisCluster(nodes,poolConfig);
	    String s=cluster.rpop("list");
	    System.out.println(s);
	    //��jedis ��ȡcluster nodes ��Ϣ
//	    Jedis jedis=new Jedis("10.9.1.25",8004);
//	    Set set=jedis.keys("*");
//	    Object[] a=set.toArray();
//	    System.out.println(jedis.type("string1"));
//	    for(int i=0;i<a.length;i++){
//	    	System.out.println(a[i]);
//	    	//System.out.println(jedis.type(a[i].toString()));
//	    }
//	    for(int i=0;i<a.length;i++){
//	    	
//	    	System.out.println(jedis.type("zset"));
//	    }
	    
	    
	    //����ֵΪ[]
//	    Set set=cluster.hkeys("*");
//	    System.out.println(set.toString());
	    
	    try {  
	    	//jedis.close();
	        cluster.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
	private String node[][]={
			{"10.9.1.25","8000"},
			{"10.9.1.25","8001"},
			{"10.9.1.25","8002"},
			{"10.9.1.25","8003"},
			{"10.9.1.25","8004"},
			{"10.9.1.25","8005"}
	};
	public static void main(String args[]){
		S s=new S();
	}
}