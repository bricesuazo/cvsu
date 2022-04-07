price = int
wood = ""

print("Select a wood type: \n 1. Pine - $100\n 2. Oak - $225\n 3. Mahogany - $310")
wood_type = int(input("Select a wood type: "))

if wood_type == 1:
    wood = "Pine - $100"
    print("Selected: ", wood)
    price = 100
elif wood_type == 2:
    wood = "Oak - $225"
    print("Selected: ", wood)
    price = 225
elif wood_type == 3:
    wood = "Mahogany - $310"
    print("Selected: ", wood)
    price = 310
else:
    print("You have entered wrong input.")

print("Select a size of the wood (+10 % on the price if you choose Large): \n L - Large\n S - Small")
size = input("Select the wood size: ")

if size == 'L':
    price = (price*0.10) + price
    print("Selected: Large")
elif size == 'S':
    print("Selected: Small")
else:
    print("You have entered wrong input.")

print("Total Price = $", price)