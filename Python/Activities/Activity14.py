def fib(num):
    if num <= 1:
        return num
    else:
        return(fib(num - 1) + fib(num - 2))

num = int(input("Enter a number to generate fibonacci sequence: "))

for i in range(num):
    print(fib(i))