package q1;

import java.util.ArrayList;

/**
 * Represents a course.
 * @author echo 
 * @version 1.0
 */
public class Course {

    /**
     * The name of the course.
     */
    private String courseName;
    
    /**
     * The arraylist to keep track of students.
     */
    private ArrayList <Student> studentInfo = new ArrayList <Student>();
    
    /**
     * Constructs a course with a name.
     * @param courseName a string represents the course name
     */
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    /**
     * Adds a student to the course.
     * @param student the student object
     */
    public void addStudent(Student student) throws IllegalArgumentException {
        final int five = 5;
        if (studentInfo.size() >= five) {
            throw new IllegalArgumentException(
                    "A class can only track up to 5 students!");
        }
        studentInfo.add(student);
        
    }
    
    /**
     * Calculates the average of all students' test score averages.
     * @return the average score
     */
    public double average() {
        double sum = 0;
        for (Student student:studentInfo) {
            sum += student.average();
        }
        return sum / studentInfo.size();
    }
    
    /**
     * Prints all students in the course.
     */
    public void roll() {
        String info = courseName + "\n\n";
        for (Student student:studentInfo) {
            info += student + "\n\n";
        }
        System.out.print(info);
    }
    

}
