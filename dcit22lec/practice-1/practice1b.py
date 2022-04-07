accountNumber = int(input("Enter account number (-1 to quit): "))
if accountNumber !=  -1:
    beginningBalance = float(input("Enter beginning balance:"))
    charges = float(input("Enter total charges: "))
    credits = float(input("Enter total credits: "))
    creditLimit = float(input("Enter credit limit: "))
    newBalance = float((beginningBalance - credits) + charges)
    print("New balance is", newBalance)
    if (creditLimit < newBalance):
        print("Account:", accountNumber)
        print("Credit Limit:", creditLimit)
        print("Balance:", newBalance)
        print("Credit Limit Exceeded.")