package dolphin;

import java.util.ArrayList;

public class Diciplin {
    private String diciplinName;
    private ArrayList<Member> diciplinMembers;

    public Diciplin(String diciplinName, ArrayList<Member> diciplinMembers) {
        this.diciplinName = diciplinName;
        this.diciplinMembers = diciplinMembers;
    }

    public void addMemberToDiciplin(Member member){
        diciplinMembers.add(member);
    }

    public ArrayList<Member> getDiciplinMembers() {
        return diciplinMembers;
    }

}
