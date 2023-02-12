package Students;
import java.util.Arrays;
public class Roster {
    private Student[] roster;
    private int size;
    public static final int NOT_FOUND = -1;
    public static final int DEFAULT_SIZE = 4;
    public static final int GROW_SIZE = 4;

    public Roster() {
        roster = new Student[DEFAULT_SIZE];
        size = 0;
    }

    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i].equals(student)) {
                return i;
            }
        }
        return NOT_FOUND;
    } //search the given student in roster

    //change this method below
    private void grow() {
        Student[] arr = new Student[roster.length + GROW_SIZE];
        for (int i = 0; i < size; i++) {
            arr[i] = roster[i];
        }
        roster = arr;
    } //increase the array capacity by 4

    public boolean add(Student student) {
        int findStudent = find(student);
        if (findStudent != NOT_FOUND) {
            return false;
        }
        if (size >= roster.length) {
            grow();
        }
        roster[size] = student;
        size++;
        return true;

    } //add student to end of array

    public boolean remove(Student student) {
        int findStudent = find(student);
        if (findStudent != NOT_FOUND) {
            return false;
        }
        for (int i = findStudent; i < size - 1; i++) {
            roster[i] = roster[i + 1];
        }
        roster[size - 1] = null;

        size = size--;
        return true;

    }//maintain the order after remove

    public boolean contains(Student student) {

        return find(student) != NOT_FOUND;
    } //if the student is in roster
    public String print()//printing by the porfile in order
            //No helper method needed so far
    {
        String print = "";

        if (size == 0)
            print += "Student roster is empty!\n";
        else
        {
            print += "* Student roster sorted by last name, first name, DOB ** ";
            for (int i = 0; i < size; i++)
            {
                print += roster[i].toString() + "\n";
            }
            print += "* end of Roster **";
        }

        return print;
    }

    //print out the roster sorted out by the profile
    public void printBySchoolMajor() {
        // PC
        //printing by the major's order

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int comparison = roster[i].getMajor().compareTo(roster[j].getMajor());
                if (comparison == 0) {
                    comparison = roster[i].getMajor().compareTo(roster[j].getMajor());
                }
                if (comparison > 0) {
                    Student temp = roster[i];
                    roster[i] = roster[j];
                    roster[j] = temp;
                }
            }
        }
        System.out.println("* Student roster sorted by school, major **");
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].getProfile().getLastName() + "," + roster[i].getProfile().getFirstName() + "," + roster[i].getProfile().getDOB().toString() + "," + roster[i].getMajor() + "," + roster[i].getMajor() + "," + roster[i].getStanding());
        }
        System.out.println("* end of Roster **");




    }
    //print the roster sorted by major

    public void printByStanding() {
        //PS
        //prints majors by their standing
        sortByStanding();
        String print = "";
        print += "* Student Roster sorted by Standing ** ";
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].toString());
        }
        print += "* end of Roster **";
    }
    //print the roster sorted out by the standing

    public void sortByStanding() {//helper method for printByStanding
        int n = size;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (roster[j].getStanding().compareTo(roster[minIndex].getStanding()) < 0) {
                    minIndex = j;
                }
            }
            Student temp = roster[minIndex];
            roster[minIndex] = roster[i];
            roster[i] = temp;
        }
    }


//helper method for change command
    public void change(Student s, String m){
        for(int i = 0; i< roster.length; i++){
            if (roster[i] != null) {
                if(roster[i].equals(s)){
                    try {
                        roster[i].setMajor(m);
                    }catch (Exception exe){
                        System.out.println(exe.toString());
                    }
                }
            }

        }
    }

    public void printRoster(){
        for(int i = 0; i< roster.length; i++) {
            if (roster[i] != null) {
                System.out.println(roster[i].toString());
            }
        }
    }
    public Student getStudent(int i){
        return roster[i];
    }

}
