public class Demonstrator extends Instructor {

    public Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }

    public String getInstructorType() {
        instructorType = "Demonstrator";
        return instructorType;
    }

    @Override
    public boolean canTeach(Subject subject) {
        if(subject.getSpecialism() == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
