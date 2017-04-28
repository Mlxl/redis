package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JMenuItem;  
import javax.swing.JPopupMenu;  
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;  
import javax.swing.tree.DefaultTreeCellEditor;  
import javax.swing.tree.DefaultTreeCellRenderer;  
import javax.swing.tree.DefaultTreeModel;  
import javax.swing.tree.TreePath;  
import javax.swing.tree.TreeSelectionModel;

import model.Connect;
import model.Key;
import model.KeyInfo;
import model.Keys;
import redis.clients.jedis.JedisCluster;
  
public class PanelTree implements MouseListener,ActionListener {  
      
    private static DefaultMutableTreeNode DataBase;
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
    
   
    public PanelTree() {
    		try{
    			Window.contain.remove(js);
    		}catch(Exception e){
    			
    		}
	    	DataBase=new DefaultMutableTreeNode("DataBase");
	        //获得所有的keys
	        keys=new Keys();
	        List<String> k=keys.getKeysName();
	        for(int i=0;i<k.size();i++){
	        	DataBase.add(new DefaultMutableTreeNode(k.get(i).toString()));
	        }
	        
	        //实例化tree
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
	        
	        //添加右击菜单
	        addMenu();
    }
    
    public void addMenu(){
    	 popMenuroot = new JPopupMenu();  
         addItem = new JMenuItem("添加");  
         addItem.addActionListener(this);  
         delItem = new JMenuItem("删除");  
         delItem.addActionListener(this);  
         editItem = new JMenuItem("修改");  
         editItem.addActionListener(this);  
   
         popMenuroot.add(addItem);    
         popMenuroot.add(delItem);    
         popMenuroot.add(editItem);
    }
    //点击事件
    public void mouseClicked(MouseEvent e) { 
    	//双击显示数据
    	TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用  
        if (path == null) {  
        	return;  
        }
    	if(e.getClickCount()==2){
    		 DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    		 String keyname=node.toString();
    		 if(node.isRoot())return;
    		// System.out.println("点击执行"+keyname);
    		 //显示key相关信息
    		 @SuppressWarnings("unused")
			PanelKey paneldata=new PanelKey(keyname);
    		 
    	}
    }  
    
    public void mouseEntered(MouseEvent e) {  
    	
    }  
  
    public void mouseExited(MouseEvent e) {  
  
    }  
    
    //按下触发
    public void mousePressed(MouseEvent e) {  
    	TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用  
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
    //鼠标释放时触发
    public void mouseReleased(MouseEvent e) {  
  
    }  
  
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {  
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  
        if (e.getSource() == addItem) {  
        	if(node.isRoot()){
        		//打开弹窗
        		KeyInfo kif=new KeyInfo();
        		DataDialog dialog=new DataDialog(Window.window,Window.table,kif,true);
        		dialog.show();
        		//如果点击了cancel  则不会发生操作
        		if(!kif.isFlag()) return ;
        		
        		//在redis库中插入
        		Key key=new Key(kif.getKeyname());
        		switch(kif.getKeytype()){
        		case "string": key.setSet("value");break;
        		case "hash": key.setHash("field", "value");break;
        		case "list": key.setListleft("value");break;
        		case "set": key.setSet("member");break;
        		case "zset": key.setZset(0, "member");
        		}
        		//树种增加节点
        		((DefaultTreeModel) tree.getModel()).insertNodeInto(new DefaultMutableTreeNode(kif.getKeyname()), node, node  
                    .getChildCount());  
        		tree.expandPath(tree.getSelectionPath());
        		
        	}
        } else if (e.getSource() == delItem) {  
            if (node.isRoot()) {  
                return;  
            }
            ((DefaultTreeModel) tree.getModel()).removeNodeFromParent(node);  
            //从数据库中删除
        	JedisCluster cluster=new Connect().getCluster();
    		cluster.del(node.toString());
    		try{
    			cluster.close();
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
            
            
        } else if (e.getSource() == editItem) {  
            tree.startEditingAtPath(tree.getSelectionPath());  
        }  
    } 
  
}