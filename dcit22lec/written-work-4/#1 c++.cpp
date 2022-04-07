#include <iostream>
using namespace std;

int main(){
    
    float your_speed, normal_speed;
    cout<<"Enter Your Speed in MPH: ";
    cin>>your_speed;
    normal_speed = 55;
    
    if (your_speed <= normal_speed){
    cout << "Normal Speed"<< endl;
    }else if ((your_speed < 70) & (your_speed > normal_speed)){
    cout << "Fine: " << (50 + ((your_speed-normal_speed)*5)) << " USD" << endl;
    }else if (your_speed > 70){
    cout << "Fine: " << (125 + ((your_speed-70)*10)) << "USD" << endl;
    }else{
    cout << "You have entered wrong input." << endl;

    }
}
