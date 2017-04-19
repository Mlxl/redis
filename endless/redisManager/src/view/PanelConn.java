package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import model.Connect;

public class PanelConn extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ConnTableModel model=new ConnTableModel();
	private JTable table=new JTable(model);;
	
	public PanelConn(){
			//清空ScrollPane、SouthPane
		//	Window.scrollPane.removeAll();
			Window.southPanel.removeAll();

			//插入table
			//table=new JTable(model);
			
			Window.scrollPane.setViewportView(table);
			
			//设置宽度
			TableColumn tableColumn=table.getColumnModel().getColumn(3);
			tableColumn.setPreferredWidth(180);
			
			//在最底部添加按钮
			JButton addnode=new JButton("+");
			JButton delnode=new JButton("-");
			JButton appnode=new JButton("√");
			
			Window.southPanel.add(addnode);
			Window.southPanel.add(delnode);
			Window.southPanel.add(appnode);
			
			
			addnode.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					addData();
				}
				
			});
			delnode.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					removeData();
				}
				
			});
			//保存数据 并且连接数据库
			appnode.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent actionevent) {
					saveData();
					//连接redis集群
					@SuppressWarnings("unused")
					Connect con=new Connect();
				}
				
			});
	}
	private void addData() {  
        model.addRow("10.9.1.25","800", "~/Documents/clu/800");  
        table.updateUI();  
    }  
  
    private void removeData() {
    	try{
    		int i=table.getSelectedRow();
    		model.removeRow(i);  
            table.updateUI();
    	}catch(Exception e){
    		
    	}
    }  
  
    // 保存数据
    private void saveData() {  
    	model.savaContent();
    }  
}


