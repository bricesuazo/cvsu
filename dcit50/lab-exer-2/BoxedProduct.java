package InventoryManager;

public class BoxedProduct {
    final private String brand;
    final private int quantity;
    
    BoxedProduct (String brand, int quantity){
        this.brand = brand;
        this.quantity = quantity;
    }
    String getBrand(){
        return this.brand;
    }
    int getQuantity(){
        return this.quantity;
    }
}