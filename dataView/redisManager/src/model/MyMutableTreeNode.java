package model;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyMutableTreeNode extends DefaultMutableTreeNode{
	
	//key值类型：0-String 1-Hash 2-List 3-Set 4-zSet
	private int type;
	//属于哪个节点
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
