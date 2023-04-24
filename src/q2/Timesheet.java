package q2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;


/**
 * The Timesheet of a company to show emplyees' work for the week. 
 * One Timesheet object is corresponding to one employee, 
 * and  has one row for each project/work package.
 * @author Echo
 * @version 1.0
 */
public class Timesheet {
   
    /**
     * The end date of a week, must be a Friday.
     */
    private LocalDate endWeek;

    /**
     * The employee number.
     */
    private String empNum;
    
    /**
     * A list of TimesheetRow objects.
     */
    private List <TimesheetRow> details = new ArrayList <TimesheetRow>();
    
    /**
     * The no-argument constructor of Timesheet class.
     */
    public Timesheet() {
        
    }

    /**
     * The constructor of Timesheet class takes empNum and endWeek.
     * @param empNum the emplyee number of the new object
     * @param endWeek the end date of the new object
     */
    public Timesheet(String empNum, LocalDate endWeek) {
        this.empNum = empNum;
        this.endWeek = endWeek;
        if (endWeek.getDayOfWeek() != DayOfWeek.FRIDAY) {
            this.endWeek = 
                    endWeek.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
    }
    
    /**
     * Getter of endWeek.
     * @return the date of end date.
     */
    public LocalDate getEndWeek() {
        return endWeek;
    }
    
    /**
     * Setter of endWeek.
     * @param date the date to be set as the end date
     */
    public void setEndWeek(LocalDate date) throws Exception {
        if (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
            throw new Exception("End date must be a Friday");
        }
        endWeek = date;
    }


    /**
     * Getter of employee number.
     * @return the employee number
     */
    public String getEmpNum() {
        return empNum;
    }

    /**
     * Setter of employee number.
     * @param empNum the string to be set as employee number
     */
    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    /**
     * Getter of the TimesheetRow list.
     * @return the list
     */
    public List <TimesheetRow> getDetails() {
        return details;
    }

    /**
     * Setter of the TimesheetRow list.
     * @param details the list to be set as TimesheetRow list
     */
    public void setDetails(List <TimesheetRow> details) {
        this.details = details;
    }
    
    /**
     * Provides all timesheet data.
     * @return the string.
     */
    public String toString() {
        String detail = "Employee number: " + empNum 
                + "\nEnd date: " + endWeek;
        for (TimesheetRow timesheetrow : details) {
            detail += "\n" + timesheetrow;
        }
        return detail;
    }
    
    /**
     * Adds a row to the end of the list.
     * @param row a timesheet row
     */
    public void addRow(TimesheetRow row) {
        details.add(row);
    }
    
    //    /**
    //     * Drives the program.
    //     * @param args unused
    //     */ 
    //    public static void main(String[] args) {
    //        final int year = 2022;
    //        final int month = 4;
    //        final float time1 = 5f;
    //        final float time2 = 3.5f;
    //        final float time3 = 2.0f;
    //        final int three = 3;
    //        Timesheet timesheet = new Timesheet(
    //                "123", LocalDate.of(year, month, 1));
    //        
    //        // create three timesheet rows and add them to the timesheet
    //        TimesheetRow row1 = new TimesheetRow(1, "Task 1", 
    //                time1, time2, time3, time1, time2, time3, time1);
    //        TimesheetRow row2 = new TimesheetRow(2, "Task 2", 
    //                time2, time3, time1, time2, time1, time3, time2);
    //        TimesheetRow row3 = new TimesheetRow(three, "Task 3", 
    //                time3, time3, time2, time1, three, time2, time2);
    //        timesheet.addRow(row1);
    //        timesheet.addRow(row2);
    //        timesheet.addRow(row3);
    //        
    //        // print out the timesheet
    //        System.out.println(timesheet);
    //    }


}
