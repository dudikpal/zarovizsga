package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog{
    
    public Beagle(String name) {
        super(name);
    }
    
    // a gyakorlófeladatban nem lehetett set()-et használni
    // elbizonytalanodtam, hogy akkor itt se? bár nincs leírva
    // de ha már öröklés, akkor maradtam ennél a csúnyább megoldásnál
    @Override
    protected void feed() {
        super.happiness += 2;
    }
    
    @Override
    protected void play(int hours) {
        super.happiness += hours * 2;
    }
}
