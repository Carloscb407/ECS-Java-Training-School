//import java.io library and packages Random and ArrayList from java.util library
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Administrator class
 * Main class of the project
 * used to define an administrator
 * reads a file with details about a school and creates the school
 * runs the school for a specified number of days
 * creates random number of students every day
 * different instructors have different chances of entering the school
 * free instructors have 20% chance of leaving the school
 * students with all certificates can leave the school
 * else there is a 5% chance of leaving
 */
public class Administrator {
    /**
     * constructor of the class
     * @param school the school overseen by the instructor
     */
    public Administrator(School school) {
        this.school = school;
    }

    /**
     * default constructor of the class
     */
    public Administrator() {

    }

    /**
     * getter method used to get school
     * @return school
     */
    public School getSchool() {
        return school;
    }

    /**
     * setter method used to set the school of the administrator
     * @param school
     */
    public void setSchool(School school) {
        this.school = school;
    }

    //declartion of school and random instances
    School school ;
    Random random = new Random();

    int addedStudentsNumber;

    /**
     * getter method used to get the random number of students which will be added
     * @return addedStudentsNumber the number of students added
     */
    public int getAddedStudentsNumber() {
        addedStudentsNumber = random.nextInt(2) + 1;
        return addedStudentsNumber;
    }

    /*
    counters for the new instructors which will be created
    used when naming the new instructors in order to keep track of them
     */
    int counterOfNewStudents,counterOfNewTeachers,counterOfNewDemonstrators,counterOfNewGUITrainers,counterOfNewOOTrainers;

    private int percentage;

    /**
     * getter method used to get a random number out of 100
     * used for getting the percentage chance
     * @return percentage the number which will be used to check the percentage chance
     */
    private int getRandomPercentage() {
        percentage = random.nextInt(99) + 1;
        return percentage;
    }

    /**
     * void method used to add new instructors to the course
     * Teachers have a 20% chance of being added
     * Demonstrators have a 10% chance of being added
     * GUITrainers have a 5% chance of being added
     * OOTrainers have a 5% chance of being added
     */
    public void addNewInstructor() {
        /*
        if statement checks if teacher chance of being added was met
        if true creates a new teacher and adds him to the school's instructors list
        increases counter
         */
        if(getRandomPercentage() <= 20) {
            counterOfNewTeachers++;
            school.getInstructors().add(new Teacher("newTeacher" + counterOfNewTeachers,'F',44));
        }

        /*
        if statement checks if Demonstrator chance of being added was met
        if true creates a new Demonstrator and adds him to the school's instructors list
        increases counter
         */
        if(getRandomPercentage() <= 10) {
            counterOfNewDemonstrators++;
            school.getInstructors().add(new Demonstrator("newDemonstrator" + counterOfNewDemonstrators,'F',44));
        }

        /*
        if statement checks if GUITrainer chance of being added was met
        if true creates a new GUITrainer and adds him to the school's instructors list
        increases counter
         */
        if(getRandomPercentage() <= 5) {
            counterOfNewGUITrainers++;
            school.getInstructors().add(new GUITrainer("newGUITrainer" + counterOfNewGUITrainers,'M',33));
        }

        /*
        if statement checks if OOTrainer chance of being added was met
        if true creates a new OOTrainer and adds him to the school's instructors list
        increases counter
         */
        if(getRandomPercentage() <= 5) {
            counterOfNewOOTrainers++;
            school.getInstructors().add(new OOTrainer("newOOTrainer" + counterOfNewOOTrainers,'F',44));
        }
    }

    /**
     * boolean method checks if student has all the certificates given by the school
     * @param  student the student which is checked
     * @return true if he has all certificates
     * @return false if he doesn't
     */
    private boolean hasAllCertificates(Student student) {
        //counter used to store nr of certificates owned by the student
        int nrOfCertificates = 0;

        //foreach loop used to iterate through the subjects
        for(Subject subject : school.getSubjects()) {
            /*
            if statement checks if student has the subject certificate
            if true increases nrOfCertificates by 1
             */
            if(student.hasCertificate(subject)) {
                nrOfCertificates++;
            }
        }
        return nrOfCertificates == school.getSubjects().size();
    }

    /**
     * String method used to return a string made of
     * 1) name of the school
     * 2) the instructors list and details about all instructors
     * 3) the students list and details about all students
     * 4) the courses list with details about each course
     * @return school description in a pretty string format
     */
    public String schoolDescription() {
        //string used to store the course's description
        String instructorCourse;

        //string used to store the instructor list in a pretty string format
        String allInstructorsInfo = null;

        /*
        foreach loop used to iterate through instructors
        creates a pretty string that stores the instructors list
         */
        for(Instructor instructor : school.getInstructors()) {
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
        for(Student student : school.getStudents()) {
            //string that shows the students enrolled course
            String enrolledCourse = null;

            /*
            foreach loop iterates through the courses
             */
            for(Course course : school.getCourses()) {
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
        for(Course course : school.getCourses()) {
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
        return getSchool().toString();
        //return "xxxxxxxxxxxxxxxxxxxxxx " + "SCHOOL-" + school.getName().toUpperCase() + " xxxxxxxxxxxxxxxxxxxxxx" + "\n\n" + "--------SCHOOL DESCRIPTION--------" + "\n" + allInstructorsInfo + "\n" + allStudentsInfo + "\n\n" + allCoursesInfo + "\n";
        //return school.toString() + "\n\n" + "--------SCHOOL DESCRIPTION--------" + "\n" + allInstructorsInfo + "\n" + allStudentsInfo + "\n\n" + allCoursesInfo + "\n";
    }

    /**
     * getter method for the day of the simulation
     * dayOfSimulation is used to show the current day of the simulation
     * @return dayOfSimulation
     */
    public int getDayOfSimulation() {
        return dayOfSimulation;
    }

    /**
     * setter method for the dayOfSimulation
     * @param dayOfSimulation the current day of the simulation
     */
    public void setDayOfSimulation(int dayOfSimulation) {
        this.dayOfSimulation = dayOfSimulation;
    }

    /**
     * getter method used to get the day the simulation starts from
     * @return simulationDay
     */
    public int getSimulationDay() {
        return simulationDay;
    }

    /**
     * setter method used when reading the last day from the file
     * @param simulationDay
     */
    public void setSimulationDay(int simulationDay) {
        this.simulationDay = simulationDay;
    }

    //the first day of the simulation
    int simulationDay;

    //the current day of the simulation
    int dayOfSimulation;

    //chance of leaving
    int leavingChance;


    /**
     * int method used to get the user's extension choice
     * @return userExtensionChoice the extension the user chose to ran
     */
    public int chooseExtension() {
        //variable that holds the user's choice of extension
        int userExtensionChoice;

        System.out.println("Choose which extension you want to run" + "\n" + "-->Extension 2.1 (Saving at an interval of days set by the user)" + "\n");
        System.out.println("-->Extension 2.2 (user choice of saving and ending the simulation at the end of the day)");
        System.out.println("Press 1 for Extension 2.1 and 2 for Extension 2.2");
        userExtensionChoice = toolbox.readIntegerFromCmd();

        /*
        if statement checks if the user's choice is invalid
        if true user is asked if they want to run without the save extensions
        if so program runs without these extensions
        else
        if the user chooses to run with extensions
        the user has to choose extension again until a valid value has been chosen
         */
        if(userExtensionChoice != 1 && userExtensionChoice != 2) {
            System.out.println("Do you want to run without these 2 extensions?");
            System.out.println("Press Y if the answer is yes.");
            String noExtension = toolbox.readStringFromCmd();
            if (noExtension.equals("y") || noExtension.equals("Y")) {
                System.out.println("Program will run without save extensions.");
            }
            else{
                System.out.println("You chose to run program with extensions.");
                while(userExtensionChoice != 1 && userExtensionChoice != 2){
                    System.out.println("Choose extension again");
                    userExtensionChoice = toolbox.readIntegerFromCmd();
                }
            }
        }
        return userExtensionChoice;
    }

    /**
     * void method used to run the school
     * reads a file and calls readFile method for that file
     * sets first day of the simulation
     * runs the school for a specified number of days
     * creates random number of students every day and adds them to the school
     * different instructors have different chances of entering the school
     * free instructors have 20% chance of leaving the school
     * students with all certificates can leave the school
     * else there is a 5% chance of leaving
     * saves the status of the simulation at a user specified interval
     * @param fileName     name of the file which is read
     * @param days         nr of days the school is run for
     * @param saveInterval the interval at which the simulation is saved
     */
    public void run(String fileName,int days,int saveInterval) {
        //calls readFile method for the file
        readFile(fileName);

        //variable used to store the extension choice of the user
        int extensionChoice = chooseExtension();
        if(extensionChoice == 1 && saveInterval == 0) {
            System.out.println("Choose the interval you want to save the simulation at:");
            saveInterval = toolbox.readIntegerFromCmd();
        }

        /*
        sets simulation day to the first day of the simulation
        adds 1 because the last day the simulation was run is in the file
        so the simulation should resume starting the next day
         */
        setSimulationDay(getSimulationDay() + 1);

        /*
        for loop runs the simulation for a user specified number of days
         */
        for(int i = getSimulationDay(); i <= days ; i++) {
            /*
            for loop adds a random number of students
            counter is used to give a different name to each new student
            counter also keeps track of the number of students which have been added
             */
            for(int j = 0; j < getAddedStudentsNumber() ; j++) {
                counterOfNewStudents++;
                school.getStudents().add(new Student("newStudent" + counterOfNewStudents,'M',19));
            }

            //calls method which adds instructors based on percentage chance
            addNewInstructor();

            //runs the school for a day
            school.aDayAtSchool();

            //copy arraylist of the school's instructors list used to iterate through the instructor list and change it
            ArrayList<Instructor> instructorListCopy = new ArrayList<>(school.getInstructors());

            /*
            foreach loop iterates through the instructors list
            gets the leaving chance and checks if it s below 20
            if true instructor leaves the school
             */
            for(Instructor instructor : instructorListCopy) {
                leavingChance = getRandomPercentage();
                if(instructor.isFree() && leavingChance <= 20) {
                    school.getInstructors().remove(instructor);
                }
            }
            //copy arraylist of the school's students list used to iterate through the student list and change it
            ArrayList<Student> studentListCopy = new ArrayList<>(school.getStudents());

            /*
            foreach loop iterates through the students list
            checks if student has all certificates
            if true student leaves the school
            else
            gets the leaving chance and checks if it s below 5
            if true student leaves the school
             */
            for(Student student : studentListCopy) {
                if(hasAllCertificates(student)) {
                    school.getStudents().remove(student);
                }
                else
                {
                    if(getRandomPercentage() <= 5) {
                        school.getStudents().remove(student);
                    }
                }
            }

            //sets the current day of the simulation
            setDayOfSimulation(i);

            //prints the day of the simulation
            System.out.println( "\n" + "---------------------" + "DAY " + i + "--------------------");

            //prints the school's description in a pretty string format
            System.out.println(schoolDescription());

            /**
             * Extension 2.2 starts here
             * this commented code is part of an extension
             * the code asks the user if they want to save the simulation at the end of the day
             * if so the simulation ends and a save file is created
             * in the last day of the simulation the user is notified that the simulation will end
             * if user doesn't want to save a second question will appear in order to ensure the user's decision
             */
            if(extensionChoice == 2) {
                /*
                if statement checks if it s the last day of the simulation
                if true and the user doesn't save he s asked again
                else
                user is asked if they want to save
                if true simulation is saved in a file
                else the simulation continues
                 */
                if (i == days) {
                    System.out.println("The simulation will end.");
                    System.out.println("Do you want to save the current status of simulation?");
                    System.out.println("Press Y if the answer is yes.");
                    String userInput = toolbox.readStringFromCmd();

                    /*
                    if statement checks if the user wants to save the simulation status
                    if true simulation is saved
                    else user is asked again to ensure the decision wasn't a mistake
                     */
                    if (userInput.equals("y") || userInput.equals("Y")) {
                        System.out.println("The simulation was stopped.");
                        save();
                        System.out.println("The status of the simulation was saved.");
                    } else {
                        System.out.println("are you sure you don't want to save the simulation?");
                        System.out.println("Press Y if the answer is yes.");
                        String userInput2 = toolbox.readStringFromCmd();
                        if (userInput2.equals("y") || userInput2.equals("Y")) {
                            System.out.println("The status of the simulation was not saved.");
                        } else {
                            save();
                            System.out.println("The status of the simulation was saved.");
                        }
                    }
                } else {
                    System.out.println("Do you want to save the current status of simulation?");
                    System.out.println("Press Y if the answer is yes.");
                    String userInput = toolbox.readStringFromCmd();
                    if (userInput.equals("y") || userInput.equals("Y")) {
                        System.out.println("The simulation was stopped.");
                        save();
                        System.out.println("The status of the simulation was saved.");
                        break;
                    } else {
                        System.out.println("The status of the simulation was not saved.");
                    }
                }
            }
            /**
             * Extension 2.2 ends here
             */

            /**
             * Extension 2.1 starts here
             * the status of the simulation is saved at an interval specified by the user
             */
            if(extensionChoice == 1) {
                /*
                if statement checks if it s the first save
                because after the first save the dayToSave increases by 1
                so it starts from 1 rather than 0
                 */
                if (firstSave == 0) {
                    /*
                    if statement checks if the saving interval was reached
                    if true the status of the simulation is saved and dayToSave is reset to 0
                    else dayToSave is increased by 1
                     */
                    if (dayToSave == (saveInterval - 1)) {
                        firstSave = 1;
                        save();
                        dayToSave = 0;
                    }
                } else {
                    /*
                    if statement checks if the saving interval was reached
                    if true the status of the simulation is saved and dayToSave is reset to 0
                     */
                    if (dayToSave == (saveInterval)) {
                        firstSave = 1;
                        save();
                        dayToSave = 0;
                    }
                }
                dayToSave++;
            }
            /**
             * Extension 2.1 ends here
             */
        }
    }
    int firstSave;
    //used in the extension which asks the user at end of day if they want to save
    Toolbox toolbox = new Toolbox();

    //counter used to check when the saving interval is reached
    int dayToSave;

    //create BufferedReader object
    BufferedReader reader ;

    /**
     * method tries to read a file with the name parameter fileName
     * catches exception when file is not found
     * prints out error message if needed
     * calls method readLine() and reads every line of the file
     * @param fileName name of the file which is read
     */
    public void readFile(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found. Error is: ");
            e.printStackTrace();
        }
        readLine();
    }

    /**
     * boolean method used to check if file is ready
     * catches exception if file is not ready to read
     * prints out error message if needed
     * @return false if the reader is null or file can t be read
     * @return true if the file is ready to read
     */
    public boolean fileIsReady() {
        if(reader == null) {
            return false;
        }

        try {
            return reader.ready();
        } catch (IOException e) {
            System.err.println("valid file ready to read");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * String method used to read a line from the file
     * catches exception when line can not be read
     * prints out error message if needed
     * @return line which is read if possible
     * @return null if line can t be read
     */
    public String getLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Line could not be read.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * void method used to read every line of the file
     * creates a new school with instructors,students and subjects based on the file
     */
    public void readLine() {
        //while loop used to read the file by line
        while(fileIsReady()) {
            /*
            splits every line at ":"
            every line begins with the type of object which needs to be created
            followed by details about that object
             */
            String[] fileLine = getLine().split(":");

            /*
            checks if the line represents the last saved day of the simulation
            if true sets the first day of the simulation
             */
            if(fileLine[0].equals("day")) {
                setSimulationDay(Integer.parseInt(fileLine[1]));
            }

            /*
            checks if the line represents the school
            if true creates a new school with the specified name
             */
            if(fileLine[0].equals("school")) {
                School newSchool = new School(fileLine[1]);
                setSchool(newSchool);
            }

            /*
            checks if the line represents a subject
            if true creates a new subject with the specified details and adds it to the school
             */
            if(fileLine[0].equals("subject")) {
                String[] subjectInfo = fileLine[1].split(",");
                school.getSubjects().add(new Subject(subjectInfo[0],Integer.parseInt(subjectInfo[1]),Integer.parseInt(subjectInfo[2]),Integer.parseInt(subjectInfo[3])));
            }

            /*
            checks if the line represents a student
            if true creates a new student with the specified details and adds it to the school
             */
            if(fileLine[0].equals("student")) {
                String[] studentInfo = fileLine[1].split(",");
                school.getStudents().add(new Student(studentInfo[0],studentInfo[1].charAt(0),Integer.parseInt(studentInfo[2])));
            }

            /*
            checks if the line represents a Teacher
            if true creates a new Teacher with the specified details and adds it to the school
             */
            if(fileLine[0].equals("Teacher")) {
                String[] teacherInfo = fileLine[1].split(",");
                school.getInstructors().add(new Teacher(teacherInfo[0],teacherInfo[1].charAt(0),Integer.parseInt(teacherInfo[2])));
            }

            /*
            checks if the line represents a Demonstrator
            if true creates a new Demonstrator with the specified details and adds it to the school
             */
            if(fileLine[0].equals("Demonstrator")) {
                String[] demonstratorInfo = fileLine[1].split(",");
                school.getInstructors().add(new Demonstrator(demonstratorInfo[0],demonstratorInfo[1].charAt(0),Integer.parseInt(demonstratorInfo[2])));
            }

            /*
            checks if the line represents a OOTrainer
            if true creates a new OOTrainer with the specified details and adds it to the school
             */
            if(fileLine[0].equals("OOTrainer")) {
                String[] ooTrainerInfo = fileLine[1].split(",");
                school.getInstructors().add(new OOTrainer(ooTrainerInfo[0],ooTrainerInfo[1].charAt(0),Integer.parseInt(ooTrainerInfo[2])));
            }

            /*
            checks if the line represents a GUITrainer
            if true creates a new GUITrainer with the specified details and adds it to the school
             */
            if(fileLine[0].equals("GUITrainer")) {
                String[] guiTrainerInfo = fileLine[1].split(",");
                school.getInstructors().add(new GUITrainer(guiTrainerInfo[0],guiTrainerInfo[1].charAt(0),Integer.parseInt(guiTrainerInfo[2])));
            }
        }
    }

    /**
     * void method used to save the status of the simulation as a .txt file
     * catches exception if file can t be found
     * shows error message if needed
     */
    private void save() {
        //the file where the status of simulation will be saved
        PrintStream savedSimulation = null;
        try {
            savedSimulation = new PrintStream(new File("saved" + getSchool().getName() + "Day" + getDayOfSimulation() + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //write the school name in the specified format
        savedSimulation.append("school:" + getSchool().getName() + "\n");

        //write the day of the simulation in the specified format
        savedSimulation.append("day:" + getDayOfSimulation() + "\n");

        /*
        foreach loop used to write each subject and details about it in the specified format
         */
        for(Subject subject : getSchool().getSubjects()) {
            savedSimulation.append("subject:" + subject.getDescription() + "," + subject.getID() + "," + subject.getSpecialism() + "," + subject.getDuration() + "\n");
        }

        /*
        foreach loop used to write each student and details about it in the specified format
         */
        for(Student student : getSchool().getStudents()) {
            savedSimulation.append("student:" + student.getName() + "," + student.getGender() + "," + student.getAge() + "\n");
        }

        /*
        foreach loop used to write each instructor and details about it in the specified format
         */
        for(Instructor instructor : getSchool().getInstructors()) {
            savedSimulation.append(instructor.getInstructorType() + ":" + instructor.getName() + "," + instructor.getGender() + "," + instructor.getAge() + "\n");
        }

        //closes this file output stream and releases any system resources associated with this stream
        savedSimulation.close();
    }

    /**
     * main method of the instructor class
     * gets the string arguments and assigns them to variables
     * creates an administrator object
     * runs method run() for the administrator with the parameters
     * fileName- name of the file which is read
     * days- days to run
     * saveInterval- interval at which simulation is saved
     * @param args fileName, days, saveInterval
     */
    public static void main(String[] args) {
        Administrator administrator = new Administrator();
        String fileName = args[0];
        int days = Integer.parseInt(args[1]);
        if(args.length > 2){
            int saveInterval = Integer.parseInt(args[2]);
            administrator.run(fileName,days,saveInterval);
        }
        else{
            administrator.run(fileName,days,0);
        }
    }
}
