package Students;
import java.util.Scanner;
import java.util.StringTokenizer;


// A - add a student
// R - remove a specific student
// P - display roster by profile
// PS - display by the school and major
// PC - display by the credits finished
// C - Change a student's major
// Q - Stop the program execution and display "Roster Manager Terminated"
// L - List the students in a specified school, sorted by last name, first name, and DOB

// display "Roster manager running" when it is running
// display "Roster manager Terminated" when it is terminated using the command Q


/**
 * Main class that handles user input and output.
 * @author Maanini Kantem, Shreeya Karanam
 */
public class RosterManager {
    private Roster roster;

    /**
     * This function serves as the backbone of the program.
     * It reads lines of input and either calls a function accordingly or prints "Invalid Command!"
     */
    public void run() throws Exception {
        roster = new Roster();
        String command;
        String[] commandList;
        Scanner scan = new Scanner(System.in);

        System.out.println("Roster manager running....");

        while (scan.hasNextLine()) {
            command = scan.nextLine();
            commandList = command.split(" ");

            if (commandList[0].equals("Q")) break;
            switch (commandList[0]) {
                case "A"://working
                    addStudent(command);
                    break;
                case "R"://not working
                    removeStudent(command);
                    break;
                case "P":
                    roster.print();
                    break;
                case "PC"://not working
                    roster.printBySchoolMajor();
                    break;
                case "PS"://working
                    roster.printByStanding();
                    break;
                case "C"://working but need ot print new major
                    change(command);
                    break;
               // case "L"://not implemented
                 //   ListProfileinSchool(command);
                  //  break;
                default:
                    System.out.println("Invalid command!");
            }
        }

        scan.close();
        System.out.println("Roster Manager session has ended.");
}

    private void addStudent(String command) throws Exception {

        String[] commandList = command.split(" ");
        String firstName = commandList[1];
        String lastName = commandList[2];
        String dob = commandList[3];
        String major = commandList[4];

        int credits = Integer.parseInt(commandList[5]);
        Profile profile = new Profile(lastName, firstName, dob);
        Student student = new Student(profile, major, credits);
        if (roster.contains(student)) {
            System.out.println("Error: Student already exists in the roster.");
            return;
        }
        boolean success = roster.add(student);
        if (success) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Error: Unable to add student.");
        }


    }



    private void removeStudent(String command) throws Exception {

        String[] commandList = command.split(" ");
        final int NUM = 4;
        if(commandList.length > NUM) {
            System.out.println("This command takes only 4 arguments!");
        }
        String firstName = commandList[1];
        String lastName = commandList[2];
        String dob = commandList[3];
        Date date = new Date(dob);
        /**
        if(!date.isValid()){
            System.out.println("The date given is not valid!");
            return;
        }
         **/

        Profile profile = new Profile(lastName, firstName, dob);
        Student student = new Student(profile);
        Boolean found = roster.contains(student);

        if (found == true) {
            return;
        }
        boolean success = roster.remove(student);
        if (success) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Unable to remove student, no record found in the system");
        }
    }

    public void change(String command){
        String[] commandList = command.split(" ");
        if(commandList.length > 5) {
            System.out.println("This command takes only 3 arguments!");
        }
        String fname = commandList[1];
        String lname = commandList[2];
        String dob = commandList[3];
        Date date = new Date(dob);



        Major major = Major.valueOf(m);

        Profile profile = new Profile(lname, fname, dob);
        Student student = new Student(profile, major);

        if (roster.contains(student)){

        }

    }
}


