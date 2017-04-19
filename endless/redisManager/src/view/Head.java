package view;

import java.awt.event.*;
import javax.swing.*;

public class Head {
	JButton buttonconn;
	JButton buttoninfo;
	JButton buttondata;
	public Head(){
		//��ʼ��Button
		buttonconn=new JButton("����");
		buttoninfo=new JButton("�ڵ���Ϣ");
		buttondata=new JButton("����");
		
		
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
			if(e.getActionCommand().equals("����")){
				@SuppressWarnings("unused")
				PanelConn conn=new PanelConn();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("�ڵ���Ϣ")){
				@SuppressWarnings("unused")
				PanelInfo info=new PanelInfo();
				Window.scrollPane.updateUI();
				Window.southPanel.updateUI();
			}
			if(e.getActionCommand().equals("����")){
				@SuppressWarnings("unused")
				PanelData data=new PanelData();
				Window.scrollPane.updateUI();
				Window.treePanel.updateUI();
				Window.southPanel.updateUI();
			}
		}
		
	}
}
