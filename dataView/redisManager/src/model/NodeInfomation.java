
package model;
//存储节点信息

public class NodeInfomation {
	//端口编号
	private String ID;
	//端口
	private String location;
	//角色  true为主节点
	private String roles;
	//主节点
	private String masterID;
	//状态 
	private boolean state;
	//slot
	private String slotf;
	private String master;
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master=master;
	}
	public NodeInfomation(){
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(boolean roles) {
		if(roles==true)
			this.roles ="主节点";
		else
			this.roles="从节点";
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
	//从LOcation中提取IP
	public String getIP(){
		return getLocation().substring(0,getLocation().indexOf(":"));
	}
	
	public String getPort(){
		return getLocation().substring(getLocation().indexOf(":")+1);
	}
	
}
