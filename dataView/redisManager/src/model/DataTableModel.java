package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DataTableModel extends DefaultTableModel{


	private static final long serialVersionUID = 1L;
		private Vector content; 
	    private String[] title_name;
	    private Key key;
	    private int size;
	    
	    public DataTableModel(Key key) {  
	    	//System.out.println("model");
	    	this.key=key;
	    	
	    	//匹配标题
	    	this.title_name=getTitle_name(key.getType());
	    	
	    	//为content赋值
	    	content=new Vector();
	    	List<List> list=key.getKeyValue();
	    	for(int i=0;i<list.size();i++){
	    		Vector v=new Vector();
	    		if(!key.getType().equals("string")){
	    			//System.out.println("是否为String :"+(key.getType().equals("string")));
	    			v.add(content.size());
	    		}
	    		for(int j=0;j<list.get(i).size();j++){
	    			//System.out.println(list.get(i).get(j));
	    			v.add(list.get(i).get(j));
	    		}
	    		content.add(v);
	    	}
	    	size=content.size();
//	    	System.out.println("________构造_______");
//	    	for(int i=0;i<content.size();i++){
//	    		for(int j=0;j<((Vector)content.get(i)).size();j++){
//	    			System.out.print(((Vector)content.get(i)).get(j));
//	    		}
//	    		System.out.println();
//	    	}
	    }  
	    
	  

	    /**  
	     * 让表格中某些值可修改，但需要setValueAt(Object value, int row, int col)方法配合才能使修改生效  
	     */  
	    public boolean isCellEditable(int rowIndex, int columnIndex) {  
	        
	        return true;  
	    }  
	  
	    /**  
	     * 使修改的内容生效  
	     */  
	    public void setValueAt(Object value, int row, int col) {  
	        ((Vector) content.get(row)).remove(col);  
	        ((Vector) content.get(row)).add(col, value); 
	        this.fireTableCellUpdated(row, col);  
	    }  
	  
	    public String getColumnName(int col) {  
	      return title_name[col];
	    }  
	  
	    public int getColumnCount() {  
	        return title_name.length;  
	    }  
	  
	    public int getRowCount() {
	        	return size;
	    }  
	  
	    public Object getValueAt(int row, int col) {
//	    	for(int i=0;i<content.size();i++){
//	    		for(int j=0;j<((Vector)content.get(i)).size();j++){
//	    			System.out.println(((Vector)content.get(i)).get(j));
//	    		}            
//	    	}
	    	return ((Vector)content.get(row)).get(col);
	      
	    }  
	  
	    /**  
	     * 返回数据类型  
	     */  
	    public Class getColumnClass(int col) {  
	        return getValueAt(0, col).getClass();  
	    }
	    
	    //将数据更改写入数据库
	    public void savaContent(){
	    		
	    	}
//	    	for(int i=0;i<ConectInfo.s.length;i++){
//	    		for(int j=0;j<3;j++){
//	    			System.out.print(ConectInfo.s[i][j]);
//	    			System.out.print(" ");
//	    		}
//	    		System.out.println();
//	    	}
//	 	}
	    

	    public String[] getTitle_name(String s){
			 String[] title_name;
				 String[] string_title= {"value"};  
			 String[] hash_title={"row","field","value"};
			 String[] list_title={"row","value"};
			 String[] set_title={"row","value"};
			 String[] zset_title={"row","value","score"};
			 
			switch(s){
	    	case "string":return title_name=string_title;
	    	case "hash"  :return title_name=hash_title;
	    	case "list"  :return title_name=list_title;
	    	case "set"   :return title_name=set_title;
	    	case "zset"  :return title_name=zset_title;
	    	default: return null;
	    	}
		}
//	    public void addRow() {  
//	    	Vector<String> v=new Vector<String>();
//	    	v.add(0,""+content.size());
//	    	for(int i=1;i<title_name.length;i++){
//	    		v.add(i,title_name[i]);
//	    	}
//	    	content.add(v);
//	    }  
//	  
//	    public void removeRow(int row) {  
//	        content.remove(row); 
//	        for(int i=row;i<content.size();i++){
//	        	int a=Integer.parseInt(getValueAt(i,0).toString());
//	        	setValueAt(a-1,i,0);
//	        }
//	    }  
}

