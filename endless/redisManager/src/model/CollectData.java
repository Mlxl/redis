//负责对cluster nodes返回值进行解析
package model;

import java.util.ArrayList;
import java.util.List;

public class CollectData {
	//解析后的数据
	public static List<NodeInfomation> info=new ArrayList<NodeInfomation>();
	
	
	private String[] str=new String[6];
	private int number=6;
	public CollectData(String string){
		count(string);
		String[] str1=this.enterSplit(string);
		CollectData.info=divice(str1);
		findMaster(info);
	}
	//计算有几组数据并实例化str
	public void count(String cln){
		int n=0;
		if(cln.length()==0) this.number=0;
		else{
			for(int enter=0;enter!=-1;n++){
				enter=cln.indexOf("\n",enter+1);
				
			}
			//貌似是因为字符串末尾带有一个 \n
			this.number=n-1;
		}
		str=new String [number];
	}
	//分行
	public String [] enterSplit(String cln){
		 int enter=0;
		    //将字符串按照\n分开
		    for(int i=0,j=0;i<number-1;i++){
		    	j=enter;
		    	enter=cln.indexOf("\n",enter+1);
		    	if(j==0)str[i]=cln.substring(j,enter);
		    	else str[i]=cln.substring(j+1,enter);
		    }
		    str[number-1]=cln.substring(enter+1,cln.length());
		    return	str;
	}
	
	//将每一组数据按照空格分开，并且收集
	public List<NodeInfomation> divice(String[] str){
		List <NodeInfomation> nodeinfo=new ArrayList<NodeInfomation>();
		String s;
		for(int i=0;i<number;i++){
			
			NodeInfomation node=new NodeInfomation();
			for(int k=0,j=0,blank=0;blank!=-1;k++){
				j=blank;
				blank=str[i].indexOf(" ",blank+1);
				if(j==0) s=str[i].substring(j, blank);
				else if(blank==-1) s=str[i].substring(j+1,str[i].length());
				    else	s=str[i].substring(j+1, blank);
				//为从节点设置slotf值
				node.setSlotf(" ");
				switch (k){
	    		
				case 0: node.setID(s);break;
	    		case 1: node.setLocation(s);break;
	    		case 2:	node.setRoles(s.endsWith("er"));break;
	    		case 3:	if(!node.getRoles().startsWith("主")) {
	    					node.setMasterID(s);break;}
	    		        else   node.setMasterID("   ");;
	    		case 8:	node.setSlotf(s);break;
				}
			}
			nodeinfo.add(node);
		}
		return nodeinfo;
	}
	//设置找到主节点
	public void findMaster(List<NodeInfomation> ma){
		for(int i=0;i<ma.size();i++){
			if(ma.get(i).getRoles().startsWith("从")){
				for(int j=0;j<ma.size();j++){
					if(ma.get(i).getMasterID().equals(ma.get(j).getID()))
						ma.get(i).setMaster("节点"+String.valueOf(j));
				}
			}
			else ma.get(i).setMaster(" ");
			
		}
	}
	
}
