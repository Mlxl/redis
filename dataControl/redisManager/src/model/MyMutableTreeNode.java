package model;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyMutableTreeNode extends DefaultMutableTreeNode{
	
	//keyֵ���ͣ�0-String 1-Hash 2-List 3-Set 4-zSet
	private int type;
	//�����ĸ��ڵ�
	private int port;
	
	public MyMutableTreeNode(String s){
		super(s);
	}
	
	public MyMutableTreeNode(String s,int type){
		super(s);
		this.type=type;
	}
	public int getType(){
		return this.type;
	}
	
}
