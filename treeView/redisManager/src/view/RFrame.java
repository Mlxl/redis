//���,�Լ�ͨ�����ݵĴ洢
package view;

import java.awt.*;
import javax.swing.*;

class RFrame extends JFrame {
	
	//��ȡ��Ļ�ֱ���
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	//������
	public final int width= screenSize.width*3/4;
	public final int height=screenSize.height*3/4;
	//table
	public static final int raw_count=20;
	public static final int clumn_count=7;
	
	//headPanel�ߴ�
	//public Dimension treeDim=new Dimension(100,1000);
	
	public RFrame(){
		//���ô�С
		setSize(width,height);
		//���ñ���
		setTitle("Redis Manager");
		//����λ��
		setLocation(screenSize.width/8,screenSize.height/10);
		//����ͼ��
		Image img=new ImageIcon("redis.gif").getImage();
		setIconImage(img);
	}
}
