package view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ConectInfo;

public class PanelData extends JPanel{
	
	public static Boolean flag=true;
	private JTable table;
	private String [] title_name;

	
	public PanelData(){
	
		//�ػ�srollPane
		DefaultTableModel model=new DefaultTableModel();
		JTable table =new JTable(model);
		Window.scrollPane.setViewportView(table);
		
		//�ػ�treePanel
		//if(flag==true){
			
			flag=false;
			MyTree tree=new MyTree();
		//}
		//�ػ�southPane
		Window.southPanel.removeAll();
	
	}
	
//	public PanelData(int flag){
//		//���southPanel�еİ�ť
//		Window.southPanel.removeAll();
//		
//		title_name=this.getTitle_name(flag);
//		model=new KeyDataTableModel(title_name);
//		table=new JTable(model);
//		Window.scrollPane.setViewportView(table);
//		
//		/
//		
//		//����keypanel
//		{
//			
//		}
//	}
//	
//	public void addKey(int flag){
//		if(flag!=0){
//			model.addRow();
//			table.updateUI();
//		}
//	}
//	
//	public void removeKey(){
//		if(flag!=0){
//			try{
//				int i=table.getSelectedRow();
//				model.removeRow(i);
//				table.updateUI();
//			}catch(Exception e){
//				//���Ը����û�û��ѡ��Ҫɾ������
//			}
//		}
//	}
//	
//	public void saveKey(){
//		model.savaContent();
//	}
//
//	//�ҳ���ͬ�������Ͷ�Ӧ��title_name
//	public String[] getTitle_name(int flag){
//		 String[] title_name;
//		 String[] string_title= {"value"};  
//		 String[] hash_title={"value"};
//		 String[] list_title={"row","value"};
//		 String[] set_title={"row","value"};
//		 String[] zset_title={"row","score","value"};
//		 
//		switch(flag){
//    	case 0:return title_name=string_title;
//    	case 1:return title_name=hash_title;
//    	case 2:return title_name=list_title;
//    	case 3:return title_name=set_title;
//    	default:return title_name=zset_title;
//    	}
//	}
}
