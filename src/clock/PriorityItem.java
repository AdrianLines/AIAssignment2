package clock;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private final T alarmName;
    private final int priority;

    public PriorityItem(T alarmName, int priority) {
        this.alarmName = alarmName;
        this.priority = priority;
    }

    public T getItem() {
        return alarmName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
}
