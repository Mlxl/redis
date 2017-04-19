package view;

import java.awt.event.*;
import javax.swing.*;

public class Head {
	JButton buttonconn;
	JButton buttoninfo;
	JButton buttondata;
	public Head(){
		//初始化Button
		buttonconn=new JButton("连接");
		buttoninfo=new JButton("节点信息");
		buttondata=new JButton("数据");
		
		
		Window.headPanel.add(buttonconn);
		Window.headPanel.add(buttoninfo);
		Window.headPanel.add(buttondata);
		
		
		HeadAction connAction=new HeadAction(); 
		HeadAction infoAction=new HeadAction(); 
		HeadAction dataAction=new HeadAction(); 
		
		buttonconn.addActionListener(connAction);
		buttoninfo.addActionListener(infoAction);
		buttondata.addActionListener(dataAction);
	
	}
	private class HeadAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("连接")){
				@SuppressWarnings("unused")
				PanelConn conn=new PanelConn();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("节点信息")){
				@SuppressWarnings("unused")
				PanelInfo info=new PanelInfo();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("数据")){
				@SuppressWarnings("unused")
				PanelData data=new PanelData();
				Window.scrollPane.updateUI();
				Window.treePanel.updateUI();
				Window.southPanel.updateUI();
			}
		}
		
	}
}
