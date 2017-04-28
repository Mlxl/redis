//�Զ���tablemodel
package view;

import model.CollectData;
import model.NodeInfomation;
import model.ServerManage;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class InfoTableModel extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;
	//����panelInfo�������Ϣ
	private Vector<Vector<String>> content;
	
	
	private String []title_name={"�ڵ�","��ַ","��ɫ","���ڵ�","״̬","��ͣ","�۵�","����"};
	
	 public InfoTableModel() {  
	    	content = new Vector<Vector<String>>();  
	    }  
	
	//
	public InfoTableModel(int i, int j) {
		super(i, j);
		
		CollectData data=new CollectData();
		List<NodeInfomation> info=data.getNodesInfo();
		content=new Vector<Vector<String>>(info.size());
		for(int j1=0;j1<info.size();j1++){
			Vector<String> v=new Vector<String>();
			//�ڵ���
			v.add(0,"�ڵ�"+j1);
			//��ַ
			v.add(1,info.get(j1).getLocation());
			//��ɫ
			v.add(2,info.get(j1).getRoles());
			//���ڵ�
			v.add(3,info.get(j1).getMaster());
			v.add(4,"������");
			v.add(5,"ֹͣ");
			v.add(6,info.get(j1).getSlotf());
			v.add(7,"�޸�");
			content.add(v);
		}
	}
	//����������ʾ
    @Override  
    public Object getValueAt(int row, int column)  
    {  
    	return content.get(row).get(column); 
    }  

    @Override  
    public int getRowCount()  
    {  
        try{
        	return content.size();
        }catch(Exception e){
        	
        }
        return 0;
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
		        //Ϊ������д���¼�
		        if(column==2&&(getValueAt(row,column)!=value)){
		        	if(value=="���ڵ�"){
						String[]s=getValueAt(row, 1).toString().split(":");
						ServerManage smg=new ServerManage();
						smg.exec("redis-cli -c -p "+s[1]+" cluster failover");
					}
					else {
						String val=getValueAt(row,1).toString();
						int i=0;
						while(!getValueAt(i,3).equals(val)){
							i++;
						}
						
						String[]s=getValueAt(i, 1).toString().split(":");
						ServerManage smg=new ServerManage();
						smg.exec("redis-cli -c -p "+s[1]+" cluster failover");
					}
		        	Window.scrollPane.updateUI();
		        }
		    	content.get(row).remove(column);  
		        content.get(row).add(column, value.toString());  
		        this.fireTableCellUpdated(row, column);
    }  
    
  
    /**  
     * ������������  
     */  
//    public Class getColumnClass(int col) {  
//        return getValueAt(0, col).getClass();  
//    }  
    
    //�Ƿ�ɱ༭
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
	

