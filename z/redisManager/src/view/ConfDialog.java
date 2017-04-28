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
        setSize(400,500);
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
        ltimeout.setBounds(50, 40, 140, 20);
        timeout.setText(confInfo.getTimeOut());
        timeout.setBounds(210, 40, 90, 20);
        
        //loglevel
        add(lloglevel);
        add(loglevel);
        lloglevel.setBounds(50, 70, 140, 20);
        loglevel.setText(confInfo.getLoglevel());
        loglevel.setBounds(210, 70, 90, 20);
        
        //从服务器 只读
        add(lslavereadonly);
        add(slavereadonly);
        lslavereadonly.setBounds(50, 100, 140, 20);
        slavereadonly.setText(confInfo.getSlavereadonly());
        slavereadonly.setBounds(210, 100, 90, 20);
        
        add(lzip);
        add(zip);
        lzip.setBounds(50,130,140,20);
        zip.setText(confInfo.getZip());
        zip.setBounds(210,130, 90, 20);
        
        add(lslavepriority);
        add(slavepriority);
        lslavepriority.setBounds(50, 160, 140, 20);
        slavepriority.setText(confInfo.getSlavepriority());
        slavepriority.setBounds(210, 160, 90, 20);
        
        
        add(ok);
        add(cancel);
        ok.setBounds(80, 450, 73, 23);
        cancel.setBounds(245, 450,73, 23);
		
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
				confInfo.setLoglevel(loglevel.getText());
				confInfo.setSlavepriority(slavepriority.getText());
				confInfo.setZip(zip.getText());
				confInfo.setSlavepriority(slavepriority.getText());
				
				figcontr.setConfig();
				
				
				dispose();
				
			}
        });
        
        
	}
}










