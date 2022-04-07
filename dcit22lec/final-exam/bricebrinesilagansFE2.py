num = int(input("Enter Number: "))
print('N\t', '10N\t', '100N\t', '1000N\t', sep = "")

for i in range(1, num + 1):
    for j in range(1, 5):
        print(i, '\t', end='')
        i *= 10
    print()
