
class Phone{
    int id;
    String brand;
    String model;
    int storage;
    int screenSize;
    String color;
    int price;
    String os;

    public Phone(int id, String brand, String model, int storage, int screenSize, String color, int price, String os){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.storage = storage;
        this.screenSize = screenSize;
        this.color = color;
        this.price = price;
        this.os = os;
        System.out.println("Phone instance created with id: " + id);
    }

    public void makeCall(){
        System.out.println("Phone" + this.id + " is calling...");
    }

    public void receiveCall(){
        System.out.println("Phone" + this.id + " is receiving call...");
    }

    public void sendSms(){
        System.out.println("Phone" + this.id + " is sending SMS...");
    }

    class Camera {
        int resolution;
        boolean hasFlash;

        public Camera(int resolution, boolean hasFlash) {
            this.resolution = resolution;
            this.hasFlash = hasFlash;
            System.out.println("Camera instance in phone" + Phone.this.id + " created with resolution: " + resolution);
        }

        public void takePhoto() {
            System.out.println("Camera in phone" + Phone.this.id + " is taking photo...");
        }

        public void recordVideo() {
            System.out.println("Camera in phone" + Phone.this.id + " is recording video...");
        }

        public void flashOn() {
            System.out.println("Camera in phone" + Phone.this.id + " is turning on flash...");
        }
    }

    class Processor {
        int cores;
        int clockSpeed;

        public Processor(int cores, int clockSpeed){
            this.cores = cores;
            this.clockSpeed = clockSpeed;
            System.out.println("Processor instance in phone" + Phone.this.id + " created with cores: " + cores);
        }

        public void process(){
            System.out.println("Processor in phone" + Phone.this.id + " is processing...");
        }

        public void playGame(){
            System.out.println("Processor in phone" + Phone.this.id + " is playing game...");
        }

        public void playMusic(){
            System.out.println("Processor in phone" + Phone.this.id + " is playing music...");
        }
    }
}

class House{
    int id;
    String address;
    int area;
    int price;
    String owner;
    String type;
    int rooms;
    int bathrooms;

    public House(int id, String address, int area, int price, String owner, String type, int rooms, int bathrooms){
        this.id = id;
        this.address = address;
        this.area = area;
        this.price = price;
        this.owner = owner;
        this.type = type;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        System.out.println("House instance created with id: " + id);
    }

    public void rent(){
        System.out.println("House" + this.id + " is renting...");
    }

    public void sell(){
        System.out.println("House" + this.id + " is selling...");
    }

    public void buy(){
        System.out.println("House" + this.id + " is buying...");
    }

    class Kitchen {
        int area;
        boolean isOpen;

        public Kitchen(int area, boolean isOpen) {
            this.area = area;
            this.isOpen = isOpen;
            System.out.println("Kitchen instance in house" + House.this.id + " created with area: " + area);
        }

        public void cook() {
            System.out.println("Kitchen in house" + House.this.id + " is cooking...");
        }

        public void clean() {
            System.out.println("Kitchen in house" + House.this.id + " is cleaning...");
        }

        public void wash() {
            System.out.println("Kitchen in house" + House.this.id + " is washing...");
        }
    }

    class Bathroom {
        int area;
        int appliances;

        public Bathroom(int area, int appliances) {
            this.area = area;
            this.appliances = appliances;
            System.out.println("Bathroom instance in house" + House.this.id + " created with area: " + area);
        }

        public void takeShower() {
            System.out.println("Bathroom in house" + House.this.id + " is taking shower...");
        }

        public void takeBath() {
            System.out.println("Bathroom in house" + House.this.id + " is taking bath...");
        }

        public void washHands() {
            System.out.println("Bathroom in house" + House.this.id + " is washing hands...");
        }
    }

}

class Car{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String type;
    int doors;
    int seats;

    public Car(int id, String brand, String model, int year, int price, String color, String type, int doors, int seats){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        this.doors = doors;
        this.seats = seats;
        System.out.println("Car instance created with id: " + id);
    }

    public void drive(){
        System.out.println("Car" + this.id + " is driving...");
    }

    public void park(){
        System.out.println("Car" + this.id + " is parking...");
    }

    public void stop(){
        System.out.println("Car" + this.id + " is stopping...");
    }
}

class Laptop{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String os;
    int storage;
    int ram;

    public Laptop(int id, String brand, String model, int year, int price, String color, String os, int storage, int ram){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.os = os;
        this.storage = storage;
        this.ram = ram;
        System.out.println("Laptop instance created with id: " + id);
    }

    public void turnOn(){
        System.out.println("Laptop" + this.id + " is turning on...");
    }

    public void turnOff(){
        System.out.println("Laptop" + this.id + " is turning off...");
    }

    public void restart(){
        System.out.println("Laptop" + this.id + " is restarting...");
    }
}

class Watch{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String type;
    String material;

    public Watch(int id, String brand, String model, int year, int price, String color, String type, String material){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        this.material = material;
        System.out.println("Watch instance created with id: " + id);
    }

    public void showTime(){
        System.out.println("Watch" + this.id + " is showing time...");
    }

    public void showDate(){
        System.out.println("Watch" + this.id + " is showing date...");
    }

    public void showAlarm(){
        System.out.println("Watch" + this.id + " is showing alarm...");
    }
}

class Printer{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String type;
    String material;

    public Printer(int id, String brand, String model, int year, int price, String color, String type, String material){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        this.material = material;
        System.out.println("Printer instance created with id: " + id);
    }

    public void print(){
        System.out.println("Printer" + this.id + " is printing...");
    }

    public void scan(){
        System.out.println("Printer" + this.id + " is scanning...");
    }

    public void copy(){
        System.out.println("Printer" + this.id + " is copying...");
    }
}

class Headset{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String type;
    String material;

    public Headset(int id, String brand, String model, int year, int price, String color, String type, String material){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        this.material = material;
        System.out.println("Headset instance created with id: " + id);
    }

    public void listenMusic(){
        System.out.println("Headset" + this.id + " is listening music...");
    }

    public void listenRadio(){
        System.out.println("Headset" + this.id + " is listening radio...");
    }

    public void listenPodcast(){
        System.out.println("Headset" + this.id + " is listening podcast...");
    }
}

class Tablet{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String os;
    int storage;
    int ram;

    public Tablet(int id, String brand, String model, int year, int price, String color, String os, int storage, int ram){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.os = os;
        this.storage = storage;
        this.ram = ram;
        System.out.println("Tablet instance created with id: " + id);
    }

    public void playGame(){
        System.out.println("Tablet" + this.id + " is playing game...");
    }

    public void playMovie(){
        System.out.println("Tablet" + this.id + " is playing movie...");
    }

    public void playMusic(){
        System.out.println("Tablet" + this.id + " is playing music...");
    }
}

class Television{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String type;
    String material;

    public Television(int id, String brand, String model, int year, int price, String color, String type, String material){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        this.material = material;
        System.out.println("Television instance created with id: " + id);
    }

    public void watchMovie(){
        System.out.println("Television" + this.id + " is watching movie...");
    }

    public void watchGame(){
        System.out.println("Television" + this.id + " is watching game...");
    }

    public void watchNews(){
        System.out.println("Television" + this.id + " is watching news...");
    }
}

class LoudSpeaker{
    int id;
    String brand;
    String model;
    int year;
    int price;
    String color;
    String type;
    String material;

    public LoudSpeaker(int id, String brand, String model, int year, int price, String color, String type, String material){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        this.material = material;
        System.out.println("LoudSpeaker instance created with id: " + id);
    }

    public void playMusic(){
        System.out.println("LoudSpeaker" + this.id + " is playing music...");
    }

    public void playRadio(){
        System.out.println("LoudSpeaker" + this.id + " is playing radio...");
    }

    public void playPodcast(){
        System.out.println("LoudSpeaker" + this.id + " is playing podcast...");
    }
}


public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone(1, "Samsung", "Galaxy S10", 128, 6, "Black", 1000, "Android");
        Phone.Camera camera1 = phone1.new Camera(12, true);
        Phone.Processor processor1 = phone1.new Processor(8, 2);

        Phone phone2 = new Phone(2, "Apple", "iPhone 11", 256, 6, "White", 1200, "iOS");
        Phone.Camera camera2 = phone2.new Camera(12, true);
        Phone.Processor processor2 = phone2.new Processor(8, 2);

        Phone phone3 = new Phone(3, "Huawei", "P30 Pro", 256, 6, "Black", 800, "Android");
        Phone.Camera camera3 = phone3.new Camera(40, true);
        Phone.Processor processor3 = phone3.new Processor(8, 2);

        phone1.makeCall();
        camera1.takePhoto();
        processor1.process();

        phone2.receiveCall();
        camera2.recordVideo();
        processor2.playGame();

        phone3.sendSms();
        camera3.flashOn();
        processor3.playMusic();

        System.out.println();

        House house1 = new House(1, "123 Main St", 1000, 100000, "John Doe", "Single Family", 5, 3);
        House.Kitchen kitchen1 = house1.new Kitchen(50, true);
        House.Bathroom bathroom1 = house1.new Bathroom(20, 2);

        House house2 = new House(2, "456 Park Ave", 2000, 200000, "Jane Doe", "Apartment", 3, 2);
        House.Kitchen kitchen2 = house2.new Kitchen(40, false);
        House.Bathroom bathroom2 = house2.new Bathroom(15, 1);

        House house3 = new House(3, "789 Elm St", 1500, 150000, "Jim Smith", "Condo", 4, 2);
        House.Kitchen kitchen3 = house3.new Kitchen(30, true);
        House.Bathroom bathroom3 = house3.new Bathroom(25, 3);

        house1.rent();
        kitchen1.cook();
        bathroom1.takeShower();

        house2.buy();
        kitchen2.clean();
        bathroom2.takeBath();

        house3.sell();
        kitchen3.wash();
        bathroom3.washHands();

        System.out.println();

        Car car1 = new Car(1, "Toyota", "Camry", 2019, 20000, "White", "Sedan", 4,5);
        Car car2 = new Car(2, "Honda", "Civic", 2018, 15000, "Black", "Sedan", 4,5);
        Car car3 = new Car(3, "Ford", "F-150", 2017, 25000, "Red", "Truck", 4,7);

        car1.drive();
        car2.park();
        car3.stop();

        System.out.println();

        Laptop laptop1 = new Laptop(1, "Apple", "MacBook Pro", 2019, 2000, "Silver", "MacOS", 512, 16);
        Laptop laptop2 = new Laptop(2, "Dell", "XPS 15", 2018, 1500, "Black", "Windows", 256, 8);
        Laptop laptop3 = new Laptop(3, "Lenovo", "ThinkPad", 2017, 1000, "White", "Windows", 128, 4);

        laptop1.turnOn();
        laptop2.turnOff();
        laptop3.restart();

        System.out.println();

        Watch watch1 = new Watch(1, "Apple", "Apple Watch", 2019, 500, "Silver", "Apple WatchOS", "Stainless Steel");
        Watch watch2 = new Watch(2, "Samsung", "Galaxy Watch", 2018, 400, "Black", "Tizen", "Stainless Steel");
        Watch watch3 = new Watch(3, "Fitbit", "Versa", 2017, 300, "White", "Fitbit OS", "Aluminum");

        watch1.showTime();
        watch2.showDate();
        watch3.showAlarm();

        System.out.println();

        Printer printer1 = new Printer(1, "HP", "OfficeJet Pro", 2019, 500, "Black", "Inkjet", "Plastic");
        Printer printer2 = new Printer(2, "Canon", "PIXMA", 2018, 400, "White", "Inkjet", "Plastic");
        Printer printer3 = new Printer(3, "Epson", "WorkForce", 2017, 300, "Silver", "Inkjet", "Plastic");

        printer1.print();
        printer2.scan();
        printer3.copy();

        System.out.println();

        Headset headset1 = new Headset(1, "Apple", "AirPods", 2019, 200, "White", "Bluetooth", "Plastic");
        Headset headset2 = new Headset(2, "Samsung", "Galaxy Buds", 2018, 150, "Black", "Bluetooth", "Plastic");
        Headset headset3 = new Headset(3, "Sony", "WF-1000XM3", 2017, 100, "Silver", "Bluetooth", "Plastic");

        headset1.listenMusic();
        headset2.listenPodcast();
        headset3.listenRadio();

        System.out.println();

        Tablet tablet1 = new Tablet(1, "Apple", "iPad Pro", 2019, 1000, "Silver", "iOS", 128, 64);
        Tablet tablet2 = new Tablet(2, "Samsung", "Galaxy Tab S4", 2018, 800, "Black", "Android", 256, 32);
        Tablet tablet3 = new Tablet(3, "Microsoft", "Surface Pro", 2017, 600, "White", "Windows", 512, 16);

        tablet1.playGame();
        tablet2.playMovie();
        tablet3.playMusic();

        System.out.println();

        Television television1 = new Television(1, "Samsung", "QLED", 2019, 2000, "Black", "LED", "metal");
        Television television2 = new Television(2, "LG", "OLED", 2018, 1500, "White", "LED", "metal");
        Television television3 = new Television(3, "Sony", "XBR", 2017, 1000, "Silver", "LED", "plastic");

        television1.watchMovie();
        television2.watchGame();
        television3.watchNews();

        System.out.println();

        LoudSpeaker loudSpeaker1 = new LoudSpeaker(1, "JBL", "Flip 4", 2019, 100, "Black", "Bluetooth", "Plastic");
        LoudSpeaker loudSpeaker2 = new LoudSpeaker(2, "Bose", "SoundLink", 2018, 80, "White", "Bluetooth", "Plastic");
        LoudSpeaker loudSpeaker3 = new LoudSpeaker(3, "Sony", "SRS-XB41", 2017, 60, "Silver", "Bluetooth", "Plastic");

        loudSpeaker1.playMusic();
        loudSpeaker2.playPodcast();
        loudSpeaker3.playRadio();
    }
}