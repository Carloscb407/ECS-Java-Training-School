//import package ArrayList from java.util library
import java.util.ArrayList;

/**
 * Student class that extends Person class
 * used to define a student
 */
public class Student extends Person {
    //declare ArrayList used to hold the certificate of the student
    ArrayList<Integer> certificates = new ArrayList<>();

    /**
     * Constructor of the class
     * @param name   the name of the teacher
     * @param gender the gender of the teacher
     * @param age    the age of the teacher
     */
    public Student(String name, char gender, int age)
    {
        super(name, gender, age);
    }

    /**
     * second constructor of the class used to set the certificates
     * @param certificates the Arraylist of certificates
     */
    /*
    public Student(ArrayList<Integer> certificates) {
        this.certificates = certificates;
    }

     */

    /**
     * method used to get the student to graduate
     * adds the id f the subject to the certificates arraylist
     * @param subject the subject the student graduates
     */
    public void graduate(Subject subject)
    {
        getCertificates().add(subject.getID());
        //System.out.println("student graduate" + getName());
    }

    //variable used to keep record if the student is enrolled in a course or not
    public boolean enrolled = false;

    /**
     * boolean method used to check if the student has the certificate of a subject
     * @param  subject the subject which is checked
     * @return true if the student has the cerificate
     * @return false if the student doesn't have the certificate
     */
    public boolean hasCertificate(Subject subject)
    {
        boolean hascertificate = certificates.contains(subject.id);
        return hascertificate;
    }

    /**
     * getter method used to get the arraylist of certificates
     * @return certificates
     */
    public ArrayList<Integer> getCertificates() {
        return certificates;
    }

    /**
     * toString method used to get details about the student
     * @return name,gender,age and list of certificates of student
     */
    @Override
    public String toString()
    {
        //string variable which keeps all the certificates of the student in a format
        String certificateList = null;

        /*
        foreach loop used to iterate thrugh all certificates
        adds all certificates to the certificateList string
         */
        for(Integer certificateID : getCertificates())
        {
            //if statement used to check if this is the first certificate which is added to the string
            if(certificateList == null)
            {
                certificateList =  "Subject ID: " + certificateID ;
            }
            else {
                certificateList += "Subject ID: " + certificateID ;
            }
        }
        return "Student Name: " + getName() + ", Gender: " + getGender() + ", Age: " + getAge() + "\n" + "---CERTIFICATE LIST---" + "\n" + certificateList + "\n";
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
