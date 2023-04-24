package q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimesheetRowTest {

    private TimesheetRow row;
    
    @BeforeEach
    void setUp() throws Exception {
        row = new TimesheetRow(1, "Work Package A", 3.2f, 1.1f, 4.5f, 5.5f, 3.2f, 2.0f, 5.0f);
    }

    @Test
    void testGetHour() {
        assertEquals(3.2f, row.getHour(0));
        assertEquals(1.1f, row.getHour(1));
        assertEquals(4.5f, row.getHour(2));
        assertEquals(5.5f, row.getHour(3));
        assertEquals(3.2f, row.getHour(4));
        assertEquals(2.0f, row.getHour(5));
        assertEquals(5.0f, row.getHour(6));
    }

    @Test
    void testSetHour() {
        row.setHour(1, 7.5f);
        assertEquals(7.5f, row.getHour(1));
        
        row.setHour(3, 6.5f);
        assertEquals(6.5f, row.getHour(3));
        
        row.setHour(6, 5.5f);
        assertEquals(5.5f, row.getHour(6));
    }

    @Test
    void testToString() {
        String expected = "Project: 1\tWork package: Work Package A\tHours(from Sat to Fri): 3.2, 1.1, 4.5, 5.5, 3.2, 2.0, 5.0";
        assertEquals(expected, row.toString());
    }

    @Test
    void testGetProject() {
        assertEquals(1, row.getProject());
    }

    @Test
    void testSetProject() {
        row.setProject(2);
        assertEquals(2, row.getProject());
    }

    @Test
    void testGetWorkPackage() {
        assertEquals("Work Package A", row.getWorkPackage());
    }

    @Test
    void testSetWorkPackage() {
        row.setWorkPackage("Work Package B");
        assertEquals("Work Package B", row.getWorkPackage());
    }

    @Test
    void testGetHours() {
        long expected = 14095877432740640L;
        assertEquals(expected, row.getHours());
    }

    @Test
    void testSetHours() {
        long expected = 9223091678569562112L;
        row.setHours(expected);
        assertEquals(expected, row.getHours());
    }
    
    @Test
    public void testConstructor() {
        TimesheetRow row2 = new TimesheetRow();
        assertEquals(0L, row2.getHours());
    }


}
