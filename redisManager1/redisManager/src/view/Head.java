package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Head {
	private String head[]={"����","�ڵ���Ϣ","����","����","����"};
	JButton buttonconn;
	JButton buttoninfo;
	JButton buttondata;
	JButton buttonconf;
	JButton buttoncomd;
	public Head(JPanel panel,JPanel panel1,JPanel panel2){
		//��ʼ��Button
		buttonconn=new JButton("����");
		buttoninfo=new JButton("�ڵ���Ϣ");
		buttondata=new JButton("����");
		buttonconf=new JButton("����");
		buttoncomd=new JButton("����");
		
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
