package view;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Connect;
import model.DataTableModel;
import model.Key;
import model.Keys;

public class PanelKey {
	private String type;
	private Key key;
	
	public PanelKey(String keyname){
		
		key=new Key(keyname);
		this.type=key.getType();
		
		
		//在scrollPane中显示key值信息
		DataTableModel model=new DataTableModel(key);
		JTable table=new JTable(model);
		Window.scrollPane.setViewportView(table);
		
		//更新southPane
		addButton();
	}
	
	//更新southPane
	public void addButton(){
		JButton addkey=new JButton("+");
		JButton delkey=new JButton("-");
		JButton appkey=new JButton("√");
		JButton leftadd=new JButton("L+");
		JButton righadd=new JButton("R+");
		
		switch(this.type){
		case "list":{
				Window.southPanel.removeAll();
				
				Window.southPanel.add(leftadd);
				Window.southPanel.add(delkey);
				Window.southPanel.add(appkey);
				Window.southPanel.add(righadd);
				
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
