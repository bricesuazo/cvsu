print("Input 10 numbers:")
items = 10
num = 0
average = float(0)
for i in range(1, items + 1):
    num = int(input())
    average += num
    
average /= 10
print("The average is: ", average)