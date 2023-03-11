import java.io.*;

abstract class Shape implements Serializable {
    String name;
    static String color = "Red";

    Shape(String name){
        this.name = name;
    }

    abstract double calculateArea();

    abstract double calculatePerimeter();

}

class Triangle extends Shape implements Serializable{
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

class Rectangle extends Shape implements Serializable{
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

class Circle extends Shape implements Serializable{
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

class Square extends Shape implements Serializable{
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
        Shape triangle1 = new Triangle("T1",3,4,5);
        Shape rectangle1 = new Rectangle("R1", 3,5);
        Shape circle1 = new Circle("C1", 5);
        Shape square1 = new Square("S1", 5);

//      Serialize
        try {
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle1);
            out.writeObject(rectangle1);
            out.writeObject(circle1);
            out.writeObject(square1);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }

//      Deserialize
        Shape triangle2 = null;
        Shape rectangle2 = null;
        Shape circle2 = null;
        Shape square2 = null;

        try {
            FileInputStream fileIn = new FileInputStream("shapes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            triangle2 = (Shape) in.readObject();
            rectangle2 = (Shape) in.readObject();
            circle2 = (Shape) in.readObject();
            square2 = (Shape) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Shape class not found");
            c.printStackTrace();
        }

        System.out.println("Deserialized Triangle...");
        System.out.println("Name: " + triangle2.name + " Side1: " + ((Triangle) triangle2).side1 + " Side2: " + ((Triangle) triangle2).side2 + " Side3: " + ((Triangle) triangle2).side3);
        System.out.println(" Area: " + triangle2.calculateArea() + " Perimeter: " + triangle2.calculatePerimeter());

        System.out.println("Deserialized Rectangle...");
        System.out.println("Name: " + rectangle2.name + " Side1: " + ((Rectangle) rectangle2).side1 + " Side2: " + ((Rectangle) rectangle2).side2);
        System.out.println("Area: " + rectangle2.calculateArea() + " Perimeter: " + rectangle2.calculatePerimeter());

        System.out.println("Deserialized Circle...");
        System.out.println("Name: " + circle2.name + " Radius: " + ((Circle) circle2).radius);
        System.out.println("Area: " + circle2.calculateArea() + " Perimeter: " + circle2.calculatePerimeter());

        System.out.println("Deserialized Square...");
        System.out.println("Name: " + square2.name + " Side: " + ((Square) square2).side);
        System.out.println("Area: " + square2.calculateArea() + " Perimeter: " + square2.calculatePerimeter());

    }
}