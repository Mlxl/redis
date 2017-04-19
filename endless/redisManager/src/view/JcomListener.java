//package view;
//
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JTable;
//import javax.swing.table.TableModel;
//
//import model.ServerManage;
//
//public class JcomListener implements ItemListener{
//	
//	private JTable table;
//	
//	public JcomListener(JTable t){
//		this.table=t;
//	}
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		List<String> list=new ArrayList<String>();
//		int i=table.getSelectedRow();
//		if(i!=-1){ 
//		if(e.getStateChange()==ItemEvent.SELECTED){
//			
//			//System.out.println("初始值"+i);
//			Object s=table.getModel().getValueAt(i,3);
//			System.out.println(s);
//			if(e.getItem()=="主节点"){
//				if(s!=null) list=this.find(s, i);
//			}else if(e.getItem()=="从节点"){
//				//无主节点时，值为空格
//				if(s==" "){	
//					list.add(table.getModel().getValueAt(i,1).toString());
//				}
//			}
//		}
//		for(int i1=0;i1<list.size();i1++){
//			System.out.println("List:"+list.get(i1));
//		}
//		//将命令拼接成字符串
//		String s="redis-cli -h 10.9.1.25 -p 8002 shutdown;cd ~/Documents/clu/8002;redis-server redis.conf";
//		ServerManage sm=new ServerManage();
//		sm.exec(s);
////		for(int i1=0;i1<list.size();i1++){
////			System.out.println("杀死："+list.get(i1));
////			ServerManage sm=new ServerManage(list.get(i1));
////			sm.killServer();
////		}
////		for(int i1=0;i1<list.size();i1++){
////			System.out.println("启动："+list.get(i1));
////			ServerManage smg=new ServerManage(list.get(i1));
//				smg.setServer();
////		}
//		}
//	}
//	//找到该节点的主节点，以及主节点下的从节点
//	public List find(Object s,int i){
//		List<String> list=new ArrayList<String>();
//		TableModel model=table.getModel();
//		for(int j=0;j<model.getRowCount();j++){
//			if(model.getValueAt(j,3)==s&&i!=j){
//				list.add(model.getValueAt(j,1).toString());
//				System.out.println(model.getValueAt(j, 1));
//			}
//		}
//		for(int k=0;k<model.getRowCount();k++){
//			if(model.getValueAt(k, 0)==s)
//				list.add(model.getValueAt(k,1).toString());
//		}
//		
//		return list;
//	}
//	
//}
