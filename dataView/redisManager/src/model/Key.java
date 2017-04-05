package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//���ݿ�key����
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
			 System.out.println(keyname+"����redis�е�key");
		 }
		 return null;
	}
	public List getKeyValue(){
		switch(getType()){
		case "string":return stringGet();
		case "hash":;return hashGet(); 
		case "list":;return listGet();
		case "set" :;return setGet();
		case "zset":;return zsetGet();
		default:return null;
		}
	}
	

	public List stringGet(){
		List<List> list=new ArrayList<List>();
		String str=Connect.cluster.get(keyname);
		//System.out.println(str);
		List<String> l= new ArrayList<String>();
		l.add(str);
		list.add(l);
		return list;
	}
	
	public List hashGet(){
		Set set=Connect.cluster.hkeys(keyname);
		List<List> list=new ArrayList<List>();
		Object[] arry=set.toArray();
		for(int i=0;i<arry.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(arry[i].toString());
			l.add(Connect.cluster.hget(keyname,arry[i].toString()));
			list.add(l);
		}
		
		return list;
	}
	
	public List listGet(){
		List<List> list=new ArrayList<List>();
		Object o[]=Connect.cluster.lrange(keyname, 0,-1).toArray();
		for(int i=0;i<o.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(o[i].toString());
			list.add(l);
		}
		return list;
	}
	
	public List setGet(){
		List<String> list=new ArrayList<String>();
		Object o[]=Connect.cluster.smembers(keyname).toArray();
		for(int i=0;i<o.length;i++){
			list.add(o[i].toString());
		}
		return list;
	}
	
	public List zsetGet(){
		List<List> list=new ArrayList<List>();
		Object o[]=Connect.cluster.zrange(keyname, 0, -1).toArray();
		for(int i=0;i<o.length;i++){
			List<String> l=new ArrayList<String>();
			l.add(o[i].toString());
			l.add(Connect.cluster.zscore(keyname, o[i].toString()).toString());
			list.add(l);
		}
		return list;
	}
}
