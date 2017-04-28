//�Զ���Button�༭
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;  
import javax.swing.JButton;  
import javax.swing.JPanel;  
import javax.swing.JTable;  
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.ServerManage;
  
/** 
 * �Զ���һ�����������Ӱ�ť�ĵ�Ԫ��༭������ü̳�DefaultCellEditor����ȻҪʵ�ֵķ�����̫���ˡ� 
 *  
 */   
public class MyButtonEditor extends DefaultCellEditor  
{  
  
    /** 
     * serialVersionUID 
     */  
    private static final long serialVersionUID = -6546334664166791132L;  
  
    private JPanel panel;  
  
    private JButton button;  
  
    private JTable table;
    
    public MyButtonEditor(JTable table)  
    {  
        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�   
        super(new JTextField());  
  
        // ���õ�����μ���༭��   
        this.setClickCountToStart(1);  
  
        this.initButton();
  
        this.initPanel();  
  
        // ��Ӱ�ť��   
        this.panel.add(this.button);  
        this.table=table;
    }
    private void initButton()  
    {
        this.button = new JButton();  
  
        // ���ð�ť�Ĵ�С��λ�á�   
        this.button.setBounds(20, 0, 60, 15);  
  
        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��   
        this.button.addActionListener(new ActionListener()  
        {  
			public void actionPerformed(ActionEvent e)  
            {  
            	//��ͣ��ť�¼�
            	if(table.getSelectedColumn()==5){
	                // ����ȡ���༭���¼����������tableModel��setValue������
	                MyButtonEditor.this.fireEditingCanceled();  
	                //Head.headPanel.setBackground(Color.pink);
	                int i=table.getSelectedRow();
	                Object ob=table.getModel().getValueAt(i, 1);
	                ServerManage s=new ServerManage(ob.toString());
	    			if(table.getModel().getValueAt(i, 5)=="����"){
	                 	table.getModel().setValueAt("������", i, 4);
	                 	table.getModel().setValueAt("ֹͣ", i, 5);
	                 }
	                 else{
	                 	table.getModel().setValueAt("��ֹͣ", i, 4);
	                 	table.getModel().setValueAt("����", i, 5);
	                 }
	
	                try {
	                	//���߳��͵�EDT���м����ؽ����
						SwingUtilities.invokeLater(new EventThread(i,s));
					} catch (Exception e1) {
						System.out.println("invokeLater����");
					}
            	}
            	//�����޸İ�ť�¼�
            	else{
            		SwingUtilities.invokeLater(new EventThread1());
            	}
                
                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�   
            }  
        });   
  
    }  
    

    
  
    private void initPanel()  
    {  
        this.panel = new JPanel();  
  
        // panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��   
        this.panel.setLayout(null);  
    }  
  
  
    /** 
     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ�� 
     */  
    @Override  
    public Component getTableCellEditorComponent(JTable table, Object value,
    		boolean isSelected, int row, int column)  
    {  
        // ֻΪ��ť��ֵ���ɡ�Ҳ����������������   
        this.button.setText(value == null ? "" : String.valueOf(value));  
  
        return this.panel;  
    }  
  
    /** 
     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ�� 
     */  
    @Override  
    public Object getCellEditorValue()  
    {  
        return this.button.getText();  
    }


//�޸ı���Ĭ�ϱ༭����

    //this.table.getColumnModel().getColumn(2).setCellEditor(new MyButtonEditor());

 
//
//��������ܻ����ﵽЧ���ˡ����ǻ�Ҫע�⣬����2��˵������Ҫ���ÿɱ༭���ܣ����У���Ȼ��Ȼ���������¼��ġ�
//
//����Ƭ�Σ�
//��δ������û�õ�
	public boolean isCellEditable(int row, int column)  
	{  
	    // ���а�ť�еĹ����������Ҫ����true��Ȼ��ť���ʱ���ᴥ���༭Ч����Ҳ�Ͳ��ᴥ���¼���   
	    if (column == 6)  
	    {  
	        return true;  
	    }  
	    else  
	    {  
	        return false;  
	    }  
	} 
	//�ڲ��࣬�½���һ���̣߳�����ɱ��/��������
	private class EventThread implements Runnable{
		private int i;
		private ServerManage s;
		public EventThread(int i,ServerManage s){
			this.i=i;
			this.s=s;
		}
		public void run(){
			 if(table.getModel().getValueAt(i, 5)=="ֹͣ"){
             	s.setServer();
             }
             else{
             	s.killServer();
             }
		}
	}
	//�½��̣߳� ���ڴ����ù���ҳ��
	private class EventThread1 implements Runnable{
		
		public EventThread1(){
			
		}
		
		@SuppressWarnings("deprecation")
		public void run() {
			ConfDialog conf=new ConfDialog(Window.window,table,true);
    		
    		conf.show();
			
		}
		
	}
}
