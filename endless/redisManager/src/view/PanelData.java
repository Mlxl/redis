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

	
	public PanelData(){
	
		//�ػ�srollPane
		DefaultTableModel model=new DefaultTableModel();
		JTable table =new JTable(model);
		Window.scrollPane.setViewportView(table);
		
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
