package control;

import view.Window;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public  class Run {
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable()
		{
			public void run(){
				JFrame frame=new Window();
				//�����û��ر�ʱ����Ӧ����
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//��ʾ���
				frame.setVisible(true);
				
				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
	
				});
			}
		});
	}
}
