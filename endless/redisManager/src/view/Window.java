//实例化全段各部分，并且调用后端数据
package view;
import java.awt.*;
import javax.swing.*;

public class Window extends RFrame{
	 
	private static final long serialVersionUID = 1L;

	public static Window window;
	
	public static Container contain;
	
	
	//顶格
	public static JPanel headPanel=new JPanel();
	//最末格
	public static JPanel southPanel=new JPanel();
	//滚动窗格
	public static JScrollPane scrollPane = new JScrollPane();
	//tree菜单
	public static JScrollPane treePanel=new JScrollPane();
	//key值操作界面容器
	public static JScrollPane keysPanel=new JScrollPane();
	public Window(){
		window=this;
		//布局
		contain=getContentPane();
		contain.add(headPanel,BorderLayout.NORTH);
		contain.add(scrollPane, BorderLayout.CENTER);
		contain.add(southPanel,BorderLayout.SOUTH);
		treePanel.setPreferredSize(new Dimension(180,scrollPane.getHeight()));
		//headPanel填充
		//正常代码
		@SuppressWarnings("unused")
		Head head=new Head();
		
	}
	
}

		
	


