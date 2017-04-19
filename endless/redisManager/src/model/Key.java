package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//数据库key操作
public class Key {
	//private String type;
	private String keyname;
	
	public Key(String s){
		this.keyname=s;
	}
	
	public String getType(){
		 try{
			return Connect.cluster.type(keyname);
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
		Connect.cluster.set(keyname, value);
	}
	
	public void setZset(double score,String member){
		System.out.println(score);
		System.out.println(member);
		System.out.println(keyname);
		Connect.cluster.zadd(keyname, score, member);
	}
	
	public void setListleft(String s){
		Connect.cluster.lpush(keyname, s);
	}
	
	public void setListRigh(String s){
		Connect.cluster.rpush(keyname, s);
	}
	
	public void setHash(String field,String value){
		Connect.cluster.hset(keyname, field, value);
	}
	
	public void setSet(String member){
		Connect.cluster.sadd(keyname, member);
	}
	
	public void delSet(String s){
		Connect.cluster.srem(keyname, s);
	}
	public void delHash(String field){
		Connect.cluster.hdel(keyname, field);
	}
	public void delZset(String member){
		Connect.cluster.zrem(keyname, member);
	}
	
	public void delListLef(){
		Connect.cluster.lpop(keyname);
	}
	public void delListrigh(){
		Connect.cluster.rpop(keyname);
	}
	public List<List<String>> stringGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		String str=Connect.cluster.get(keyname);
		//System.out.println(str);
		List<String> l= new ArrayList<String>();
		l.add(str);
		list.add(l);
		return list;
	}
	
	public List<List<String>> hashGet(){
		Set<String> set=Connect.cluster.hkeys(keyname);
		List<List<String>> list=new ArrayList<List<String>>();
		Object[] arry=set.toArray();
		for(int i=0;i<arry.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(arry[i].toString());
			l.add(Connect.cluster.hget(keyname,arry[i].toString()));
			list.add(l);
		}
		
		return list;
	}
	
	public List<List<String>> listGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		Object o[]=Connect.cluster.lrange(keyname, 0,-1).toArray();
		for(int i=0;i<o.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(o[i].toString());
			list.add(l);
		}
		return list;
	}
	
	public List<List<String>> setGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		Object o[]=Connect.cluster.smembers(keyname).toArray();
		for(int i=0;i<o.length;i++){
			List <String>l=new ArrayList<String>();
			l.add(o[i].toString());
			list.add(l);
		}
		
		return list;
	}
	
	public List<List<String>> zsetGet(){
		List<List<String>> list=new ArrayList<List<String>>();
		Object o[]=Connect.cluster.zrange(keyname, 0, -1).toArray();
		for(int i=0;i<o.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(Connect.cluster.zscore(keyname, o[i].toString()).toString());
			l.add(o[i].toString());
			list.add(l);
		}
		return list;
		
	}
}













