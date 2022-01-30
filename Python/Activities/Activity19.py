import pandas

data = {
    "FirstName" : ["Satvik", "Avinash", "Lahri"],
    "LastName" : ["Shah", "kati", "Rath"],
    "Email" : ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    "PhoneNumber" : ["4537829157", "5892184058", "4528727830"]
}

dataFrame = pandas.DataFrame(data)

writer = pandas.ExcelWriter("Activity19_excel_file.xlsx")

dataFrame.to_excel(writer, "Sheet1", index = False)

writer.save()