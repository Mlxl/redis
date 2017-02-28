package view;

import java.awt.*;
import javax.swing.*;

public  class Test {
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable()
		{
			public void run(){
				JFrame frame=new Head();
				//定义用户关闭时的响应动作
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//显示框架
				frame.setVisible(true);
			}
		}
			);
	}
}
