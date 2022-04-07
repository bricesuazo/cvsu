life = int(3)

print('Your life is: ', life)
operation = input('1 - Addition\n2 - Substraction\n3 - Multiplication\n4 - Division\nChoose arithmetic operation: ')

while not (operation == '1' or operation == '2' or operation == '3' or operation == '4'):
    print('You have entered wrong operation.')
    operation = input('1 - Addition\n2 - Substraction\n3 - Multiplication\n4 - Division\nEnter the operation again: ')
else:
    num1 = int(input('Enter 1st number: '))
    num2 = int(input('Enter 2nd number: '))
    if operation == '1':
        print(num1, '+',num2)
        correct_answer = num1 + num2
    elif operation == '2':
        print(num1, '-',num2)
        correct_answer = num1 - num2
    elif operation == '3':
        print(num1, '*',num2)
        correct_answer = num1 * num2
    elif operation == '4':
        print(num1, '/',num2)
        correct_answer = num1 / num2

    while life != 0:
        answer = int(input('Enter your answer: '))
        if answer == correct_answer:
            print('You won!')
            break
        else:
            print('Your answer is wrong! Please try again.')
            life -= 1
            print('Your life is: ', life)
    else:
        print('Game over!')