package com.example.quecocinohoy;

public class ListElement {
    public String color;
    public String name;
    public String city;
    public String tipo;


    public ListElement(String color, String name, String city, String tipo) {
        this.color = color;
        this.name = name;
        this.city = city;
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


