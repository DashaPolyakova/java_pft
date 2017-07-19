package ru.stqa.pft.sandbox;

/**
 * Created by fbi on 19.07.2017.
 */
public class Rectangle {

    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = 4;
        this.b = 5;
    }


    public double area(){
        return this.a * this.b;
    }
}
