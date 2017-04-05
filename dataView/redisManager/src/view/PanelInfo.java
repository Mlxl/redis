package view;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PanelInfo extends JPanel{
	
	
	public PanelInfo(){
		//���ScrollPane��SouthPane
		//Window.scrollPane.removeAll();
		
		Window.southPanel.removeAll();
		
		MyTableModel model=new MyTableModel(RFrame.raw_count,RFrame.clumn_count);
		
		JTable table=new JTable(model);
		
		Window.scrollPane.setViewportView(table);
		
		
		//��ɫ������������
		String[] roles = { "���ڵ�", "�ӽڵ�" };
	
		JComboBox com = new JComboBox(roles);
		//com.addItemListener(new JcomListener(table));
	
		TableColumnModel tcm = table.getColumnModel();
	
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(com));
		//model.isCellEditable(0, 3);
		//��ͣ�����밴ť
		table.getColumnModel().getColumn(5).setCellEditor(new MyButtonEditor(table));
		table.getColumnModel().getColumn(5).setCellRenderer(new MyButtonRenderer());
		table.setRowSelectionAllowed(false);
		
		//���ÿ��
		
		TableColumn tableColumn=table.getColumnModel().getColumn(1);
		tableColumn.setPreferredWidth(180);
			
	}
}
