package q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;


public class TimesheetTest {
    private Timesheet timesheet;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a Timesheet object with employee number "123" and end date of Friday next week
        LocalDate today = LocalDate.now();
        LocalDate endWeek = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        timesheet = new Timesheet("123", endWeek);
    }
    
    @Test
    public void testConstructor() {
        Timesheet timesheet1 = new Timesheet();
        assertNull(timesheet1.getEmpNum());
        assertNull(timesheet1.getEndWeek());
        assertTrue(timesheet1.getDetails().isEmpty());
    }


    @Test
    public void testGetEndWeek() {
        LocalDate expected = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        assertEquals(expected, timesheet.getEndWeek());
    }

    @Test
    public void testSetEndWeek() throws Exception {
        // Set a new end date of Friday in two weeks
        LocalDate newEndWeek = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusWeeks(1);
        timesheet.setEndWeek(newEndWeek);
        assertEquals(newEndWeek, timesheet.getEndWeek());
    }
    
    @Test
    public void testConstructorSetsEndWeekToNextFriday() {
        // Set the endWeek to a Wednesday
        LocalDate endWeek = LocalDate.of(2023, 3, 22);
        Timesheet timesheet = new Timesheet("12345", endWeek);
        LocalDate expectedEndWeek = LocalDate.of(2023, 3, 24); // Next Friday
        assertEquals(expectedEndWeek, timesheet.getEndWeek());
    }


    @Test
    public void testSetEndWeekInvalid() {
        LocalDate invalidEndWeek = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        Exception exception = assertThrows(Exception.class, () -> {
            timesheet.setEndWeek(invalidEndWeek);
        });

        String expectedMessage = "End date must be a Friday";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void testGetEmpNum() {
        assertEquals("123", timesheet.getEmpNum());
    }

    @Test
    public void testSetEmpNum() {
        timesheet.setEmpNum("456");
        assertEquals("456", timesheet.getEmpNum());
    }

    @Test
    public void testGetDetails() {
        assertTrue(timesheet.getDetails().isEmpty());
    }

    @Test
    public void testSetDetails() {
        // Create a new TimesheetRow object and set it as the details list
        TimesheetRow row = new TimesheetRow();
        List<TimesheetRow> rows = new ArrayList<>();
        rows.add(row);
        timesheet.setDetails(rows);
        assertEquals(rows, timesheet.getDetails());
    }

    @Test
    public void testAddRow() {
        // Add a new TimesheetRow object to the details list
        TimesheetRow row = new TimesheetRow();
        timesheet.addRow(row);
        assertEquals(1, timesheet.getDetails().size());
        assertTrue(timesheet.getDetails().contains(row));
    }

    @Test
    public void testToString() {
        Timesheet timesheet = new Timesheet("123", LocalDate.of(2022, 4, 1));
        TimesheetRow row1 = new TimesheetRow(1, "Task 1",  5.0f, 3.5f, 2.0f, 5.0f, 3.5f, 2.0f, 5.0f);
        TimesheetRow row2 = new TimesheetRow(2, "Task 2", 
                3.5f, 2.0f, 5.0f, 3.5f, 5.0f, 2.0f, 3.5f);
        TimesheetRow row3 = new TimesheetRow(3, "Task 3", 2.0f, 2.0f, 3.5f, 5.0f, 3.0f, 3.5f, 3.5f);
        timesheet.addRow(row1);
        timesheet.addRow(row2);
        timesheet.addRow(row3);
        String expected = "Employee number: 123"
                + "\nEnd date: 2022-04-01"
                + "\nProject: 1\tWork package: Task 1\tHours(from Sat to Fri): 5.0, 3.5, 2.0, 5.0, 3.5, 2.0, 5.0"
                + "\nProject: 2\tWork package: Task 2\tHours(from Sat to Fri): 3.5, 2.0, 5.0, 3.5, 5.0, 2.0, 3.5"
                + "\nProject: 3\tWork package: Task 3\tHours(from Sat to Fri): 2.0, 2.0, 3.5, 5.0, 3.0, 3.5, 3.5";
        assertEquals(expected, timesheet.toString());
    }

}
