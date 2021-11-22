package dolphin;

public class Member extends Factory{
        private boolean isCompetitive;
        private boolean isActive;
        private String dateOfBirth;
        private String name;
        private boolean arrears; //restance
        private double swimmingResults;
        private int memberId;


        public Member(boolean isCompetitive, boolean isActive, String dateOfBirth, String name, boolean arrears, double swimmingResults, int memberId) {
                this.isCompetitive = isCompetitive;
                this.isActive = isActive;
                this.name = name;
                this.arrears = arrears;
                this.swimmingResults = swimmingResults;
                this.memberId = memberId;

                String[] thisDate = dateOfBirth.split("-");
                dateOfBirth = thisDate[2] + "-" + thisDate[1] + "-" + thisDate[0];
                this.dateOfBirth = dateOfBirth;
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

        //tetststiajgpd

        public String getName() {
                return name;
        }

        public boolean isArrears() {
                return arrears;
        }

}
