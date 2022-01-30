import pandas

data = {
    "Usernames" : ["admin", "Charles", "Deku"],
    "Passwords" : ["password", "Charl13", "AllMight"]
}

dataFrame = pandas.DataFrame(data)

print(dataFrame)

dataFrame.to_csv("Activity17_csv_file.csv", index = False)