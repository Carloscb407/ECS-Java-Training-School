/**
 * abstract class Instructor that extends Person class
 * used to define an Instructor
 */
public abstract class Instructor extends Person{
    /**
     * Constructor of the class
     * @param name   the name of the teacher
     * @param gender the gender of the teacher
     * @param age    the age of the teacher
     */
    public Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * abstract getter method used to get Instructor type
     * @return instructorType
     */
    public abstract String getInstructorType();
    String instructorType;

/*
    public Instructor() {

    }
 */

    Course assignedCourse;

    /**
     * getter method used to get the course assigned to the instructor
     * @return
     */
    public Course getAssignedCourse() {
        return assignedCourse;
    }

    /**
     * method used to set the instructor's assigned course
     * @param assignedCourse the course which is assigned
     */
    public void assignCourse(Course assignedCourse) {
        this.assignedCourse = assignedCourse;
    }

    /**
     * method used to check if the instructor is free
     * @return true if instructor has no assigned course
     * @return false if instructor has an assigned course
     */
    public boolean isFree()
    {
        if(getAssignedCourse() == null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * method used to unassign the instructor
     */
    public void unassignCourse() {
        assignedCourse = null;
        //System.out.println("instructor unassigned");
    }

    /**
     * abstract boolean method used to check if the instructor can teach a subject
     * @param subject the subject whose compatibility with the instructor is checked
     * @return true if the instructor can teach the subject
     * @return false if the instructor can t teach the subject
     */
    public abstract boolean canTeach(Subject subject);

    /**
     * toString method used to get details about the instructor
     * @return name , gender and age of the instructor
     */
    @Override
    public String toString()
    {
        return "Instructor name: " + this.getName() + ", Gender: " + this.getGender() + ", Age: " +  this.getAge() + "," ;
    }

    int consecutiveWorkDays;

    /**
     * method used to set the number of consecutive workdays
     * @param consecutiveWorkDays the value assigned
     */
    @Override
    public void setConsecutiveWorkDays(int consecutiveWorkDays) {
        this.consecutiveWorkDays = consecutiveWorkDays;
    }

    /**
     * method used to get the number of consecutive workdays
     * @return consecutiveWorkDays
     */
    public int getConsecutiveWorkDays()
    {
        return consecutiveWorkDays;
    }
}
