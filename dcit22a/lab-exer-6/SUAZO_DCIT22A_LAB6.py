usernameList = ["admin", "joshua", "cardines"]
passwordList = ["admin123", "joshua123", "cardines123"]
username = input('Enter username: ')
password = input('Enter password: ')


for i in range(len(usernameList or passwordList)):
    if username == usernameList[i] and password == passwordList[i]:
        print('Access Granted! :)')
        break
else:
    print('Account not found! :(')