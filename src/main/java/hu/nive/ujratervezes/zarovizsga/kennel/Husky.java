package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog{
    
    public Husky(String name) {
        super(name);
    }
    
    
    @Override
    protected void feed() {
        super.happiness += 4;
    }
    
    @Override
    protected void play(int hours) {
        super.happiness += hours * 3;
    }
}
