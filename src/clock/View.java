package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.text.DefaultCaret;

public class View implements Observer {
     JMenuBar menuBar;
     JMenu alarms, clock;
     static PriorityQueue<Alarm> q;
     public static int newAlarmTime;
     public static String newAlarmTimeStr;
     public static String newAlarmName;
   
     
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
        //frame.setContentPane(panel);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        
       listToString();        
    }
});
        pane.add(button, BorderLayout.PAGE_START);
         
        panel.setPreferredSize(new Dimension(200, 700));
        pane.add(panel, BorderLayout.CENTER);
         
       
         
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
    
    
public void addtoList() throws QueueOverflowException{
        
        
      
        
//        String name = newAddAlarm.getAlarmName();
//        Alarm alarm = new Alarm(name);
        
        
    }
    
    public void listToString(){
       System.out.println(q);
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
        
        
    }
}
