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
		//清空ScrollPane、SouthPane
		//Window.scrollPane.removeAll();
		
		Window.southPanel.removeAll();
		
		model=new InfoTableModel(RFrame.raw_count,RFrame.clumn_count);
		
		Window.table=new JTable(model);
		
		Window.scrollPane.setViewportView(Window.table);
		
		
		//角色栏插入下拉框
		String roles[]={"主节点","从节点"};
		JComboBox<String> com = new JComboBox<String>(roles);
		TableColumnModel tcm = Window.table.getColumnModel();
	
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(com));

		//启停栏插入按钮
		Window.table.getColumnModel().getColumn(5).setCellEditor(new MyButtonEditor(Window.table));
		Window.table.getColumnModel().getColumn(5).setCellRenderer(new MyButtonRenderer());
		Window.table.setRowSelectionAllowed(false);

		//配置修改   按钮
		Window.table.getColumnModel().getColumn(7).setCellEditor(new MyButtonEditor(Window.table));
		Window.table.getColumnModel().getColumn(7).setCellRenderer(new MyButtonRenderer());
		Window.table.setRowSelectionAllowed(false);
		//设置宽度
		
		TableColumn tableColumn=Window.table.getColumnModel().getColumn(1);
		tableColumn.setPreferredWidth(180);
		
	}
}
