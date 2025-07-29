// File name: DblQueueTest.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Assignment Number: 6
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description: JUnit tests for DblQueue class
// Last Changed: 3/24/24

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DblQueueTest {

    @Test
    public void testDefaultConstructor() {
        DblQueue myQ = new DblQueue();
        assertEquals(0, myQ.size());
    }

    @Test
    public void newQueueIsEmpty() {
        DblQueue queue = new DblQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueueIncreasesSize() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void dequeueDecreasesSize() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void frontReturnsFirstElement() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        assertEquals(1.0, queue.front());
    }

    @Test
    public void dequeueRemovesFirstElement() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.dequeue();
        assertEquals(2.0, queue.front());
    }

    @Test
    public void enqueueAndDequeueMaintainOrder() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        assertEquals(1.0, queue.front());
        queue.dequeue();
        assertEquals(2.0, queue.front());
    }

    @Test
    public void dequeueOnEmptyQueueThrowsException() {
        DblQueue queue = new DblQueue();
        assertThrows(RuntimeException.class, queue::dequeue);
    }

    @Test
    public void frontOnEmptyQueueThrowsException() {
        DblQueue queue = new DblQueue();
        assertThrows(RuntimeException.class, queue::front);
    }

    @Test
    public void cloneCreatesEqualQueue() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        DblQueue clonedQueue = queue.clone();
        assertEquals(queue, clonedQueue);
    }

    @Test
    public void equalsIdentifiesEqualQueues() {
        DblQueue queue1 = new DblQueue();
        queue1.enqueue(1.0);
        DblQueue queue2 = new DblQueue();
        queue2.enqueue(1.0);
        assertEquals(queue1, queue2);
    }

    @Test
    public void equalsIdentifiesUnequalQueues() {
        DblQueue queue1 = new DblQueue();
        queue1.enqueue(1.0);
        DblQueue queue2 = new DblQueue();
        queue2.enqueue(2.0);
        assertNotEquals(queue1, queue2);
    }

    @Test
    public void testMultipleEnqueueAndDequeueOperations() {
        DblQueue queue = new DblQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        assertEquals(5, queue.size());
        assertEquals(5.0, queue.front());
    }

    @Test
    public void testClearingQueue() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertThrows(RuntimeException.class, () -> queue.dequeue());
    }

    @Test
    public void testSizeAfterMultipleOperations() {
        DblQueue queue = new DblQueue();
        assertTrue(queue.isEmpty());
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.enqueue(3.0);
        queue.dequeue();
        queue.enqueue(4.0);
        assertEquals(3, queue.size());
    }

    @Test
    public void testCloneIsDeepCopy() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        DblQueue clonedQueue = queue.clone();
        clonedQueue.dequeue();
        assertTrue(clonedQueue.isEmpty());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testEqualsAfterModifications() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        for (int i = 0; i < 5; i++) {
            queue1.enqueue(i);
            queue2.enqueue(i);
        }
        assertEquals(queue1, queue2);
        queue1.dequeue();
        assertNotEquals(queue1, queue2);
    }

    @Test
    public void testQueueConsistencyAfterRandomOperations() {
        DblQueue queue = new DblQueue();
        Random random = new Random();
        int enqueueCount = 0;
        int dequeueCount = 0;

        for (int i = 0; i < 1000; i++) {
            if (random.nextBoolean() && enqueueCount - dequeueCount < 50) {
                queue.enqueue(random.nextDouble());
                enqueueCount++;
            } else if (!queue.isEmpty()) {
                queue.dequeue();
                dequeueCount++;
            }
        }
        assertEquals(enqueueCount - dequeueCount, queue.size());
    }

    @Test
    public void testEnqueueDequeueLargeNumberOfElements() {
        DblQueue queue = new DblQueue();
        int numElements = 10000;
        for (int i = 0; i < numElements; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < numElements; i++) {
            assertEquals(i, queue.front());
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueDequeueNegativeValues() {
        DblQueue queue = new DblQueue();
        queue.enqueue(-1.0);
        queue.enqueue(-2.0);
        assertFalse(queue.isEmpty());
        assertEquals(-1.0, queue.front());
        queue.dequeue();
        assertEquals(-2.0, queue.front());
    }

    @Test
    public void testFrontDoesNotRemoveElement() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        double front = queue.front();
        assertEquals(1.0, front);
        assertEquals(1, queue.size());
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testEqualsWithDifferentQueues() {
        DblQueue queue1 = new DblQueue();
        queue1.enqueue(1.0);
        DblQueue queue2 = new DblQueue();
        queue2.enqueue(1.0);
        queue2.enqueue(2.0);
        assertNotEquals(queue1, queue2);
    }

    @Test
    public void testCloneReflectsSubsequentChanges() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        DblQueue clone = queue.clone();
        queue.enqueue(2.0);
        assertNotEquals(clone, queue);
    }

    @Test
    public void testSizeConsistency() {
        DblQueue queue = new DblQueue();
        assertEquals(0, queue.size());
        queue.enqueue(1.0);
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testEqualsWithSelf() {
        DblQueue queue = new DblQueue();
        assertEquals(queue, queue);
    }

    @Test
    public void testEqualsWithNull() {
        DblQueue queue = new DblQueue();
        assertNotEquals(null, queue);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        DblQueue queue = new DblQueue();
        assertNotEquals(queue, new Object());
    }

    @Test
    public void testEqualsWithEmptyQueues() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        assertEquals(queue1, queue2);
    }

    @Test
    public void testEqualsWithSameContents() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        queue1.enqueue(1.0);
        queue2.enqueue(1.0);
        assertEquals(queue1, queue2);
    }

    @Test
    public void testNotEqualsWithDifferentContents() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        queue1.enqueue(1.0);
        queue2.enqueue(2.0);
        assertNotEquals(queue1, queue2);
    }

    @Test
    public void testNotEqualsWithDifferentSizes() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        queue1.enqueue(1.0);
        assertNotEquals(queue1, queue2);
    }

    @Test
    public void testEqualsWithLargeIdenticalQueues() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        for (int i = 0; i < 1000; i++) {
            queue1.enqueue(i);
            queue2.enqueue(i);
        }
        assertEquals(queue1, queue2);
    }

    @Test
    public void testNotEqualsWithOneDifferentElementInLargeQueues() {
        DblQueue queue1 = new DblQueue();
        DblQueue queue2 = new DblQueue();
        for (int i = 0; i < 1000; i++) {
            queue1.enqueue(i);
            queue2.enqueue(i);
        }
        queue2.dequeue();
        queue2.enqueue(1001);
        assertNotEquals(queue1, queue2);
    }

}
