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


/* This is the class that renders out the app
    The queue isn't supposed to be done in here 
    but I couldn't get it to work by putting it into the model

*/

public class View<T> extends JFrame implements Observer {

    //Swing variables 

     
     JTable  table;
     JScrollPane scrollPane;
     JPanel panel2;
     Container pane;  
     JLabel nextAlarm;
     
     
     //alarm Variables used to add them to the table
     public int lastalrm;
     public static int newAlarmTime;
     public static String newAlarmTimeStr;
     public static String newAlarmName;
     public int currentTime;
     public String currentLinkName;
     public String currentLinkTime;
     
     //ArrayList sent to comboBox
     public ArrayList<String> alarmList = new ArrayList<String>(); 
     
     //headers for the JTable
     String columnHeaders[]={"Alarm Name","Alarm Time"};
     
     
     
     
     //initialisers for the q and the other frames
     static PriorityQueue<Alarm> q;
     AddingAlarm newAddAlarm = new AddingAlarm();
     EditAlarms editAlarm;
     ClockPanel panel;
     
   
    /* Method used to add an alarm to the list, the values are taken in from the adding alarm form*/ 
    public static void setNewAlarm(String alarmtimeString, String alarmName) throws QueueOverflowException{
        
        //gets an int value from the 24 hour time to be used as the priority
        newAlarmTime = Integer.parseInt(alarmtimeString) ;
        
        //creates a new alarm from these values 
        Alarm alarm = new Alarm(alarmName, alarmtimeString);
        
        //adds it to the queue
        q.add(alarm, newAlarmTime);  
    }
    
    
    
    /* Method used to save the queue */ 
    public void save() throws FileNotFoundException, QueueUnderflowException{ 
        
    //saving file to alarms.ics    
    try (PrintStream out = new PrintStream(new FileOutputStream("alarms.ics"))) {
    //if the q isn't empty    
    if(!q.isEmpty()){
        
    //these are the fields required for icalendar format    
    out.println("BEGIN:VCALENDAR");
    out.println("VERSION:2.0");
    out.println("PRODID:-//Adrians Clock//Alarm clock 1.0//EN");
    out.println("CALSCALE:GREGORIAN");
    out.println("METHOD:PUBLISH");
    out.println("BEGIN:VEVENT");
        
   
        String currentLink = String.valueOf(q.head()); //gets the string value for the 
        currentLinkName =  currentLink.split(", ")[0];//set new string values
        currentLinkTime = currentLink.split(", ")[1]; //gets the time value from the string 
        int currentLinkTimeInt = Integer.parseInt(currentLinkTime); // gets int value from the time
        
            out.println("SUMMARY:"+currentLinkName);  
            out.println("UID:"+currentLink);
            out.println("STATUS:CONFIRMED");
            out.println("TRANSP:TRANSPARENT");
            out.println("RRULE:FREQ=YEARLY;INTERVAL=1;BYMONTH=2;BYMONTHDAY=12");
            out.println("DTSTART:20080212T"+currentLinkTime+"00");
            out.println("DTEND:20080212T"+currentLinkTime+"00");
            out.println("DTEND:20080212T"+currentLinkTime+"00");
            out.println("DTSTAMP:20080212T"+currentLinkTime+"00");
            out.println("END:VEVENT");

     while(q.nextLink(currentLinkTimeInt) != null){ //if there is a next link
         
            currentLink = String.valueOf(q.nextLink(currentLinkTimeInt)); //set a new current link
            
            
            currentLinkName =  currentLink.split(", ")[0]; //get new alarm and time values
            currentLinkTime = currentLink.split(", ")[1];
            out.println("SUMMARY:"+currentLinkName);
            currentLinkTimeInt = Integer.parseInt(currentLinkTime);
            
            out.println("BEGIN:VEVENT");
            out.println("SUMMARY:"+currentLinkName);  
            out.println("UID:"+currentLink);
            out.println("STATUS:CONFIRMED");
            out.println("TRANSP:TRANSPARENT");
            out.println("RRULE:FREQ=YEARLY;INTERVAL=1;BYMONTH=2;BYMONTHDAY=12");
            out.println("DTSTART:20080212T"+currentLinkTime+"00");
            out.println("DTEND:20080212T"+currentLinkTime+"00");
            out.println("DTEND:20080212T"+currentLinkTime+"00");
            out.println("DTSTAMP:20080212T"+currentLinkTime+"00");
            out.println("END:VEVENT");
           
            
            
            
            
      }
    
    out.println("END:VCALENDAR");
    
    
    
     }
    }
}
    
    /* Method used to load the queue from a file */ 
    public void load() throws FileNotFoundException, IOException{
    
      
    }
    
    
    
    /* Constructor method used */
    public View(Model model) {
        
        
       //Swing variables 
        final JFrame frame = new JFrame();
        q = new OrderedLinkedList<>();
        panel = new ClockPanel(model);
        table =new JTable();
        scrollPane = new JScrollPane();
        
        // Frame settings
        frame.setTitle("Java Clock"); //sets the title of the frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets the default exit operation
        
        //JTable settings
         table.setModel(new javax.swing.table.DefaultTableModel( //sets the table model to be a default table model
    new Object [0][0], //sets the data to be a multidimensional object array
    columnHeaders //sets the headers of the table to be the string array columnHeaders
) 
    //Table settings
         {
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
        
   //How will the window close? 
   frame.addWindowListener(new java.awt.event.WindowAdapter() { //adds a window listener to the frame
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) { //creates a windowClosing method for when the window is closed
        int input = JOptionPane.showConfirmDialog(null, "Do you want to save alarms?");// Dialogue box to decide if the user wants to save or not
        if (input ==1){
            
            
        }else if (input == 0){
            try {
                
                save();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            } catch (QueueUnderflowException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    
    
        // 0=yes, 1=no, 2=cancel
        
);     
        
        
        
//adds the table to a scrollPane
scrollPane.setViewportView(table);


if (table.getColumnModel().getColumnCount() > 0) {
    table.getColumnModel().getColumn(0).setResizable(false);
    table.getColumnModel().getColumn(1).setResizable(false);
}

        
//start of BorderLayout
       
        Container pane = frame.getContentPane(); //creates a container 
        
        //Edit Alarm Button
        JButton button = new JButton(new AbstractAction("edit alarms") {
    public void actionPerformed(ActionEvent e) { //action even added to the JButton
        if(!q.isEmpty()){//if the queue isn't empty
            
        //try catch to run the rerun method which adds items to the ArrayList
        try {
            rerun(); 
           
        } catch (QueueUnderflowException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EditAlarms editAlarm = new EditAlarms(alarmList); //create new EditAlarms with the ArrayList
        editAlarm.createFrame();   //runs the create frame method
    }}
});
        
        
        //Add Alarm JButton
         JButton addAlarm = new JButton(new AbstractAction("Add Alarm") {//adds action Listener to create a new frame for adding an alarm
    public void actionPerformed(ActionEvent e) {
        newAddAlarm.createFrame(); //runs createFrame
    }
});
        
        
        
        //BorderLayout to add things to different places and define sizes
        
        //sets prefered dimensions for the clock face and the table
        panel.setPreferredSize(new Dimension(200, 200));
        scrollPane.setPreferredSize(new Dimension(400, 200));
        
        /*sets the attributes locations that they will be added to. The buttons will be added to the top and bottom of the page
        the clock is in the middle and the table is on the right        
        */
        pane.add(button, BorderLayout.PAGE_START);
        pane.add(panel, BorderLayout.CENTER);
        pane.add(scrollPane, BorderLayout.EAST);
        pane.add(addAlarm, BorderLayout.PAGE_END);
        // End of borderlayout code
        
        
        //packs the frame and sets it to visible
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /* Method used to return the position in the queue of the next alarm, this is an important method for ordering the queue by next alarm*/
    public int getQueuePosition() throws QueueUnderflowException{
        
        //sets qpos to 0
        int qPos = 0;
        if(!q.isEmpty()){//if the q isn't empty
        
        
        Object currentLinkObj = q.head();//gets the first item in the queue
        String currentLink = String.valueOf(currentLinkObj); //gets the string value for the 
        currentLinkTime = currentLink.split(", ")[1]; //gets the time value from the string 
        int currentLinkTimeInt = Integer.parseInt(currentLinkTime); // gets int value from the time
        
        //if the int value from time is less than the current time (if the alarm has already been)
        if (currentLinkTimeInt < currentTime){ 
            qPos = qPos+1;//add 1 to qPos, this means it will skip another alarm when it puts out the table
        }
        
        //this if statement finds out if an alarm is going off or not.
        //last alrm value is set when the alarm is going off so that Dialogue windows don't pop up for a whole minue
        if (currentLinkTimeInt == currentTime && currentTime != lastalrm){ 
           
            JOptionPane.showMessageDialog(pane, "Alarm Is going off: "+ currentLink); //dialogue box created to show that the alarm is going off
            lastalrm = currentTime; //lastalrm changed to be the current time so the alarm only goes off once in the minute that it is set for
            
        }
        
       //if statement to say that the minute the alarm is going has passed 
       if(lastalrm == currentTime - 1){ 
           
           //ints can't be set to null so its set to a number that can't be obtained in our app.
           lastalrm = 9999;
       } 
        
        //While loop to sort though the list and find out if the alarms should beskipped or not
        //the rest of this method is a repeat of the previous but in a while loop
        while(q.nextLinkprio(currentLinkTimeInt) <= currentTime && q.nextLink(currentLinkTimeInt) != null  ){
        
        qPos = qPos+1;
        currentLink = String.valueOf(q.nextLink(currentLinkTimeInt));
         
        currentLinkName =  currentLink.split(", ")[0];
        currentLinkTime = currentLink.split(", ")[1];
        currentLinkTimeInt = Integer.parseInt(currentLinkTime);
        
        if (currentLinkTimeInt == currentTime && currentTime != lastalrm){
            JOptionPane.showMessageDialog(pane, "Alarm Is going off: "+ currentLink);
            lastalrm = currentTime;
        }
       if(lastalrm == currentTime - 1){
           System.out.println("alarm has finished going off");
           lastalrm = 9999;
       }
   }
   }
        
        return qPos; //returns qPos 
    }
    
    /* This method creates the menu, it is where the list is reorganised based on the current time */
    public void createMenu() throws QueueUnderflowException{ 
       DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
       tmodel.setRowCount(0); //clears the current table
       if(!q.isEmpty()){
       Object currentLinkObj = q.head(); //sets currentLinkObj to be the first item in the list
       int numberToSkip = getQueuePosition(); //gets the queue position for the next alarm
       
       int position = 0; //sets the position of the table to be 0
       String currentLink = String.valueOf(currentLinkObj); //gets string value from object
       
       currentLinkName =  currentLink.split(", ")[0]; //splits string into the name of the alarm and Time of the alarm
       currentLinkTime = currentLink.split(", ")[1];
       if(numberToSkip<=0){ //if the first item in the list is after the current time 
       addToTable(position,currentLinkName,currentLinkTime ); //add it to the table
    
       position = position + 1; //add 1 to the position so the next instance will be down in the table
       }
       numberToSkip = numberToSkip-1; //remove from this value
       int currentLinkTimeInt = Integer.parseInt(currentLinkTime); //get the priority of the link so we can determine the next link
     

      
      while(q.nextLink(currentLinkTimeInt) != null){ //if there is a next link
         
            currentLink = String.valueOf(q.nextLink(currentLinkTimeInt)); //set a new current link
            
            
            currentLinkName =  currentLink.split(", ")[0]; //get new alarm and time values
            currentLinkTime = currentLink.split(", ")[1];
            if(numberToSkip<=0){ //if the link exists after the current time
                
            addToTable(position,currentLinkName,currentLinkTime ); //add it to the table
            System.out.println("while Link time "+currentLinkTimeInt);
            position = position + 1; //add 1 to the position
            }  
            numberToSkip = numberToSkip-1; //remove 1 from this value
        
            currentLinkTimeInt = Integer.parseInt(currentLinkTime);
            
      }
    
      
      /*Now that we've added the next alarms to the table we need to add the ones that we skipped that have already gone off in the day*/
       currentLinkObj = q.head(); //go back to the start of the list
       numberToSkip = getQueuePosition(); //reset this value to be the q position
       currentLink = String.valueOf(currentLinkObj);//reset the current link
       currentLinkName =  currentLink.split(", ")[0];//get new string values
       currentLinkTime = currentLink.split(", ")[1];
       
       if( numberToSkip != 0){
       addToTable(position,currentLinkName,currentLinkTime );//These values will always be added to the table
       System.out.println("while Link time "+currentLinkTimeInt);
       position = position + 1;//add 1 to the position
       numberToSkip = numberToSkip-1;
    
       currentLinkTimeInt = Integer.parseInt(currentLinkTime);
       }
       while(q.nextLink(currentLinkTimeInt) != null && numberToSkip != 0){ //another while loop to add the remaining alarms we don't want it to add the already existing alarms so the numbertoskip value can't be 0

            currentLink = String.valueOf(q.nextLink(currentLinkTimeInt)); //set new current link 
            currentLinkName =  currentLink.split(", ")[0];//set new string values
            currentLinkTime = currentLink.split(", ")[1];
            
                
            addToTable(position,currentLinkName,currentLinkTime ); //add to table
            if(position == 0){ //if its the first item in the list set it to be the next alarm
          //System.out.println("the next alarm is " + currentLink);
            }
            position = position + 1; //add 1 to the position
            
            numberToSkip = numberToSkip-1;
        
            currentLinkTimeInt = Integer.parseInt(currentLinkTime);
      }
       
       
      
        
       } else{
            
       }
       
      
    }
 
    /* Method used to add items to the Table */
 public void addToTable(int position, String AlarmName, String AlarmTime){
        
        //gets the table model and inserts a row based on the items that get passed in.
        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
        tmodel.insertRow( position, new Object[] { AlarmName, AlarmTime});   
   }
 
 

    
 /* Method used in the edit alarm button the run through the table and make an arrayList to be passed through to the comboBox*/
 public void rerun() throws QueueUnderflowException{
     //clears the alarmList
     alarmList.clear();
     
     //If the list isn't empty 
     if(!q.isEmpty()){
     Object currentLinkObj = q.head(); //sets currentLinkObj to be the first item in the list
     String currentLink = String.valueOf(currentLinkObj);//reset the current link
     alarmList.add(currentLink); //adds the link to the arraylist
     currentLinkName =  currentLink.split(", ")[0];//get new string values
     currentLinkTime = currentLink.split(", ")[1];
     int  currentLinkTimeInt = Integer.parseInt(currentLinkTime);
        
     while(q.nextLink(currentLinkTimeInt) != null){ //another while loop to add the remaining alarms we don't want it to add the already existing alarms so the numbertoskip value can't be 0

            currentLink = String.valueOf(q.nextLink(currentLinkTimeInt)); //set new current link 
            alarmList.add(currentLink); //adds item to the ArrayList
            currentLinkName =  currentLink.split(", ")[0];//set new string values
            currentLinkTime = currentLink.split(", ")[1];
       
        
            currentLinkTimeInt = Integer.parseInt(currentLinkTime);
      }
     }
 }
 
 
    /* Method used to edit items in the List */ 
    public void edit(String oldlink, String newlink, int prio) throws QueueUnderflowException, QueueOverflowException{
        //to edit an item in the list we will remove the item and add a new one 
        
        String oldLinkName =  oldlink.split(", ")[0];//set new string values for the old  link
        String oldLinkTime = oldlink.split(", ")[1];
        int oldlinkint = Integer.parseInt(oldLinkTime);
        q.remove(oldlinkint);//remove the old link
        
        
        String prir = Integer.toString(prio);
        if (prio < 1000){
                   prir="0"+prir;
        }

        setNewAlarm(newlink, prir);//adds new alarm 
        
    }
   
    
    /* method used to remove a link from the list*/
    public static void remove(String link) throws QueueUnderflowException{
        
        //gets the values that we need for the linked list
        String LinkName =  link.split(", ")[0];//set new string values
        String LinkTime = link.split(", ")[1];
        int linkint = Integer.parseInt(LinkTime);
        
        
        q.remove(linkint);//removes the link based on the links priority
    }
    
    
    /* Method used from the observable */
    public void update(Observable o, Object arg) {
        panel.repaint();
        currentTime = (int)arg; //sets currentTime to be the value passed through from mdoel
        
         try { 
             createMenu();//runs create menu every second so the table appears dynamic
         } catch (QueueUnderflowException ex) {
             Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
        
        
    }
}
