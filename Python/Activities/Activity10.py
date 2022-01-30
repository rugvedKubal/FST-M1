tupleOfNums = tuple(input("Enter comma separated numbers: ").split(","))

print("Numbers divisible by 5: ")
for i in tupleOfNums:
    if int(i)%5 == 0:
        print(i)