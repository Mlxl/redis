package view;

import java.awt.event.*;
import javax.swing.*;

public class Head {
	JButton buttonconn;
	JButton buttoninfo;
	JButton buttondata;
	JButton buttonconf;
	public Head(){
		//初始化Button
		buttonconn=new JButton("连接");
		buttoninfo=new JButton("节点信息");
		buttondata=new JButton("数据");
		buttonconf=new JButton("配置");
		
		
		Window.headPanel.add(buttonconn);
		Window.headPanel.add(buttoninfo);
		Window.headPanel.add(buttondata);
		Window.headPanel.add(buttonconf);
		
		
		HeadAction connAction=new HeadAction(); 
		HeadAction infoAction=new HeadAction(); 
		HeadAction dataAction=new HeadAction(); 
		HeadAction confAction=new HeadAction(); 
		
		buttonconn.addActionListener(connAction);
		buttoninfo.addActionListener(infoAction);
		buttondata.addActionListener(dataAction);
		buttonconf.addActionListener(confAction);
	}
	private class HeadAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println("Start");
//			System.out.println(e.getActionCommand());
			if(e.getActionCommand().equals("连接")){
				PanelConn conn=new PanelConn();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("节点信息")){
				PanelInfo conn=new PanelInfo();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("数据")){
				PanelData data=new PanelData();
				Window.scrollPane.updateUI();
				Window.treePanel.updateUI();
				Window.southPanel.updateUI();
			}
		}
		
	}
}
