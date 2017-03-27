package view;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.ConectInfo;

public class ConnTableModel extends DefaultTableModel{
	 private static final long serialVersionUID = -7495940408592595397L;  
	  
	    private Vector content = null;  
	    private int size;
	    private String[] title_name = {"ID","IP","�˿�","·��"};  
	  
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
	     * �ñ����ĳЩֵ���޸ģ�����ҪsetValueAt(Object value, int row, int col)������ϲ���ʹ�޸���Ч  
	     */  
	    public boolean isCellEditable(int rowIndex, int columnIndex) {  
	        if (columnIndex == 0) {  
	            return false;  
	        }  
	        return true;  
	    }  
	  
	    /**  
	     * ʹ�޸ĵ�������Ч  
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
	     * ������������  
	     */  
	    public Class getColumnClass(int col) {  
	        return getValueAt(0, col).getClass();  
	    }
	    
	    //���ݵ�ConectInfo�ľ�̬��Ա����
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










