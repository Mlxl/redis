package view;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector content=null;
	
	private int size;
	
	private String []title_name={"��ַ","�˿�","��ɫ","���ڵ�","״̬","��ͣ","�۵�"};
	
	 public MyTableModel() {  
	    	content = new Vector();  
	    }  
	public MyTableModel(int i){
		content=new Vector(i);
		for(int j=0;j<i;j++){
			Vector v=new Vector(7);
			v.add(0,"xxxxxxx1");
			v.add(1,"6739");
			v.add(2,"���ڵ�");
			v.add(3,"��");
			v.add(4,"δ����");
			v.add(5,"����");
			v.add(6,"1-16383");
			content.add(v);
		}
	}
	
	public MyTableModel(int i, int j) {
		super(i, j);
		

		content=new Vector(i);
		for(int j1=0;j1<i;j1++){
			Vector v=new Vector(7);
			v.add(0,"xxxxxxx1");
			v.add(1,"6739");
			v.add(2,"���ڵ�");
			v.add(3,"��");
			v.add(4,"δ����");
			v.add(5,"����");
			v.add(6,"1-16383");
			content.add(v);
		}
	
		this.size=j;
	}
	//����������ʾ
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
    public void setValueAt(Object Value, int row, int column) { 
    	((Vector) content.get(row)).remove(column);  
        ((Vector) content.get(row)).add(column, Value);  
        this.fireTableCellUpdated(row, column);  
    }  
    
  
    /**  
     * ������������  
     */  
//    public Class getColumnClass(int col) {  
//        return getValueAt(0, col).getClass();  
//    }  

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
	

