#include <iostream>
using namespace std;

int main(){
    float passenger_baggage;
    cout << "Enter your Baggage's weight (POUNDS): ";
    cin >> passenger_baggage;
    
    if ((passenger_baggage <= 50) & (passenger_baggage >= 0)){
    cout << "No Charge" << endl;
    }else if (passenger_baggage > 50){
    cout << "Charge = " << 5 + ((passenger_baggage - 50)*0.95) << "USD" << endl;
    }else{
    cout << "You have entered wrong input" << endl;
    }
}