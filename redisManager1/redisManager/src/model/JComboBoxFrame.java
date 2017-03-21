//下拉框例子
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxFrame extends JFrame
{
    private JComboBox cb = new JComboBox();
    
    public JComboBoxFrame()
    {
        cb.addItem("1");
        cb.addItem("2");
        cb.addItem("3");
        
        cb.addItemListener(new ItemListener()
            {
                public void itemStateChanged(ItemEvent event)
                {
                    switch (event.getStateChange())
                    {
                    case ItemEvent.SELECTED: 
                        System.out.println("选中" + event.getItem());
                        break;
                    case ItemEvent.DESELECTED:
                        System.out.println("取消选中" + event.getItem());
                        break;
                    }
                }
            });
        
        add(cb);
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new JComboBoxFrame();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
