speed = int(input("Enter Your Speed in MPH: "))
normal_speed = 55

if speed <= normal_speed:
    print("Normal Speed")
elif (speed < 70) & (speed > normal_speed):
    print("Fine: ", 50 + ((speed-normal_speed)*5), "USD")
elif speed > 70:
    print("Fine: ", 125 + ((speed-70)*10), "USD")
else:
    print("You have entered wrong input.")