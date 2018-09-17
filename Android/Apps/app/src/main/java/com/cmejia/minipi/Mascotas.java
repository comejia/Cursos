package com.cmejia.minipi;

import android.graphics.drawable.Drawable;

public class Mascotas {
    private String name;
    private String raza;

    public Mascotas() {
        super();
    }

    public Mascotas(String name, String raza) {
        this.name = name;
        this.raza = raza;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getName() {
        return name;
    }
    public String getRaza() {
        return raza;
    }
}
