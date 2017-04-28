package model;

import redis.clients.jedis.JedisCluster;

//保存key值信息，以及针对key值整体的操作
public class KeyInfo{
	private String keyname;
	private String keytype;
	//标志位
	private boolean flag;
	
	public KeyInfo(){
		flag=false;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getKeytype() {
		return keytype;
	}

	public void setKeyType(String keytype) {
		this.keytype = keytype;
	}
	
	public void setKey(){
		
	}
	

}
