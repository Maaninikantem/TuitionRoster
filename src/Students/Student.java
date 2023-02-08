package Students;

public class Student implements Comparable<Student>{
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;
/**
    public Student() throws Exception
    {
        this(new Profile("First Name", "Last Name", Date('10/7/2003')), Major.CS, 80);
    }
**/
    public Student(Profile profile, Major major, int creditCompleted) throws Exception
    {
        this.profile = profile;
        if(this.major == Major.CS) {
            this.major = Major.CS;
        } else if(this.major == Major.ITI) {
            this.major = Major.ITI;
        } else if(this.major == Major.BAIT) {
            this.major = Major.BAIT;
        } else if(this.major == Major.EE) {
            this.major = Major.EE;
        } else if(this.major == Major.Math) {
            this.major = Major.Math;
        } else {
            throw new Exception("'" + major + "' is not a valid major.");
        }
        this.creditCompleted = creditCompleted;
    }

    public Profile getProfile() {
        return profile;
    }

    public Major getMajor(){
        return major;
    }
    public int getCreditCompleted() {
        return creditCompleted;
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
        public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return profile.equals(student.profile);
    }

        @Override
        public int compareTo(Student s) {
        return profile.compareTo(s.profile);
    }

    }


