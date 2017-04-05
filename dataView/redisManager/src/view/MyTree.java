package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;  
import javax.swing.JMenuItem;  
import javax.swing.JPopupMenu;  
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;  
import javax.swing.tree.DefaultTreeCellEditor;  
import javax.swing.tree.DefaultTreeCellRenderer;  
import javax.swing.tree.DefaultTreeModel;  
import javax.swing.tree.TreePath;  
import javax.swing.tree.TreeSelectionModel;

import model.Connect;
import model.DataTableModel;
import model.Keys;
import model.MyMutableTreeNode;  
  
public class MyTree implements MouseListener,ActionListener {  
      
    private static final long serialVersionUID = 1L;  
    private static DefaultMutableTreeNode DataBase;
    private static Boolean flag=false;
    private static JTree tree;  
    private static JScrollPane js;
    
    DefaultTreeModel model;
    JPopupMenu popMenuroot;
    JPopupMenu popMenuchil;
    JMenuItem addItem;  
    JMenuItem delItem;  
    JMenuItem editItem;  
    JMenuItem delItem1;
    
    private Keys keys;
    
    JMenuItem editItem1;
    
    private int index=0;
    public MyTree() {
    		try{
    			Window.contain.remove(js);
    		}catch(Exception e){
    			
    		}
	    	DataBase=new DefaultMutableTreeNode("DataBase");
	        //������е�keys
	        keys=new Keys();
	        List k=keys.getKeysName();
	        for(int i=0;i<k.size();i++){
	        	DataBase.add(new DefaultMutableTreeNode(k.get(i).toString()));
	        }
	        
	        //ʵ����tree
	        model=new DefaultTreeModel(DataBase);
	        tree=new JTree(model);
	        
	        tree.setEditable(true);  
	        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  
	        tree.addMouseListener(this);  
	        tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer()));  
	        
	        js=new JScrollPane();
	        js.setViewportView(tree);
	        js.setPreferredSize(new Dimension(180,Window.scrollPane.getHeight()));
	        Window.contain.add(js,BorderLayout.WEST);
	        
	        //����һ��˵�
	        addMenu();
    }
    
    public void addMenu(){
    	 popMenuroot = new JPopupMenu();  
         addItem = new JMenuItem("���");  
         addItem.addActionListener(this);  
         delItem = new JMenuItem("ɾ��");  
         delItem.addActionListener(this);  
         editItem = new JMenuItem("�޸�");  
         editItem.addActionListener(this);  
   
         popMenuroot.add(addItem);    
         popMenuroot.add(delItem);    
         popMenuroot.add(editItem);
    }
    //����¼�
    public void mouseClicked(MouseEvent e) { 
    	//˫����ʾ����
    	TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // �ؼ������������ʹ��  
        if (path == null) {  
        	return;  
        }
    	if(e.getClickCount()==2){
    		 DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    		 String keyname=node.toString();
    		 if(node.isRoot())return;
    		// System.out.println("���ִ��"+keyname);
    		 //��ʾkey�����Ϣ
    		 PanelKey paneldata=new PanelKey(keyname);
    		 
    	}
    }  
    
    public void mouseEntered(MouseEvent e) {  
    	
    }  
  
    public void mouseExited(MouseEvent e) {  
  
    }  
    
    //���´���
    public void mousePressed(MouseEvent e) {  
    	TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // �ؼ������������ʹ��  
        if (path == null) {  
        	return;  
        }  
        tree.setSelectionPath(path);
        if(e.getButton() == 3){
//	        if (node.isRoot()) {  
	            popMenuroot.show(tree, e.getX(), e.getY());  
//	        }else popMenuchil.show(tree, e.getX(), e.getY());
        }
    }  
    //����ͷ�ʱ����
    public void mouseReleased(MouseEvent e) {  
  
    }  
  
    public void actionPerformed(ActionEvent e) {  
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  
        if (e.getSource() == addItem) {  
        	if(node.isRoot()){
        		((DefaultTreeModel) tree.getModel()).insertNodeInto(new DefaultMutableTreeNode("key"+(index++)), node, node  
                    .getChildCount());  
        		tree.expandPath(tree.getSelectionPath());
        	}
        } else if (e.getSource() == delItem) {  
            if (node.isRoot()) {  
                return;  
            }  
            ((DefaultTreeModel) tree.getModel()).removeNodeFromParent(node);  
        } else if (e.getSource() == editItem) {  
            tree.startEditingAtPath(tree.getSelectionPath());  
        }  
    } 
  
} 