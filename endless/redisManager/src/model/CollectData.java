//�����cluster nodes����ֵ���н���
package model;

import java.util.ArrayList;
import java.util.List;

public class CollectData {
	//�����������
	public static List<NodeInfomation> info=new ArrayList<NodeInfomation>();
	
	
	private String[] str=new String[6];
	private int number=6;
	public CollectData(String string){
		count(string);
		String[] str1=this.enterSplit(string);
		CollectData.info=divice(str1);
		findMaster(info);
	}
	//�����м������ݲ�ʵ����str
	public void count(String cln){
		int n=0;
		if(cln.length()==0) this.number=0;
		else{
			for(int enter=0;enter!=-1;n++){
				enter=cln.indexOf("\n",enter+1);
				
			}
			//ò������Ϊ�ַ���ĩβ����һ�� \n
			this.number=n-1;
		}
		str=new String [number];
	}
	//����
	public String [] enterSplit(String cln){
		 int enter=0;
		    //���ַ�������\n�ֿ�
		    for(int i=0,j=0;i<number-1;i++){
		    	j=enter;
		    	enter=cln.indexOf("\n",enter+1);
		    	if(j==0)str[i]=cln.substring(j,enter);
		    	else str[i]=cln.substring(j+1,enter);
		    }
		    str[number-1]=cln.substring(enter+1,cln.length());
		    return	str;
	}
	
	//��ÿһ�����ݰ��տո�ֿ��������ռ�
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
				//Ϊ�ӽڵ�����slotfֵ
				node.setSlotf(" ");
				switch (k){
	    		
				case 0: node.setID(s);break;
	    		case 1: node.setLocation(s);break;
	    		case 2:	node.setRoles(s.endsWith("er"));break;
	    		case 3:	if(!node.getRoles().startsWith("��")) {
	    					node.setMasterID(s);break;}
	    		        else   node.setMasterID("   ");;
	    		case 8:	node.setSlotf(s);break;
				}
			}
			nodeinfo.add(node);
		}
		return nodeinfo;
	}
	//�����ҵ����ڵ�
	public void findMaster(List<NodeInfomation> ma){
		for(int i=0;i<ma.size();i++){
			if(ma.get(i).getRoles().startsWith("��")){
				for(int j=0;j<ma.size();j++){
					if(ma.get(i).getMasterID().equals(ma.get(j).getID()))
						ma.get(i).setMaster("�ڵ�"+String.valueOf(j));
				}
			}
			else ma.get(i).setMaster(" ");
			
		}
	}
	
}
