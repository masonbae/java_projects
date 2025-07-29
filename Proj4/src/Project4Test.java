// File name: Project4Test.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS 2201
// Assignment Number: 4
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description: writing recursive functions
// Last Changed: 2/29/24

// Testing the recursive programming lab

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Project4Test {

    // Here are some initial JUnit tests of the functions you are to implement.
    // You should add tests of your own to fully test the functions. The provided
    // tests do not constitute thorough/complete testing.


    @Test
    public void testSumArray() {
        int[] test = {1, 2, 3, 4, 5};
        assertEquals(15, Project4.sumArray(test, 5));
    }

    @Test
    public void testMember() {
        int[] tmp = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        assertTrue(Project4.member(55, tmp, 10));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(Project4.isPalindrome("abcdeedcba"));
    }

    @Test
    public void testHarmonicSum() {
        assertEquals(1.0, Project4.harmonicSum(1), 0.000000001);
        assertEquals((double) 55835135 / (double) 15519504, Project4.harmonicSum(20), 0.000000001);
        System.out.print("Testing harmonicSum: ");
        System.out.println("the first 4 Harmonic sums are:");
        for (int i = 1; i < 5; i++) {
            System.out.println(Project4.harmonicSum(i));
        }
    }

    @Test
    public void testAddStar() {
        assertEquals("a*b*c", Project4.addStar("abc"));
    }

    @Test
    public void testReplace() {
        int[] tmp = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        int[] result1 = {12, 13, 21, 30, 3, 55, 1000, 5, 201, 789};
        assertEquals(1, Project4.replace(2, 3, tmp, 10));
        assertArrayEquals(result1, tmp);
    }

    @Test
    public void testGCD() {
        assertEquals(6, Project4.gcd(24, 30));
    }

    @Test
    public void testHelloWorldRepeat() {
        assertEquals("Hello Hello Hello World World World", Project4.helloWorldRepeat(3));
    }

    @Test
    public void testConvert2Binary() {
        assertEquals("11001", Project4.convert2Binary(25));
        System.out.print("Testing convert2Binary: ");
        System.out.println("The first ten binary numbers are: ");
        for (int j = 0; j < 10; j++) {
            System.out.println(j + " = " + Project4.convert2Binary(j));
        }
        System.out.println();
    }

    @Test
    public void testPrintPattern() {
        System.out.println("A four star hourglass pattern: ");
        Project4.printPattern(4);
        System.out.println();
    }

    @Test
    public void testReverseArray() {
        int[] tmp2 = {789, 201, 5, 1000, 55, 2, 30, 21, 13, 12};
        int[] tmp3 = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        Project4.reverseArray(tmp2, 0, 9);
        assertArrayEquals(tmp3, tmp2);
    }

    @Test
    public void testArrayInitialize() {
        int[] testI = new int[100]; // all initialized to zero
        Project4.arrayInitialize(testI, 5, 20, 80);
        for (int k = 0; k < 20; k++)
            assertEquals(0, testI[k]);
        for (int k = 20; k <= 80; k++)
            assertEquals(5, testI[k]);
        for (int k = 81; k < 100; k++)
            assertEquals(0, testI[k]);
    }

    @Test
    public void testBinomialCoeff() {
        assertEquals(6, Project4.binomialCoeff(4, 2));
    }

    @Test
    public void testCount2() {
        assertEquals(2, Project4.count2(212));
    }

    @Test
    public void testNumDecodes() {
        assertEquals(3, Project4.numDecodes("111")); //aaa,ak,ka
        assertEquals(5, Project4.numDecodes("1221")); //abba,abu,ava,lba,lu
    }

    @Test
    public void testMoveXs() {
        assertEquals("rexx", Project4.moveXs("xxre"));
    }

    @Test
    public void testNewton() {
        // test that Newton's approximate is within 0.00001 of actual
        assertEquals(Math.sqrt(33333), Project4.newton(33333, 10), 0.00001);
    }

    @Test
    public void testCountTheWays() {
        assertEquals(2, Project4.countTheWays(2, 2));
        assertEquals(70, Project4.countTheWays(5, 5));
    }

    @Test
    public void testK_element_sum() {
        int[] tmp222 = {789, 201, -5, 1000, 55, 2, -30, -21, 13, 12};
        assertTrue(Project4.K_element_sum(1, 13, tmp222, 10));
        assertFalse(Project4.K_element_sum(3, 979, tmp222, 10));
    }

    @Test
    public void testPalindrome_able() {
        assertTrue(Project4.palindrome_able("carRACE"));
        assertFalse(Project4.palindrome_able("daily"));
    }


    @Test
    public void testNumOfTerms() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        int cnt = 0;
        for (int k = 0; k < 20; k++) {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k % 3) == 0) ? 0 : k % 10;
            if (tmpPtr.value != 0) cnt++;
            tmpPtr.next = head;
            head = tmpPtr;
        }
        assertEquals(cnt, Project4.numOfTerms(head));
    }

    @Test
    public void testNormalizeBigNum() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        for (int k = 0; k < 20; k++) {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k % 3) == 0) ? 0 : k % 10;
            tmpPtr.next = head;
            head = tmpPtr;
        }

        // add some zeros at the end
        for (tmpPtr = head; tmpPtr.next != null; tmpPtr = tmpPtr.next) {
        } // nothing to do
        for (int i = 0; i < 6; i++) {   //tmpPtr refers to the last node
            tmpPtr.next = new Project4.Node();
            tmpPtr = tmpPtr.next;
            tmpPtr.value = 0;
            tmpPtr.next = null;
        }

        assertEquals("9 0 7 6 0 4 3 0 1 0 0 8 7 0 5 4 0 2 1 0 0 0 0 0 0 0 ", list2String(head));
        head = Project4.normalizeBigNum(head);
        assertEquals("9 0 7 6 0 4 3 0 1 0 0 8 7 0 5 4 0 2 1 ", list2String(head));
    }

    @Test
    public void testEcho2() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        for (int k = 0; k < 10; k++) {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k % 3) == 0) ? 0 : k % 10;
            tmpPtr.next = head;
            head = tmpPtr;
        }
        assertEquals("0 8 7 0 5 4 0 2 1 0 0 1 2 0 4 5 0 7 8 0 ", Project4.echo2(head));
    }


    @Test
    public void testContains() {
        // create a linked list
        Project4.Node superList = null;
        Project4.Node tmpPtr;

        for (int k = 0; k < 20; k++) {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k % 4) == 0) ? 0 : k;
            tmpPtr.next = superList;
            superList = tmpPtr;
        }

        Project4.Node subList = null;
        for (int k = 7; k < 20; k = k + 2) {
            tmpPtr = new Project4.Node();
            tmpPtr.value = (((k - 1) % 4) == 0) ? 0 : k;
            tmpPtr.next = subList;
            subList = tmpPtr;
        }

        assertTrue(Project4.contains(superList, subList));
        superList = superList.next;
        assertFalse(Project4.contains(superList, subList));
        subList = subList.next;
        assertTrue(Project4.contains(superList, subList));
        subList = subList.next.next.next;
        assertTrue(Project4.contains(superList, subList));
        subList.next.value = 666;
        assertFalse(Project4.contains(superList, subList));
    }

//    @Test
//    public void testChallenge() {
//        Project4.Node head = null;
//        // give the list new data
//        for (int k = 0; k<20; k++)
//        {
//            Project4.Node tmpPtr = new Project4.Node();
//            tmpPtr.value = ((k % 2) == 0) ? -k : k;
//            tmpPtr.next = head;
//            head = tmpPtr;
//        }
//
//        assertEquals("19 -18 17 -16 15 -14 13 -12 11 -10 9 -8 7 -6 5 -4 3 -2 1 0 ", list2String(head));
//        head=Project4.reverseList(head);
//        assertEquals("0 1 -2 3 -4 5 -6 7 -8 9 -10 11 -12 13 -14 15 -16 17 -18 19 ", list2String(head));
//
//    }


    // print a space-separated list of numbers from a linked-list
    public static void printList(Project4.Node head) {

        System.out.print("contents of list: ");
        for (Project4.Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.value + " ");
        }
        System.out.println("Done");

    }


    // return a space-separated list of numbers from a linked-list
    public static String list2String(Project4.Node head) {
        String result = "";
        for (Project4.Node cur = head; cur != null; cur = cur.next) {
            result += cur.value + " ";
        }
        return result;
    }

    @Test
    public void testIsPalindrome_withNonPalindrome() {
        String testString = "Hello";
        assertFalse(Project4.isPalindrome(testString));
    }

    @Test
    public void testMoveXs_withAllXs() {
        assertEquals("xxxx", Project4.moveXs("xxxx"));
    }

    @Test
    public void testNumDecodes_withEdgeCase() {
        assertEquals(1, Project4.numDecodes("10"));
        assertEquals(0, Project4.numDecodes("0"));
    }

    @Test
    public void testBinomialCoeff_withBoundary() {
        assertEquals(1, Project4.binomialCoeff(5, 0));
        assertEquals(1, Project4.binomialCoeff(5, 5));
    }

    @Test
    public void testArrayInitialize_fullArray() {
        int[] testArray = new int[10];
        Project4.arrayInitialize(testArray, 1, 0, 9);
        for (int i : testArray) {
            assertEquals(1, i);
        }
    }

    @Test
    public void testPrintPattern_withOneStar() {
        System.out.println("A one-star hourglass pattern: ");
        Project4.printPattern(1);
        System.out.println();
    }

    @Test
    public void testConvert2Binary_withZero() {
        assertEquals("0", Project4.convert2Binary(0));
    }

    @Test
    public void testHelloWorldRepeat_withZero() {
        assertEquals("", Project4.helloWorldRepeat(0));
    }

    @Test
    public void testGCD_withZero() {
        assertEquals(5, Project4.gcd(0, 5));
    }

    @Test
    public void testReplace_withNoMatch() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(0, Project4.replace(6, 10, array, 5));
    }

    @Test
    public void testHarmonicSum_withLargerNumber() {
        assertEquals(2.9289682539682538, Project4.harmonicSum(10), 0.00001);
    }

    @Test
    public void testIsPalindrome_withMixedCase() {
        assertTrue(Project4.isPalindrome("Aa"));
    }

    @Test
    public void testIsPalindrome_withSingleCharacter() {
        assertTrue(Project4.isPalindrome("a"));
    }

    @Test
    public void testMember_withNonExistingElement() {
        int[] array = {10, 20, 30, 40, 50};
        assertFalse(Project4.member(60, array, 5));
    }

    @Test
    public void testK_element_sum_withEdgeConditions() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(Project4.K_element_sum(2, 9, array, 5)); // 4+5
        assertFalse(Project4.K_element_sum(3, 100, array, 5));
    }

    @Test
    public void testReverseArray_withOddNumberOfElements() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        Project4.reverseArray(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testArrayInitialize_withSingleElement() {
        int[] testArray = new int[1];
        Project4.arrayInitialize(testArray, 7, 0, 0);
        assertEquals(7, testArray[0]);
    }

    @Test
    public void testBinomialCoeff_withTopEqualsBottom() {
        assertEquals(1, Project4.binomialCoeff(5, 5));
    }

    @Test
    public void testCount2_withoutAnyTwos() {
        assertEquals(0, Project4.count2(345678));
    }

    @Test
    public void testNumDecodes_withSingleDigit() {
        assertEquals(1, Project4.numDecodes("8"));
    }

    @Test
    public void testMoveXs_withNoX() {
        assertEquals("hello", Project4.moveXs("hello"));
    }

    @Test
    public void testPalindrome_able_withSingleCharacter() {
        assertTrue(Project4.palindrome_able("a"));
    }

    @Test
    public void testK_element_sum_withExactMatchRequired() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(Project4.K_element_sum(2, 3, array, 5)); // 1 + 2
    }

    @Test
    public void testEcho2_withEmptyList() {
        Project4.Node head = null; // empty list
        assertEquals("", Project4.echo2(head));
    }

    @Test
    public void testContains_withExactMatch() {
        Project4.Node superList = new Project4.Node();
        superList.value = 1;
        superList.next = new Project4.Node();
        superList.next.value = 2;

        Project4.Node subList = new Project4.Node();
        subList.value = 1;
        subList.next = new Project4.Node();
        subList.next.value = 2;

        assertTrue(Project4.contains(superList, subList));
    }

    @Test
    public void testArrayInitialize_withNegativeBounds() {
        int[] array = {1, 2, 3, 4, 5};
        Project4.arrayInitialize(array, 9, 4, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testMoveXs_withXAtBeginningAndEnd() {
        assertEquals("helxxxx", Project4.moveXs("xxxhelx"));
    }

}