package Students;

public class Profile implements Comparable<Profile> {
    private String fname;
    private String lname;
    private Date dob;


    /**
     * Creates an instance of the Patient class, given no parameters.
     * first name and last name is set to null and date of birth is set to today's date.
     */


    /**
     * Creates an instance of the Patient class when given a object of type Patient
     * @param s Student the appointment is for.
     */


    /**
     * Creates an instance of the Profile class given patient first name, last name and date of birth.
     * @param fname String first name.
     * @param lname String last name.
     * @param dob String date of birth.
     */
    public Profile(String lname, String fname, String dob)
    {
        this.lname = lname;
        this.fname = lname;
        this.dob = new Date(dob);
    }

    /**
     * Returns Student's first name.
     * @return the String object.
     */
    public String getLastName()
    {
        return this.lname;
    }

    /**
     * Returns student's last name.
     * @return the String object.
     */
    public String getFirstName()
    {
        return this.fname;
    }

    /**
     * Returns student's date of birth.
     * @return the Date object.
     */
    public Date getDOB()
    {
        return this.dob;
    }

    /**
     * Checks to see if the patient are the same.
     * @param obj The patient we are comparing the current one to.
     * @return True if two patient have same first name, last name, and date of birth, false otherwise.
     */


    /**
     * Returns a string representation of the patient.
     * @return a string representation of the patient.
     */
    @Override
    public String toString()
    {
        return (lname+" "+fname+", DOB: "+dob);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Profile) {
            Profile profile = (Profile) obj;
            if(this.lname.equals(profile.lname) && this.fname.equals(profile.fname) && this.dob.equals(profile.dob)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Compares patients to each other first by the last name and then by first name. If the first name and last name is same, date of birth is compared.
     * For use with the printByPatient function.
     * @param student The patient to compare the current one to.
     * @return int value if last name's or first name's are not same, it returns -1,0,-1 based on compareTo() method of Date class.
     */
    @Override
    public int compareTo(Profile student)
    {
        if(fname.compareTo(student.getFirstName()) != 0) return fname.compareTo(student.getFirstName());
        if(lname.compareTo(student.getLastName()) != 0) return lname.compareTo(student.getLastName());
        return dob.compareTo(student.getDOB());
    }
}


