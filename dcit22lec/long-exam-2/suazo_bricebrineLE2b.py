Q1 = float(input("Quiz 1 (10 items): "))
Q2 = float(input("Quiz 2 (10 items): "))
Q3 = float(input("Quiz 3 (10 items): "))
Q4 = float(input("Quiz 4 (10 items): "))
Q5 = float(input("Quiz 5 (10 items): "))

LQ1 = float(input("Long Exam 1 (100 items): "))
LQ2 = float(input("Long Exam 2 (100 items): "))
LQ3 = float(input("Long Exam 3 (100 items): "))

lecture_grade = float(((Q1 + Q2 + Q3 + Q4 + Q5) / 50.0 * 100.0) * 0.20 + ((LQ1 + LQ2 + LQ3) / 300.0 * 100.0) * 0.80)
print(lecture_grade, "%")

if ((lecture_grade >= 96.72) and (lecture_grade <= 100)):
    print("1.00")
elif ((lecture_grade >= 93.38) and (lecture_grade <= 96.71)):
    print("1.25")
elif ((lecture_grade >= 90.04) and (lecture_grade <= 93.37)):
    print("1.50")
elif ((lecture_grade >= 86.70) and (lecture_grade <= 90.03)):
    print("1.75")
elif ((lecture_grade >= 83.36) and (lecture_grade <= 86.69)):
    print("2.00")
elif ((lecture_grade >= 80.02) and (lecture_grade <= 83.35)):
    print("2.25")
elif ((lecture_grade >= 75.68) and (lecture_grade <= 80.01)):
    print("2.50")
elif ((lecture_grade >= 73.34) and (lecture_grade <= 76.67)):
    print("2.75")
elif ((lecture_grade >= 70) and (lecture_grade <= 73.33)):
    print("3.00")
elif ((lecture_grade >= 0) and (lecture_grade < 70)):
    print("5.00")
else:
    print("Invalid Grade.")

