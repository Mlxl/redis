package model;
//找到redis 集群中的所有key
import java.util.ArrayList;
import java.util.List;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
//key名相关
public class Keys {
	//存储所有的keys信息
	private List<String> keysname=new ArrayList<String>();
	private List<NodeInfomation> info;
	@SuppressWarnings("rawtypes")
	private  List<List> master=new ArrayList<List>();
	public Keys(){
		
		CollectData data=new CollectData();
		info=data.getNodesInfo();
		searchMaster();
		searchKeys();
	}
	
	
	//获取所有主节点
	private void searchMaster(){
		System.out.println(info.size());
		for(int i=0;i<info.size();i++){
			if(info.get(i).getRoles().startsWith("主")){
				List<String> l=new ArrayList<String>();
				l.add(info.get(i).getIP());
				l.add(info.get(i).getPort());
				master.add(l);
			}
		}
	}
	
	//获取所有key名
	private void searchKeys(){
		for(int i=0;i<master.size();i++){
			Jedis jedis=new Jedis(master.get(i).get(0).toString(),Integer.parseInt(master.get(i).get(1).toString()));
			Object [] o=jedis.keys("*").toArray();
			for(int s=0;s<o.length;s++){
				keysname.add(o[s].toString());
			}
			try{
				jedis.close();
			}catch(Exception e){
				System.out.println("jedis关闭失败");
			}
		}
	}
	
	public List<String> getKeysName(){
		return this.keysname;
	}
	
	//返回key的数据类型
	public String getKeyType(String s){
		if(!this.keysname.contains(s)) return null;
		JedisCluster cluster=new Connect().getCluster();
		String str=cluster.type(s);
		try{
			cluster.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
}










