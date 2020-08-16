/**
 * An Event class.
 * An Event is a task that start at a specific time and ends at a specific time.
 */
public class Event extends Task {
    private final String time;

    private Event(String description, String time, boolean isDone) {
        super(description, isDone);
        this.time = time;
    }

    /**
     * Returns a new uncompleted event.
     * @param description Description of event.
     * @param time Time during which the event is happening.
     * @return New uncompleted event.
     */
    public static Event getEvent(String description, String time) {
        return new Event(description, time, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task markComplete() {
        return new Event(description, time, true);
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), time);
    }
}