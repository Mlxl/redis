//ʵ����ȫ�θ����֣����ҵ��ú������
package view;
import java.awt.*;
import javax.swing.*;

public class Window extends RFrame{
	public static Container contain;
	
	
	//����
	public static JPanel headPanel=new JPanel();
	//��ĩ��
	public static JPanel southPanel=new JPanel();
	//��������
	public static JScrollPane scrollPane = new JScrollPane();
	//tree�˵�
	public static JScrollPane treePanel=new JScrollPane();
	//keyֵ������������
	public static JScrollPane keysPanel=new JScrollPane();
	public Window(){
		//����
		contain=getContentPane();
		contain.add(headPanel,BorderLayout.NORTH);
		contain.add(scrollPane, BorderLayout.CENTER);
		contain.add(southPanel,BorderLayout.SOUTH);
		treePanel.setPreferredSize(new Dimension(180,scrollPane.getHeight()));
		//headPanel���
		//��������
		Head head=new Head();
		
		//PanelData data=new PanelData();
		//PanelInfo info=new PanelInfo(scrollPane,raw_count,clumn_count);
		//PanelConn conn=new PanelConn();
	}
	
}

		
	


