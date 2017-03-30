package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import javax.swing.JFrame;  
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
  
public class MyTree implements MouseListener,ActionListener {  
      
    private static final long serialVersionUID = 1L;  
    JTree tree;  
    JPopupMenu popMenu;  
    JMenuItem addItem;  
    JMenuItem delItem;  
    JMenuItem editItem;  
  
    public MyTree() {  
        tree = new JTree();  
        tree.setEditable(true);  
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  
        tree.addMouseListener(this);  
        tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer()));  
        
        
        popMenu = new JPopupMenu();  
        addItem = new JMenuItem("添加");  
        addItem.addActionListener(this);  
        delItem = new JMenuItem("删除");  
        delItem.addActionListener(this);  
        editItem = new JMenuItem("修改");  
        editItem.addActionListener(this);  
  
        popMenu.add(addItem);  
        popMenu.add(delItem);  
        popMenu.add(editItem);  
        
        Window.treePanel.add(tree);
//        JScrollPane js=new JScrollPane(tree);
//        js.setPreferredSize(new Dimension(180,Window.scrollPane.getHeight()));
//        Window.contain.add(js,BorderLayout.WEST);
    }  
  
    public void mouseClicked(MouseEvent e) {  
  
    }  
  
    public void mouseEntered(MouseEvent e) {  
  
    }  
  
    public void mouseExited(MouseEvent e) {  
  
    }  
  
    public void mousePressed(MouseEvent e) {  
        TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用  
        if (path == null) {  
        	System.out.println("无效mousePress");
        	return;  
        }  
        tree.setSelectionPath(path);  
  
        if (e.getButton() == 3) {  
            popMenu.show(tree, e.getX(), e.getY());  
        }  
    }  
  
    public void mouseReleased(MouseEvent e) {  
  
    }  
  
    public void actionPerformed(ActionEvent e) {  
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  
        if (e.getSource() == addItem) {  
            ((DefaultTreeModel) tree.getModel()).insertNodeInto(new DefaultMutableTreeNode("Test"), node, node  
                    .getChildCount());  
            tree.expandPath(tree.getSelectionPath());  
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