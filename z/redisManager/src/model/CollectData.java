//负责对cluster nodes返回值进行解析
package model;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

public class CollectData {
	//解析后的数据
//	public static List<NodeInfomation> info=new ArrayList<NodeInfomation>();
	
	private String []str;
	
	public CollectData(){
		
	}
	//返回解析后的信息
	public List<NodeInfomation> getNodesInfo(){
		str=getClusterNodes().split("\n");
		List<NodeInfomation> list=new ArrayList<NodeInfomation>();
		for(int i=0;i<str.length;i++){
			String[] s=str[i].split(" ");
			NodeInfomation node=new NodeInfomation();
			for(int j=0;j<s.length;j++){
				
				switch (j){
	    		
				case 0: node.setID(s[j]);break;
	    		case 1: node.setLocation(s[j]);break;
	    		case 2:	node.setRoles(s[j].endsWith("er"));break;
	    		case 3:	if(!node.getRoles().startsWith("主")) {
	    					node.setMasterID(s[j]);break;}
	    		        else   node.setMasterID("   ");;
	    		case 8:	node.setSlotf(s[j]);break;
				}
			}
			list.add(node);
		}
		findMaster(list);
		return list;
	}
	//从集群获取信息
	public String getClusterNodes(){
		
	    ConectInfo conectInfo=new ConectInfo();
	    Jedis jedis=conectInfo.getJedis();
	    //获得cluster nodes 返回信息
	    String clusterNodes=jedis.clusterNodes();
	    try {  
	    	jedis.close();
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }
	    return clusterNodes;
	}
	//设置找到主节点
	public void findMaster(List<NodeInfomation> ma){
		for(int i=0;i<ma.size();i++){
			if(ma.get(i).getRoles().startsWith("从")){
				for(int j=0;j<ma.size();j++){
					if(ma.get(i).getMasterID().equals(ma.get(j).getID()))
						ma.get(i).setMaster(ma.get(j).getLocation());
				}
			}
			else ma.get(i).setMaster(" ");
			
		}
	}
	
}
