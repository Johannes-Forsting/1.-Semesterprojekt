package dolphin;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public class Member{
        private int memberID;
        private String name;
        private LocalDate dateOfBirth;
        private boolean isActive;
        private boolean isCompetitive;
        private Diciplin diciplin;
        private boolean arrears; //restance





        private int subscribtionRate;

        //Skal måske bruges senere
        private double swimmingResults;


        public Member(int memberID, boolean isCompetitive, boolean isActive, String dateOfBirth, String name, Diciplin diciplin, boolean arrears) {
                this.memberID = memberID;
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

        public int getMemberAge(){
                return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        }



        public double setSwimmingResults(double personalTime){
                if(personalTime<swimmingResults){
                        this.swimmingResults = personalTime;
                        //pr added - overwrited previous record
                }
                return this.swimmingResults;
        }

        public int getMemberID(){
                return memberID;
        }


        public String getDiciplin(){
                if (diciplin == null){
                        return "None";
                }
                else{
                        return diciplin.getDiciplinName();
                }
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

        public LocalDate getDateOfBirth() {
                return dateOfBirth;
        }

        public int getSubscribtionRate() {
                return subscribtionRate;
        }

        @Override
        public String toString() {
                String spaceForID = (memberID < 10) ? "\t\t" : "\t";

                String spaceForName = (name.length() < 6) ? "\t\t\t\t" : (name.length() < 10) ? "\t\t\t" : "\t\t";

                String spaceForComp = isCompetitive ? "\t\t" : "\t";



                return "MemberID: " + memberID + spaceForID +
                        "Name: " + name + spaceForName +
                        "Birthdate: " + dateOfBirth + "\t" +
                        "isActive: " + isActive + "\t" +
                        "isCompetitive: " + isCompetitive + spaceForComp +
                        "Diciplin: " + diciplin.getDiciplinName() ;
        }
}
