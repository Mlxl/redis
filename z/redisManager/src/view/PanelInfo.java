package view;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PanelInfo extends JPanel{
	
	private InfoTableModel model;
	
	private static final long serialVersionUID = 1L;

	public PanelInfo(){
		//���ScrollPane��SouthPane
		//Window.scrollPane.removeAll();
		
		Window.southPanel.removeAll();
		
		model=new InfoTableModel(RFrame.raw_count,RFrame.clumn_count);
		
		Window.table=new JTable(model);
		
		Window.scrollPane.setViewportView(Window.table);
		
		
		//��ɫ������������
		String roles[]={"���ڵ�","�ӽڵ�"};
		JComboBox<String> com = new JComboBox<String>(roles);
		TableColumnModel tcm = Window.table.getColumnModel();
	
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(com));

		//��ͣ�����밴ť
		Window.table.getColumnModel().getColumn(5).setCellEditor(new MyButtonEditor(Window.table));
		Window.table.getColumnModel().getColumn(5).setCellRenderer(new MyButtonRenderer());
		Window.table.setRowSelectionAllowed(false);

		//�����޸�   ��ť
		Window.table.getColumnModel().getColumn(7).setCellEditor(new MyButtonEditor(Window.table));
		Window.table.getColumnModel().getColumn(7).setCellRenderer(new MyButtonRenderer());
		Window.table.setRowSelectionAllowed(false);
		//���ÿ��
		
		TableColumn tableColumn=Window.table.getColumnModel().getColumn(1);
		tableColumn.setPreferredWidth(180);
		
	}
}
