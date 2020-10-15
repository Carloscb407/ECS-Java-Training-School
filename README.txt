Student 
Name: Carlos Alberto Brat
username: cab1g19
email: cab1g19@soton.ac.uk

Coursework description:
I attempted all of the parts(1,2,3,4,5,6 plus extensions) and succesfully did them.

The extensions i did were:
1)"Your Instructors might be able to teach more than one course in a day (up to a certain limit). The students can enrol in more than on course at a time (up to a certain limit). Modify your instructors, students and simulation to deal with this."
-->I made it so that the instructors and students can work a maximum of 10 consecutive days after which they have to take a break.
-->When they have to take a break i remove them from the course and replace them with a different student/instructor.

2)"You might want to allow the simulation to save out the current state of a simulation to a file so that it can be reloaded and restarted at another time."
I did 2 methods for this extension:
-->For this extension i allow the user to choose if they want to run the program with extension 2.1 or 2.2 
-->The user can choose to run the program without these 2 extensions as well by inputting a number differrent than the one specified for choosing the extensions
-->if they do that the program asks again to make sure the user doesn't want to use any save extensions
-->if user chooses to run the program with extension 2.1, if the user hasn't already set a saving interval when running the command "java Administrator myFile nrOfDaysOfSimulation",
the program asks the user to choose a saving interval.

  (2.1)-->when the user runs the program in the command line parameters, after entering the name of the file and the days the simulation has to run, u can enter the interval at which the simulation will be saved.For example: if you enter "java Administrator 200 10" the program will save the simulation every 10 days(10,20,30 etc.). When saving the simulation the program will create a .txt file with the name "save+(name of the school)+Day+(the day which was saved)+.txt".As an example when saving day1 of the simulation of school with name "University" the file which will be created is "saveUniversityDay1.txt".

  (2.2)-->the user is asked at the end of each day if they want to save the status of the simulation
       -->if they choose to save, the simulation ends and the file is saved the same way as stated before("save+(name of the school)+Day+(the day which was saved)+.txt")
       -->if not,the simulation continues
       -->at the last day of the simulation,the user is told the simulation is about to end and asked if they want to save
       -->if they choose not to save, the program asks again in order to ensure that the input wasn't wrong by mistake

How to run the code:
       -->the code can be run in the normal way to check extension 1 "java Administrator mySchool.txt 200"

       -->to check extension (2.1) the user has to enter 1 when asked which extension they want to run
       -->code should be run in the way described above "java Administrator mySchool.txt 200 +(integer value that describes the saving interval of the simulation)"
       -->or follow the instructions from the readme file and from the program itself when it is run

       -->to check extension (2.2) the user has to enter 2 when asked which extension they want to run