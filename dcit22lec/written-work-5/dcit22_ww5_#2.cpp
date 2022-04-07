#include <iostream>
using namespace std;

int main() {
    float pay_rate, hours_worked, regular_pay, overtime_pay, gross_pay, tax, net_pay, total_tax;
    char employee_code, state_code;
    
    cout << "Pay Rate ($): ";
    cin >> pay_rate;
    cout << "Hours Worked: ";
    cin >> hours_worked;
    cout << "Employee Code ('A' for Full time & 'B' for Part-time): ";
    cin >> employee_code;
    cout << "State Code ('Y' for New York & 'J' for New Jersey)";
    cin >> state_code;
    
    if (hours_worked <= 40){
        regular_pay = pay_rate * hours_worked;
        overtime_pay = 0;
        gross_pay = regular_pay + overtime_pay;
    }else if (hours_worked > 40){
        overtime_pay = ((hours_worked - 40) * 1.5);
        regular_pay = (pay_rate * 40) + overtime_pay;
        gross_pay = regular_pay + overtime_pay;
    }else if (hours_worked <= 0){
        cout << "You didn't work this day." << endl;
    }else{
        cout << "Invalid" << endl;
    }
    
    if ((employee_code == 'A' | 'a') & (state_code == 'Y' | 'y')){
        tax = 7;
        total_tax = gross_pay * (tax / 100);
        cout << "Tax (7%): " << total_tax << endl;
    }else if ((employee_code == 'A' | 'a') & (state_code != 'Y' | 'y')){
        tax = 4.5;
        total_tax = gross_pay * (tax / 100);
        cout << "Tax (4.5%): " << total_tax << endl;
    }else if (employee_code != 'A' | 'a'){
        tax = 0;
        total_tax = gross_pay * (tax / 100);
    }else{
        cout << "Invalid" << endl;
    }

    net_pay = gross_pay - total_tax;
    
    cout << "Regular Pay: " << regular_pay << endl;
    cout << "Overtime Pay: " << overtime_pay << endl;
    cout << "Gross Pay: " << gross_pay << endl;
    cout << "Total Tax: " << total_tax << endl;
    cout << "Net Pay: " << net_pay << endl;
}