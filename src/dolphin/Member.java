package dolphin;

public class Member {
        private boolean isCompetitive;
        private boolean isActive;
        private int age;
        private String name;
        private boolean arrears; //restance


        public Member(boolean isCompetitive, boolean isActive, int age, String name, boolean arrears) {
                this.isCompetitive = isCompetitive;
                this.isActive = isActive;
                this.age = age;
                this.name = name;
                this.arrears = arrears;
        }

        public String setSwimmingResults(String personalTime){


                return personalTime;
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
