//自定义tablemodel
package view;

import model.Connect;
import model.NodeInfomation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private Vector content;
	
	private int size;
	
	private String []title_name={"节点","地址","角色","主节点","状态","启停","槽点"};
	
	 public MyTableModel() {  
	    	content = new Vector();  
	    }  
	public MyTableModel(int i){
		Connect con=new Connect();
		List<NodeInfomation> info=con.getInfomation();
		content=new Vector(info.size());
		for(int j1=0;j1<info.size();j1++){
			Vector<String> v=new Vector<String>();
			//节点编号
			v.add(0,"编号"+j1);
			//地址
			v.add(1,info.get(j1).getlocation());
			//角色
			v.add(2,info.get(j1).getRoles());
			//主节点
			v.add(3,info.get(j1).getMasterID());
			v.add(4,"已启动");
			v.add(5,"停止");
			v.add(6,info.get(j1).getSlotf());
			content.add(v);
		}
	
		this.size=info.size();
	}
		
	
	//
	public MyTableModel(int i, int j) {
		super(i, j);
		
		Connect con=new Connect();
		List<NodeInfomation> info=con.getInfomation();
		content=new Vector(info.size());
		for(int j1=0;j1<info.size();j1++){
			Vector<String> v=new Vector<String>();
			//节点编号
			v.add(0,"节点"+j1);
			//地址		
			v.add(1,info.get(j1).getlocation());
			//角色
			v.add(2,info.get(j1).getRoles());
			//主节点
			v.add(3,info.get(j1).getMaster());
			v.add(4,"已启动");
			v.add(5,"停止");
			v.add(6,info.get(j1).getSlotf());
			content.add(v);
		}
	
		this.size=info.size();
	}
	//负责数据显示
    @Override  
    public Object getValueAt(int row, int column)  
    {  
    	return ((Vector) content.get(row)).get(column); 
    }  

    @Override  
    public int getRowCount()  
    {  
        return size;  
    }  
    public String getColumnName(int column){
    	return title_name[column];
    }
    @Override  
    public int getColumnCount()  
    {  
        return title_name.length;  
    }  

    @Override  
    public void setValueAt(Object value, int row, int column) { 
//    		if(column==2){
//    			Object s=((Vector)content.get(row)).get(column);
//    			if(value!=s){
//    				
//    			}
//    		}
//    		else{
		    	((Vector) content.get(row)).remove(column);  
		        ((Vector) content.get(row)).add(column, value);  
		        this.fireTableCellUpdated(row, column);
    		
    }  
    
  
    /**  
     * 返回数据类型  
     */  
    public Class getColumnClass(int col) {  
        return getValueAt(0, col).getClass();  
    }  
    
    //是否可编辑
	@Override
	public boolean isCellEditable(int row ,int col){
		switch(col){
		case 2:
		case 5:
			return true;
			
		default:
			return false;
		}
}
	}
	

