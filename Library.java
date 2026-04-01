/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Set;

public class Library extends Building implements LibraryRequirements {

  /**
   * Attributes
   */
  private Hashtable<String, Boolean> collection;

    /**
    * Constructor
    * @param name The name of the building
    * @param address The address of the building
    * @param nFloors The number of floors the building has
    */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
      
    }

    /**
     * Method for adding a book to the library 
     * @param title String of the title of the book 
     */
    public void addTitle(String title) {
      if (this.containsTitle(title) == false) {
        this.collection.put(title, true);
      }
     
      else {
        throw new RuntimeException("The title has already been added to the collection");
     
      }
      
    }

    /**
     * Method for removing a book from the colletion
     * @param title String of the title of the book
     * @return title of the book being removed
     */
    public String removeTitle(String title) {
      if (this.containsTitle(title)) {
        this.collection.remove(title);
        return title;

      }
    
      else {
        throw new RuntimeException("The title is not in the collection");

      }
    }

    /**
     * Method for checking out a book from the library
     * @param title String of the title of the book
     */
    public void checkOut(String title){ 
      if (this.isAvailable(title)) {
        this.collection.replace(title, false);
      
      }
     
      else {
        throw new RuntimeException("The title is unavailable.");
      
      }
    }

    /**
     * Method for returning a book to the library
     * @param title String of the title of the book
     */
    public void returnBook(String title) {
      if (this.isAvailable(title) == false) {
        this.collection.replace(title, true);
      
      }
     
      else {
        throw new RuntimeException("The title wasn't checked out.");
      
      }
    }

    /**
    * Method for seeing if the book is in the collection
    * @param title String of the title of the book
    * @return true if the book is in the collection, false if not
    */
    public boolean containsTitle(String title) {
      if (this.collection.containsKey(title)) {
        return true;
     
      }
     
      else {
        return false;
      
      }
    } 

    /**
     * Method for seeing if the book is available for checkout
     * @param title String of the title of the book
     * @return available, ture if the book is available, false if not
     */
    public boolean isAvailable(String title) {
      if (this.containsTitle(title)) {
        boolean available = this.collection.get(title);
        return available;
      
      }
     
      else {
        throw new RuntimeException("The title is not in the collection.");
      
      }
    }

    /**
     * Method for printing out the books in the collection and their status
     */
    public void printCollection() {
      Set<String> setOfKeys = this.collection.keySet();
        for (String key : setOfKeys) {
          System.out.println("Title: " + key + " Available: " + this.collection.get(key));

        }
      
    }

  /**
   * Main
   */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "1 Neilson Drive", 4);

    neilson.addTitle("Crime and Punishment");
    neilson.checkOut("Crime and Punishment");
    neilson.addTitle("Twilight");
    neilson.printCollection();
    
  }
}