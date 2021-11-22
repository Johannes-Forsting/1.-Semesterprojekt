package dolphin;

public class Member {
        private boolean isCompetitive;
        private boolean isActive;
        private int age;
        private String name;
        private boolean arrears; //restance
        private double swimmingResults;


        public Member(boolean isCompetitive, boolean isActive, int age, String name, boolean arrears, double swimmingResults) {
                this.isCompetitive = isCompetitive;
                this.isActive = isActive;
                this.age = age;
                this.name = name;
                this.arrears = arrears;
                this.swimmingResults = swimmingResults;
        }

        public double setSwimmingResults(double personalTime){
                if(personalTime<swimmingResults){
                        this.swimmingResults = personalTime;
                        //pr added - overwrited previous record
                }
                return this.swimmingResults;
        }

        public double getSwimmingResults() {
                return swimmingResults;
        }

        public boolean isCompetitive() {
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
