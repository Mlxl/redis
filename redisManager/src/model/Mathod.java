package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class Mathod {
	public static void main (String args[])throws Exception{
		JedisPoolConfig poolConfig = new JedisPoolConfig(); 
		
	    // 最大连接数  
	    poolConfig.setMaxTotal(10);  
	    // 最大空闲数  
	    poolConfig.setMaxIdle(3);  
	    // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：  
	    // Could not get a reso-urce from the pool  
	    poolConfig.setMaxWaitMillis(1000); 
	    poolConfig.setTestOnBorrow(true);
	    Set<HostAndPort> nodes=new LinkedHashSet<HostAndPort>();
	    nodes.add(new HostAndPort("10.9.1.25", 8000));  
	    nodes.add(new HostAndPort("10.9.1.25", 8001));  
	    nodes.add(new HostAndPort("10.9.1.25", 8002));  
	    nodes.add(new HostAndPort("10.9.1.25", 8003));  
	    nodes.add(new HostAndPort("10.9.1.25", 8004));  
	    nodes.add(new HostAndPort("10.9.1.25", 8005));   
	    JedisCluster cluster1 = new JedisCluster(nodes,poolConfig);  
	    Jedis jedis=new Jedis("10.9.1.25",8000);
	    String cln=jedis.clusterNodes();
	   
	    String str[]=new String [6];
	    int enter=0;
	    //将jedis字符串按照\n分开
	    for(int i=0,j=0;i<5;i++){
	    	j=enter;
	    	enter=cln.indexOf("\n",enter+1);
	    	if(j==0)str[i]=cln.substring(j,enter);
	    	else str[i]=cln.substring(j+1,enter);
	    	//System.out.println(str[i]);
	    }
	    str[5]=cln.substring(enter+1,cln.length());

	    List<NodeInfomation> n=divice(str);	  
	    Iterator<NodeInfomation> it= n.iterator();
		while(it.hasNext()){
			NodeInfomation no=it.next();
			System.out.print(no.getID());
			System.out.print(no.getlocation());
			System.out.print(no.isRoles());
			System.out.print(no.getMasterID());
			System.out.println(no.getSlotf());	
		}
	    
		jedis.close();
		cluster1.close();
	}
	//将Str[]依照空格分开，并将节点信息写入list
	public static List<NodeInfomation> divice(String[] str){
		List <NodeInfomation> nodeinfo=new ArrayList<NodeInfomation>();
		String s;
		for(int i=0;i<str.length;i++){
			
			NodeInfomation node=new NodeInfomation();
			for(int k=0,j=0,blank=0;blank!=-1;k++){
				j=blank;
				blank=str[i].indexOf(" ",blank+1);
				if(j==0) s=str[i].substring(j, blank);
				else if(blank==-1) s=str[i].substring(j+1,str[i].length());
				    else	s=str[i].substring(j+1, blank);
				switch (k){
	    		
				case 0: node.setID(s);break;
	    		case 1: node.setlocation(s);break;
	    		case 2:	node.setRoles(s.endsWith("er"));break;
	    		case 3:	if(!node.isRoles()) {
	    					node.setMasterID(s);break;}
	    		        else   break;
	    		case 8:	node.setSlotf(s);break;
				}
			}
			nodeinfo.add(node);
		}
		return nodeinfo;
	}
}
