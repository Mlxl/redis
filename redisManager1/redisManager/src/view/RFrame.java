//���
package view;

import java.awt.*;
import javax.swing.*;

class RFrame extends JFrame {
	
	//��ȡ��Ļ�ֱ���
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	//������
	public final int width= screenSize.width/2;
	public final int height=screenSize.height/2;
	//table
	int raw_count=20;
	int clumn_count=7;
	
	public RFrame(){
		
		//���ô�С
		setSize(width,height);
		//���ñ���
		setTitle("Redis Manager");
		//����λ��
		setLocation(screenSize.width/4,screenSize.height/6);
		//����ͼ��
		Image img=new ImageIcon("redis.gif").getImage();
		setIconImage(img);
	}
}
