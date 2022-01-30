import pandas

dataFrame = pandas.read_csv("Activity17_csv_file.csv")

print("print values in Usernames column: ")
print(dataFrame["Usernames"])
print("-------------------------------------------")
print("print username and password of second row: ")
print("username: "+dataFrame["Usernames"][1]+", password: "+dataFrame["Passwords"][1])
print("-------------------------------------------")
print("sort Usernames in ascendending order: ")
print(dataFrame.sort_values("Usernames"))
print("-------------------------------------------")
print("sort Passwords in descending order: ")
print(dataFrame.sort_values("Passwords", ascending = False))