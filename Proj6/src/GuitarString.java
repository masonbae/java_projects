// File name: GuitarString.java
// Author: Mason Bae
// userid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Assignment Number: 6
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description: class that simulates a guitar string of a given frequency
// Last Changed: 3/24/24
//

import java.util.Random;

public class GuitarString {

    // Do not change or delete these two public constants
    public static final int SAMPLE_RATE = 44100;
    public static final double DECAY_FACTOR = 0.996;

    private DblQueue buffer;
    private int time;
    private final double frequency;
    private static final Random random = new Random();

    public GuitarString(double frequency) {
        if (frequency <= 0) {
            throw new IllegalArgumentException("Frequency must be positive");
        }
        this.frequency = frequency;
        int capacity = (int) Math.round(SAMPLE_RATE / frequency);
        this.buffer = new DblQueue();
        for (int i = 0; i < capacity; i++) {
            this.buffer.enqueue(0.0);
        }
        this.time = 0;
    }

    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            buffer.dequeue();
            buffer.enqueue(random.nextDouble() - 0.5);
        }
    }

    public void tic() {
        double first = buffer.front();
        buffer.dequeue();
        double second = buffer.front();
        double newSample = DECAY_FACTOR * 0.5 * (first + second);
        buffer.enqueue(newSample);
        time++;
    }

    public double sample() {
        return buffer.front();
    }

    public int getTime() {
        return time;
    }

    public double getFrequency() {
        return frequency;
    }

    public GuitarString clone() {
        GuitarString clonedString = new GuitarString(this.frequency);
        clonedString.buffer = this.buffer.clone();
        clonedString.time = this.time;
        return clonedString;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        GuitarString that = (GuitarString) other;
        return this.frequency == that.frequency && this.time == that.time;
    }

}
