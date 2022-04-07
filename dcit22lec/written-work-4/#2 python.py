passenger_baggage = int(input("Enter your Baggage's weight (POUNDS): "))

if (passenger_baggage <= 50) & (passenger_baggage >= 0):
    print("No Charge")
elif passenger_baggage > 50:
    print("Charge = ", 5 + ((passenger_baggage - 50)*0.95), "USD")
else:
    print("You have entered wrong input")