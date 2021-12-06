package dolphin;

import java.time.LocalDate;
import java.time.Period;

public class Member{
        private int memberID;
        private String name;
        private LocalDate dateOfBirth;
        private boolean isActive;
        private boolean isCompetitive;
        private Diciplin diciplin;
        private boolean arrears; //restance
        private int subscribtionRate;

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
                setSubscribtionRate();

        }

        private int getAge(LocalDate currentDate) {
                return Period.between(this.dateOfBirth, currentDate).getYears();
        }

        public int getMemberAge(){
                return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        }



        //=============GETTERS==================

        public String getDiciplin(){
                if (diciplin == null){
                        return "None";
                }
                else{
                        return diciplin.getDiciplinName();
                }
        }

        public int getMemberID(){
                return memberID;
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

        //=============GETTERS==================

        //=============SETTERS==================

        public void setArrears(boolean arrears) {
                this.arrears = arrears;
        }

        public void setCompetitive(boolean competitive) {
                isCompetitive = competitive;
        }

        public void setActive(boolean isActive){
                this.isActive = isActive;
                setSubscribtionRate();
        }

        public void setSubscribtionRate(){
                int age = getAge(LocalDate.now());
                this.subscribtionRate = this.isActive == false ? 500 : age < 18 ? 1000 : age > 60 ? 1200 : 1600;
        }

        //=============SETTERS==================

        @Override
        public String toString() {
                String spaceForID = (memberID < 10) ? "\t\t" : "\t";

                String spaceForName = (name.length() < 6) ? "\t\t\t\t" : (name.length() < 10) ? "\t\t\t" : "\t\t";

                String spaceForComp = isCompetitive ? "\t\t" : "\t";

                String spaceForDici = getDiciplin().length() < 8 ? "\t\t\t" : getDiciplin().length() < 12 ? "\t\t" : "\t";



                return "MemberID: " + memberID + spaceForID +
                        "Name: " + name + spaceForName +
                        "Birthdate: " + dateOfBirth + "\t" +
                        "isActive: " + isActive + "\t" +
                        "isCompetitive: " + isCompetitive + spaceForComp +
                        "Diciplin: " + getDiciplin() + spaceForDici +
                        "Subscribtion rate: " + this.subscribtionRate + "\t\t" +
                        "Has arrears: " + this.isArrears();


        }
}
