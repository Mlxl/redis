package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.DataTableModel;
import model.Key;

public class PanelKey extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private Key key;
	private DataTableModel model;
	
	public PanelKey(String keyname){
		
		key=new Key(keyname);
		this.type=key.getType();
		
		
		//在scrollPane中显示key值信息
		model=new DataTableModel(key);
		Window.table=new JTable(model);
		Window.scrollPane.setViewportView(Window.table);
		

		
		//更新southPane
		addButton();
	}
	
	public void addRow(){
		model.addRow(0);
		Window.table.updateUI();
	}
	
	public void removeRow(){
		int i=Window.table.getSelectedRow();
		//当没有选择行时，i为—1
		if(-1==i) return;
		model.removeRow(i,0);
		Window.table.updateUI();
	}
	
	//更新southPane
	public void addButton(){
		JButton addkey=new JButton("+");
		JButton delkey=new JButton("-");
		
		delkey.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				removeRow();
				Window.table.updateUI();
			}
		});
		
		addkey.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addRow();
				Window.table.updateUI();
			}
		});
		switch(this.type){
		case "list":{
			
				JButton leftadd=new JButton("L+");
				JButton righadd=new JButton("R+");
				JButton leftdel=new JButton("L-");
				JButton righdel=new JButton("R-");	
			
				Window.southPanel.removeAll();
				
				
				Window.southPanel.add(leftadd);
				Window.southPanel.add(righadd);
				Window.southPanel.add(leftdel);
				Window.southPanel.add(righdel);
				
				leftadd.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						model.addRow(0);
						Window.table.updateUI();
					}
				});
				righadd.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						model.addRow(1);
						Window.table.updateUI();
					}
				});
				leftdel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						model.removeRow(0,0);
						Window.table.updateUI();
					}
					
				});
				righdel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						model.removeRow(0,1);
						Window.table.updateUI();
					}
					
				});
				Window.southPanel.updateUI();
				break;
		}
		case "string":{
			Window.southPanel.removeAll();
			
			Window.southPanel.updateUI();
			break;
		}
		case "hash":{
			Window.southPanel.removeAll();
						
			Window.southPanel.add(addkey);
			Window.southPanel.add(delkey);
			
			Window.southPanel.updateUI();
			break;
		}
		case "set":{
			Window.southPanel.removeAll();
			
			Window.southPanel.add(addkey);
			Window.southPanel.add(delkey);
			
			Window.southPanel.updateUI();
			break;
		}
		case "zset":{
			Window.southPanel.removeAll();
			
			Window.southPanel.add(addkey);
			Window.southPanel.add(delkey);
			
			Window.southPanel.updateUI();
			break;
		}
		}
	}
}
