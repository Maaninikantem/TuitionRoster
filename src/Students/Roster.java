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
    public String print()
    {
        String print = "";
        if (size == 0)
            print += "Student roster is empty!\n";
        else
        {
            print += "* list of students in the roster **\n";
            for (int i = 0; i < size; i++)
            {
                print += roster[i].toString() + "\n";
            }
            print += "* end of roster **\n";
        }

        return print;
    }

    //print out the roster sorted out by the profile
    public void printBySchoolMajor() {
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
        System.out.println("Roster sorted by School Major: ");
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].getProfile().getLastName() + "," + roster[i].getProfile().getFirstName() + "," + roster[i].getProfile().getDOB().toString() + "," + roster[i].getMajor() + "," + roster[i].getMajor() + "," + roster[i].getStanding());
        }
    }
    //print the roster sorted by major

    public void printByStanding() {
        sortByStanding();
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].toString());
        }
    }
    //print the roster sorted out by the standing

    private void sortByProfile() {
        for (int i = 1; i < size; i++) {
            Student key = roster[i];
            int j = i - 1;
            while (j >= 0 && roster[j].compareTo(key) > 0) {
                roster[j + 1] = roster[j];
                j--;
            }
            roster[j + 1] = key;
        }
    }

    public void sortByStanding() {
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
    public void printBySchool(String school) {
        for (int i = 0; i < size; i++) {
            Student s = roster[i];
            if (s.getMajor().equals(school)) {
                System.out.println(s.toString());
            }
        }
    }



}
    //Note that the Student class must implement the Comparable interface in order to sort the array of students.


