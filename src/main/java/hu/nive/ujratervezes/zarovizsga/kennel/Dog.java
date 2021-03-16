package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {
    
    private String name;
    protected int happiness;
    
    
    public Dog(String name) {
        this.name = name;
        this.happiness = 0;
    }
    
    
    protected abstract void feed();
    
    protected abstract void play(int hours);
    
    
    public String getName() {
        return name;
    }
    
    public int getHappiness() {
        return happiness;
    }
    
    public static void main(String[] args) {
    
    }
}
