/**
 * Immutable Task Object.
 * A task has a description and a completion status.
 */
public class Task implements ITask{
    protected final String description;
    protected final boolean isDone;

    private Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns a new uncompleted task.
     * @param description Description of task.
     * @return New uncompleted task.
     */
    public static Task getTask(String description) {
        return new Task(description, false);
    }

    /**
     * Returns a task which is completed.
     * @return Completed Task.
     */
    @Override
    public Task markComplete() {
        return new Task(this.description, true);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", isDone ? "✓" : "✗", description);
    }
}
