package com.rafal.kalkulatorodleglosci;

public class Anglo extends MiaraAnglo implements IPrzeliczniki {

    // stworzenie konstruktora
    public Anglo(double odl, double mang) {
        super(odl, mang);
    }

    // implementacja metody abstrakcyjnej
    @Override
    public double policzOdl() {
        return odl/mang;
    }
}
