package view;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

import model.KeyInfo;

public class DataDialog extends Dialog implements ActionListener,ItemListener {
	
	private static final long serialVersionUID = 1L;
	//判断type是否被修改
	private boolean flag=false;
	
	private JComboBox<String> jcb;
	private String type[]={"string","list","hash","set","zset"};
	private JTextArea jta; 
	private JButton ok;
	private JButton cancel;
	
	
	private KeyInfo kif;
	public DataDialog(Frame parent,JTable table,KeyInfo ki,boolean modal){
		super(parent,modal);
		kif=ki;
		//下拉框选择key类型
		setTitle("添加");
		setSize(450,500);
		setLocation(200,75);
		setResizable(false);
		setLayout(null);
		
		//添加key名
		jcb=new JComboBox<String>(type);
		jcb.setBorder(BorderFactory.createTitledBorder("数据类型"));
		jcb.addActionListener(this);
		jcb.addItemListener(this);
		jcb.setEditable(true);
		jcb.setBounds(0,30, 450, 50);
		add(jcb);
		
		jta=new JTextArea();
		jta.setLineWrap(true);
		jta.setBorder(BorderFactory.createTitledBorder("key名"));
		jta.setBounds(0,90,450,130);
		add(jta);
		
		ok=new JButton("ok");
		cancel=new JButton("cancel");
		ok.setBounds(70,450,70,23);
		cancel.setBounds(300,450,73,23);
		add(ok);
		add(cancel);
		
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s=jta.getText();
				if (s!=null){
					kif.setKeyname(s);
					kif.setFlag(true);
				}
				if(false==flag){
					kif.setKeyType("string");
				}
				dispose();
				
			}
			
		});
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED){
			flag=true;
			kif.setKeyType(e.getItem().toString());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
	}
	
	
}

















