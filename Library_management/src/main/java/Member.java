public class Member extends Person{
    private final int memberId;
    private static int firstId = 1;

    public Member(String name, int nationalCode) {
        super(name, nationalCode);
        this.memberId = firstId;
        firstId++;
    }

    public int getMemberId() {
        return memberId;
    }

    public static int getFirstId() {
        return firstId;
    }

    public static void setFirstId(int firstId) {
        Member.firstId = firstId;
    }

    public void save(){
        File.save(this);
    }

    public void remove(){
        File.remove(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "Name: " + name +
                ", National Code: '" + nationalCode + '\'' +
                ", Member Id: " + memberId +
                '}';
    }
}
