#include <iostream>
using namespace std;

int main() {
    float users_CreditLimit, users_AccountBalance;
    cout << "Welcome to Humongus National Bank!" << endl;
    cout << "Enter your Credit Limit ($): ";
    cin >> users_CreditLimit;
    cout << "Enter your Account Balance ($): ";
    cin >> users_AccountBalance;
    cout << "" << endl;
    cout << "Your credit limit is: $" << users_CreditLimit << endl;
    cout << "Your account balance is: $" << users_AccountBalance << endl;
    
    if ((users_CreditLimit < 2000) & (users_AccountBalance < 500)){
        cout << "We will be issuing you a Platinum Card." << endl;
    }else if ((users_CreditLimit < 2000) & (users_AccountBalance > 500)){
        cout << "If your account balance falls below $500, you will receive a Platinum Card." << endl;
    }else if ((users_CreditLimit < 0) & (users_AccountBalance < 0)){
        cout << "You have entered invalid Credit Limit and Account Balance." << endl;
    }

cout << "Thank for trusting Humongus National Bank!";
}
