//�Զ���tablemodel
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
	
	private String []title_name={"�ڵ�","��ַ","��ɫ","���ڵ�","״̬","��ͣ","�۵�"};
	
	 public MyTableModel() {  
	    	content = new Vector();  
	    }  
	public MyTableModel(int i){
		Connect con=new Connect();
		List<NodeInfomation> info=con.getInfomation();
		content=new Vector(info.size());
		for(int j1=0;j1<info.size();j1++){
			Vector<String> v=new Vector<String>();
			//�ڵ���
			v.add(0,"���"+j1);
			//��ַ
			v.add(1,info.get(j1).getlocation());
			//��ɫ
			v.add(2,info.get(j1).getRoles());
			//���ڵ�
			v.add(3,info.get(j1).getMasterID());
			v.add(4,"������");
			v.add(5,"ֹͣ");
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
			//�ڵ���
			v.add(0,"�ڵ�"+j1);
			//��ַ		
			v.add(1,info.get(j1).getlocation());
			//��ɫ
			v.add(2,info.get(j1).getRoles());
			//���ڵ�
			v.add(3,info.get(j1).getMaster());
			v.add(4,"������");
			v.add(5,"ֹͣ");
			v.add(6,info.get(j1).getSlotf());
			content.add(v);
		}
	
		this.size=info.size();
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
     * ������������  
     */  
    public Class getColumnClass(int col) {  
        return getValueAt(0, col).getClass();  
    }  
    
    //�Ƿ�ɱ༭
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
	

