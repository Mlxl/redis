//ʵ����ȫ�θ����֣����ҵ��ú������
package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Window extends RFrame{
	public static JPanel headPanel=new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	
	public Window(){
		add(headPanel,BorderLayout.NORTH);
		
		add(scrollPane, BorderLayout.CENTER);
		String head[]={"����","�ڵ���Ϣ","����","����","����"};
		for(String s:head){
			headPanel.add(new JButton(s));
		}
		
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
		
		//���ÿ���
		int columnCount=table.getColumnCount();
		for(int i=0;i<columnCount;i++){
			if(i==1){
				TableColumn tableColumn=table.getColumnModel().getColumn(i);
				tableColumn.setPreferredWidth(180);
			}
		}
	}
	
}
		
	
