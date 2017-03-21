//框架
package view;

import java.awt.*;
import javax.swing.*;

class RFrame extends JFrame {
	
	//获取屏幕分辨率
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	//长、宽
	public final int width= screenSize.width/2;
	public final int height=screenSize.height/2;
	//table
	int raw_count=20;
	int clumn_count=7;
	
	public RFrame(){
		
		//设置大小
		setSize(width,height);
		//设置标题
		setTitle("Redis Manager");
		//设置位置
		setLocation(screenSize.width/4,screenSize.height/6);
		//加载图标
		Image img=new ImageIcon("redis.gif").getImage();
		setIconImage(img);
	}
}
