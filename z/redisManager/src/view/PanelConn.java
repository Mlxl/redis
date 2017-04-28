package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class PanelConn extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ConnTableModel model;
	public PanelConn(){
			
			Window.southPanel.removeAll();
			
			model=new ConnTableModel();
			Window.table=new JTable(model);
			Window.scrollPane.setViewportView(Window.table);
			
			//���ÿ��
			TableColumn tableColumn=Window.table.getColumnModel().getColumn(3);
			tableColumn.setPreferredWidth(180);
			
			//����ײ���Ӱ�ť
			JButton addnode=new JButton("+");
			JButton delnode=new JButton("-");
			JButton appnode=new JButton("��");
			
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
			//�������� �����������ݿ�
			appnode.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent actionevent) {
					saveData();
				
				}
				
			});
	}
	private void addData() {  
		Vector<String> v=new Vector<String>();
		int i=model.getRowCount();
		v.add(""+i);
		v.add("10.9.1.25");
		v.add("800"+i);
		v.add("~/Documents/clu/800"+i);
        model.addRow(v);
        Window.table.updateUI();  
    }  
  
    private void removeData() {
    	try{
    		int i=Window.table.getSelectedRow();
    		model.removeRow(i);  
            Window.table.updateUI();
    	}catch(Exception e){
    		
    	}
    }  
  
    // ��������
    private void saveData() {  
    	model.savaContent();
    }  
}


