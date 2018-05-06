package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

public class View<T> extends JFrame implements Observer {
     JMenuBar menuBar;
     JMenu alarms, clock;
     JTable  table;
     JScrollPane scrollPane;
     JPanel panel2;
     Container pane;
     public ArrayList<String> alarmList; 
     
     static PriorityQueue<Alarm> q;
     public static int newAlarmTime;
     public static String newAlarmTimeStr;
     public static String newAlarmName;
     public Object [][] tableArray[][];

    
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
    
    
    
    public View(Model model) {
        JFrame frame = new JFrame();
        q = new OrderedLinkedList<>();
        panel = new ClockPanel(model);
        table =new JTable();
        scrollPane = new JScrollPane();
        
        
        
        //frame.setContentPane(panel);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setModel(new javax.swing.table.DefaultTableModel(
    tableArray,
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
        
        JButton button = new JButton(new AbstractAction("output list") {
    public void actionPerformed(ActionEvent e) {
        
        try {        
            listToString();
        } catch (QueueUnderflowException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void createMenu() throws QueueUnderflowException{
       if(!q.isEmpty()){
        
       
       Object currentLinkObj = q.head();
       
       int position = 0;
       String currentLink = String.valueOf(currentLinkObj);
       
       currentLinkName =  currentLink.split(", ")[0];
       currentLinkTime = currentLink.split(", ")[1];
       
       addToTable(position,currentLinkName,currentLinkTime );
       
       int currentLinkTimeInt = Integer.parseInt(currentLinkTime);
       
        
      
      
             
      
      System.out.println("first Link time "+currentLinkTimeInt);
      
      while(q.nextLink(currentLinkTimeInt) != null){
            System.out.println("next Link "+q.nextLink(currentLinkTimeInt));
            currentLink = String.valueOf(q.nextLink(currentLinkTimeInt));  
            position = position + 1;
            currentLinkName =  currentLink.split(", ")[0];
            currentLinkTime = currentLink.split(", ")[1];
            addToTable(position,currentLinkName,currentLinkTime );
            
            System.out.println(alarmList);
        
            currentLinkTimeInt = Integer.parseInt(currentLinkTime);
            
            

          
      }
       
       System.out.println(q.toString());
        
       } else{
            System.out.println("Wudup");
       }
       
      
    }
    
 public void addToTable(int position, String AlarmName, String AlarmTime){
       
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.insertRow( position, new Object[] { AlarmName, AlarmTime });
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
        
        
        
    }
}
