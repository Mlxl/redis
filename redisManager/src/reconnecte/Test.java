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
//	    //最大连接数
//	    config.setMaxTotal(5);
//	    //最大空闲数
//	    config.setMaxIdle(5);
//	    //最大允许等待时间
//	    config.setMaxWaitMillis(1000);
//	    JedisPool pool=new JedisPool(config,"10.9.1.25",6379);
//	    Jedis jedis=null;
//	    try{
//	    	for(int i=0;i<5;i++){
//	    		jedis=pool.getResource();
//	    		jedis.set("name"+i, "liqing"+i);
//	    		System.out.println("第"+i+"个连接，得到的值为："+jedis.get("name"+i));
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