package org.example;

public class Planets {
    private String name;         // Название планеты
    private double mass;         // Масса планеты (в килограммах)
    private double radius;       // Радиус планеты (в метрах)
    private double distance;     // Расстояние от планеты до Солнца (в метрах)
    private double orbitalPeriod;// Период обращения планеты вокруг Солнца (в днях)
    private double rotationPeriod; // Период вращения планеты вокруг своей оси (в часах)

    public Planets(String name, double mass, double radius, double distance, double orbitalPeriod, double rotationPeriod) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.distance = distance;
        this.orbitalPeriod = orbitalPeriod;
        this.rotationPeriod = rotationPeriod;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getDistance() {
        return distance;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public void setRotationPeriod(double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public double calculateSurfaceGravity() {
        final double G = 6.67430E-11; // гравитационная постоянная
        return (G * mass) / (radius * radius);
    }

    public double calculateOrbitalSpeed() {
        final double G = 6.67430E-11; // гравитационная постоянная
        return Math.sqrt((G * getMass()) / getDistance());
    }

    public double calculateDayLength() {
        double circumference = 2 * Math.PI * getRadius(); // длина экватора
        double velocity = circumference / (getRotationPeriod() * 3600); // скорость вращения (в м/с)
        return (2 * Math.PI * getRadius()) / velocity; // продолжительность суток (в секундах)
    }

    public double calculateYearLength() {
        return getOrbitalPeriod() * 365; // продолжительность года (в днях)
    }

}
