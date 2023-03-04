
abstract class Shape{
    String name;
    static String color = "Red";

    Shape(String name){
        this.name = name;
    }

    abstract double calculateArea();

    abstract double calculatePerimeter();

}

class Triangle extends Shape{
    double side1;
    double side2;
    double side3;

    Triangle(String name, double side1, double side2, double side3){
        super(name);
        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }else{
            throw new IllegalArgumentException("Invalid triangle sides");
        }
    }

    double calculateArea(){
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    double calculatePerimeter(){
        return side1 + side2 + side3;
    }

}

class Rectangle extends Shape{
    double side1;
    double side2;

    Rectangle(String name, double side1, double side2) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
    }

    double calculateArea(){
        return side1 * side2;
    }

    double calculatePerimeter(){
        return (side1 + side2) * 2;
    }

}

class Circle extends Shape{
    double radius;

    Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    double calculateArea(){
        return Math.PI * radius * radius;
    }

    double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }

}

class Square extends Shape{
    double side;

    Square(String name, double side){
        super(name);
        this.side = side;
    }

    double calculateArea(){
        return side * side;
    }

    double calculatePerimeter(){
        return side * 4;
    }

}

public class Main {
    public static void main(String[] args) {
        Shape Triangle1 = new Triangle("T1",3,4,5);
        System.out.println("Triangle1.name = " + Triangle1.name);
        System.out.println("Triangle1.calculateArea() = " + Triangle1.calculateArea());
        System.out.println("Triangle1.calculatePerimeter() = " + Triangle1.calculatePerimeter());

        Shape Rectangle1 = new Rectangle("R1", 3,5);
        System.out.println("Rectangle1.name = " + Rectangle1.name);
        System.out.println("Rectangle1.calculateArea() = " + Rectangle1.calculateArea());
        System.out.println("Rectangle1.calculatePerimeter() = " + Rectangle1.calculatePerimeter());

        Shape Circle1 = new Circle("C1", 5);
        System.out.println("Circle1.name = " + Circle1.name);
        System.out.println("Circle1.calculateArea() = " + Circle1.calculateArea());
        System.out.println("Circle1.calculatePerimeter() = " + Circle1.calculatePerimeter());

        Shape Square1 = new Square("S1", 5);
        System.out.println("Square1.name = " + Square1.name);
        System.out.println("Square1.calculateArea() = " + Square1.calculateArea());
        System.out.println("Square1.calculatePerimeter() = " + Square1.calculatePerimeter());

        System.out.println("Shape.color = " + Shape.color);
    }
}