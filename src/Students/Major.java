package Students;

public enum Major {

    CS("CS"), ITI("ITI"), BAIT("BAIT"), EE("EE"), Math("Math");

        public  String major;
        Major(String m){
            this.major = m;
        }

        public void setMajor(Major m){
            this.major = m.major;
        }

        public String toString(){
            String result = "";
            if(this.major.equals("CS")){
                result += "(SAS "+major+" 01:198) ";
            }else if(this.major.equals("ITI")){
                result += "(SC&I "+major+" 04:547) ";
            }else if(this.major.equals("MATH")){
                result += "(SAS "+major+" 01:640) ";
            }else if(this.major.equals("BAIT")){
                result += "(RBS "+major+" 33:136) ";
            }else if(this.major.equals("EE")){
                result += "(SOE "+major+" 14:332) ";
            }
            return result;
        }
    }







