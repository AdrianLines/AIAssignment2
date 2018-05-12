package clock;

import java.util.Calendar;
import java.util.Observable;
//import java.util.GregorianCalendar;

public class Model extends Observable {
    
    int hour = 0;
    int minute = 0;
    int second = 0;
    int longhour ;
    int oldSecond = 0;
    
    
    
        
    public int getCurrentTime(){
    int currentTime;
    String hourString = Integer.toString(hour);
    String minuteString = Integer.toString(minute);
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
            notifyObservers(updatedTime);
        }
        
       
        
    }
    
}