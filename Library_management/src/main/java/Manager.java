public class Manager extends Person{

    public Manager(String name, int nationalCode) {
        super(name, nationalCode);
    }

    public void save(){
        File.save(this);
    }

    public void remove(){
        File.remove(this);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name: '" + name + '\'' +
                ", nationalCode: " + nationalCode +
                '}';
    }
}
