package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import static jdk.nashorn.tools.ShellFunctions.input;

public class View<T> extends JFrame implements Observer {

    
     JMenuBar menuBar;
     JMenu alarms, clock;
     JTable  table;
     JScrollPane scrollPane;
     JPanel panel2;
     Container pane;
     public ArrayList<String> alarmList; 
     public int currentTime;
     
     static PriorityQueue<Alarm> q;
     public static int newAlarmTime;
     public static String newAlarmTimeStr;
     public static String newAlarmName;
     

    
     public String currentLinkName;
     public String currentLinkTime;
     
   
   
     AddingAlarm newAddAlarm = new AddingAlarm();
     
     
     
     
     
    ClockPanel panel;
    
    public static  void setNewAlarm(String alarmtimeString, String alarmName) throws QueueOverflowException{
   
        newAlarmTimeStr = alarmtimeString;
        newAlarmName = alarmName;
        newAlarmTime = Integer.parseInt(alarmtimeString) ;
        
        Alarm alarm = new Alarm(newAlarmName, newAlarmTimeStr);
        q.add(alarm, newAlarmTime);
       
        
    }
    public void save() throws FileNotFoundException{
    
    try (PrintStream out = new PrintStream(new FileOutputStream("alarms.txt"))) {
    out.print(q.toString());
}
    }
    
    public void load() throws FileNotFoundException, IOException{
    
      
    }
    
    
    
    
    public View(Model model) {
        final JFrame frame = new JFrame();
        q = new OrderedLinkedList<>();
        panel = new ClockPanel(model);
        table =new JTable();
        scrollPane = new JScrollPane();
        //currentTime = model.update();
        
        
        //frame.setContentPane(panel);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setModel(new javax.swing.table.DefaultTableModel(
    new Object [0][0],
    new String [] {
        "Alarm Name", "Alarm Timel"
    }
) {
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class
    };
    boolean[] canEdit = new boolean [] {
        false, false
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
});
        
        
   frame.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        int input = JOptionPane.showConfirmDialog(null, "Do you want to save alarms?");
        
        if (input ==1){
            
            
        }else if (input == 0){
            try {
                
                save();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
        } 
        }
    }
    
    
        // 0=yes, 1=no, 2=cancel
        //System.out.println(input);
);     
        
        
        

scrollPane.setViewportView(table);

if (table.getColumnModel().getColumnCount() > 0) {
    table.getColumnModel().getColumn(0).setResizable(false);
    table.getColumnModel().getColumn(1).setResizable(false);
}

        
        // Start of border layout code
        
        // I've just put a single button in each of the border positions:
        // PAGE_START (i.e. top), PAGE_END (bottom), LINE_START (left) and
        // LINE_END (right). You can omit any of these, or replace the button
        // with something else like a label or a menu bar. Or maybe you can
        // figure out how to pack more than one thing into one of those
        // positions. This is the very simplest border layout possible, just
        // to help you get started.
        
        
        menuBar = new JMenuBar();
        alarms = new JMenu("Show Alarms");
        clock = new JMenu("Show Clock");
        
        
      
        
        
        menuBar.add(alarms);
        menuBar.add(clock);
        
        Container pane = frame.getContentPane();
        
        JButton button = new JButton(new AbstractAction("save list") {
    public void actionPerformed(ActionEvent e) {
        
                
        
        
    }
});
        pane.add(button, BorderLayout.PAGE_START);
        
panel.setPreferredSize(new Dimension(200, 200));
        scrollPane.setPreferredSize(new Dimension(200, 200));
        pane.add(panel, BorderLayout.CENTER);
        pane.add(scrollPane, BorderLayout.EAST);


         JButton addAlarm = new JButton(new AbstractAction("Add Alarm") {
    public void actionPerformed(ActionEvent e) {
        newAddAlarm.createFrame();
    }
});
       
        pane.add(addAlarm, BorderLayout.PAGE_END);
        
    
        
        // End of borderlayout code
        
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
    }
    
    public int getQueuePosition() throws QueueUnderflowException{
        int qPos = 0;
        if(!q.isEmpty()){
        
   
        Object currentLinkObj = q.head();
        String currentLink = String.valueOf(currentLinkObj);
        currentLinkTime = currentLink.split(", ")[1];
        int currentLinkTimeInt = Integer.parseInt(currentLinkTime);
        if (currentLinkTimeInt < currentTime){
            qPos = qPos+1;
        }
        
        
        while(q.nextLinkprio(currentLinkTimeInt) <= currentTime && q.nextLink(currentLinkTimeInt) != null  ){
        qPos = qPos+1;
         currentLink = String.valueOf(q.nextLink(currentLinkTimeInt)); 
         currentLinkName =  currentLink.split(", ")[0];
       //  System.out.println(currentLinkTime);
        currentLinkTime = currentLink.split(", ")[1];
        currentLinkTimeInt = Integer.parseInt(currentLinkTime);
        
        }
        }
        
        return qPos; 
    }
    
    public void createMenu() throws QueueUnderflowException{
       if(!q.isEmpty()){
       DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
       tmodel.setRowCount(0);
       Object currentLinkObj = q.head();
       
       
       int position = 0;
       String currentLink = String.valueOf(currentLinkObj);
       
       currentLinkName =  currentLink.split(", ")[0];
       currentLinkTime = currentLink.split(", ")[1];
       
       addToTable(position,currentLinkName,currentLinkTime );
       
       int currentLinkTimeInt = Integer.parseInt(currentLinkTime);
     
     // System.out.println("first Link time "+currentLinkTimeInt);
      
      while(q.nextLink(currentLinkTimeInt) != null){
         //   System.out.println("next Link "+q.nextLink(currentLinkTimeInt));
            currentLink = String.valueOf(q.nextLink(currentLinkTimeInt));  
            position = position + 1;
            currentLinkName =  currentLink.split(", ")[0];
            currentLinkTime = currentLink.split(", ")[1];
            addToTable(position,currentLinkName,currentLinkTime );
            
          
        
            currentLinkTimeInt = Integer.parseInt(currentLinkTime);
            
            

          
      }
       
       System.out.println(q.toString());
        
       } else{
            
       }
       
      
    }
    
 public void addToTable(int position, String AlarmName, String AlarmTime){
       
        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
        tmodel.insertRow( position, new Object[] { AlarmName, AlarmTime });
   }    
    
public ArrayList<String> getArrayList() throws QueueOverflowException{
        return alarmList;
        
      
        
//        String name = newAddAlarm.getAlarmName();
//        Alarm alarm = new Alarm(name);
      
    }
    
    public void listToString() throws QueueUnderflowException{
       
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
        currentTime = (int)arg;
        System.out.println("this is the current Time "+ currentTime);
         try { 
             createMenu();
         } catch (QueueUnderflowException ex) {
             Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         try {
             System.out.println("this is the amount of alarms before the time it is now "+getQueuePosition());
         } catch (QueueUnderflowException ex) {
             Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
}
