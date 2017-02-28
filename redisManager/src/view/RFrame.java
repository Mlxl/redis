//框架
package view;

import java.awt.*;
import javax.swing.*;

class RFrame extends JFrame {
	
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
	
	public final int width= screenSize.width/2;
	public final int height=screenSize.height/2;
	
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
