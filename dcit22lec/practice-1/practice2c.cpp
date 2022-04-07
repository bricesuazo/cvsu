#include<iostream>
#include<conio.h>
using namespace std;

int main() {
    float payRate, noOfHours, overtimePay, regularPay, excessHours, grossPay, netPay, tax, totalEmp = 0, totalGP = 0, totalTax = 0, totalNetPay = 0;
    char empCode, locationCode, option;
    do {
        cout<<"PAY RATE: ";
        cin>>payRate;
        cout<<"NUMBER OF HOURS WORKED: ";
        cin>>noOfHours;
        cout<<"EMPLOYEE CODE: ";
        cin>>empCode;
        cout<<"LOCATION CODE: ";
        cin>>locationCode;
        overtimePay = 0;
        
        if (noOfHours <= 40){
            regularPay = payRate * noOfHours;
        }else{
            excessHours = noOfHours - 40;
            regularPay = payRate * 40;
            overtimePay = excessHours * payRate * 1.5;
        }
        grossPay = regularPay + overtimePay;
        
        if ((empCode=='A' || empCode=='a') && (locationCode=='N' || locationCode =='n')){
            tax = grossPay * .07;
        }else if ((empCode=='A' || empCode=='a') && (locationCode=='P' || locationCode=='p')){
            tax = grossPay * .045;
        }else if (empCode=='B' || empCode=='b'){
            tax = 0;
        }else{
            cout<<"Invalid Code!!!\n";
        }
        netPay = grossPay - tax;
        cout<<"\nRegular Pay: "<<regularPay;
        cout<<"\nOvertime Pay: "<<overtimePay;
        cout<<"\nTax: "<<tax;
        cout<<"\nGross Pay: "<<grossPay;
        cout<<"\nNet Pay: "<<netPay;
        totalEmp++;
        totalGP = totalGP + grossPay;
        totalTax = totalTax + tax;
        totalNetPay = totalNetPay + netPay;
        cout<<"\n\nDo you want to process another employee?(y/n): ";
        cin>>option;
    }while (option == 'Y' || option == 'y');

    cout<<"\n\nTotal number of employees processed: "<<totalEmp;
    cout<<"\nTotal gross pay: "<<totalGP;
    cout<<"\nTotal tax: "<<totalTax;
    cout<<"\nTotal net pay: "<<totalNetPay<<"\n\n";
    getch();

}