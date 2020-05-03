package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0478_Generate_Random_Point_in_a_Circle {
    private double radius,  x_center, y_center;

    public Question_0478_Generate_Random_Point_in_a_Circle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        return new double[]{len * Math.cos(deg) + x_center, len * Math.sin(deg) + y_center};
    }
}
