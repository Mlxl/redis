//自定义tablemodel
package view;

import model.CollectData;
import model.Connect;
import model.NodeInfomation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class InfoTableModel extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;
	//保存panelInfo界面的信息
	private Vector<Vector<String>> content;
	
	private int size;
	
	private String []title_name={"节点","地址","角色","主节点","状态","启停","槽点","配置"};
	
	 public InfoTableModel() {  
	    	content = new Vector<Vector<String>>();  
	    }  
	
	//
	public InfoTableModel(int i, int j) {
		super(i, j);
		
		@SuppressWarnings("unused")
		Connect con=new Connect();
		List<NodeInfomation> info=CollectData.info;
		content=new Vector<Vector<String>>(info.size());
		for(int j1=0;j1<info.size();j1++){
			Vector<String> v=new Vector<String>();
			//节点编号
			v.add(0,"节点"+j1);
			//地址		
			v.add(1,info.get(j1).getLocation());
			//角色
			v.add(2,info.get(j1).getRoles());
			//主节点
			v.add(3,info.get(j1).getMaster());
			v.add(4,"已启动");
			v.add(5,"停止");
			v.add(6,info.get(j1).getSlotf());
			v.add(7,"修改");
			content.add(v);
		}
	
		this.size=info.size();
	}
	//负责数据显示
    @Override  
    public Object getValueAt(int row, int column)  
    {  
    	return content.get(row).get(column); 
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
		    	content.get(row).remove(column);  
		        content.get(row).add(column, value.toString());  
		        this.fireTableCellUpdated(row, column);
    		
    }  
    
  
    /**  
     * 返回数据类型  
     */  
//    public Class getColumnClass(int col) {  
//        return getValueAt(0, col).getClass();  
//    }  
    
    //是否可编辑
	@Override
	public boolean isCellEditable(int row ,int col){
		switch(col){
		case 2:
		case 5:
		case 7:
			return true;
			
		default:
			return false;
		}
}
	}
	

