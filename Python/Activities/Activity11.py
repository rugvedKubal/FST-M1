fruits = {
    "mango" : 30,
    "banana" : 2,
    "jackfruit" : 10,
    "pinapple" : 6,
    "orange" : 5
}

fruitName = input("Enter name of fruit to check it's availability: ").lower()

if fruitName in fruits:
    print(fruitName+" is available.")
else:
    print(fruitName+" is not available")