/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    /**
     * Attributes
     */
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method for selling a coffee
     * @param size The size of the coffee
     * @param nSugarPackets The number of sugar packets to add to the coffee
     * @param nCreams The number of creams to add to the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces - size >= 0) {
            this.nCoffeeOunces -= size;
        }
        else {
            this.nCoffeeOunces -= size;
            this.restock(50, this.nSugarPackets, this.nCreams, this.nCups);
        }
        if (this.nSugarPackets - nSugarPackets >= 0) {
            this.nSugarPackets -= nSugarPackets;
        }
        else {
            this.nSugarPackets -= nSugarPackets;
            this.restock(this.nCoffeeOunces, 50, this.nCreams, this.nCups);
        }
        if (this.nCreams - nCreams >= 0) {
            this.nCreams -= nCreams;
        }
        else {
            this.nCreams -= nCreams;
            this.restock(this.nCoffeeOunces, this.nSugarPackets, 50, this.nCups);
        }
        if (this.nCups - 1 >= 0) {
            this.nCups -= 1;
        }
        else {
            this.nCups -= 1;
            this.restock(this.nCoffeeOunces, this.nSugarPackets, this.nCreams, 50);
        }
    }

    /**
     * Method for restocking the shop
     * @param nCoffeeOunces The amount of coffee
     * @param nSugarPackets The number of sugar packets
     * @param nCreams The number of creams
     * @param nCups The number of cups 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /**
     * Main
     */
    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "1 Chapin Way", 3, 50, 50, 50, 50);
        campusCenter.sellCoffee(57, 14, 3);

    }
    
}
