customersFullName = ['Jane Smith', 'Iason Jordan', 'David Morgan', 'Brain John', 'Jack Swift']
customersPin = [1111, 2222, 3333, 4444, 5555]
customersBalance = [10000, 20000, 30000, 40000, 50000]
accountStatus = ['Running', 'Running', 'Running', 'Running', 'Running']
keyMainMenu = ""
newBalance = float(0)

while keyMainMenu == "":
    print('====================================================\n====================================================')
    print('--------------- Welcome to Times Bank --------------\n****************************************************')
    print('=<< 1. Open a new account                        >>=')
    print('=<< 2. Withdraw Money                            >>=')
    print('=<< 3. Deposit Money                             >>=')
    print('=<< 4. Check Customers, Balance & Status         >>=')
    print('=<< 5. Change PIN                                >>=')
    print('=<< 6. Change Account Status (Freeze/Activate)   >>=')
    print('=<< 7. Exit/Quit                                 >>=')
    print('****************************************************')

    choice = int(input('Select your choice number from the above menu: '))

    if choice == 1:
        print('Choice number 1 is selected by the customer')
        numOfCustomer = int(input('Number of customers: '))
        for i in range(numOfCustomer):
            usersFullName = input('Input full name: ')
            
            while usersFullName in customersFullName:
                print('The user is already registered. Please input another name.')
                usersFullName = input('Input full name: ')

            usersPinString = ''
            while not (len(usersPinString) == 4):
                usersPinString = input('Please input a 4 digits pin: ')
            usersPin = int(usersPinString)
            
            usersInitialDeposit = float(input('Please input a value to deposit to start an account (PHP): '))
            print('\nName:', usersFullName)
            print('Pin:', usersPin)
            print('Balance:', usersInitialDeposit, '-/PHP')
            
            customersFullName.append(usersFullName)
            customersPin.append(usersPin)
            customersBalance.append(usersInitialDeposit)
            accountStatus.append('Running')
        
            print('Your name is available on the customers  list now:\n', customersFullName, '\n')
            print('Note! Please remember the Name and Pin')
            print('========================================')

        keyMainMenu = input('Please press enter key to go back to main menu to perform another function or exit...')


    elif choice == 2:
        print('Choice number 2 is selected by the customer')
        inputtedName = input('Please input your name: ')
        
        usersPinString = ''
        while not (len(usersPinString) == 4):
            usersPinString = input('Please input a 4 digits pin: ')
        inputtedPin = int(usersPinString)

        for i in range(len(customersFullName)):
            if customersFullName[i] == inputtedName and customersPin[i] == inputtedPin:
                if accountStatus[i] == 'Running':
                    print('Your Current Balance: ', customersBalance[i])
                    print('\n')
                    valueWithdraw = float(input('Input value to withdraw (PHP): '))
                    print('\n-----Withdraw Successful-----')
                    customersBalance[i] -= valueWithdraw
                    print('Your new balance: ', customersBalance[i], '-/PHP')

                    keyMainMenu = input('Please press enter key to go back to main menu to perform another function or exit...')
                elif accountStatus[i] == 'Freeze':
                    print("You can't use this account.\nAccount Status: Freeze")



    elif choice == 3:
        print('Choice number 3 is selected by the customer')
        inputtedName = input('Please input your name: ')
        
        usersPinString = ''
        while not (len(usersPinString) == 4):
            usersPinString = input('Please input a 4 digits pin: ')
        inputtedPin = int(usersPinString)

        for i in range(len(customersFullName)):
            if customersFullName[i] == inputtedName and customersPin[i] == inputtedPin:
                if accountStatus[i] == 'Running':
                    print('Your Current Balance: ', customersBalance[i])
                    print('\n')
                    valueDeposit = float(input('Input value to deposit (PHP): '))
                    print('\n-----Deposition Successful-----')
                    customersBalance[i] += valueDeposit
                    print('Your new balance: ', customersBalance[i], '-/PHP')

                    keyMainMenu = input('Please press enter key to go back to main menu to perform another function or exit...')
                elif accountStatus[i] == 'Freeze':
                    print("You can't use this account.\nAccount Status: Freeze")


    elif choice == 4:
        print('Choice number 4 is selected by the customer')
        print('Customer name list and balance mentioned below:\n')

        for i in range(len(customersFullName)):
            print('->.Customer = ', customersFullName[i])
            print('->.Balance = ', float(customersBalance[i]), '-/PHP')
            print('->.Account Status = ', accountStatus[i])
            print('\n')

        keyMainMenu = input('Please press enter key to go back to main menu to perform another function or exit...')



    elif choice == 5:
        print('Choice number 5 is selected by the customer')
        inputtedName = input('Please input your name: ')
        
        usersOldPinString = ''
        while not (len(usersOldPinString) == 4):
            usersOldPinString = input('Please input your OLD 4 digit pin: ')
        oldPin = int(usersOldPinString)

        for i in range(len(customersFullName)):
            if customersFullName[i] == inputtedName and customersPin[i] == oldPin:
                
                usersOldPinString1 = ''
                while not (len(usersOldPinString1) == 4):
                    usersOldPinString1 = input('Please input your NEW 4 digit pin: ')
                newPin1 = int(usersOldPinString1)
                
                usersOldPinString2 = ''
                while not (len(usersOldPinString2) == 4):
                    usersOldPinString2 = input('Please input your NEW 4 digit pin again: ')
                newPin2 = int(usersOldPinString2)

                if newPin1 == newPin2:
                    print('\n-----Change PIN Successful-----')
                    customersPin[i] = newPin1
                elif newPin1 != newPin2:
                    print('\n-----Error: Change PIN Unsuccessful-----')
            


    elif choice == 6:
        print('Choice number 5 is selected by the customer')
        inputtedName = input('Please input your name: ')
        usersPinString = ''
        while not (len(usersPinString) == 4):
            usersPinString = input('Please input a 4 digits pin: ')
        inputtedPin = int(usersPinString)

        for i in range(len(customersFullName)):
            if customersFullName[i] == inputtedName and customersPin[i] == inputtedPin:
                print('Your Current Balance: ', customersBalance[i])

                if accountStatus[i] == 'Running':
                    freezeChoice = input('\nFreeze your Account? (Y/N): ')
                    if (freezeChoice == 'Y') or (freezeChoice == 'y'):
                        accountStatus[i] = 'Freeze'
                        print('-----Account Status Changed Successfully-----')
                    else:
                        break
                elif accountStatus[i] == 'Freeze':
                    activateChoice = input('\nActivate your Account? (Y/N): ')
                    if (activateChoice == 'Y') or (activateChoice == 'y'):
                        accountStatus[i] = 'Running'
                        print('-----Account Status Changed Successfully-----')
                    else:
                        break


    elif choice == 7:
        print('Exiting...')
        exit()
    

    else:
        print('You have entered either not a number or not in the list.')

