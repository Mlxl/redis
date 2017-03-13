//布局
package view;

import java.awt.*;
import javax.swing.*;

class ZLayout extends RFrame{
	
	JPanel panel=new JPanel();
	JPanel menuPanel=new JPanel();
	
	public ZLayout(){
		setLayout(new BorderLayout());
		add(menuPanel,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		
		String menu[]={"连接","节点信息","数据","配置","命令"};
		for(String string:menu){
			menuPanel.add(new JButton(string));
		}
		menuPanel.setSize(50,100);
	
		panel.setLayout(new GridLayout(9,6));
		String buttons[]={"地址","角色","主节点","状态","启停","槽点"
				,"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};
		for(String string:buttons){
			panel.add(new JButton(string));
		}
		
		}
}
