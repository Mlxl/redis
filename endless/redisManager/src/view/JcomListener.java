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
//			//System.out.println("��ʼֵ"+i);
//			Object s=table.getModel().getValueAt(i,3);
//			System.out.println(s);
//			if(e.getItem()=="���ڵ�"){
//				if(s!=null) list=this.find(s, i);
//			}else if(e.getItem()=="�ӽڵ�"){
//				//�����ڵ�ʱ��ֵΪ�ո�
//				if(s==" "){	
//					list.add(table.getModel().getValueAt(i,1).toString());
//				}
//			}
//		}
//		for(int i1=0;i1<list.size();i1++){
//			System.out.println("List:"+list.get(i1));
//		}
//		//������ƴ�ӳ��ַ���
//		String s="redis-cli -h 10.9.1.25 -p 8002 shutdown;cd ~/Documents/clu/8002;redis-server redis.conf";
//		ServerManage sm=new ServerManage();
//		sm.exec(s);
////		for(int i1=0;i1<list.size();i1++){
////			System.out.println("ɱ����"+list.get(i1));
////			ServerManage sm=new ServerManage(list.get(i1));
////			sm.killServer();
////		}
////		for(int i1=0;i1<list.size();i1++){
////			System.out.println("������"+list.get(i1));
////			ServerManage smg=new ServerManage(list.get(i1));
//				smg.setServer();
////		}
//		}
//	}
//	//�ҵ��ýڵ�����ڵ㣬�Լ����ڵ��µĴӽڵ�
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
