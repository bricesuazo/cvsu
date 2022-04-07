age1 = int(input('Enter 1st age: '))
age2 = int(input('Enter 2nd age: '))
age3 = int(input('Enter 3rd age: '))

if (age1 >= age2) and (age1 >= age3):
    print('Oldest is ', age1)
    if (age2 >= age3):
        print('Youngest is ', age3)
    elif (age3 >= age2):
        print('Youngest is ', age2)

elif (age2 >= age3) and (age2 >= age1):
    print('Oldest is ', age2)
    if (age3 >= age1):
        print('Youngest is ', age1)
    elif (age1 >= age3):
        print('Youngest is ', age3)

elif (age3 >= age1) and (age3 >= age2):
    print('Oldest is ', age3)
    if (age1 >= age2):
        print('Youngest is ', age2)
    elif (age2 >= age1):
        print('Youngest is ', age1)
