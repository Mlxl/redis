//框架,以及通用数据的存储
package view;

import java.awt.*;
import javax.swing.*;

class RFrame extends JFrame {
	
	//获取屏幕分辨率
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	//长、宽
	public final int width= screenSize.width*3/4;
	public final int height=screenSize.height*3/4;
	//table
	public static final int raw_count=20;
	public static final int clumn_count=7;
	
	//headPanel尺寸
	//public Dimension treeDim=new Dimension(100,1000);
	
	public RFrame(){
		//设置大小
		setSize(width,height);
		//设置标题
		setTitle("Redis Manager");
		//设置位置
		setLocation(screenSize.width/8,screenSize.height/10);
		//加载图标
		Image img=new ImageIcon("redis.gif").getImage();
		setIconImage(img);
	}
}
