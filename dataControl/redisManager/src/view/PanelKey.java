package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Connect;
import model.DataTableModel;
import model.Key;
import model.Keys;

public class PanelKey {
	private String type;
	private Key key;
	private DataTableModel model;
	private JTable table;
	
	public PanelKey(String keyname){
		
		key=new Key(keyname);
		this.type=key.getType();
		
		
		//在scrollPane中显示key值信息
		model=new DataTableModel(key);
		table=new JTable(model);
		Window.scrollPane.setViewportView(table);
		
		//更新southPane
		addButton();
	}
	
	public void addRow(){
		model.addRow(0);
		table.updateUI();
	}
	
	public void removeRow(){
		int i=table.getSelectedRow();
		//当没有选择行时，i为—1
		if(-1==i) return;
		model.removeRow(i,0);
		table.updateUI();
	}
	
	//更新southPane
	public void addButton(){
		JButton addkey=new JButton("+");
		JButton delkey=new JButton("-");
		JButton appkey=new JButton("√");
		
		delkey.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				removeRow();
				table.updateUI();
			}
		});
		
		addkey.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addRow();
				table.updateUI();
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
				Window.southPanel.add(appkey);
				
				leftadd.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						model.addRow(0);
						table.updateUI();
					}
				});
				righadd.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						model.addRow(1);
						table.updateUI();
					}
				});
				leftdel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						model.removeRow(0,0);
						table.updateUI();
					}
					
				});
				righdel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						model.removeRow(0,1);
						table.updateUI();
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
			Window.southPanel.add(appkey);
			
			Window.southPanel.updateUI();
			break;
		}
		case "set":{
			Window.southPanel.removeAll();
			
			Window.southPanel.add(addkey);
			Window.southPanel.add(delkey);
			Window.southPanel.add(appkey);
			
			Window.southPanel.updateUI();
			break;
		}
		case "zset":{
			Window.southPanel.removeAll();
			
			Window.southPanel.add(addkey);
			Window.southPanel.add(delkey);
			Window.southPanel.add(appkey);
			
			Window.southPanel.updateUI();
			break;
		}
		}
	}
}
