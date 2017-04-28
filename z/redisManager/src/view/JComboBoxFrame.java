package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.ServerManage;

public class JComboBoxFrame extends JTextField implements ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cmb=new JComboBox<String>();
	
	public JComboBoxFrame(){
		
		cmb.addItem("主节点");
		cmb.addItem("从节点");
		
		cmb.addItemListener(new ItemListener(){
			
			public void itemStateChanged(ItemEvent itemevent) {
				//判断是否选中
				if(itemevent.getStateChange()==ItemEvent.SELECTED){
					//判断选择的item
					if(itemevent.getItem()=="从节点"){
						int i=Window.table.getSelectedRow();
						String[]s=Window.table.getModel().getValueAt(i, 1).toString().split(" ");
						ServerManage smg=new ServerManage();
						smg.exec("redis-cli -c -p "+s[1]+" cluster failover");
					}
					else {
						int i=Window.table.getSelectedRow();
						String str=Window.table.getModel().getValueAt(i,3).toString().substring(2);
						String[]s=Window.table.getModel().getValueAt(Integer.parseInt(str), 1).toString().split(" ");
						ServerManage smg=new ServerManage();
						smg.exec("redis-cli -c -p"+s[1]+" cluster failover");
					}
					
				}
				
			}
			
		});
	}
	
	
	
	@Override
	public void itemStateChanged(ItemEvent itemevent) {
		// TODO Auto-generated method stub
		
		
	}
}
