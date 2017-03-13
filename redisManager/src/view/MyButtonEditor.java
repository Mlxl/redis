package view;

import java.awt.Color;
import java.awt.Component;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.DefaultCellEditor;  
import javax.swing.JButton;  
import javax.swing.JPanel;  
import javax.swing.JTable;  
import javax.swing.JTextField;  
  
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
                // ����ȡ���༭���¼����������tableModel��setValue������   
                MyButtonEditor.this.fireEditingCanceled();  
                Head.headPanel.setBackground(Color.pink);
                table.getModel().setValueAt("555", 0, 4);
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
}
