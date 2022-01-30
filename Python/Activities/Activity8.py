listOfNums = list(input("Enter a comma separated list of numbers: ").split(","))

if listOfNums[0] == listOfNums[-1]:
    print("True")
else:
    print("False")