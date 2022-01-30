listOfNums = list(input("Enter comma separated numbers: ").split(","))
sum = 0

for num in listOfNums:
    sum = sum + int(num);

print("Sum of numbers is: "+str(sum))