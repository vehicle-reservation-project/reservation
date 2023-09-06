package com.microservice.reservation.model;

public class Vehicle {
    private Integer id;
    private String type;
    private String brand;
    private String model;
    private String color;
    private String plateNumber;
    private Integer fiscalHPower;
    private double km;
    private double priceDay;
    private Integer displacementMotorcycleCm3;
    private Integer loadCapacityM3;

    public Vehicle(Integer id, String type, String brand, String model, String color, String plateNumber, Integer fiscalHPower, double km, double priceDay, Integer displacementMotorcycleCm3, Integer loadCapacityM3) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plateNumber = plateNumber;
        this.fiscalHPower = fiscalHPower;
        this.km = km;
        this.priceDay = priceDay;
        this.displacementMotorcycleCm3 = displacementMotorcycleCm3;
        this.loadCapacityM3 = loadCapacityM3;
    }

    public Vehicle() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getFiscalHPower() {
        return fiscalHPower;
    }

    public void setFiscalHPower(Integer fiscalHPower) {
        this.fiscalHPower = fiscalHPower;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getPriceDay() {
        return priceDay;
    }

    public void setPreiseDay(double priceDay) {
        this.priceDay = priceDay;
    }

    public Integer getDisplacementMotorcycleCm3() {
        return displacementMotorcycleCm3;
    }

    public void setDisplacementMotorcycleCm3(Integer displacementMotorcycleCm3) {
        this.displacementMotorcycleCm3 = displacementMotorcycleCm3;
    }

    public Integer getLoadCapacityM3() {
        return loadCapacityM3;
    }

    public void setLoadCapacityM3(Integer loadCapacityM3) {
        this.loadCapacityM3 = loadCapacityM3;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", fiscalHPower=" + fiscalHPower +
                ", km=" + km +
                ", priceDay=" + priceDay +
                ", displacementMotorcycleCm3=" + displacementMotorcycleCm3 +
                ", loadCapacityM3=" + loadCapacityM3 +
                '}';
    }
}
