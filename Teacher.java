/**
 * Teacher class that extends Instructor class
 * Used to define a teacher
 */
public class Teacher extends Instructor {
    /**
     * Constructor of the class
     * @param name   the name of the teacher
     * @param gender the gender of the teacher
     * @param age    the age of the teacher
     */
    public Teacher(String name, char gender, int age) {
        super(name, gender, age);
    }

    /*
    public Teacher() {
        super();
    }
     */

    /**
     * getter method for the instructor type
     * @return instructorType
     */
    public String getInstructorType() {
        instructorType = "Teacher";
        return instructorType;
    }

    /**
     * overrides method canTeach from Instructor class
     * method used to check if the instructor can teach the subject
     * @param  subject the subject which is checked
     * @return true if the instructor can teach the subject
     * @return false if the instructor can't teach the subject
     */
    @Override
    public boolean canTeach(Subject subject) {
        //if statement used to check if the instructor is compatible with the specialism of the subject
        if((subject.getSpecialism() == 1) || (subject.getSpecialism() == 2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
