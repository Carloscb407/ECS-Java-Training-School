/**
 * GUITrainer class that extends Teacher class
 * used to define a GUITrainer
 */
public class GUITrainer extends Teacher {
    /**
     * Constructor of the class
     * @param name   the name of the GUITrainer
     * @param gender the gender of the GUITrainer
     * @param age    the age of the GUITrainer
     */
    public GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * getter method for the instructor type
     * @return instructorType
     */
    public String getInstructorType() {
        instructorType = "GUITrainer";
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
        if((subject.getSpecialism() == 1) || (subject.getSpecialism() == 2) || (subject.getSpecialism() == 4))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
