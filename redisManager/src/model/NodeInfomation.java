package model;
//存储节点信息

public class NodeInfomation {
	//端口编号
	private String ID;
	//端口
	private String location;
	//角色  true为主节点
	private boolean roles;
	//主节点
	private String masterID;
	//状态 
	private boolean state;
	//slot
	private String slotf;
	public NodeInfomation(){
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	public boolean isRoles() {
		return roles;
	}
	public void setRoles(boolean roles) {
		this.roles = roles;
	}
	public String getMasterID() {
		return this.masterID;
	}
	public void setMasterID(String masterID) {
		this.masterID = masterID;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getSlotf() {
		return slotf;
	}
	public void setSlotf(String slotf) {
		this.slotf = slotf;
	}
	
}
