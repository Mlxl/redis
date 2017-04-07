package view;

import java.awt.event.*;
import javax.swing.*;

public class Head {
	JButton buttonconn;
	JButton buttoninfo;
	JButton buttondata;
	JButton buttonconf;
	public Head(){
		//��ʼ��Button
		buttonconn=new JButton("����");
		buttoninfo=new JButton("�ڵ���Ϣ");
		buttondata=new JButton("����");
		buttonconf=new JButton("����");
		
		
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
			if(e.getActionCommand().equals("����")){
				PanelConn conn=new PanelConn();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("�ڵ���Ϣ")){
				PanelInfo conn=new PanelInfo();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("����")){
				PanelData data=new PanelData();
				Window.scrollPane.updateUI();
				Window.treePanel.updateUI();
				Window.southPanel.updateUI();
			}
		}
		
	}
}
