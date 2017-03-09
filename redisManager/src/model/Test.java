package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String args[]){
		String str[]={
"b164294df1122bf63cc88ae6766920f1e8819712 10.9.1.25:8002 master - 0 1489042288835 3 connected 10923-16383",
"592fa3faf36ebde916475a6ba5a157f8e9eabe50 10.9.1.25:8005 slave b164294df1122bf63cc88ae6766920f1e8819712 0 1489042290246 6 connected"};
		String s;
		List<NodeInfomation> nodeinfo=new ArrayList<NodeInfomation>();
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
		Iterator<NodeInfomation> it= nodeinfo.iterator();
		while(it.hasNext()){
			NodeInfomation n=it.next();
			System.out.println(n.getID());
			System.out.println(n.getSlotf());
			
		}
	}
}









//class ma{
//		public  List<NodeInfomation> divice(String [] str){
//			List<NodeInfomation> nodeinfo=new ArrayList<NodeInfomation>();
//			String s;
//			for(int i=0;i<str.length;i++){
//				//NodeInfomation node=new NodeInfomation();
//				for(int k=0,j=0,blank=0;blank!=-1;k++){
//					j=blank;
//					blank=str[i].indexOf(" ",blank+1);
//					if(j==0) s=str[i].substring(j, blank);
//					else if(blank==-1) s=str[i].substring(j+1,str[i].length());
//					    else	s=str[i].substring(j+1, blank);
//					System.out.println(s);
//					switch (k){
//		    		
//						case 0: node.setID(s);break;
//			    		case 1: node.setlocation(s);break;
//			    		case 2:	node.setRoles(s.endsWith("er"));break;
//			    		case 3:	if(!node.isRoles()) {
//			    					node.setMasterID(s);break;}
//			    		        else   break;
//			    		case 8:	node.setSlotf(s);break;
//		    		
//		    		}
//				}
//				//nodeinfo.add(node);
//			}
//			return nodeinfo; 
//}
//

