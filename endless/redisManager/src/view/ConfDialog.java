package view;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.ConfigContr;
import model.ConfigInfo;

class ConfDialog extends Dialog{
	private static final long serialVersionUID = 1L;
	private ConfigInfo confInfo;
	//延时
	JLabel ltimeout=new JLabel("timeout");
	//日志级别
	JLabel lloglevel=new JLabel("loglevel");
	//从服务器只读
	JLabel lslavereadonly=new JLabel("slave-serve-stale-data");
	//数否压缩LZF到数据库
	JLabel lzip=new JLabel("stop-writes-on-bgsave-error");
	//从服务器优先级
	JLabel lslavepriority=new JLabel("slave-priority");
	
	JTextField timeout =new JTextField(50);
	JTextField loglevel=new JTextField(50);
	JTextField slavereadonly=new JTextField(50);
	JTextField zip=new JTextField(50);
	JTextField slavepriority=new JTextField(50);
	
	JButton ok=new JButton("ok");
	JButton cancel=new JButton("cancel");
	
	public ConfDialog(Frame parent,JTable table,boolean modal){
		super(parent,modal);
		setTitle("配置");
        setSize(600,500);
        setLocation(200, 75);
        setResizable(false);
        setLayout(null);
        confInfo=new ConfigInfo();
        ConfigContr figcontr=new ConfigContr(confInfo,table);
        //获取系统配置
        figcontr.getConfig();
        
        //timeout
        add(ltimeout);
        add(timeout);
        ltimeout.setBounds(50, 30, 100, 20);
        timeout.setText(confInfo.getTimeOut());
        timeout.setBounds(170, 30, 90, 20);
        
        //loglevel
        add(lloglevel);
        add(loglevel);
        lloglevel.setBounds(50, 60, 100, 20);
        loglevel.setText(confInfo.getLoglevel());
        loglevel.setBounds(170, 60, 90, 20);
        
        //从服务器 只读
        add(lslavereadonly);
        add(slavereadonly);
        lslavereadonly.setBounds(50, 90, 100, 20);
        slavereadonly.setText(confInfo.getSlavereadonly());
        slavereadonly.setBounds(170, 90, 90, 20);
        
        add(lzip);
        add(zip);
        lzip.setBounds(50,120,100,20);
        zip.setText(confInfo.getZip());
        zip.setBounds(170,120, 90, 20);
        
        add(lslavepriority);
        add(slavepriority);
        lslavepriority.setBounds(50, 150, 100, 20);
        slavepriority.setText(confInfo.getSlavepriority());
        slavepriority.setBounds(170, 150, 90, 20);
        
        
        add(ok);
        add(cancel);
        ok.setBounds(100, 450, 80, 25);
        cancel.setBounds(200, 450, 80, 25);
		
        cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
        });
        
        ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				confInfo.setTimeOut(timeout.getText());
				
				
				figcontr.setConfig();
				dispose();
				
			}
        });
        
        
	}
}










