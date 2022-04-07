print("Welcome to Humongus National Bank!")
users_CreditLimit = float(input("Enter your Credit Limit ($): "))
users_AccountBalance = float(input("Enter your Account Balance ($): "))

print()
print("Your credit limit is: $", users_CreditLimit)
print("Your account balance is: $", users_AccountBalance)

if (users_CreditLimit < 2000 and users_AccountBalance < 500):
    print("We will be issuing you a Platinum Card.")
elif (users_CreditLimit < 2000 and users_AccountBalance > 500):
    print("If your account balance falls below $500, you will receive a Platinum Card.")
elif (users_CreditLimit < 0 and users_AccountBalance < 0):
    print("You have entered invalid Credit Limit and Account Balance.")

print("Thank for trusting Humongus Nation Bank!")