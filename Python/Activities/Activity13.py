def add(listOfNums):
    sum = 0
    for num in listOfNums:
        sum = sum + num;
    return sum

listOfNums = [1,2,3,4,5]

sum = add(listOfNums)

print("Sum of the list of numbers is: "+str(sum))