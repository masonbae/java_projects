// File name: DblStackTest.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 3/15/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 5
// Description: tests for DblStack

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DblStackTest {

    @Test
    public void testDefaultConstructor() {
        DblStack stk = new DblStack();
        assertEquals(0, stk.size());
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        DblStack stk = new DblStack();
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testPush() {
        DblStack stk = new DblStack();
        stk.push(1.0);
        assertEquals(1, stk.size());
        assertFalse(stk.isEmpty());
    }

    @Test
    public void testPop() {
        DblStack stk = new DblStack();
        stk.push(1.0);
        stk.push(2.0);
        stk.pop();
        assertEquals(1, stk.size());
        stk.pop();
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testTop() {
        DblStack stk = new DblStack();
        stk.push(1.0);
        stk.push(2.0);
        assertEquals(2.0, stk.top(), 0.001);
        assertEquals(2, stk.size());
    }

    @Test
    public void testPopEmptyStack() {
        DblStack stk = new DblStack();
        assertThrows(RuntimeException.class, () -> stk.pop());
    }

    @Test
    public void testTopEmptyStack() {
        DblStack stk = new DblStack();
        assertThrows(RuntimeException.class, () -> stk.top());
    }

    @Test
    public void testClone() {
        DblStack stk = new DblStack();
        stk.push(1.0);
        stk.push(2.0);
        DblStack clonedStk = stk.clone();

        assertEquals(stk.size(), clonedStk.size());
        assertEquals(stk.top(), clonedStk.top(), 0.001);
        assertNotSame(stk, clonedStk);

        clonedStk.pop();
        assertNotEquals(stk.size(), clonedStk.size());
    }

    @Test
    public void testEquals() {
        DblStack stk1 = new DblStack();
        DblStack stk2 = new DblStack();
        stk1.push(1.0);
        stk2.push(1.0);

        assertEquals(stk1, stk2);

        stk2.push(2.0);
        assertNotEquals(stk1, stk2);
    }
}
