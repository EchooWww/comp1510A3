package q1;

/**
 * The drive class of Course and Student.
 *
 * @author Echo
 * @version 1.0
 */
public class TestCourse {
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        Course comp1510 = new Course("Programming Methods");
        
        final int i1 = 100;
        final int i2 = 90;
        final int g1 = 98;
        final int g2 = 95;
        final int p1 = 97;
        final int p2 = 92;
        final int l1 = 99;
        final int l2 = 96;
        final int l3 = 93;
        Address school = new Address("3700 Willingdon Ave", 
                "Burnaby, British Columbia", "Canada", "V5G 3H2");
        Address home1 = new Address("4266 Grange St", 
                "Burnaby, British Columbia", "Canada", "V5H 1P1");
        Address home2 = new Address("4277 Grange St", 
                "Burnaby, British Columbia", "Canada", "V5H 1P2");
        Address home3 = new Address("4288 Grange St", 
                "Burnaby, British Columbia", "Canada", "V5H 1P3");
        Address home4 = new Address("4299 Grange St", 
                "Burnaby, British Columbia", "Canada", "V5H 1P4");
        Student iris = new Student("Iris", "Xu", home1, school, i1, i2, i2);
        Student gin = new Student("Gin", "Lu", home2, school, g1, i2, g2);
        Student parin = new Student("Parin", "Rava", home3, school, p1, p2, i2);
        Student leroy = new Student("Leroy", "Lau", home4, school, l1, l2, l3);
        comp1510.addStudent(iris);
        comp1510.addStudent(gin);
        comp1510.addStudent(parin);
        comp1510.addStudent(leroy);

        comp1510.roll();
        
        System.out.println("Average of all students' test score averages: " 
                + comp1510.average());
        System.out.println("Question one was called and ran sucessfully.");
        
    }

}
