package view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ConectInfo;

public class PanelData extends JPanel{
	
	private KeyDataTableModel model;
	private JTable table;
	private String [] title_name;
	private int flag;
	
	public PanelData(){
		//�ػ�southPanel��scrollPanel
		Window.southPanel.removeAll();
		
		DefaultTableModel model=new DefaultTableModel();
		JTable table =new JTable(model);
		Window.scrollPane.setViewportView(table);
		System.out.println("PanelData");
		
		
		//�ػ�treePanel
		MyTree tree=new MyTree();
		
	}
	
	public PanelData(int flag){
		//���southPanel�еİ�ť
		Window.southPanel.removeAll();
		
		title_name=this.getTitle_name(flag);
		model=new KeyDataTableModel(title_name);
		table=new JTable(model);
		Window.scrollPane.setViewportView(table);
		
		//����ײ���Ӱ�ť
		{
			JButton addkey=new JButton("+");
			JButton delkey=new JButton("-");
			JButton appkey=new JButton("��");
			JButton leftadd=new JButton("L+");
			JButton righadd=new JButton("R+");
			
			if(flag==2){
				Window.southPanel.add(leftadd);
				Window.southPanel.add(righadd);
				Window.southPanel.add(delkey);
				Window.southPanel.add(appkey);
			}else{
				Window.southPanel.add(addkey);
				Window.southPanel.add(delkey);
				Window.southPanel.add(appkey);
			}
		}
		
		//����keypanel
		{
			
		}
	}
	
	public void addKey(int flag){
		if(flag!=0){
			model.addRow();
			table.updateUI();
		}
	}
	
	public void removeKey(){
		if(flag!=0){
			try{
				int i=table.getSelectedRow();
				model.removeRow(i);
				table.updateUI();
			}catch(Exception e){
				//���Ը����û�û��ѡ��Ҫɾ������
			}
		}
	}
	
	public void saveKey(){
		model.savaContent();
	}

	//�ҳ���ͬ�������Ͷ�Ӧ��title_name
	public String[] getTitle_name(int flag){
		 String[] title_name;
		 String[] string_title= {"value"};  
		 String[] hash_title={"value"};
		 String[] list_title={"row","value"};
		 String[] set_title={"row","value"};
		 String[] zset_title={"row","score","value"};
		 
		switch(flag){
    	case 0:return title_name=string_title;
    	case 1:return title_name=hash_title;
    	case 2:return title_name=list_title;
    	case 3:return title_name=set_title;
    	default:return title_name=zset_title;
    	}
	}
}

class KeyDataTableModel extends DefaultTableModel{


	private static final long serialVersionUID = 1L;
		private Vector content; 
	    private int colmn_count;
	    private String[] title_name;

	    public KeyDataTableModel() {  
	    	content=new Vector();  
	    }  
	  
	    public KeyDataTableModel(String[] title_name) {
	    	this.title_name=title_name;
	    	content=new Vector(); 	
	    }  
	  
	    
	    
	    public void addRow() {  
	    	Vector<String> v=new Vector<String>();
	    	v.add(0,""+content.size());
	    	for(int i=1;i<title_name.length;i++){
	    		v.add(i,title_name[i]);
	    	}
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
	        
	        return false;  
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
	        return colmn_count;  
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
	    
	    //�����ݸ���д�����ݿ�
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
}
