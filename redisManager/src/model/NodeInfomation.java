package model;
//�洢�ڵ���Ϣ

public class NodeInfomation {
	//�˿ڱ��
	private String ID;
	//�˿�
	private String location;
	//��ɫ  trueΪ���ڵ�
	private boolean roles;
	//���ڵ�
	private String masterID;
	//״̬ 
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
