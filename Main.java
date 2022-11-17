import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  String name,serialNumber;
  int value;

  Inventory(String name, String serialNumber, int value){
    this.name = name;
    this.serialNumber = serialNumber;
    this.value = value;
  }
  public String getSerialNumber(){
    return serialNumber;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setValue(int value){
    this.value = value;
  }
  @Override
  public String toString(){
    return name + "," + serialNumber + "," + value;
  }
}

class Main {

  static ArrayList<Inventory> items = new ArrayList<Inventory>();
  static Scanner scanner = new Scanner(System.in);
  static int userChoice = 0;
  
	public static void main(String[] args) {

    while(true){
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the program.");
      userChoice = scanner.nextInt();
      scanner.nextLine();
      
      switch(userChoice){
        case 1:
          addItem();
          break;
        case 2:
          deleteItem();
          break;
        case 3:
          updateItem();
          break;
        case 4:
          showItems();
          break;
        default:
          System.exit(0); 
      }
    }
	}
  static void addItem(){
    System.out.println("Enter the name:");
    String name = scanner.nextLine();
    System.out.println("Enter the serial number:");
    String serialNumber = scanner.nextLine();
    System.out.println("Enter the value in dollars (whole number):");
    int value = scanner.nextInt();
    Inventory item = new Inventory(name,serialNumber,value);
    items.add(item);
  }
  static void deleteItem(){
    System.out.println("Enter the serial number of the item to delete:");
    String serialNumber = scanner.nextLine();
    for(Inventory i: items){
      if(i.getSerialNumber().equals(serialNumber)){
        items.remove(i);
      }
    }
  }
  static void updateItem(){
    System.out.println("Enter the serial number of the item to change:");
    String serialNumber = scanner.nextLine();
    for(Inventory i: items){
      if(i.getSerialNumber().equals(serialNumber)){
        System.out.println("Enter the new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter the new value in dollars (whole number):");
        int value = scanner.nextInt();
        i.setName(newName);
        i.setValue(value);
      }
    }
  }
  static void showItems(){
    for(Inventory i: items){
      System.out.println(i.toString());
    }
  }
  
}