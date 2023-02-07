package Students;
import java.util.Arrays;
public class Roster {
    private Student[] roster;
    private int size;
    public static final int NOT_FOUND = -1;
    public Roster(){
        roster = new Student[4];
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
        Student[] arr = new Student[roster.length + 4];
        for (int i = 0; i < size; i++) {
            arr[i] = roster[i];
        }
        roster = arr;
    } //increase the array capacity by 4
    public boolean add(Student student){
       int findStudent = find(student);
       if(findStudent != NOT_FOUND){
           return false;
        }
       if (size >= roster.length){
            grow();
       }
       roster[size] = student;
       size ++;
       return true;

    } //add student to end of array
    public boolean remove(Student student){
        int findStudent = find(student);
        if(findStudent != NOT_FOUND){
            return false;
        }
        for (int i = findStudent; i < size - 1; i++)
        {
            roster[i] = roster[i + 1];
        }
        roster[size - 1] = null;

        size = size--;
        return true;

    }//maintain the order after remove
    public boolean contains(Student student){
        return find(student) != NOT_FOUND;
    } //if the student is in roster
    public void print () {
        sort();
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i]);
        }
    } //print roster sorted by profiles

    //check the sorting algorithms adn implement them correclty,
    public void printBySchoolMajor() {
        sortBySchoolMajor();
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i]);
        }
    }//print roster sorted by school major
    public void printByStanding() {
        sortByStanding();
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i]);
        }
    } //print roster sorted by standing

    //below is a sorting algorithm for sorting roster by profiles
    private void sort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (roster[j].compareTo(roster[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
}
