package com.mycompany.stack.visualizer;

import java.util.Random;

public class RandomNumbers {

    Random r = new Random();

    public int randomInt(int min, int max) {
        return Math.abs(min + this.r.nextInt() % (max - min + 1));
    }

    public float randomFloat(float min, float max) {
        return Math.abs(min + this.r.nextFloat() % (max - min + 1));
    }

    public double randomDouble(double min, double max) {
        return min + this.r.nextDouble() % (max - min + 1);
    }
}
