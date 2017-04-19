package model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DataTableModel extends DefaultTableModel{


	private static final long serialVersionUID = 1L;

		private Vector<Vector<String>> content; 
	    private String[] title_name;
	    private Key key;
	    private String type;
	    private static int count=0;
	    public DataTableModel(Key key) {  
	    	//System.out.println("model");
	    	this.key=key;
	    	this.type=key.getType();
	    	
	    	//匹配标题
	    	this.title_name=getTitle_name();
	    	
	    	//为content赋值
	    	content=new Vector<Vector<String>>();
	    	List<List<String>> list=key.getKeyValue();
	    	for(int i=0;i<list.size();i++){
	    		Vector<String> v=new Vector<String>();
	    		if(!key.getType().equals("string")){
	    			//System.out.println("是否为String :"+(key.getType().equals("string")));
	    			v.add(""+content.size());
	    		}
	    		for(int j=0;j<list.get(i).size();j++){
	    			//System.out.println(list.get(i).get(j));
	    			v.add(list.get(i).get(j));
	    		}
	    		content.add(v);
	    	}
	    }  
	    
	  

	    /**  
	     * 让表格中某些值可修改，但需要setValueAt(Object value, int row, int col)方法配合才能使修改生效  
	     */  
	    public boolean isCellEditable(int rowIndex, int columnIndex) {  
	    	//list 表中只有value列的第一个和最后值可以编辑
	    	if(type.equals("list")){
	    		if(columnIndex==1&&(0==rowIndex||rowIndex==content.size()-1))	
	    		return true;
	    		else return false;
	    	}
	        if(!type.equals("string")&&0==columnIndex)
	        	return false; 
	        else return true;
	    }  
	  
	    /**  
	     * 使修改的内容生效  
	     */  
	    public void setValueAt(Object value, int row, int col) {
	    	if(value==getValueAt(row,col)) return ;
	        Object o=content.get(row).remove(col);
	        content.get(row).add(col,value.toString());
	        chang(o,value,row, col);
	        this.fireTableCellUpdated(row, col);  
	    }  
	  
	    public void chang(Object o,Object value,int row,int col){
	    	switch(type){
	    	case "string":{
	    		key.setString(value.toString());
	    		break;
	    	}
	    	case "set" :{
	    		key.delSet(o.toString());
	    		key.setSet(value.toString());
	    		break;
	    	}
	    	case "zset":{
	    		key.delZset(o.toString());
	    		key.setZset(Double.parseDouble(getValueAt(row,1).toString()),getValueAt(row,2).toString());
	    		break;
	    	}
	    	case "hash":{
	    		if(1==col){
		    		key.delHash(o.toString());
		    		key.setHash(getValueAt(row,1).toString(), getValueAt(row,2).toString());
	    		}else{
	    			key.delHash(getValueAt(row,1).toString());
	    			key.setHash(getValueAt(row,1).toString(), getValueAt(row,2).toString());
	    		}
	    		break;
	    	}
	    	case "list":{
	    		if(0==row){
	    			key.delListLef();
	    			key.setListleft(value.toString());
	    		}
	    		else{
	    			key.delListrigh();
	    			key.setListRigh(value.toString());
	    		}
	    		break;
	    	}
	    	}
		}
		
	    
	    public String getColumnName(int col) {  
	      return title_name[col];
	    }  
	  
	    public int getColumnCount() { 
	        return title_name.length;  
	    }  
	  
	    public int getRowCount() {
	    	try{
	        	return content.size();
	    	}catch(NullPointerException e){
	    		
	    	}
	    	return 0;
	    }  
	  
	    public Object getValueAt(int row, int col) {
	    	
	    	return content.get(row).get(col);
	      
	    }  
	  
	    /**  
	     * 返回数据类型  
	     */  
	    
//		public Class getColumnClass(int col) {  
//	        return getValueAt(0, col).getClass();  
//	    }

	    public String[] getTitle_name(){
			 String[] string_title= {"value"};  
			 String[] hash_title={"row","field","value"};
			 String[] list_title={"row","value"};
			 String[] set_title={"row","member"};
			 String[] zset_title={"row","score","member"};
			 
			switch(type){
	    	case "string":return string_title;
	    	case "hash"  :return hash_title;
	    	case "list"  :return list_title;
	    	case "set"   :return set_title;
	    	case "zset"  :return zset_title;
	    	default: return null;
	    	}
		}
	    
	    public void addRow(int i) {
	    	//System.out.println("addRow");
	    	Vector<String> v=new Vector<String>();
	    	v.add(0,""+content.size());
	    	//将数据直接存入数据库
	    	switch(type){
	    	case "zset":{
	    		v.add(""+0);
	    		String s=beDifferent("member"+count);
	    		v.add(s);
	    		content.add(v);
	    		key.setZset(1,s);
	    		break;
	    	}
	    	case "set" :{
	    		String s=beDifferent("nul");
	    		v.add(s);
	    		content.add(v);
	    		key.setSet(v.get(1));
	    		break;
	    	}

	    	case "hash":{
	    		String s=beDifferent("field"+count);
	    		v.add(s);
	    		v.add("null");
	    		content.add(v);
	    		key.setHash(v.get(1), v.get(2));
	    		break;
	    	}
	    	
	    	
	    	case "list":{
	    		Vector<String> v1=new Vector<String>();
	    		//i为零时左插
	    		if(0==i){
		    		v1.add("0");
		    		v1.add("null");
		    		content.add(0,v1);
		    		key.setListleft(v1.get(1));
		    		for(int j=1;j<content.size();j++){
		    			setValueAt(j,j,0);
		    			content.get(j).remove(0);  
		    	        content.get(j).add(0,""+j); 
		    		}
	    		}else{
	    			v1.add(""+content.size());
	    			v1.add("null");
	    			content.add(v1);
	    			key.setListRigh(v1.get(1));
	    		}
	    		break;
	    	}
	    	}
	    }
		public void removeRow(int row,int flag) {  
	    	
	        try{
	        	//先进行删除
	        	switch(type){
	        	case "set":{
	        		key.delSet(getValueAt(row,1).toString());
	        		break;
	        	}
	        	case "hash":{
	        		key.delHash(getValueAt(row,1).toString());
	        		break;
	        	}
	        	case "zset":{
	        		key.delZset(getValueAt(row,2).toString());
	        		break;
	        	}
	        	case "list":{
	        		if(0==flag){
	        			key.delListLef();
	        			break;
	        		}else {
	        			row=content.size()-1;
	        			String s=Connect.cluster.rpop("list");
	        			System.out.println(s);
	        			break;
	        		}
	        	}
	        	}
	        	
	    		content.remove(row);
	        }catch(ArrayIndexOutOfBoundsException e){
	        	System.out.println("请选择要删除的行  row="+row);
	        }
	        for(int i=row;i<content.size();i++){
	        	int a=Integer.parseInt(getValueAt(i,0).toString());
	        	setValueAt(a-1,i,0);
	        }
	        
	    }  
		
		public String beDifferent(String s){
			
			if(type.equals("hash")||type.equals("set")){
				for(int i=0;i<content.size();i++){
					if(s.equals(getValueAt(i,1))){
						s=s+"PP";
						beDifferent(s);
						count++;
					}
				}
				return s;
			}
			else{
				for(int i=0;i<content.size();i++){
					if(s.equals(getValueAt(i,2))){
						s=s+"@";
						beDifferent(s);
						count++;
					}
				}
				return s;
			}
		}
}

