package dolphin;

public class Member extends Factory{
        private boolean isCompetitive;
        private boolean isActive;
        private int age;
        private String name;
        private boolean arrears; //restance
        private double swimmingResults;
        private int memberId;


        public Member(boolean isCompetitive, boolean isActive, int age, String name, boolean arrears, double swimmingResults, int memberId) {
                this.isCompetitive = isCompetitive;
                this.isActive = isActive;
                this.age = age;
                this.name = name;
                this.arrears = arrears;
                this.swimmingResults = swimmingResults;
                this.memberId = memberId;
        }



        public double setSwimmingResults(double personalTime){
                if(personalTime<swimmingResults){
                        this.swimmingResults = personalTime;
                        //pr added - overwrited previous record
                }
                return this.swimmingResults;
        }

        public int getMemberId() {
                return memberId;
        }

        public double getSwimmingResults() {
                return swimmingResults;
        }

        public boolean isCompetitive()  {
                return isCompetitive;
        }

        public boolean isActive() {
                return isActive;
        }

        public int getAge() {
                return age;
        }

        public String getName() {
                return name;
        }

        public boolean isArrears() {
                return arrears;
        }

}
