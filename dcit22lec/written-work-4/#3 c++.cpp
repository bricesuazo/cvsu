#include <iostream>
using namespace std;

int main(){
    int price;
    std::string wood;
    int wood_type;
    
    cout << "Select a wood type: \n 1. Pine - $100\n 2. Oak - $225\n 3. Mahogany - $310" << endl;
    cout << "Select a wood type: " << endl;
    cin >> wood_type;
    
    if (wood_type == 1){
        wood = "Pine - $100";
        cout << "Selected: " << wood << endl;
        price = 100;
    }else if (wood_type == 2){
        wood = "Oak - $225";
        cout << "Selected: " << wood << endl;
        price = 225;
    }else if (wood_type == 3){
        wood = "Mahogany - $310";
        cout << "Selected: " << wood << endl;
        price = 310;
    }else{
        cout << "You have entered wrong input." << endl;
    }
    
    cout << "Select a size of the wood (+10 % on the price if you choose Large): \n L - Large\n S - Small" << endl;
    
    char size;
    cout << "Select the wood size: " << endl;
    cin >> size;
    
    if (size == 'L'){
        price = (price*0.10) + price;
        cout << "Selected: Large" << endl;
    }else if (size == 'S'){
        cout << "Selected: Small" << endl;
    }else{
        cout << "You have entered wrong input." << endl;
    }
    cout << "Total Price = $" << price << endl;
}