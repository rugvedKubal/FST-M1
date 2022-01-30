list1 = [21,22,23,24,25,26,27,28]
list2 = [41,42,43,44,45,46,47,48]

list3 = []

for i in list1:
    if i%2 != 0:
        list3.append(i)

for i in list2:
    if i%2 == 0:
        list3.append(i)

print("third list is: ")
print(list3)