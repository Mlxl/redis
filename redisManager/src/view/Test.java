package view;

import java.awt.*;
import javax.swing.*;

public  class Test {
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable()
		{
			public void run(){
				JFrame frame=new Head();
				//�����û��ر�ʱ����Ӧ����
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//��ʾ���
				frame.setVisible(true);
			}
		}
			);
	}
}
