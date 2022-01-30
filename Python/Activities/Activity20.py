import pandas

dataFrame = pandas.read_excel("Activity19_excel_file.xlsx")

print("number of rows and columns in excel: ")
print(dataFrame.shape)
print("--------------------------------------")
print("data in Email column: ")
print(dataFrame["Email"])
print("--------------------------------------")
print("sorted First names: ")
print(dataFrame.sort_values("FirstName"))