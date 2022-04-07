userYear = int(input('Enter your Birth Year: '))
zodiac = ['Rat', 'Ox', 'Tiger', 'Rabbit', 'Dragon', 'Snake', 'Horse', 'Sheep', 'Monkey', 'Rooster', 'Dog', 'Pig']

for j in range(12):
    num = 1912 + j
    for i in range(num, num+120+1, 12):
        if (userYear == i):
            print(zodiac[j])
if (userYear < 1912) or (userYear > 2043):
    print('You have entered out of range value')