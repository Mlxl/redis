//package reconnecte;
///**
// * Create
// */
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//public class Test {
//	
//	public static void main(String args[]){
//	    
//	    JedisPoolConfig config=new JedisPoolConfig();
//	    //���������
//	    config.setMaxTotal(5);
//	    //��������
//	    config.setMaxIdle(5);
//	    //�������ȴ�ʱ��
//	    config.setMaxWaitMillis(1000);
//	    JedisPool pool=new JedisPool(config,"10.9.1.25",6379);
//	    Jedis jedis=null;
//	    try{
//	    	for(int i=0;i<5;i++){
//	    		jedis=pool.getResource();
//	    		jedis.set("name"+i, "liqing"+i);
//	    		System.out.println("��"+i+"�����ӣ��õ���ֵΪ��"+jedis.get("name"+i));
//	    		jedis.close();
//	    	}
//	    	}catch(Exception e){
//	    		e.printStackTrace();
//	    	}finally{
//	    		pool.close();
//	    	}
//	    
//	}
//}	