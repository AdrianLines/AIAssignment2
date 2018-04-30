package clock;

/**
 * Minimal "person" class.
 *
 * At the moment a Person object just holds their name, but in a more realistic
 * system, there would obviously be more.
 */
public class Alarm {

    protected String name;
    protected String alarmtime;

    public Alarm(String name,String alarmtime) {
        this.name = name;
        this.alarmtime = alarmtime;
    }

    public String getName() {
        return name;
    }
    public String getAlarmtime() {
        return alarmtime;
    }

    @Override
    public String toString() {
        return getName()+", "+getAlarmtime();
    }
}
