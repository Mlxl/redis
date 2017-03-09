package model;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class Infomation {
	public static void main (String args[]){
		JedisPoolConfig poolConfig = new JedisPoolConfig(); 
		
	    // ���������  
	    poolConfig.setMaxTotal(10);  
	    // ��������  
	    poolConfig.setMaxIdle(3);  
	    // �������ȴ�ʱ�䣬����������ʱ�仹δ��ȡ�����ӣ���ᱨJedisException�쳣��  
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
	    JedisCluster cluster = new JedisCluster(nodes,poolConfig);  
	    Jedis jedis=new Jedis("10.9.1.25",8000);
	    String clusterNodes=jedis.clusterNodes();
	    System.out.print(clusterNodes);

	    char info[]=clusterNodes.toCharArray();
	    char a[];
	    NodeInfomation nodeinfo[]={new NodeInfomation(),new NodeInfomation(),
	    		new NodeInfomation(),
	    		new NodeInfomation(),new NodeInfomation(),new NodeInfomation(),
	    		new NodeInfomation(),new NodeInfomation()};
	    for(int i=0,j=0,k=0,l=0;i<info.length;i++){
	    	a=new char[60];
	    	if(info[i]!=' '&&info[i]!='\n'){
	    		
	    		a[k]=info[i];
	    		k++;//��¼a[]�Ĵ���
	    	}
	    	else if(info[i]=='\n'){
	    		j++;//�����±�
	    		l=0;
	    	}
	    	//Ϊ�ո�
	    	else {
	    		
		    		switch (l){
		    		
		    		case 0: nodeinfo[j].setID(new String(a));break;
		    		case 1: nodeinfo[j].setlocation(new String(a));break;
		    		case 2:	nodeinfo[j].setRoles(new String(a).endsWith("er"));break;
		    		case 3:	if(!nodeinfo[j].isRoles()) {
		    					nodeinfo[j].setMasterID(new String(a));break;}
		    		        else   break;
		    		case 8:	nodeinfo[j].setSlotf(new String(a));break;
		    		
		    		}
		    		k=0;l++;
		    	}
	    }
	  
//	    System.out.println(nodeinfo[0].getID());
//	    System.out.println(nodeinfo[0].getlocation());
//	    System.out.println(nodeinfo[0].getMasterID());
//	    System.out.println(nodeinfo[0].getSlotf());

	    try {  
	    	jedis.close();
	        cluster.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
}


