
package InventoryManager;
import java.util.Scanner;
/**
 *
 * @author Brice Suazo
 */
public class InventoryManagerClient {
    public static void main(String []args){
        int choice = 0, quantity, itemInBox;
        String brand;
        Scanner in = new Scanner(System.in);
        
        InventoryManager inventory = new InventoryManager();
        
        do {
            displayOptions();
            System.out.print("Choice: ");
            choice = in.nextInt();
            
            switch(choice){
                case 1:
                    System.out.print("Brand: ");
                    in.nextLine();
                    brand = in.nextLine();
                    
                    System.out.print("Quantity: ");
                    quantity = in.nextInt();
                    
                    SingleProduct single = new SingleProduct(brand);
                    
                    inventory.add(single, quantity);
                    break;
                case 2:
                    System.out.print("Brand: ");
                    in.nextLine();
                    brand = in.nextLine();
                    System.out.print("Item in Box: ");
                    itemInBox = in.nextInt();
                    System.out.print("Quantity: ");
                    quantity = in.nextInt();
                    
                    BoxedProduct boxes = new BoxedProduct(brand, itemInBox);
                    
                    inventory.add(boxes, quantity);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("You have entered invalid input.");
                    break;
            }
        }while(choice != 3);
        
        displayReport(inventory);
    }
    
    private static void displayOptions(){
        String options[] = {"Add Single Product", "Add Box Product", "Exit"};
        System.out.println("Options:");
        for(int i = 0; i < options.length; i++){
            System.out.printf("\t[%d] %s\n", i + 1, options[i]);
            
        }
    }
    
    private static void displayReport(InventoryManager inventory){
        System.out.println("\n-Inventory Report-\n");
        for(String brand : inventory.getBrands()){
            System.out.println(brand);
            System.out.printf("\tSingles: %d\n", inventory.getSingles(brand).length);
            System.out.printf("\tBoxes: %d\n", inventory.getBoxes(brand).length);
            System.out.printf("\tTotal Pieces: %d\n", inventory.getTotalPieces(brand));
        }
    }
}
