
package InventoryManager;
import java.util.ArrayList;

public class InventoryManager {
    private final ArrayList<String> brands = new ArrayList<>();
    private final ArrayList<SingleProduct> singles = new ArrayList<>();
    private final ArrayList<BoxedProduct> boxes = new ArrayList<>();
    private final ArrayList<Integer> total_pieces = new ArrayList<>();

    void add(SingleProduct p){
        singles.add(p);
    }
    
    void add(SingleProduct p, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(p);
        }   
        if(brands.contains(p.getBrand())){
            int index = brands.indexOf(p.getBrand());
            int tempQuantity = total_pieces.get(index);
            tempQuantity += quantity;
            total_pieces.set(index, tempQuantity);
        }else{
            total_pieces.add(quantity);
        }
        addBrand(p.getBrand());
    }
    
    void add(BoxedProduct p){
        boxes.add(p);
    }

    void add(BoxedProduct p, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(p);
        }
        
        int temp = 0;
        temp = p.getQuantity() * quantity;
        if(brands.contains(p.getBrand())){
            int index = brands.indexOf(p.getBrand());
            int tempQuantity = total_pieces.get(index);
            tempQuantity += temp;
            total_pieces.set(index, tempQuantity);
        }else{
            total_pieces.add(temp);
        }
        addBrand(p.getBrand());
    }
    
    String[] getBrands(){
        String[] brands_list = brands.toArray(new String[brands.size()]);
        return brands_list;
    }
    
    SingleProduct[] getSingles(String brand){
        ArrayList<SingleProduct> selectedBrands = new ArrayList<>();
        for (int i = 0; i < singles.size(); i++) {
            if(singles.get(i).getBrand().equals(brand)){
                selectedBrands.add(singles.get(i));
            }
        }
        SingleProduct[] singles_list = selectedBrands.toArray(new SingleProduct[selectedBrands.size()]);
        return singles_list;
    }
    
    BoxedProduct[] getBoxes(String brand){
        ArrayList<BoxedProduct> selectedBrands = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            if(boxes.get(i).getBrand().equals(brand)){
                selectedBrands.add(boxes.get(i));
            }
        }
        BoxedProduct[] boxes_list = selectedBrands.toArray(new BoxedProduct[selectedBrands.size()]);
        return boxes_list;
    }
    
    
    private void addBrand(String brand){
        if(!brands.contains(brand)){
            brands.add(brand);
        }
    }
    
    int getTotalPieces(String brand){
        int index = 0;
        if(brands.contains(brand)){
            index = brands.indexOf(brand);
        }
        return total_pieces.get(index);
    }

}
