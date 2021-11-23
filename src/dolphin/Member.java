package dolphin;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public class Member{
        private String name;
        private LocalDate dateOfBirth;
        private boolean isActive;
        private boolean isCompetitive;
        private Diciplin diciplin;
        private boolean arrears; //restance





        private int subscribtionRate;

        //Skal måske bruges senere
        private int memberId;
        private double swimmingResults;


        public Member(boolean isCompetitive, boolean isActive, String dateOfBirth, String name, Diciplin diciplin, boolean arrears) {
                this.name = name;
                this.isActive = isActive;
                this.isCompetitive = isCompetitive;
                this.diciplin = diciplin;
                this.arrears = arrears;




                //DateOfBirth kommer ind i String DD-MM-YYYY og bliver lavet om til en LocalDate variable.
                String[] thisDate = dateOfBirth.split("-");
                int year = Integer.parseInt(thisDate[2]);
                int month = Integer.parseInt(thisDate[1]);
                int day = Integer.parseInt(thisDate[0]);
                this.dateOfBirth = LocalDate.of(year, month, day);

                //subscribtionFee bliver tildelt her baseret på isActive og alder
                int age = getAge(LocalDate.now());
                this.subscribtionRate = this.isActive == false ? 500 : age < 18 ? 1000 : age > 60 ? 1200 : 1600;

        }

        private int getAge(LocalDate currentDate) {
                return Period.between(this.dateOfBirth, currentDate).getYears();
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

        public String getName() {
                return name;
        }

        public boolean isArrears() {
                return arrears;
        }

}
