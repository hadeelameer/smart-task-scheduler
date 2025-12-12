import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class MinHeapImplementationTest {
    @Test
    public void TestSJF(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");

        Task[] tasks = {
                new Task("Task 1", 2, LocalDateTime.parse("1/28/2025 9:00:00 AM", formatter)),
                new Task("Task 2", 3, LocalDateTime.parse("1/29/2025 11:30:00 AM", formatter)),
                new Task("Task 3", 4, LocalDateTime.parse("1/28/2025 10:00:00 AM", formatter)),
                new Task("Task 4", 5, LocalDateTime.parse("2/2/2025 1:00:00 PM", formatter)),
                new Task("Task 5", 1, LocalDateTime.parse("1/30/2025 3:00:00 PM", formatter)),
                new Task("Task 6", 2, LocalDateTime.parse("1/28/2025 8:30:00 AM", formatter)),

        };
        MinHeapImplementation heap = new MinHeapImplementation(true); // true = SJF

        for (Task task : tasks) {
            heap.add(task);
        }

        assertEquals("Task 5", heap.poll().getName()); // time = 1
        assertEquals("Task 6", heap.poll().getName()); // time = 2, earlier deadline
        assertEquals("Task 1", heap.poll().getName()); // time = 2
        assertEquals("Task 2", heap.poll().getName()); // time = 3
        assertEquals("Task 3", heap.poll().getName()); // time = 4
        assertEquals("Task 4", heap.poll().getName()); // time = 5
    }
    @Test
    public void TestEDF(){
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");

        Task[] tasks = {
                new Task("Task 1", 2, LocalDateTime.parse("1/28/2025 9:00:00 AM", formatter)),
                new Task("Task 2", 3, LocalDateTime.parse("1/29/2025 11:30:00 AM", formatter)),
                new Task("Task 3", 4, LocalDateTime.parse("1/28/2025 10:00:00 AM", formatter)),
                new Task("Task 4", 5, LocalDateTime.parse("2/2/2025 1:00:00 PM", formatter)),
                new Task("Task 5", 1, LocalDateTime.parse("1/30/2025 3:00:00 PM", formatter)),
                new Task("Task 6", 2, LocalDateTime.parse("1/28/2025 8:30:00 AM", formatter)),
        };

        MinHeapImplementation heap = new MinHeapImplementation(false); // false = EDF

        for (Task task : tasks) {
            heap.add(task);
        }

        assertEquals("Task 6", heap.poll().getName()); // 1/28 8:30
        assertEquals("Task 1", heap.poll().getName()); // 1/28 9:00
        assertEquals("Task 3", heap.poll().getName()); // 1/28 10:00
        assertEquals("Task 2", heap.poll().getName()); // 1/29 11:30
        assertEquals("Task 5", heap.poll().getName()); // 1/30 3:00
        assertEquals("Task 4", heap.poll().getName()); // 2/2 1:00
    }


}