package q2;


/**
 * This class represents a row in a timesheet that records 
 * the hours worked on a project for each day of the week.
 *
 * @author Echo
 * @version 1.0
 */
public class TimesheetRow {
    
    /**
     * The mask used to get the bits corresponding 
     * to a particular day of the week.
     */
    private static final long[] MASK = {0xFFL, 0xFF00L,
        0xFF0000L, 0xFF000000L, 0xFF00000000L,
        0xFF0000000000L, 0xFF000000000000L};
    
    
    /**
     * The mask used to set the bits corresponding 
     * to a particular day of the week.
    */
    private static final long[] UMASK =
        {0xFFFFFFFFFFFFFF00L,
        0xFFFFFFFFFFFF00FFL,
        0xFFFFFFFFFF00FFFFL,
        0xFFFFFFFF00FFFFFFL,
        0xFFFFFF00FFFFFFFFL,
        0xFFFF00FFFFFFFFFFL,
        0xFF00FFFFFFFFFFFFL};
    
    /**
     * The project number.
     */
    private int project;
    
    /**
     * The string of work package.
     */
    private String workPackage;
    
    /**
     * The hours worked, stored as a bit field 
     * with 2 bits for each day of the week.
     */
    private long hours;
    
    
    
    /**
     * The constructor of a TimesheetRow object.
     * @param project the project number
     * @param workPackage the string of work package
     * @param hoursEach the hours worked for each day of the week 
     *      (in the order Sat, Sun, Mon, Tue, Wed, Thu, Fri)
     */
    public TimesheetRow(int project, String workPackage, float... hoursEach) {
        this.project = project;
        this.workPackage = workPackage;
        for (int i = 0; i < hoursEach.length; i++) {
            setHour(i, hoursEach[i]);
        }
    }
    
    /**
     * The constructor of a TimesheetRow object with no argument.
     */
    public TimesheetRow() {
    }
    
    /**
     * inludes the hours for each day.
     * @return the hours from Sat to Fri
     */
    public String toString() {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        return "Project: " + project + "\tWork package: " + workPackage 
                + "\tHours(from Sat to Fri): "
                + getHour(0) + ", " + getHour(1) + ", " + getHour(2) + ", "
                + getHour(three) + ", " + getHour(four) + ", " 
                + getHour(five)  + ", " + getHour(six); 
    }

    /**
     * The getter of project number.
     * @return the project number
     */
    public int getProject() {
        return project;
    }

    /**
     * The setter of project number.
     * @param project the number 
     */
    public void setProject(int project) {
        this.project = project;
    }

    /**
     * The getter of work package.
     * @return the work package
     */
    public String getWorkPackage() {
        return workPackage;
    }

    /**
     * The setter of work package.
     * @param workPackage the work package 
     */
    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    /**
     * The getter of hours.
     * @return the hours
     */
    public long getHours() {
        return hours;
    }

    /**
     * The setter of work hours.
     * @param hours the hours
     */
    public void setHours(long hours) {
        this.hours = hours;
    }
    
    /**
     * Gets the hours for a single day of the week.
     * @param weekday from 0 sat to 6 fri
     * @return the hours for a single day in hex
     */
    public float getHour(int weekday) {
        final int eight = 8;
        int move = weekday * eight;
        final int ten = 10;
        final float tenf = 10.0f;
        long hourInBinary = (MASK[weekday] & hours) >> move;
        int hourx10 = Integer.parseInt(Long.toString(hourInBinary, ten));
        return hourx10 / tenf;
    }
    
    /**
     * Sets the hours for a single day of the week.
     * @param weekday from 0 sat to 6 fri
     * @param hoursEach the hours to be set
     */
    public void setHour(int weekday, float hoursEach) {
        final int eight = 8;
        int move = weekday * eight;
        final int ten = 10;
        int hourx10 = (int) (hoursEach * ten);
        long hourInBinary = Integer.toUnsignedLong(hourx10);
        hours = ((hourInBinary << move) | (UMASK[weekday] & hours));
    }
    
}
