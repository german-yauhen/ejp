package com.herman.enumsandannotations.enums.planet;

public class PlanetRunner {
    public static void main(String[] args) {
        double earthWeight = 80.0;
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet planet: Planet.values()) {
            System.out.printf("Weight on %s is %f%n", planet.toString(), planet.surfaceWeight(mass));
        }
    }
}
