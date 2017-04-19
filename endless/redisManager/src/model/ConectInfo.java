//用于保存连接界面输入的连接节点数据
package model;

import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

public class ConectInfo {
	//节点
	public static String s[][]={{"10.9.1.25","8000"},{"10.9.1.25","8001"},{"10.9.1.25","8002"},{"10.9.1.25","8003"},{"10.9.1.25","8004"},{"10.9.1.25","8005"}};
	
	public ConectInfo(){
		
	}
	
//	public Object getHost(int i){
//		return  ((Vector)conninfo.get(i)).get(1);
//	}
	//建立HostAndPo
	public Set<HostAndPort> setHostPort(){
		try{
			Set<HostAndPort> nodes=new LinkedHashSet<HostAndPort>();
			for(int i=0;i<s.length;i++){
				nodes.add(new HostAndPort(s[i][0],Integer.parseInt(s[i][1])));
			}
			return nodes;
		}catch(Exception e){
			
			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!以后可添加弹窗警告
			return null;
		}	
	}
	//返回一个jedis实例
	public Jedis getJedis(){
		return this.getJedis(0);
	}
	public Jedis getJedis(int i){
		if(i<s.length){
			try{
				return new Jedis(s[i][0],Integer.parseInt(s[i][1]));
			}catch(Exception e){
				return getJedis(++i);
			}
		}
		return null;
	}
}
