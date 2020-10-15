public class Main {
    public static void main(String[] args) {
        /*
        School school = new School("School");

        Instructor teacher1 = new Teacher("teacher1",'M',22);
        Instructor guiTrainer1 = new GUITrainer("guiTrainer1",'M',22);
        Instructor guiTrainer2 = new GUITrainer("guiTrainer2",'M',22);
        Instructor ooTrainer1 = new OOTrainer("ooTrainer1",'M',22);
        Instructor ooTrainer2 = new OOTrainer("ooTrainer2",'M',22);
        Instructor demonstrator1 = new Demonstrator("demonstrator1",'M',45);
        Instructor demonstrator2 = new Demonstrator("demonstrator2",'M',37);
        Instructor teacher2 = new Teacher("teacher2",'M',48);

        school.add(teacher1);
        school.add(teacher2);
        school.add(guiTrainer1);
        school.add(guiTrainer2);
        school.add(ooTrainer1);
        school.add(ooTrainer2);
        school.add(demonstrator2);
        school.add(demonstrator1);


        Subject subject1 = new Subject(1,1,3);
        Subject subject2 = new Subject(2,2,3);
        Subject subject3 = new Subject(3,3,3);
        Subject subject4 = new Subject(4,4,3);
        Subject subject5 = new Subject(5,3,3);
        Subject subject6 = new Subject(6,1,3);

        school.add(subject1);
        school.add(subject2);
        school.add(subject3);
        school.add(subject4);
        school.add(subject5);
        school.add(subject6);


        Student student1 = new Student("student1",'M',18);
        Student student2 = new Student("student2",'M',18);
        Student student3 = new Student("student3",'M',18);
        Student student4 = new Student("student4",'M',18);
        Student student5 = new Student("student5",'M',18);
        Student student6 = new Student("student6",'M',18);
        Student student7 = new Student("student7",'M',18);
        Student student8 = new Student("student8",'M',18);
        Student student9 = new Student("student9",'M',18);
        Student student10 = new Student("student10",'M',18);
        Student student11 = new Student("student11",'M',18);
        Student student12 = new Student("student12",'M',18);
        Student student13 = new Student("student13",'M',18);
        Student student14 = new Student("student14",'M',18);
        Student student15 = new Student("student15",'M',18);

        school.add(student1);
        school.add(student2);
        school.add(student3);
        school.add(student4);
        school.add(student5);
        school.add(student6);
        school.add(student7);
        school.add(student8);
        school.add(student9);
        school.add(student10);
        school.add(student11);
        school.add(student12);
        school.add(student13);
        school.add(student14);
        school.add(student15);


        Course course1 = new Course(subject1,3);
        Course course2 = new Course(subject2,3);
        Course course3 = new Course(subject3,3);
        Course course4 = new Course(subject4,3);

        school.add(course1);
        school.add(course2);
        school.add(course3);
        school.add(course4);

        course1.setInstructor(teacher1);
        course2.setInstructor(demonstrator1);
        //course3.setInstructor(ooTrainer1);
        //course4.setInstructor(guiTrainer1);

        course1.enrolStudent(student1);
        course1.enrolStudent(student2);
        course1.enrolStudent(student3);

        System.out.println("------------------------------Start of School---------------------------------");
        System.out.println(school);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("---------------------------Status of school after 1 day-----------------------");

        school.aDayAtSchool();
        System.out.println(school);


        System.out.println();
        System.out.println("Status of school after 2 day");
        school.aDayAtSchool();
        System.out.println(school);


        System.out.println();
        System.out.println("Status of school after 3 day");
        school.aDayAtSchool();
        System.out.println(school);

        System.out.println();
        System.out.println("Status of school after 4 day");
        school.aDayAtSchool();
        System.out.println(school);


        System.out.println();
        System.out.println("Status of school after 5 day");
        school.aDayAtSchool();
        System.out.println(school);


        System.out.println();
        System.out.println("Status of school after 6 day");
        school.aDayAtSchool();
        System.out.println(school);


        System.out.println();
        System.out.println("Status of school after 7 day");
        school.aDayAtSchool();
        System.out.println(school);
/*
        System.out.println();
        System.out.println("Status of school after 8 day");
        school.aDayAtSchool();
        System.out.println(school);

        System.out.println();
        System.out.println("Status of school after 9 day");
        school.aDayAtSchool();
        System.out.println(school);

 */


    }
}
