public interface ITask {
    /**
     * Returns a task which is completed.
     *
     * @return Completed Task.
     */
    ITask markComplete();

    /**
     * Returns true if the task is done, false otherwise.
     *
     * @return true if the task is done, false otherwise.
     */
    boolean isDone();

    /**
     * Checks if the task occurs at some date.
     *
     * @param date Date to check against.
     * @return True if task occurs at that time, false otherwise.
     */
    boolean isSameTime(String date);
}
