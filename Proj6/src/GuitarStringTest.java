// File name: GuitarStringTest.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Assignment Number: 6
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description: JUnit test for GuitarString class
// Last Changed: 3/24/24

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuitarStringTest {

    @Test
    public void testConstructor() {
        double testFreq = 1000;
        GuitarString myString = new GuitarString(testFreq);
        assertEquals(testFreq, myString.getFrequency(), 0.00001);
    }

    @Test
    public void testInitialSampleIsZero() {
        GuitarString string = new GuitarString(440.0);
        assertEquals(0.0, string.sample());
    }

    @Test
    public void testPluckFillsBufferWithRandomValuesInRange() {
        GuitarString string = new GuitarString(440.0);
        string.pluck();
        for (int i = 0; i < 100; i++) {
            double sample = string.sample();
            assertTrue(sample >= -0.5 && sample <= 0.5);
            string.tic();
        }
    }

    @Test
    public void testTicReducesAmplitude() {
        GuitarString string = new GuitarString(440.0);
        string.pluck();
        double initialAmplitude = Math.abs(string.sample());
        for (int i = 0; i < 1000; i++) {
            string.tic();
        }
        double laterAmplitude = Math.abs(string.sample());
        assertTrue(laterAmplitude < initialAmplitude);
    }

    @Test
    public void testTicAdvancesTime() {
        GuitarString string = new GuitarString(440.0);
        int initialTime = string.getTime();
        string.tic();
        assertEquals(initialTime + 1, string.getTime());
    }

    @Test
    public void testGetFrequency() {
        GuitarString string = new GuitarString(440.0);
        assertEquals(440.0, string.getFrequency());
    }

    @Test
    public void testPluckProducesDifferentSamples() {
        GuitarString string1 = new GuitarString(440.0);
        GuitarString string2 = new GuitarString(440.0);
        string1.pluck();
        double sample1 = string1.sample();
        string2.pluck();
        double sample2 = string2.sample();
        string1.tic();
        string2.tic();
        assertNotEquals(sample1, sample2);
    }

    @Test
    public void testFrequencyValidation() {
        assertThrows(IllegalArgumentException.class, () -> new GuitarString(-1.0));
    }

    @Test
    void testTimeIncreasesCorrectly() {
        GuitarString string = new GuitarString(440.0);
        int tics = 100;
        for (int i = 0; i < tics; i++) {
            string.tic();
        }
        assertEquals(tics, string.getTime());
    }

    @Test
    public void testClone() {
        GuitarString original = new GuitarString(440.0);
        GuitarString clone = original.clone();
        assertEquals(original.getFrequency(), clone.getFrequency());
        assertEquals(original.getTime(), clone.getTime());
    }

    @Test
    public void testEquals() {
        GuitarString string1 = new GuitarString(440.0);
        GuitarString string2 = new GuitarString(440.0);
        assertEquals(string1, string2);
    }

    @Test
    public void testNotEqualsDifferentFrequency() {
        GuitarString string1 = new GuitarString(440.0);
        GuitarString string2 = new GuitarString(220.0);
        assertNotEquals(string1, string2);
    }

    @Test
    public void testNotEqualsAfterTic() {
        GuitarString string1 = new GuitarString(440.0);
        GuitarString string2 = new GuitarString(440.0);
        string1.tic();
        assertNotEquals(string1, string2);
    }

    @Test
    public void testMultiplePlucksMaintainRange() {
        GuitarString string = new GuitarString(440.0);
        for (int i = 0; i < 10; i++) {
            string.pluck();
            assertTrue(string.sample() >= -0.5 && string.sample() <= 0.5);
        }
    }

    @Test
    public void testTicDoesNotAdvancePastBufferCapacity() {
        GuitarString string = new GuitarString(440.0);
        string.pluck();
        int expectedTics = (int) Math.round(GuitarString.SAMPLE_RATE / 440.0);
        for (int i = 0; i < expectedTics; i++) {
            string.tic();
        }
        assertEquals(expectedTics, string.getTime());
    }

    @Test
    public void testPluckResetsBuffer() {
        GuitarString string = new GuitarString(440.0);
        string.pluck();
        double initialSample = string.sample();
        for (int i = 0; i < 100; i++) {
            string.tic();
        }
        string.pluck();
        double newSample = string.sample();
        assertNotEquals(initialSample, newSample);
        assertTrue(newSample >= -0.5 && newSample <= 0.5);
    }

    @Test
    public void testEqualFrequencyStringsAreEqual() {
        GuitarString string1 = new GuitarString(440.0);
        GuitarString string2 = new GuitarString(440.0);
        assertEquals(string1, string2);
    }

    @Test
    public void testStringsWithDifferentFrequenciesAreNotEqual() {
        GuitarString string1 = new GuitarString(440.0);
        GuitarString string2 = new GuitarString(220.0);
        assertNotEquals(string1, string2);
    }

    @Test
    public void testCloneIsIndependent() {
        GuitarString original = new GuitarString(440.0);
        GuitarString clone = original.clone();
        original.pluck();
        original.tic();
        assertNotEquals(original.sample(), clone.sample(), 0.0);
    }
}
