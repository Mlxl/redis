//ʵ����ȫ�θ����֣����ҵ��ú������
package view;
import java.awt.*;
import javax.swing.*;

public class Window extends RFrame{
	public static JPanel headPanel=new JPanel();
	public static JPanel southPanel=new JPanel();
	public static JScrollPane scrollPane = new JScrollPane();
	
	public Window(){
		//����
		add(headPanel,BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);

		//headPanel���
		Head head=new Head();
		
		//PanelInfo info=new PanelInfo(scrollPane,raw_count,clumn_count);
		//PanelConn conn=new PanelConn(scrollPane,southPanel);
	}
	
}
		
	

