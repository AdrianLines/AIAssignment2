/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author 15012934
 */
public class AddingAlarm extends javax.swing.JFrame  {
    
       public String alarmName;
       public int alarmTime;
       public String alarmTimeStr;
       
       public int hour;
       public String hourStr;
       public int minute;
       public String minuteStr;
       public int second;
       public String ampm;

       
       
    
    /**
     * Creates new form AddingAlarm
     */
    public AddingAlarm() {
        initComponents();
        
    }
   
    
    public String createTime(int hours, int minutes){
        hour=hours;
        minute=minutes;
        if (hour<=9){
             hourStr = String.valueOf(hour);
             hourStr = 0+hourStr; 
        }else{
            hourStr =String.valueOf(hour);
        }
        
        if(minute <= 9){
            minuteStr = String.valueOf(minute);
            minuteStr = 0+minuteStr; 
        }else{
            minuteStr =String.valueOf(minute);
        }
        
        alarmTimeStr = hourStr+minuteStr;
         alarmTime= Integer.parseInt(alarmTimeStr);
        
      return alarmTimeStr;
    }
    
    
    public String getAlarmName(){
        return alarmName;
    }
    
    
    public int getAlarmTime(){
        return alarmTime;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        addAlarmbtn = new javax.swing.JButton();
        HourSpin = new javax.swing.JSpinner();
        MinuteSpin = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AlarmNmtxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addAlarmbtn.setText("Add Alarm");
        addAlarmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlarmbtnActionPerformed(evt);
            }
        });

        HourSpin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        HourSpin.setAutoscrolls(true);

        MinuteSpin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel1.setText("Hour");

        jLabel2.setText("Minute");

        AlarmNmtxt.setText("New Alarm");
        AlarmNmtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlarmNmtxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Alarm Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addAlarmbtn)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlarmNmtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HourSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(MinuteSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAlarmbtn)
                    .addComponent(HourSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinuteSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlarmNmtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAlarmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlarmbtnActionPerformed
        System.out.println("wooooowbutton pressed");    
        hour =(Integer) HourSpin.getValue();// TODO add your handling code here:
        
        minute =(Integer) MinuteSpin.getValue();
        
        alarmName = AlarmNmtxt.getText(); 
         
         createTime(hour,minute);
        System.out.println(alarmTimeStr);
        
        
           try {
               View.setNewAlarm(alarmTimeStr, alarmName);
           } catch (QueueOverflowException ex) {
               Logger.getLogger(AddingAlarm.class.getName()).log(Level.SEVERE, null, ex);
           }
        
       super.dispose();
        
    }//GEN-LAST:event_addAlarmbtnActionPerformed

    private void AlarmNmtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlarmNmtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlarmNmtxtActionPerformed

    /**
     * @param args the command line arguments
     */
 public static void createFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                
              new AddingAlarm().setVisible(true);
                
                
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlarmNmtxt;
    private javax.swing.JSpinner HourSpin;
    private javax.swing.JSpinner MinuteSpin;
    private javax.swing.JButton addAlarmbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
