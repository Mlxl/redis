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
	
		//÷ÿªÊsrollPane
		DefaultTableModel model=new DefaultTableModel();
		JTable table =new JTable(model);
		Window.scrollPane.setViewportView(table);
		
		//÷ÿªÊtreePanel
		//if(flag==true){
			
			flag=false;
			@SuppressWarnings("unused")
			PanelTree tree=new PanelTree();
		//}
		//÷ÿªÊsouthPane
		Window.southPanel.removeAll();
	
	}
}
