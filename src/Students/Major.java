package Students;

public enum Major {

    CS("SAS","01:198"),
    Math("SAS","01:640"),
    BAIT("RBS", "33:136"),
    ITI("SC&I","04:547"),
    EE("SOE","14:332");

    final String SCHOOL;
    final String CODE;

    Major(String schoolname, String School_code){
        SCHOOL = schoolname;
        CODE = School_code;
    }

    public String getSchoolName(){
        return SCHOOL;
    }

    public String getDeptCode(){
        return CODE;
    }


    public String toString() {

        return "("+SCHOOL + " : " +  CODE+")";

    }

}
