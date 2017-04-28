package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.JedisCluster;

//数据库key操作,key值内的操作
public class Key {
	//private String type;
	private String keyname;
	private JedisCluster cluster;
	public Key(String s){
		this.keyname=s;
		cluster=new Connect().getCluster();
	}
	
	public String getType(){
		 try{
			return cluster.type(keyname);
		 }catch(Exception e){
			 System.out.println(keyname+"不是redis中的key");
		 }
		 return null;
	}
	public String getKeyname(){
		return this.keyname;
	}
	public List<List<String>> getKeyValue(){
		//System.out.println("getKeyValue");
		switch(getType()){
		case "string":return stringGet();
		case "hash":;return hashGet(); 
		case "list":;return listGet();
		case "set" :;return setGet();
		case "zset":;return zsetGet();
		default:return null;
		}
	}
	


	
	//向数据库中保存数据
	public void setString(String value){
		cluster.set(keyname, value);
	}
	
	public void setZset(double score,String member){
		System.out.println(score);
		System.out.println(member);
		System.out.println(keyname);
		cluster.zadd(keyname, score, member);
	}
	
	public void setListleft(String s){
		cluster.lpush(keyname, s);
	}
	
	public void setListRigh(String s){
		cluster.rpush(keyname, s);
	}
	
	public void setHash(String field,String value){
		cluster.hset(keyname, field, value);
	}
	
	public void setSet(String member){
		cluster.sadd(keyname, member);
	}
	
	public void delSet(String s){
		cluster.srem(keyname, s);
	}
	public void delHash(String field){
		cluster.hdel(keyname, field);
	}
	public void delZset(String member){
		cluster.zrem(keyname, member);
	}
	
	public void delListLef(){
		cluster.lpop(keyname);
	}
	public void delListrigh(){
		cluster.rpop(keyname);
	}
	public void delString(){
		cluster.del(keyname);
	}
	public List<List<String>> stringGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		String str=cluster.get(keyname);
		//System.out.println(str);
		List<String> l= new ArrayList<String>();
		l.add(str);
		list.add(l);
		return list;
	}
	
	public List<List<String>> hashGet(){
		Set<String> set=cluster.hkeys(keyname);
		List<List<String>> list=new ArrayList<List<String>>();
		Object[] arry=set.toArray();
		for(int i=0;i<arry.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(arry[i].toString());
			l.add(cluster.hget(keyname,arry[i].toString()));
			list.add(l);
		}
		
		return list;
	}
	
	public List<List<String>> listGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		Object o[]=cluster.lrange(keyname, 0,-1).toArray();
		for(int i=0;i<o.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(o[i].toString());
			list.add(l);
		}
		return list;
	}
	
	public List<List<String>> setGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		Object o[]=cluster.smembers(keyname).toArray();
		for(int i=0;i<o.length;i++){
			List <String>l=new ArrayList<String>();
			l.add(o[i].toString());
			list.add(l);
		}
		
		return list;
	}
	
	public List<List<String>> zsetGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		Object o[]=cluster.zrange(keyname, 0, -1).toArray();
		for(int i=0;i<o.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(cluster.zscore(keyname, o[i].toString()).toString());
			l.add(o[i].toString());
			list.add(l);
		}
		return list;
		
	}
	protected void finalize(){
		try{
			cluster.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}













