//package model;
//
//import java.io.IOException;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPoolConfig;
//
//public class ZInfomation {
//	public static void main (String args[]){
//		JedisPoolConfig poolConfig = new JedisPoolConfig(); 
//		
//	    // ���������  
//	    poolConfig.setMaxTotal(10);  
//	    // ��������  
//	    poolConfig.setMaxIdle(3);  
//	    // �������ȴ�ʱ�䣬����������ʱ�仹δ��ȡ�����ӣ���ᱨJedisException�쳣��  
//	    // Could not get a reso-urce from the pool  
//	    poolConfig.setMaxWaitMillis(1000); 
//	    poolConfig.setTestOnBorrow(true);
//	    Set<HostAndPort> nodes=new LinkedHashSet<HostAndPort>();
//	    nodes.add(new HostAndPort("10.9.1.25", 8000));  
//	    nodes.add(new HostAndPort("10.9.1.25", 8001));  
//	    nodes.add(new HostAndPort("10.9.1.25", 8002));  
//	    nodes.add(new HostAndPort("10.9.1.25", 8003));  
//	    nodes.add(new HostAndPort("10.9.1.25", 8004));  
//	    nodes.add(new HostAndPort("10.9.1.25", 8005));   
//	    JedisCluster cluster = new JedisCluster(nodes,poolConfig);  
//	    Jedis jedis=new Jedis("10.9.1.25",8000);
//	    String clusterNodes=jedis.clusterNodes();
//	    System.out.print(clusterNodes);
//	    CollectData collect=new CollectData(clusterNodes);
//	    
//	    try {  
//	    	jedis.close();
//	        cluster.close();  
//	    } catch (IOException e) {  
//	        e.printStackTrace();  
//	    } 
//	}
//}
//
//
