//import package ArrayList from java.util library
import java.util.ArrayList;

/**
 * School class
 * used to define a school
 */
public class School {
    //declaration of variable used to store name of school
    String name;

    /**
     * default constructor of the class
     */
    /*
    public School() {

    }

     */

    /**
     * getter method for the name of school
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * constructor of the class
     * @param name name of the school
     */
    public School(String name) {
        this.name = name;
    }

    public ArrayList<Integer> allCertificates = new ArrayList<>();

    //declaration of Arraylists used to store students,courses,subjects and instructors of the school
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Course> courseList = new ArrayList<>();
    ArrayList<Subject> subjectList = new ArrayList<>();
    ArrayList<Instructor> instructorList = new ArrayList<>();

    /**
     * method used to add a student to the student arraylist
     * @param student
     */
    public void add(Student student) {
        getStudents().add(student);
    }

    /**
     * method used to remove student from the student arraylist
     * @param student
     */
    public void remove(Student student) {
        getStudents().remove(student);
    }

    /**
     * getter method used to get the student arraylist
     * @return studentList
     */
    public ArrayList<Student> getStudents() {
        return studentList;
    }

    /**
     * method used to add a subject to the subject arraylist
     * @param subject
     */
    public void add(Subject subject) {
        getSubjects().add(subject);
    }

    /**
     * method used to remove subject from the subject arraylist
     * @param subject
     */
    public void remove(Subject subject) {
        getSubjects().remove(subject);
    }

    /**
     * getter method used to get the subject arraylist
     * @return subjectList
     */
    public ArrayList<Subject> getSubjects() {
        return subjectList;
    }

    /**
     * method used to add a instructor to the instructor arraylist
     * @param instructor
     */
    public void add(Instructor instructor) {
        getInstructors().add(instructor);
    }

    /**
     * method used to remove instructor from the instructor arraylist
     * @param instructor
     */
    public void remove(Instructor instructor) {
        getInstructors().remove(instructor);
    }

    /**
     * getter method used to get the instructor arraylist
     * @return instructorList
     */
    public ArrayList<Instructor> getInstructors() {
        return instructorList;
    }

    /**
     * method used to add a course to the course arraylist
     * @param course
     */
    public void add(Course course) {
        getCourses().add(course);
    }

    /**
     * method used to remove course from the course arraylist
     * @param course
     */
    public void remove(Course course) {
        getCourses().remove(course);
    }

    /**
     * getter method used to get the course arraylist
     * @return courseList
     */
    public ArrayList<Course> getCourses() {
        return courseList;
    }

    //variable used to show if subject has a course
    boolean subjectHasCourse;

    /**
     * void method used to simulate a day at school
     * creates a new course for any subject that doesn't have a course
     * assigns instructors and students to courses
     * calls method aDayPasses for every course
     * removes courses that don't have instructors or students
     * removes courses that finished or have been cancelled
     */
    public void aDayAtSchool() {

        /*
        foreach loop used to iterate through the school subject Arraylist
        creates new Course for any subject that doesn't have one
         */
        for(Subject subject : getSubjects()) {
            //counter for the courses who don't have the subject
            int counter =0;
            subjectHasCourse = false;

            /*
            foreach loop used to iterate through the courses
            checks if the subject is not found in the courses' subjects
            if true adds 1 to the counter
            else makes subjectHasCourse true
             */
            for(Course course : getCourses()) {
                if(course.getSubject() != subject) {
                    counter++;
                }
                else{
                    subjectHasCourse = true;
                }
            }

            /*
            if statement checks if subject doesn't have course
            creates a new Course for the subject and adds it to the subject arraylist
             */
            if(!subjectHasCourse && counter != getSubjects().size()) {
                getCourses().add(new Course(subject,2));
            }
        }

        /*
        foreach loop used to iterate through the courses
        searches for courses who don't have an instructor and assigns one if possible
         */
        for(Course course : getCourses()) {
            //if statement used to check if the course has an instructor
            if(!course.hasInstructor()) {
                /*
                foreach loop used to iterate trough the instructors
                break loop when instructor compatible to the course is found
                 */
                for(Instructor instructor : getInstructors()) {
                    /*
                    if statement checks if instructor is free and can be assigned to the course
                    if true assigns instructor to course and break loop
                     */
                    if(instructor.isFree() && course.setInstructor(instructor)) {
                        //instructor.assignCourse(course);
                        //System.out.println("instructor " + instructor.getName() + " assigned to subject id " + course.getSubject().getID());
                        course.setInstructor(instructor);
                        break;
                    }
                }
            }
        }

        /*
        double foreach loops used to iterate through the students and courses
        searches for students who aren't enrolled in any course
        checks if student has the certificate for the subject
        assigns them to the course if it's not full
         */
        for(Student student : getStudents()) {
            for (Course course : getCourses()) {
                //checks if student is free
                if(!student.enrolled) {
                    //if statement checks if student is already in the course
                    if (!course.students.contains(student)) {
                        /*
                        if statement checks if course is not full and student doesn't have its certificate
                        if true enrols student to the course
                         */
                        if ((course.getSize() < 3) && (!student.hasCertificate(course.getSubject()))) {
                            course.enrolStudent(student);
                        }
                    }
                }
            }
        }

        //Instructor object used to copy instructor which needs break of the course before being unassigned
        Instructor unassignedInstructor;

        /*
        for loop used to iterate through the courses
        checks if instructor or students need a break and replaces them if needed
        calls method aDayPasses for every course
         */
        for(Course course : getCourses())
        {
            //if statement used to check if course instructor is not null
            if(course.getInstructor() != null) {
                /*
                if statement checks if instructor needs a break
                if true instructor is unassigned and new one is assigned
                 */
                if (course.getInstructor().getConsecutiveWorkDays() >= 10) {
                    unassignedInstructor = course.getInstructor();
                    course.getInstructor().unassignCourse();

                    /*
                    foreach loop searches for instructor who is free,doesn't need a break and can teach the course
                    assigns the instructor to the course and breaks the loop
                     */
                    for (Instructor instructor : getInstructors()) {
                        if (instructor.getConsecutiveWorkDays() < 10) {
                            if (instructor.isFree() && course.setInstructor(instructor)) {
                                System.out.println("instructor " + instructor.getName() + " assigned to subject id " + course.getSubject().getID());
                                course.setInstructor(instructor);
                                break;
                            }
                        }
                    }
                    /*
                    unassigned instructor's consecutiveWorkDays is set to 0
                    set after loop which assigns new instructor so it wouldn't get assigned again
                     */
                    unassignedInstructor.setConsecutiveWorkDays(0);
                }
            }

            //copy of courses' student arraylist
            ArrayList<Student> copyArray = new ArrayList<>(course.students);

            /*
            foreach loop used to iterate through the copyArray of students
            checks if student needs a break
            if true removes student from course and replaces with different available student
             */
            for(Student student : copyArray)
            {
                /*
                if statement checks if student needs a break
                if true student is removed from the course's student arraylist
                new student is assigned
                 */
                if(student.getConsecutiveWorkDays() >= 10) {
                    //student enrolled status becomes false
                    student.enrolled = false;
                    course.getStudentsArray().remove(student);

                    /*
                    foreach loop searches for newStudent who:
                    - doesn't need a break
                    - is not enrolled
                    - doesn't have certificate
                    assigns the instructor to the course
                    makes newStudent enrolled status true
                    breaks the loop
                     */
                    for (Student newStudent : getStudents()) {
                        if(newStudent.getConsecutiveWorkDays() < 10){
                            if (!newStudent.enrolled) {
                                if (!course.students.contains(newStudent)) {
                                    if (!newStudent.hasCertificate(course.getSubject())) {
                                        course.enrolStudent(newStudent);
                                        newStudent.enrolled = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    /*
                    removed students's consecutiveWorkDays is set to 0
                    set after loop which assigns new student so it wouldn't get assigned again
                     */
                    student.setConsecutiveWorkDays(0);
                }
            }

            //calls method aDayPasses for the course
            course.aDayPasses();
        }

        //copy of courseList used to iterate through the courseList and change it
        ArrayList<Course> courseListCopy = new ArrayList<>(getCourses());

        /*
        foreach loop used to remove courses who have been cancelled or have finished
         */
        for(Course course : courseListCopy) {
            /*
            checks if course has been cancelled or has finished
            if true removes course from school courseList and unassigns instructor
             */
            if((course.isCancelled()) || (course.getStatus() == 0)) {
                getCourses().remove(course);
                if(course.getInstructor() != null) {
                    course.getInstructor().unassignCourse();
                }
            }
        }
    }

    /**
     * toString method used to get details of school
     * @return name of school in a format in uppercase letters
     */
    @Override
    public String toString() {
        //string used to store the course's description
        String instructorCourse;

        //string used to store the instructor list in a pretty string format
        String allInstructorsInfo = null;

        /*
        foreach loop used to iterate through instructors
        creates a pretty string that stores the instructors list
         */
        for(Instructor instructor : getInstructors()) {
            instructorCourse = null;

            //if statement checks if instructor is not null
            if(instructor != null) {
                /*
                if statement checks if the instructor's assigned course is not null
                if true assigns the description of the subject to the instructorCourse variable
                 */
                if(instructor.getAssignedCourse() != null) {
                    /*
                    if(instructor.getAssignedCourse().getSubject() != null)
                    {
                        instructorCourse = (instructor.getAssignedCourse().getSubject().getDescription());
                    }
                     */
                    instructorCourse = (instructor.getAssignedCourse().getSubject().getDescription());
                }
            }

            /*
            if statement checks if it s the first time an instructor is being added
            if true in order to create the pretty string the title is added before the instructor info
            else the instructors keep getting added in the same format
             */
            if(allInstructorsInfo == null) {
                allInstructorsInfo = "---INSTRUCTOR LIST---" + "\n" + instructor.toString() + " Assigned Course: "+ instructorCourse + ";" + "\n";
            }
            else {
                allInstructorsInfo += instructor.toString() + " Assigned Course: " + instructorCourse + ";" + "\n";
            }
        }

        //string used to store the student list in a pretty string format
        String allStudentsInfo = null;

        /*
        foreach loop used to iterate through students
        creates a pretty string that stores the students list
         */
        for(Student student : getStudents()) {
            //string that shows the students enrolled course
            String enrolledCourse = null;

            /*
            foreach loop iterates through the courses
             */
            for(Course course : getCourses()) {
                /*
                if statement checks if the student is part of the course
                if true the course's subject description is assigned to enrolledCourse
                 */
                if(course.getStudentsArray().contains(student)) {
                    enrolledCourse = course.getSubject().getDescription() + "\n";
                }
            }

            /*
            if statement checks if it s the first time a student is being added
            if true in order to create the pretty string the title is added before the student info
            else the students keep getting added in the same format
             */
            if(allStudentsInfo == null) {
                allStudentsInfo = "---STUDENT LIST---" + "\n" + student.toString() + "Enrolled Course:" + enrolledCourse + "\n";
            }
            else {
                allStudentsInfo += student.toString() + "Enrolled Course:" + enrolledCourse + "\n";
            }
        }

        //string used to store the course list in a pretty string format
        String allCoursesInfo = null;

        /*
        foreach loop used to iterate through courses
        creates a pretty string that stores the courses list
         */
        for(Course course : getCourses()) {
            //name of the course
            String courseName;

            //string used to store all the students from the course
            String allStudents = null;

            /*
            foreach loop iterates through the students from the course
             */
            for(Student student : course.getStudents()) {
                /*
                if statement checks if it s the first time a student is being added
                if true in order to create the pretty string the title is added before the student info
                else the students keep getting added in the same format
                 */
                if(allStudents != null) {
                    allStudents += student.toString();
                }
                else{
                    allStudents = student.toString();
                }
            }

            //the course's subject description is assigned to enrolledCourse
            courseName = course.getSubject().getDescription();

            /*
            if statement checks if it s the first time a course is being added
            if true in order to create the pretty string the title is added before the course info
            else the course keep getting added in the same format
             */
            if(allCoursesInfo == null) {
                allCoursesInfo = "---COURSE LIST---" + "\n" + "Course " + courseName + " info: " + "\n" + course.toString() + "\n" + allStudents + "\n";
            }
            else {
                allCoursesInfo += "Course " + courseName + " info: " + "\n" + (course.toString()) + "\n" + allStudents + "\n";
            }
        }
        return "xxxxxxxxxxxxxxxxxxxxxx " + "SCHOOL-" + getName().toUpperCase() + " xxxxxxxxxxxxxxxxxxxxxx" + "\n\n" + "--------SCHOOL DESCRIPTION--------" + "\n" + allInstructorsInfo + "\n" + allStudentsInfo + "\n\n" + allCoursesInfo + "\n";
        //return  "xxxxxxxxxxxxxxxxxxxxxx " + "SCHOOL-" + getName().toUpperCase() + " xxxxxxxxxxxxxxxxxxxxxx" ;
    }
}

