package model;

import redis.clients.jedis.JedisCluster;

//����keyֵ��Ϣ���Լ����keyֵ����Ĳ���
public class KeyInfo{
	private String keyname;
	private String keytype;
	//��־λ
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
