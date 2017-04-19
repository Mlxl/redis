package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

public class ConfigContr {
	public static String readfile="D:"+File.separator+"redis.conf";
	public static String writefile="D:"+File.separator+"redis1.conf";
	
	private ConfigInfo info;
	
	private String host;
	private String user;
	private String password;
	private String port;
	private String slavereadonly;
	
	//��PanelInfo��table���������Ա��ȡ����
	public ConfigContr(ConfigInfo info,JTable table){
		this.info=info;
		int row =table.getSelectedRow();
		String s[]=table.getValueAt(row, 1).toString().split(":");
		host=s[0];
		port=s[1];
		
		user="tyler";
		password="xdlxl";
	}
	
	public ConfigInfo getConfigInfo(){
		return this.info;
	}
	
	public void setSlaveReadOnly(String s){
		this.slavereadonly=s;
	}
	
	public String getSlaveReadOnly(){
		return this.slavereadonly;
	}
	
	public void getConfig(){
		getFromUB();
		getFromDisk();
	}
	
	public void setConfig(){
		writeToDisk();
		writeToUB();
	}
	
	//����������ļ�������D��
	public void getFromUB(){
		 Connection con = new Connection(host);   
	        try{   
	            con.connect();   
	            @SuppressWarnings("unused")
				boolean isAuthed = con.authenticateWithPassword(user, password);   
	               
	            SCPClient scpClient = con.createSCPClient();   
	            scpClient.get("~/Documents/clu/"+port+"/redis.conf","D:"+File.separator);
	            
	            con.close();   
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        }   
	}
	
	//�������������ص��ļ�
	public void getFromDisk(){
		BufferedReader br =null;	// ׼����һ������Ķ���
		String temp;
		String s[];
		
		try{
			StringBuffer sb=new StringBuffer();
			FileReader fr=new FileReader(ConfigContr.readfile);
			br = new BufferedReader(fr)  ;
			while(!((temp=br.readLine())==null)){
				if(temp.startsWith("#")||temp.isEmpty()) continue;
				s=temp.split(" ");
				switch(s[0]){
//				case "save":
//					info.setSave(s[1],s[2]);
//					continue;
				case "loglevel":
					info.setLoglevel(s[1]);
					continue;
				case "stop-writes-on-bgsave-error":
					info.setZip(s[1]);
					continue;
				case "slave-serve-stale-data":
					info.setSlaveReadOnly(s[1]);
					continue;
				case "timeout":
					info.setTimeOut(s[1]);
					continue;
				case "slave-priority":
					info.setSlavepriority(s[1]);
					continue;
				}
				sb.append(temp).append("\n");
			}
			
			FileWriter fw=new FileWriter(ConfigContr.writefile);
			BufferedWriter bw=new BufferedWriter(fw);
			
			//δ�޸Ĺ�������ֱ��д�����ݿ�
			bw.write(sb.toString());
			
			delFile(ConfigContr.readfile);
			
			fr.close();
			br.close();
			bw.flush();
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�����úõ��ļ�д�뱾�ش���
	public void writeToDisk(){
		StringBuffer s=new StringBuffer(); 
		s.append("timeout "+info.getTimeOut()+"\n");
		s.append("loglevel "+info.getLoglevel()+"\n");
		s.append("slave-serve-stale-data "+info.getSlavereadonly()+"\n");
		s.append("stop-writes-onbgsave-error "+info.getZip()+"\n");
		s.append("slave-priority "+info.getSlavepriority()+"\n");
		try{
			FileWriter fw=new FileWriter(ConfigContr.writefile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(s.toString());
			
			bw.flush();
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�����ش��������ļ�д�������
	public void writeToUB(){
		Connection con = new Connection(host);   
        try{   
            con.connect();   
            @SuppressWarnings("unused")
			boolean isAuthed = con.authenticateWithPassword(user, password);   
               
            SCPClient scpClient = con.createSCPClient();   
            scpClient.put(ConfigContr.writefile,"~/Documents/clu");
            
            con.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        } 
	}
	
	//ִ����������
	public void executeCmd(){
		StringBuffer sb=new StringBuffer();
		String s="config set ";
		sb.append(s).append("timeout ").append(info.getTimeOut()).append(";");
		sb.append(s).append("loglevel ").append(info.getLoglevel()).append(";");
		sb.append(s).append("slave-serve-stale-datav ").append(info.getLoglevel()).append(";");
		sb.append(s).append("stop-writes-onbgsave-error ").append(info.getZip()).append(";");
		sb.append(s).append("slave-priority ").append(info.getSlavepriority()).append(";");
		
		ServerManage sm=new ServerManage();
		sm.exec(sb.toString());
	}
	
	//ɾ�������ļ�
	public void delFile(String s){
		File f=new File(s);
		if(f.exists())	
			f.delete();
		else 
			System.out.println("Ҫɾ����Ŀ��в�����");
	}
}

















