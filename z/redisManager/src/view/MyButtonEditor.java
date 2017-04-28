//自定义Button编辑
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
 * 自定义一个往列里边添加按钮的单元格编辑器。最好继承DefaultCellEditor，不然要实现的方法就太多了。 
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
        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。   
        super(new JTextField());  
  
        // 设置点击几次激活编辑。   
        this.setClickCountToStart(1);  
  
        this.initButton();
  
        this.initPanel();  
  
        // 添加按钮。   
        this.panel.add(this.button);  
        this.table=table;
    }
    private void initButton()  
    {
        this.button = new JButton();  
  
        // 设置按钮的大小及位置。   
        this.button.setBounds(20, 0, 60, 15);  
  
        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。   
        this.button.addActionListener(new ActionListener()  
        {  
			public void actionPerformed(ActionEvent e)  
            {  
            	//启停按钮事件
            	if(table.getSelectedColumn()==5){
	                // 触发取消编辑的事件，不会调用tableModel的setValue方法。
	                MyButtonEditor.this.fireEditingCanceled();  
	                //Head.headPanel.setBackground(Color.pink);
	                int i=table.getSelectedRow();
	                Object ob=table.getModel().getValueAt(i, 1);
	                ServerManage s=new ServerManage(ob.toString());
	    			if(table.getModel().getValueAt(i, 5)=="启动"){
	                 	table.getModel().setValueAt("已启动", i, 4);
	                 	table.getModel().setValueAt("停止", i, 5);
	                 }
	                 else{
	                 	table.getModel().setValueAt("已停止", i, 4);
	                 	table.getModel().setValueAt("启动", i, 5);
	                 }
	
	                try {
	                	//将线程送到EDT队列即返回结果。
						SwingUtilities.invokeLater(new EventThread(i,s));
					} catch (Exception e1) {
						System.out.println("invokeLater错误");
					}
            	}
            	//配置修改按钮事件
            	else{
            		SwingUtilities.invokeLater(new EventThread1());
            	}
                
                // 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。   
            }  
        });   
  
    }  
    

    
  
    private void initPanel()  
    {  
        this.panel = new JPanel();  
  
        // panel使用绝对定位，这样button就不会充满整个单元格。   
        this.panel.setLayout(null);  
    }  
  
  
    /** 
     * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格） 
     */  
    @Override  
    public Component getTableCellEditorComponent(JTable table, Object value,
    		boolean isSelected, int row, int column)  
    {  
        // 只为按钮赋值即可。也可以作其它操作。   
        this.button.setText(value == null ? "" : String.valueOf(value));  
  
        return this.panel;  
    }  
  
    /** 
     * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。 
     */  
    @Override  
    public Object getCellEditorValue()  
    {  
        return this.button.getText();  
    }


//修改表格的默认编辑器：

    //this.table.getColumnModel().getColumn(2).setCellEditor(new MyButtonEditor());

 
//
//这样后就能基本达到效果了。但是还要注意，对列2来说，还需要启用可编辑功能，才行，不然仍然触发不了事件的。
//
//代码片段：
//这段代码基本没用到
	public boolean isCellEditable(int row, int column)  
	{  
	    // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。   
	    if (column == 6)  
	    {  
	        return true;  
	    }  
	    else  
	    {  
	        return false;  
	    }  
	} 
	//内部类，新建了一个线程，用于杀死/启动服务
	private class EventThread implements Runnable{
		private int i;
		private ServerManage s;
		public EventThread(int i,ServerManage s){
			this.i=i;
			this.s=s;
		}
		public void run(){
			 if(table.getModel().getValueAt(i, 5)=="停止"){
             	s.setServer();
             }
             else{
             	s.killServer();
             }
		}
	}
	//新建线程， 用于打开配置功能页面
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
