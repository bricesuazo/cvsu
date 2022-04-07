pay_rate = float(input("Pay Rate ($): "))
hours_worked = int(input("Hours Worked: "))
employee_code = str(input("Employee Code ('A' for Full time & 'B' for Part-time): "))
state_code = str(input("State Code ('Y' for New York & 'J' for New Jersey): "))

regular_pay = float
overtime_pay = float
gross_pay = float
tax = float
net_pay = float
total_tax = float

if hours_worked <= 40:
    regular_pay = pay_rate * hours_worked
    overtime_pay = 0
    gross_pay = regular_pay + overtime_pay
elif hours_worked > 40:
    overtime_pay = ((hours_worked - 40) * 1.5)
    regular_pay = (pay_rate * 40) + overtime_pay
    gross_pay = regular_pay + overtime_pay
elif hours_worked <= 0:
    print("You didn't work this day.")
else:
    print("Invalid")

if (employee_code == 'A' or 'a') and (state_code == 'Y' or 'y'):
    tax = 7
    total_tax = gross_pay * (tax / 100)
    print("Tax (7%): ", total_tax)
elif (employee_code == 'A' or 'a') and (state_code != 'Y' or 'y'):
    tax = 4.5
    total_tax = gross_pay * (tax / 100)
    print("Tax (4.5%): ", total_tax)
elif (employee_code != 'A' or 'a'):
    tax = 0
    total_tax = gross_pay * (tax / 100)
else:
    print("Invalid")

net_pay = gross_pay - total_tax

print("Regular Pay: ", regular_pay)
print("Overtime Pay: ", overtime_pay)
print("Gross Pay: ", gross_pay)
print("Tax (", tax, "%): ", total_tax)
print("Net Pay: ", net_pay)