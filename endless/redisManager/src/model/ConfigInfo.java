
//用于保存配置文件中的信息
package model;

public class ConfigInfo {
	
	private String timeout;
	private String[] save;
	private String loglevel;
	private String slavereadonly;
	private String zip;
	private String slavepriority;
	
	
	public ConfigInfo(){
		
	}
	
	public void setTimeOut(String s){
		this.timeout=s;
	}
	
	public String getTimeOut(){
		return this.timeout;
	}
	
	public void setSave(String s0,String s1){
		save=new String[2];
		save[0]=s0;
		save[1]=s1;
	}
	
	public String getSave(){
		return save[0]+" "+save[1];
	}
	
	public String getLoglevel(){
		return this.loglevel;
	}
	
	public void setLoglevel(String s){
		this.loglevel=s;	
	}
	
	public void setZip(String s){
		this.zip=s;
	}
	
	public String getZip(){
		return this.zip;
	}
	
	public void setSlavepriority(String s){
		this.slavepriority=s;
	}
	
	public String getSlavepriority(){
		return this.slavepriority;
	}
	
	public void setSlaveReadOnly(String s){
		System.out.println(s);
		this.slavereadonly=s;
	}
	
	public String getSlavereadonly(){
		return this.slavereadonly;
	}
	public void nodeInfo(){
		
	}
	
}

