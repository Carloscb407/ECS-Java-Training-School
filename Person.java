/**
 * Person superclass
 * used to define a Person
 */
public abstract class Person {
    //declaration of variables to hold person characteristics
    char gender;
    int age;
    String name;

    /**
     * getter method for the gender of person
     * @return gender of the person
     */
    public char getGender() {
        return gender;
    }

    /**
     * getter method for the age of person
     * @return age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * setter method for the age of person
     * @param age age assigned to the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * getter method for the name of person
     * @return name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * constructor of the class
     * @param name   name of the person
     * @param gender gender of the person
     * @param age    age of the person
     */
    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     * default constructor for the class
     */
    /*
    public Person() {
    }

     */

    /**
     * abstract getter method used to get the number of consecutive workdays
     * @return
     */
    public abstract int getConsecutiveWorkDays();

    /**
     * abstract setter method used to set the number of consecutive workdays
     * @param consecutiveWorkDays
     */
    public abstract void setConsecutiveWorkDays(int consecutiveWorkDays);
}