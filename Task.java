import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    String name;
    int timeNeeded;
    LocalDateTime deadline;


    Task(String name, int timeNeeded, LocalDateTime deadline)
    {
        this.name = name;
        this.timeNeeded = timeNeeded;
        this.deadline = deadline;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd yyyy h:mm a");
        return "Task{" +
                "name= " + name  +
                ", time needed= " + timeNeeded +
                ", deadline= " + deadline.format(fmt) +
                '}';
    }
}
