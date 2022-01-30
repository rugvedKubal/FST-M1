def calSum(num):
    if num != 0:
        return num + calSum(num - 1)
    else:
        return 0

sum = calSum(10)

print("Sum is: "+str(sum))