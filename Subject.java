/**
 * Subject class
 * used to define a subject
 */
public class Subject {
    //declaration of  variables used to store subject details
    public String  description;
    public int id,specialism, duration;

    /**
     * getter method used to get description of subject
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * setter method used to set description of subject
     * @param subjectDescription description which is set to the subject
     */
    public void setDescription(String subjectDescription) {
        this.description = subjectDescription;
    }

    /**
     * getter method used to get duration of subject
     * @return duration
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * getter method used to get specialism of subject
     * @return specialism
     */
    public int getSpecialism() {
        return this.specialism;
    }

    /**
     * constructor of the class
     * @param description       description of subject
     * @param subjectID         id of the subject
     * @param subjectSpecialism specialism of subject
     * @param subjectDuration   duration of subject
     */
    public Subject(String description,int subjectID, int subjectSpecialism, int subjectDuration) {
        this.description = description;
        this.id = subjectID;
        this.specialism = subjectSpecialism;
        this.duration = subjectDuration;
    }

    /**
     * getter method used to get id of subject
     * @return id
     */
    public int getID() {
        return this.id;
    }

    /**
     * toString method used to get details of subject
     * @return id,specialism,duration and description of the subject
     */
    @Override
    public String toString()
    {
        return "Id: " + getID() + ", Specialism: " + getSpecialism() + ", Duration: " + getDuration() + ", Description: " + getDescription() + ";";
    }
}
