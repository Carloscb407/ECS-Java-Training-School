//import package ArrayList from java.util library
import java.util.ArrayList;

/**
 * Course class
 * defines a course with a subject, instructor and students
 */
public class Course  {
    //declaration of subject object
    Subject subject;

    //variable used to decrease daysToRun
    private int i ;

    public int daysToRun;
    private int daysUntilStarts;

    /**
     * method used to set days to run to the duration of the course in the beginning
     * then used to decrease days to run by i
     */
    public void setDaysToRun() {
        this.daysToRun = getSubject().getDuration();
        this.daysToRun = this.daysToRun - i;
    }

    /**
     * method used to get the days the course has to run
     * calls method setDaysToRun
     * @return daysToRun
     */
    public int getDaysToRun() {
        this.setDaysToRun();
        return daysToRun;
    }

    /**
     * getter method used to get the subject of the course
     * @return subject of the course
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * getter method used to get the days until the course starts
     * @return daysUntilStarts
     */
    public int getDaysUntilStarts() {
        return daysUntilStarts;
    }

    /**
     * constructor fo the class
     * @param subject         the subject of the course
     * @param daysUntilStarts the days until course starts
     */
    public Course(Subject subject, int daysUntilStarts) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
    }

    /**
     * getter method used to get the status fo the course
     * @return the days until it starts as negative value if the course hasn't started it
     * @return the days left to run if the course started
     * @return 0 if the course finished
     */
    public int getStatus()
    {
        int status;

        /*
        if statement used to check if course didn't start
        if true status becomes the negative value of daysUntilStarts
         */
        if(getDaysUntilStarts() > 0 )
        {
            status = 0 - this.daysUntilStarts;
        }
        else {
            /*
            if statement used to check if course didn't finish
            if true status becomes daysToRun
            else status becomes 0
             */
            if(getDaysToRun() > 0)
            {
                status = getDaysToRun();
            }
            else{
                status = 0;
            }
        }
        return status;
    }

    /**
     * method used to simulate that a day passed
     */
    public void aDayPasses()
    {
        /*
        foreach loop used to iterate through the arraylist of students from course
        increases consecutive work days by 1 for each student
         */
        for(Student student : getStudentsArray())
        {
            student.setConsecutiveWorkDays(student.getConsecutiveWorkDays()+1);
        }

        /*
        if statement checks if the course has instructor
        if true increases consecutive work days of instructor by 1
         */
        if(getInstructor() != null)
        {
            getInstructor().setConsecutiveWorkDays(getInstructor().getConsecutiveWorkDays()+1);
        }

        /*
        if statement used to check if course started
        if true increases i by 1 and calls method setDaysToRun
         */
        if(this.daysUntilStarts <= 0 )
        {
            i++;
            this.setDaysToRun();
        }

        //decrease dayUntilStarts by 1
        this.daysUntilStarts--;


        //if statement checks if course has instructor and students
        if((hasInstructor()) && (getSize() != 0))
        {
            //if statement checks if course has finished
            if(getStatus() == 0)
            {
                /*
                for loop used to iterate through the students ArrayList
                call method graduate for every student
                 */
                for(Student student : students)
                {
                    student.graduate(subject);
                }
                //unassign instructor from course
                instructor.unassignCourse();
            }
            //boolean variable used to keep track of course cancellation
            cancelled = false;
        }
        else{
            /*
            if statement checks if course is running now
            if true course is cancelled
            students are released from the course
             */
            if(getStatus() > 0){
                cancelled = true;
                students.clear();
                listOfStudents = students.toArray(new Student[getSize()]);
            }
        }
    }

    //variable that shows if course is cancelled
    boolean cancelled;

    //variable that shows if the enrollment of student was successful
    boolean enrollment;

    //declaration of the arraylist used to store students
    ArrayList<Student> students = new ArrayList<>();

    //declaration of Student object array of the size of the student arraylist
    Student[] listOfStudents = students.toArray(new Student[getSize()]);

    /**
     * getter method used to get the students arrayList
     * @return students
     */
    public ArrayList<Student> getStudentsArray() {
        return students;
    }

    /**
     * boolean method tries to enrol student in course
     * show the enrollment status of a student
     * @param student the student which is enrolled
     * @return enrollment shows the enrollment status
     */
    public boolean enrolStudent(Student student)
    {
        /*
        if statement checks if course is full or started
        if true enrollment is not possible
        else
        enrollment is possible
        student enrolled status becomes true
        add student to the course's student arraylist
        create a Student object array of the size of the student arraylist
         */
        if(((this.getSize() >= 3) || (getStatus() > 0)))
        {
            enrollment = false;
        }
        else{
            enrollment = true;
            student.enrolled = true;
            students.add(student);
            listOfStudents = students.toArray(new Student[getSize()]);
        }
        return enrollment;
    }

    /**
     * int method used to get the size of the courses's student arraylist
     * @return size of the student arraylist
     */
    public int getSize()
    {
        return students.size();
    }

    /**
     * getter method for the student array
     * @return listOfStudents
     */
    public Student[] getStudents()
    {
        return listOfStudents;
    }

    /**
     * setter method used to set the instructor of the course
     * @param instructor
     * @return true if the instructor was assigned successfully
     * @return false if the instructor couldn't be assigned
     */
    public boolean setInstructor(Instructor instructor)
    {
        /*
        if statement checks if instructor can teach the subject
        if true assigns instructor to this course
         */
        if(instructor.canTeach(subject))
        {
            instructor.assignCourse(this);
            this.instructor = instructor;
            return true;
        }
        else
        {
            return false;
        }
    }

    Instructor instructor;

    /**
     * boolean method which shows if the course has instructor
     * @return true if course has instructor
     * @return false if course doesn't have instructor
     */
    public boolean hasInstructor()
    {
        return instructor != null;
    }

    /**
     * boolean method which shows if course is cancelled
     * @return cancelled status of cancellation
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * toString method used to get details about course
     * @return instructor,subject and status of course
     */
    @Override
    public String toString()
    {
        return "Instructor: " + instructor + "\n" + "Subject: " + getSubject() + "\n" + "Status: " + getStatus();
    }

    /**
     * getter method used to get instructor of the course
     * @return instructor of the course
     */
    public Instructor getInstructor()
    {
        return instructor;
    }
}
