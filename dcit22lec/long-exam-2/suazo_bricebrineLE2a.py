hours_work = float(input("Hours worked in a week: "))
hourly_rate = float(input("Hourly rate: "))

regular_pay = hours_work * hourly_rate

overtime = 0
overtime_pay = 40

if (hours_work > 40):
    overtime = hours_work - 40

overtime_pay = overtime * 1.5 * hourly_rate

print("Regular pay: ", regular_pay)
print("Overtime pay: ", overtime_pay)
print("Gross pay: ", regular_pay + overtime_pay)