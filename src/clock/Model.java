package clock;

import java.util.Calendar;
import java.util.Observable;
//import java.util.GregorianCalendar;


/* This class is the observable class, it sends information out to the observers.   
    This is the class that is supposed to be used for the list 
    but I did it in view instead

*/
public class Model extends Observable {
    
    //Variables
    int hour = 0;
    int minute = 0;
    int second = 0;
    int longhour ;
    int oldSecond = 0;
    
    
    
    /* Method used to return the 24 hour time */    
    public int getCurrentTime(){ 
    int currentTime;
    String hourString = Integer.toString(longhour);
     String minuteString;
    if (minute < 10){
    minuteString = Integer.toString(minute);
    minuteString = "0" + minuteString ;
    }else {
    minuteString = Integer.toString(minute);
    }
    String currentTimeString = hourString+minuteString;
    currentTime = Integer.parseInt(currentTimeString);
    return currentTime;
 
    }
    
    
    public Model() {
        update();
    }
    
    
    public void update() {
        Calendar date = Calendar.getInstance();
        hour = date.get(Calendar.HOUR);
        longhour = date.get(Calendar.HOUR_OF_DAY);
        minute = date.get(Calendar.MINUTE);
        oldSecond = second;
        second = date.get(Calendar.SECOND);
        
        
         int updatedTime= getCurrentTime();
        if (oldSecond != second) {
            setChanged();
            notifyObservers(updatedTime);//sends the currentTime to the observers
        }
        
       
        
    }
    
}