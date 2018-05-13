/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Adrian2018
 * 
 * This is the Class that is used to edit and delete alarms, 
 * I initially wanted to edit and delete alarms with buttons in the table but it wasn't letting me add them
 * 
 * 
 */
public class EditAlarms extends javax.swing.JFrame {

    /* Variables */
   ArrayList<String> ls = new ArrayList<String>(); //Array list that is used to define the values in the combobox

   public EditAlarms(ArrayList<String> lst) {
        
             ls=lst; //sets the array list to the arraylist that gets passed through from View
           

        initComponents();// initialise components
        
        /* set parts of the JFrame to be inivisble */ 
        setVisible(true);
        hourSpin.setVisible(false);
        minSpin.setVisible(false);
        jtfalarm.setVisible(false);
        editconfbtn.setVisible(false);
        namelbl.setVisible(false);
        hourlbl.setVisible(false);
        minutelbl.setVisible(false);
    }
    
    /* Method used to create a String for the time so it  can presented in 24 hour format. */ 
    public String createTime(int hours, int minutes){ 
         String hourStr;
         String minuteStr;
        if (hours<=9){
            hourStr = String.valueOf(hours);
             hourStr = 0+hourStr; 
        }else{
            hourStr =String.valueOf(hours);
        }
        
        if(minutes <= 9){
            minuteStr = String.valueOf(minutes);
            minuteStr = 0+minuteStr; 
        }else{
            minuteStr =String.valueOf(minutes);
        }
        
        String alarmTimeStr = hourStr+minuteStr;
        
        
      return alarmTimeStr;
    }
    
    
    
    /*  Method used to create the frame that gets called from View when an alarm needs to be edited/deleted */ 
     public static void createFrame()
    {  
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
   
            }
        });
    }
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        alarmSelect = new javax.swing.JComboBox<>();
        jtfalarm = new javax.swing.JTextField();
        hourSpin = new javax.swing.JSpinner();
        minSpin = new javax.swing.JSpinner();
        editconfbtn = new javax.swing.JButton();
        namelbl = new javax.swing.JLabel();
        hourlbl = new javax.swing.JLabel();
        minutelbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Alarm");

        editbtn.setText("Edit Alarm");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        delbtn.setText("Delete Alarm");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        alarmSelect.setModel(new DefaultComboBoxModel(ls.toArray()));

        jtfalarm.setText("filler text");
        jtfalarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfalarmActionPerformed(evt);
            }
        });

        editconfbtn.setText("Submit edited alarm");
        editconfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editconfbtnActionPerformed(evt);
            }
        });

        namelbl.setText("Alarm Name");

        hourlbl.setText("Hour");

        minutelbl.setText("Minute");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alarmSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfalarm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namelbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hourlbl)
                            .addComponent(hourSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(editbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(delbtn)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minutelbl)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editconfbtn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(editbtn)
                    .addComponent(delbtn)
                    .addComponent(alarmSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namelbl)
                    .addComponent(hourlbl)
                    .addComponent(minutelbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfalarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hourSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editconfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    /* Action that gets called when the Edit Alarm Button is clicked*/ 
    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        String LinkName =  alarmSelect.getSelectedItem().toString().split(", ")[0];//sets string values from the alarm that is getting edited
        String LinkTime = alarmSelect.getSelectedItem().toString().split(", ")[1];
        
        
        //splits the time string in half so it can be converted into minutes/hours and displayed in the spinner
        String s1a = LinkTime.substring(0, (LinkTime.length()/2));
        String s1b = LinkTime.substring((LinkTime.length()/2));
        int s1ai =Integer.parseInt(s1a) ;
        int s1bi =Integer.parseInt(s1b);   
        Object spinhr = (Object)s1ai;
        Object spinmin = (Object)s1bi;
        
        //Sets the values for the new spinners and text field so they have the information from the previous alarm
        jtfalarm.setText(LinkName);
        hourSpin.setValue(spinhr);
        minSpin.setValue(spinmin);
        
        //makes some attributes visible 
        hourSpin.setVisible(true);
        minSpin.setVisible(true);
        jtfalarm.setVisible(true);
        editconfbtn.setVisible(true);
        hourlbl.setVisible(true);
        namelbl.setVisible(true);
        minutelbl.setVisible(true);
    }//GEN-LAST:event_editbtnActionPerformed

    
    /* Method called when the delete button is pressed*/
    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        String value = alarmSelect.getSelectedItem().toString(); //creates a String for the desired alarm
        
       //Try catch to send the value to be removed to View  
       try {
           View.remove(value);//sends string to remove()
          
       } catch (QueueUnderflowException ex) {
           Logger.getLogger(EditAlarms.class.getName()).log(Level.SEVERE, null, ex);
       }
     
      setVisible(false); //hides the edit alarm frame 
       
       
       
    }//GEN-LAST:event_delbtnActionPerformed

    
    /* Method called when the confirm edit button is pressed */
    private void editconfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editconfbtnActionPerformed
    String value = alarmSelect.getSelectedItem().toString(); //gets the desired alarm to be editied
        
        //Creates 2 String variables from the alarm that is getting created
        int hour =(Integer) hourSpin.getValue(); 
        int minute =(Integer) minSpin.getValue(); 
        String alarmName = jtfalarm.getText(); 
        String timeStr = createTime(hour,minute);
 
       //try catch to remove the value from the list 
       try {
           View.remove(value);
           setVisible(false);
       } catch (QueueUnderflowException ex) {
           Logger.getLogger(EditAlarms.class.getName()).log(Level.SEVERE, null, ex);
       }  
       
       //try catch to send the 2 strings to View to be added to the list
       try {
           View.setNewAlarm(timeStr, alarmName);
       } catch (QueueOverflowException ex) {
           Logger.getLogger(EditAlarms.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
         
       


// TODO add your handling code here:
    }//GEN-LAST:event_editconfbtnActionPerformed

    private void jtfalarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfalarmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfalarmActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditAlarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAlarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAlarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAlarms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAlarms(ls).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alarmSelect;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JButton editconfbtn;
    private javax.swing.JSpinner hourSpin;
    private javax.swing.JLabel hourlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jtfalarm;
    private javax.swing.JSpinner minSpin;
    private javax.swing.JLabel minutelbl;
    private javax.swing.JLabel namelbl;
    // End of variables declaration//GEN-END:variables
}