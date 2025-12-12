import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PQUse {
    public static void main (String[] args) {
        MinHeapInterface sjf = new MinHeapImplementation(true);
        MinHeapInterface edf = new MinHeapImplementation(false);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");

        Task[] tasks = {
                new Task("Task 1", 2, LocalDateTime.parse("1/28/2025 9:00:00 AM", formatter)),
                new Task("Task 2", 3, LocalDateTime.parse("1/29/2025 11:30:00 AM", formatter)),
                new Task("Task 3", 4, LocalDateTime.parse("1/28/2025 10:00:00 AM", formatter)),
                new Task("Task 4", 5, LocalDateTime.parse("2/2/2025 1:00:00 PM", formatter)),
                new Task("Task 5", 1, LocalDateTime.parse("1/30/2025 3:00:00 PM", formatter)),
                new Task("Task 6", 2, LocalDateTime.parse("1/28/2025 8:30:00 AM", formatter)),
                new Task("Task 7", 3, LocalDateTime.parse("1/31/2025 10:15:00 AM", formatter)),
                new Task("Task 8", 4, LocalDateTime.parse("1/28/2025 12:00:00 PM", formatter)),
                new Task("Task 9", 5, LocalDateTime.parse("2/1/2025 9:45:00 AM", formatter)),
                new Task("Task 10", 1, LocalDateTime.parse("2/3/2025 2:30:00 PM", formatter))
        };

        // Add tasks to both heaps
        for (Task t : tasks) {
            sjf.add(t);
            edf.add(t);
        }

        // Show SJF order
        System.out.println("SJF Order:");
        Task t;
        while ((t = sjf.poll()) != null)
            System.out.println(t.toString());

        // Show EDF order
        System.out.println("\nEDF Order:");
        while ((t = edf.poll()) != null)
            System.out.println(t.toString());
    }
}

