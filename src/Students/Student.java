package Students;

public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;




    public Student(Profile profile){
        this.profile = profile;
    }
    public Student(Profile profile, Major major){
        this.profile = profile;
    }
    public Student(Profile profile, String major, int creditCompleted) throws Exception {
        this.profile = profile;
        this.creditCompleted = creditCompleted;
    }

    public void setMajor(String major) throws Exception {
        if (major.equals("CS") || major.equals("cS") || major.equals("Cs") || major.equals("cs")) {
            this.major = Major.CS;
        } else if (major.equals("ITI") || major.equals("Iti") || major.equals("iti") || major.equals("ITi")) {
            this.major = Major.ITI;
        } else if (major.equals("BAIT") || major.equals("Bait") || major.equals("BAit") || major.equals("BAIt")) {
            this.major = Major.BAIT;
        } else if (major.equals("EE") || major.equals("eE") || major.equals("Ee") || major.equals("ee")) {
            this.major = Major.EE;
        } else if (major.equals("MATH") || major.equals("math") || major.equals("Math") || major.equals("MAth")) {
            this.major = Major.Math;
        } else {
            throw new Exception("'" + major + "' is not a valid major.");
        };
    }

    public Profile getProfile() {
        return profile;
    }

    public Major getMajor() {
        return major;
    }

    public String getCreditCompleted() {
        return getStanding();
    }

    public String getStanding() {
        if (creditCompleted < 30) {
            return "Freshman";
        } else if (creditCompleted >= 30 && creditCompleted < 60) {
            return "Sophomore";
        } else if (creditCompleted >= 60 && creditCompleted < 90) {
            return "Junior";
        } else {
            return "Senior";
        }
    }


    @Override
    public String toString() {
        return profile.toString() + "\t" + major.toString() + "\t" + creditCompleted + "\t" + getStanding();
    }

    @Override
    public boolean equals(Object obj)
    {
        Student s = (Student)obj;
        return (this.getProfile().equals(obj)  && this.creditCompleted == s.getNumCredits());
    }


    @Override
    public int compareTo(Student other) {
        // Compare based on profile first
        int profileCompare = profile.compareTo(other.getProfile());
        if (profileCompare != 0) {
            return profileCompare;
        }

        // Compare based on standing
        int standingCompare = getStanding().compareTo(other.getStanding());
        if (standingCompare != 0) {
            return standingCompare;
        }

        // Compare based on major
        return major.compareTo(other.getMajor());

    }
}


