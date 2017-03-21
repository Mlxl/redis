package view;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PanelInfo extends RFrame{
	
	private JScrollPane scrollPane = new JScrollPane();
	
	public PanelInfo(){
		
		MyTableModel model=new MyTableModel(raw_count,clumn_count);
		
		JTable table=new JTable(model);
		
		scrollPane.setViewportView(table);
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
		int columnCount=table.getColumnCount();
		for(int i=0;i<columnCount;i++){
			if(i==1){
				TableColumn tableColumn=table.getColumnModel().getColumn(i);
				tableColumn.setPreferredWidth(180);
			}
		}
	}
}
