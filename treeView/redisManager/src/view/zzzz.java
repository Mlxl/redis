//package view;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.util.Vector;
//
//import javax.swing.*;
//import javax.swing.JPanel;
//import javax.swing.table.DefaultTableModel;
//
//import model.ConectInfo;
//import model.MyMutableTreeNode;
//
//public class zzzz extends Window{
//	
//	MyMutableTreeNode treenode;
//	
//	JPanel panelname;
//	JPanel panelvalue;
//	JPanel panelkey;
//	JPanel panelfun;
//	
//	public zzzz(){
//		//����scrollPane
//		scrollPane.setVisible(false);
//		
//		//װ��keyPanel
//		add(keyPanel,BorderLayout.CENTER);
//		keyPanel.setVisible(true);
//		
//		
//	}
//	
//	//key���
//	public void showkeys(){
//		panelname=new JPanel();
//		panelfun=new JPanel();
//		JScrollPane scroll=new JScrollPane();
//		keyPanel.add(panelname,BorderLayout.NORTH);
//		keyPanel.add(scroll, BorderLayout.CENTER);
//		keyPanel.add(panelfun, BorderLayout.EAST);
//		//����ģ��
//		{
//			JTextField jtxf1=new JTextField(10);
//			JTextField jtxf2=new JTextField(30);
//			JTextField jtxf3=new JTextField(10);
//			JTextField jtxf4=new JTextField(10);
//			
//			//��Ϊֻ��״̬
//			jtxf1.setEnabled(true);
//			jtxf2.setEnabled(true);
//			jtxf3.setEnabled(true);
//			jtxf4.setEnabled(true);
//			
//			jtxf1.setFont(new Font("����",Font.BOLD|Font.ITALIC,16));
//			//����ˮƽ����
//			//jtf4.setHorizontalAlignment(JTextField.CENTER);
//			
//			panelname.add(jtxf1);
//			panelname.add(jtxf2);
//			panelname.add(jtxf3);
//			panelname.add(jtxf4);
//			
//			JButton jb1=new JButton("������");
//			JButton jb2=new JButton("ɾ��");
//			
//			panelname.add(jb1);
//			panelname.add(jb2);
//		}
//		
//		//keyֵչʾ
//		{	
//			DefaultTableModel model=new DefaultTableModel();
//			int i=treenode.getType();
//			switch(i){
//				case 0:
//			}
//		}
//	}
//	
//	//����value����
//	public void showValue(){
//
//		panelvalue=new JPanel();
//		JTextField jtf=new JTextField("value");
//		jtf.setFont(new Font("����",Font.BOLD|Font.ITALIC,16));
//		JTextArea jta1=new JTextArea(10,15);
//		
//		jta1.setTabSize(4);  
//        jta1.setFont(new Font("�꿬��", Font.BOLD, 16));  
//        jta1.setLineWrap(true);// �����Զ����й���  
//        jta1.setWrapStyleWord(true);// ������в����ֹ���  
//        jta1.setBackground(Color.pink);
//        
//    	panelkey.add(jtf);
//    	panelkey.add(jta1);
//	}
//	
//	//����key����
//	public void showKey(){
//		panelkey=new JPanel();
//		JTextField jt=new JTextField("Key");
//		jt.setFont(new Font("����",Font.BOLD|Font.ITALIC,16));
//		JTextArea jta=new JTextArea(10,15);
//		
//		jta.setTabSize(4);  
//        jta.setFont(new Font("�꿬��", Font.BOLD, 16));  
//        jta.setLineWrap(true);// �����Զ����й���  
//        jta.setWrapStyleWord(true);// ������в����ֹ���  
//        jta.setBackground(Color.pink);
//        
//    	panelkey.add(jt);
//    	panelkey.add(jta);
//	}
//	
//}
//class DataTableModel extends DefaultTableModel{
//	 private static final long serialVersionUID = -7495940408592595397L;  
//	  
//	    private Vector content = null;  
//	    private int size;
//	    private String[] title_name;  
//	    
//	    public DataTableModel(String[] s) {  
//	    	content = new Vector();  
//	    	this.title_name=s;
//	    }  
//	  
//	    public DataTableModel(int count,String[] s) {  
//	    	content = new Vector(count); 
//	    	this.title_name=s;
//	    }  
//	  
//	    public void addRow(String IP,String port,String path) {  
//	        Vector<String> v = new Vector<String>();  
//	        v.add(0,""+content.size());  
//	        v.add(1,IP);  
//	        v.add(2,port);
//	        v.add(3,path);
//	        content.add(v); 
//	    }  
//	  
//	    public void removeRow(int row) {  
//	        content.remove(row); 
//	        for(int i=row;i<content.size();i++){
//	        	int a=Integer.parseInt(getValueAt(i,0).toString());
//	        	setValueAt(a-1,i,0);
//	        }
//	    }  
//	  
//
//	    /**  
//	     * �ñ����ĳЩֵ���޸ģ�����ҪsetValueAt(Object value, int row, int col)������ϲ���ʹ�޸���Ч  
//	     */  
//	    public boolean isCellEditable(int rowIndex, int columnIndex) {    
//	         return false;  
//	    }  
//	  
//	    /**  
//	     * ʹ�޸ĵ�������Ч  
//	     */  
//	    public void setValueAt(Object value, int row, int col) {  
//	        ((Vector) content.get(row)).remove(col);  
//	        ((Vector) content.get(row)).add(col, value); 
//	        this.fireTableCellUpdated(row, col);  
//	    }  
//	  
//	    public String getColumnName(int col) {  
//	        return title_name[col];  
//	    }  
//	  
//	    public int getColumnCount() {  
//	        return 4;  
//	    }  
//	  
//	    public int getRowCount() {
//	    	try{
//	        	return content.size();
//	    	}catch(Exception e){
//	    		return 1;
//	    	}
//	    }  
//	  
//	    public Object getValueAt(int row, int col) {  
//	        return ((Vector) content.get(row)).get(col);
//	      
//	    }  
//	  
//	    /**  
//	     * ������������  
//	     */  
//	    public Class getColumnClass(int col) {  
//	        return getValueAt(0, col).getClass();  
//	    }
//	    
//	    //���ݵ�ConectInfo�ľ�̬��Ա����
//	    public void savaContent(){
//	    	ConectInfo.s=new String[content.size()][3];
//	    	for(int i=0;i<content.size();i++){
//	    		for(int j=0;j<3;j++){
//	    			ConectInfo.s[i][j]=((Vector) content.get(i)).get(j+1).toString();
//	    		}
//	    
//	    	}
//	    }
//}
//
