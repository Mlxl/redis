package view;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.ConectInfo;

public class ConnTableModel extends DefaultTableModel{
	 private static final long serialVersionUID = -7495940408592595397L;  
	  
	    private Vector content = null;  
	    private int size;
	    private String[] title_name = {"ID","IP","端口","路径"};  
	  
	    public ConnTableModel() {  
	    	content = new Vector();  
	    }  
	  
	    public ConnTableModel(int count) {  
	    	content = new Vector(count); 
	    	
	    }  
	  
	    public void addRow(String IP,String port,String path) {  
	        Vector<String> v = new Vector<String>(4);  
	        v.add(0,""+content.size());  
	        v.add(1,IP);  
	        v.add(2,port);
	        v.add(3,path);
	        content.add(v); 
	    }  
	  
	    public void removeRow(int row) {  
	        content.remove(row); 
	        for(int i=row;i<content.size();i++){
	        	int a=Integer.parseInt(getValueAt(i,0).toString());
	        	setValueAt(a-1,i,0);
	        }
	    }  
	  

	    /**  
	     * 让表格中某些值可修改，但需要setValueAt(Object value, int row, int col)方法配合才能使修改生效  
	     */  
	    public boolean isCellEditable(int rowIndex, int columnIndex) {  
	        if (columnIndex == 0) {  
	            return false;  
	        }  
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
	        return 4;  
	    }  
	  
	    public int getRowCount() {
	    	try{
	        	return content.size();
	    	}catch(Exception e){
	    		return 1;
	    	}
	    }  
	  
	    public Object getValueAt(int row, int col) {  
	        return ((Vector) content.get(row)).get(col);
	      
	    }  
	  
	    /**  
	     * 返回数据类型  
	     */  
	    public Class getColumnClass(int col) {  
	        return getValueAt(0, col).getClass();  
	    }
	    
	    //传递到ConectInfo的静态成员当中
	    public void savaContent(){
	    	ConectInfo.s=new String[content.size()][3];
	    	for(int i=0;i<content.size();i++){
	    		for(int j=0;j<3;j++){
	    			ConectInfo.s[i][j]=((Vector) content.get(i)).get(j+1).toString();
	    		}
	    
	    	}
//	    	for(int i=0;i<ConectInfo.s.length;i++){
//	    		for(int j=0;j<3;j++){
//	    			System.out.print(ConectInfo.s[i][j]);
//	    			System.out.print(" ");
//	    		}
//	    		System.out.println();
//	    	}
	    }
}










