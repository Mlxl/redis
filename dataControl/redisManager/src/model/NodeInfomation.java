
package model;
//�洢�ڵ���Ϣ

public class NodeInfomation {
	//�˿ڱ��
	private String ID;
	//�˿�
	private String location;
	//��ɫ  trueΪ���ڵ�
	private String roles;
	//���ڵ�
	private String masterID;
	//״̬ 
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
			this.roles ="���ڵ�";
		else
			this.roles="�ӽڵ�";
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
	//��LOcation����ȡIP
	public String getIP(){
		return getLocation().substring(0,getLocation().indexOf(":"));
	}
	
	public String getPort(){
		return getLocation().substring(getLocation().indexOf(":")+1);
	}
	
}
