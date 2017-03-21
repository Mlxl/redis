package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Head {
	private String head[]={"连接","节点信息","数据","配置","命令"};
	JButton buttonconn;
	JButton buttoninfo;
	JButton buttondata;
	JButton buttonconf;
	JButton buttoncomd;
	public Head(JPanel panel,JPanel panel1,JPanel panel2){
		//初始化Button
		buttonconn=new JButton("连接");
		buttoninfo=new JButton("节点信息");
		buttondata=new JButton("数据");
		buttonconf=new JButton("配置");
		buttoncomd=new JButton("命令");
		
		panel.add(buttonconn);
		panel.add(buttoninfo);
		panel.add(buttondata);
		panel.add(buttonconf);
		panel.add(buttoncomd);
		
		HeadAction connAction=new HeadAction(); 
		HeadAction infoAction=new HeadAction(); 
		HeadAction dataAction=new HeadAction(); 
		HeadAction confAction=new HeadAction(); 
		HeadAction comdAction=new HeadAction();
		
		buttonconn.addActionListener(connAction);
		buttoninfo.addActionListener(infoAction);
		buttondata.addActionListener(dataAction);
		buttonconf.addActionListener(confAction);
		buttoncomd.addActionListener(comdAction);
	}
	private class HeadAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==buttonconn){
				
			}
		}
		
	}
}
