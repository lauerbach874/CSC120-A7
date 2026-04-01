/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  /**
   * Attributes
   */
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;

  /**
   * Constructor 
   * @param name The name of the building
   * @param address The address of the building
   * @param nFloors The number of floors the building has
   * @param hasDiningRoom If the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * Getter for the boolean telling if the house has a dining room
   * @return ture if it has a dining room, false if not
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }


  /**
   * Getter for the number of residents in the house
   * @return the number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Method for moving a student into the house
   * @param student The student
   */
  public void moveIn(Student s) {
    this.residents.add(s);
  }

  /**
   * Method for moving a student out of the house
   * @param student The student
   * @return The student who moved out
   */
  public Student moveOut(Student s) {
    if (this.residents.contains(s)) {
      this.residents.remove(s);
      return s;
    }
    else {
      throw new RuntimeException("The student isn't in the house.");
    }
  }

  /**
   * Method checking if the student is a resident of the house
   * @param student The student
   * @return true if the student is a resident, false if not
   */
  public boolean isResident(Student s) {
    if (this.residents.contains(s)) {
      boolean isResident = true;
      return isResident;
    }
    else {
      boolean isResident = false;
      return isResident;
    }
  }



  /**
   * Main 
   */
  public static void main(String[] args) {

    House chapin = new House("Chapin House", "3 Chapin Way", 4, true);
    House morris = new House("Morris House", "101 Green Street", 4, false);
    Student Lily = new Student("Lily", "99", 2028);
    

    chapin.moveIn(Lily);
    boolean isResident = chapin.isResident(Lily);
    System.out.println(isResident);
    Student moveOut = chapin.moveOut(Lily);
    isResident = chapin.isResident(Lily);
    System.out.println(moveOut);
    System.out.println(isResident);

  }

}