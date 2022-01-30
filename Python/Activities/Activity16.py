class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer+" "+self.model+" is moving")

    def stop(self):
        print(self.manufacturer+" "+self.model+" has stopped")


tataNexon = Car("Tata", "Nexon", "2019", "automatic", "blue")
suzukiBaleno = Car("Suzuki", "Baleno", "2017", "manual", "red")
mahindraXUV300 = Car("Mahindra", "XUV 300", "2020", "automatic", "white")

tataNexon.accelerate()
tataNexon.stop()

suzukiBaleno.accelerate()
suzukiBaleno.stop()

mahindraXUV300.accelerate()
mahindraXUV300.stop()