package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PanelData extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Boolean flag=true;
	
	private DefaultTableModel model;
	
	public PanelData(){
	
		//�ػ�srollPane
		model=new DefaultTableModel();
		Window.table =new JTable(model);
		Window.scrollPane.setViewportView(Window.table);
		
		//�ػ�treePanel
		//if(flag==true){
			
			flag=false;
			@SuppressWarnings("unused")
			PanelTree tree=new PanelTree();
		//}
		//�ػ�southPane
		Window.southPanel.removeAll();
	
	}
}
