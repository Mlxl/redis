package model;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyMutableTreeNode extends DefaultMutableTreeNode{
	
	
	private static final long serialVersionUID = 1L;
	//key÷µ¿‡–Õ£∫0-String 1-Hash 2-List 3-Set 4-zSet
	private int type;
	
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
