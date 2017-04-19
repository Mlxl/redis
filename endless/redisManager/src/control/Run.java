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
				//定义用户关闭时的响应动作
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//显示框架
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
