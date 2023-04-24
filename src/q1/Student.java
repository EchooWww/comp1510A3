package q1;

/**
 * Represents a BCIT student.
 * 
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2017
 */
public class Student {
    /** First name of this student. */
    private String firstName;

    /** Last name of this student. */
    private String lastName;

    /** Home address of this student. */
    private Address homeAddress;

    /** School address of this student.  Can be shared by other students */
    private Address schoolAddress;
    
    /** Score of test 1 of this student.*/
    private double score1;
    
    /** Score of test 2 of this student.*/
    private double score2;
    
    /** Score of test 3 of this student.*/
    private double score3;

    /**
     * Constructs a Student object that contains the specified values.
     * @param first a String representing the first name
     * @param last a String representing the last name
     * @param home an Address object containing the home address
     * @param school an Address object containing the school address
     * @param score1 a floating point value representing the score in 1st test
     * @param score2 a floating point value representing the score in 2nd test
     * @param score3 a floating point value representing the score in 2nd test
     */
    public Student(String first, String last, Address home, Address school, 
            double score1, double score2, double score3) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    
    /**
     * Constructs a Student object that set the 3 scores to 0.
     */
    
    public Student() {
        score1 = 0;
        score2 = 0;
        score3 = 0;
    }
    
    /**
     * Set the specified test score to be some value.
     * @param testNum a int representing the test to be set
     * @param score a double value representing the score
     */
    public void setTestScore(int testNum, double score) {
        if (testNum == 1) {
            score1 = score;
        } else if (testNum == 2) {
            score2 = score;
        } else {
            score3 = score;
        }
    }
    
    /**
     * Get the specified test score.
     * @param testNum a int representing the test to be goten
     * @return the score
     */
    public double getTestScore(int testNum) {
        if (testNum == 1) {
            return score1;
        } else if (testNum == 2) {
            return score2;
        } else {
            return score3;
        }
    }
    
    /**
     * Return the average test scorer for the student.
     * @return the average of the 3 tests
     */
    public double average() {
        final int three = 3;
        return (score1 + score2 + score3) / three;
    }
    
    
    /**
     * Returns a String description of this Student object.
     * @return description a String
     */
    public String toString() {
        String result;

        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress;
        result += "\nScore 1: " + score1 + ",\tScore 2: " + score2 
                + ",\tScore 3: " + score3;
        result += "\nAverage Score: " + average();

        return result;
    }
}

