// File name: Project4.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS 2201
// Assignment Number: 4
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description: writing recursive functions
// Last Changed: 2/29/24

// Recursive programming lab

// NOTE: your implementation of these functions must be recursive.
// NO LOOPS ARE ALLOWED, except where permitted by the header comments.
// Please read the project spec for other restrictions.

// NOTE: the functions in this file are not listed in any particular order.
// In particular, they are not listed easiest to hardest. You are not
// required to implement them in the order given, so jump around and do
// the easy ones, or the ones that make sense to you, first.

// NOTE: if for some reason you fail to complete a function listed here,
// please just leave the declaration with the provided dummy code. That will
// ensure our grading script will at least compile with your submission.

// NOTE: you should remove the TODO comment once you have implemented a function.
// Failure to do so will result in a style penalty.

public class Project4 {

    //Task: compute the sum of the first size elements of an array of integers
    //Pre: anArray is an array of integers, 0<=size<=anArray.length
    //Post: the sum of anArray[0]...anArray[size-1] is returned
    //Additional requirement: do not make new arrays
    public static int sumArray(int[] anArray, int size) {
        if (size == 0){
            return 0;
        }

        return sumArray(anArray, size -1) + anArray[size-1];
    }


    //Task: determine if target is in the set
    //Pre: set is an array of 'size' integers, size is non-negative
    //Post: true is returned if target is in the set, else false;
    //  the set is unchanged
    //Additional requirement: do not make new arrays
    public static boolean member(int target, int[] set, int size) {
        if (size == 0) {
            return false;
        }
        if (set[size - 1] == target) {
            return true;
        }

        return member(target, set, size - 1);
    }


    //Task: determine if a string is a palindrome
    //Pre: str is a string object
    //Post: returns true if str is a palindrome, otherwise returns false
    //      The test is case-insensitive [look up Character.toUpperCase() and
    //      Character.toLowerCase()]. You do not need to worry about
    //      trimming blanks from the ends of the string.
    //Note: the empty string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1)
            return true;

        char first = Character.toUpperCase(str.charAt(0));
        char last = Character.toUpperCase(str.charAt(str.length() - 1));

        if (first == last)
            return isPalindrome(str.substring(1, str.length() - 1));
        else
            return false;
    }



    //Task: compute the sum of the first n harmonic terms
    //Pre: n is a positive integer
    //Post: the sum of the first n harmonic terms is returned.
    // The harmonic series is 1 + (1/2) + (1/3) + (1/4) + ...
    public static double harmonicSum(int n) {
        if(n == 1){
            return 1;
        }

        return harmonicSum(n-1) + (double)1/n;
    }



    // Task: Given a string, compute recursively a new string where all the adjacent
    //   chars are now separated by a "*".
    // Pre: str is a string (it may be empty).
    // Post: a correctly starred string is returned.
    // Examples:
    //   addStar("hello") --> "h*e*l*l*o"
    //   addStar("abc") --> "a*b*c"
    //   addStar("ab") --> "a*b"
    public static String addStar(String str) {
        if(str.length() <= 1){
            return str;
        }

        return str.charAt(0) + "*" + addStar(str.substring(1));
    }



    //Task: replace all occurrences of 'target' in the array 'numbers'
    //      with 'replacement'
    //Pre: 'numbers' is an array of 'size' integers, size is non-negative
    //Post: all occurrences of 'target' in 'numbers' have been replaced
    //      with 'replacement'; the number of replacements performed is
    //      returned to the caller.
    public static int replace(int target, int replacement, int[] numbers, int size) {
        if (size == 0) {
            return 0;
        }
        int replacements = replace(target, replacement, numbers, size - 1);
        if (numbers[size - 1] == target) {
            numbers[size - 1] = replacement;
            return replacements + 1;
        }
        return replacements;
    }



    // Task: compute the Greatest Common Divisor (GCD) of two non-negative
    //       integers using Euclid's formula:
    //
    // Euclid's method for computing the greatest common divisor (GCD) of two
    // non-negative integers a and b is as follows. Divide a and b to obtain the
    // integer quotient q and remainder r, so that a = bq+r (if b = 0,
    // then GCD(a, b) = a). Then GCD(a, b) = GCD(b, r). Replace a with b and
    // b with r and repeat the procedure. Because the remainders are decreasing,
    // eventually a remainder of 0 will result. The last nonzero remainder is
    // the greatest common divisor of a and b.
    //
    // Pre: the parameters x & y are non-negative
    // Post: the GCD of x & y is returned
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }



    // Task: produce a string of num "Hello World"'s, where all the "Hello"'s precede
    //   all the "World"'s. For example:
    //   When num is 1, return "Hello World"
    //   When num is 3, return "Hello Hello Hello World World World"
    //   Note: there is only a single space between any two words, and there is
    //   no space at the beginning or end of the string
    // Pre: num is a non-negative integer
    // Post: the desired string is returned
    public static String helloWorldRepeat(int num) {
        if (num == 0) {
            return "";
        }

        if(num == 1){
            return "Hello World";
        }

        return "Hello " + helloWorldRepeat(num-1) + " World";
    }


    // Task: produce the binary representation of a decimal number
    //   A decimal number is converted to binary by repeated
    //   division by 2. For each division, keep track of the quotient
    //   and remainder. The remainder becomes the low-order bit (rightmost
    //   bit) of the binary representation. The higher-order bits are
    //   determined by repeating the processes with the quotient.
    //   The process stops when num is either zero or one.
    // Pre: num is a non-negative integer
    // Post: the binary representation of num is produced and returned
    //   as a string.
    // To convert an integer to a string you can use Integer.toString().
    public static String convert2Binary(int num) {
        if (num == 0 || num == 1) {
            return Integer.toString(num);
        }

        return convert2Binary(num / 2) + Integer.toString(num % 2);
    }


    // Task: Print a pseudo hourglass pattern on the screen
    // Pre: num is a positive integer
    // Post: the desired pattern is displayed on the console (System.out)
    // You may use iteration to print a line of *'s, but
    // must use recursion to complete the pattern.
    // Example: a call to printPattern(4) should produce the 7 line
    // pattern below (excluding the beginning and ending comment):
    // Each & every line you print should end with a newline character.
    /*
     ****
     ***
     **
     *
     **
     ***
     ****
     */
    public static void printPattern(int num) {
        if (num <= 0) {
            return;
        }
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
        printPattern(num - 1);
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();

    }


    // Task: reverse the contents of a[first]...a[last]
    // Pre: 'a' is an array of at least 'last'+1 integers, first & last are non-negative
    // Post: the elements a[first]...a[last] have been reversed.
    public static void reverseArray(int[] a, int first, int last) {
        if (first < last) {
            int temp = a[first];
            a[first] = a[last];
            a[last] = temp;

            reverseArray(a, first + 1, last - 1);
        }
    }


    // Task: initialize all elements of the array between indices lb and ub to the
    //   given value, including the elements at lb & ub
    // Note: lb = lower bound, ub = upper bound
    // Pre: lb and ub are valid indices into the array a
    // Post: the array elements in the segment a[lb...ub] have been initialized to value
    // Additional requirement: This function must be done by dividing the array segment
    //   in half and performing recursive calls on each half (as opposed to just shrinking
    //   the array bound by one each time)
    public static void arrayInitialize(int[] a, int value, int lb, int ub) {
        if (lb > ub) {
            return;
        }
        if (lb == ub) {
            a[lb] = value;
        } else {
            int mid = lb + (ub - lb) / 2;

            arrayInitialize(a, value, lb, mid);

            arrayInitialize(a, value, mid + 1, ub);
        }
    }



    // Task: Compute the Binomial Coefficient using Pascal's Triangle.
    // The Binomial Coefficient B(n, r) is the coefficient of the term x^r in the binomial
    // expansion of (1 + x)^n. For example, B(4,2) = 6 because (1+x)^4 = 1 + 4x + 6x^2 + 4x^3 + x^4
    // The Binomial Coefficient can be computed using the Pascal Triangle formula:
    //	B(n, r) = 1                          if r = 0 or r = n
    //	B(n, r) = B(n-1, r-1) + B(n-1, r)    otherwise
    // Pre: r & n are non-negative, and r<=n
    public static int binomialCoeff(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        return binomialCoeff(n - 1, r - 1) + binomialCoeff(n - 1, r);
    }



    // Task: Given a non-negative int n, compute recursively (no loops) the count of the
    //   occurrences of 2 as a digit, except that a 2 with another 2 immediately to its
    //   left counts double, so 2212 yields 4. Note that mod (%) by 10 yields the rightmost
    //   digit (126%10 is 6), while divide (/) by 10 removes the rightmost digit (126/10 is 12).
    // Pre: n is non-negative
    // Post: count of the occurrences of 2 is returned (with doubling as appropriate)
    // Examples:
    //   count2(2) --> 1
    //   count2(212) --> 2
    //   count2(2212) --> 4
    public static int count2(int n) {
        if (n == 0) {
            return 0;
        }

        int lastDigit = n % 10;

        int nextDigit = (n / 10) % 10;

        int rest = count2(n / 10);

        if (lastDigit == 2) {
            if (nextDigit == 2) {
                return 2 + rest;
            } else {
                return 1 + rest;
            }
        }

        return rest;
    }


    // Task: Given the mapping a = "1", b = "2", ... z = "26", and an encoded message, count the
    //   number of ways it can be decoded.
    // Pre: msg is string with a decodable message (it may be empty)
    // Post: number of ways the message can be decoded is returned
    // Example: the message "111" would give 3, since it could be decoded as "aaa", "ka", and "ak".
    // You can assume that the messages are decodable. For example, "001" is not allowed.
    // You may use iteration to enumerate all 26 possibilities for the next letter, but must use
    // recursion to solve the problem. The function Integer.toString(int) will return a string
    // representation of the int parameter.
    public static int numDecodes(String msg) {
        if (msg.isEmpty()) {
            return 1;
        }

        int count = 0;
        if (msg.charAt(0) != '0') {
            count += numDecodes(msg.substring(1));
        }

        if (msg.length() >= 2 && (msg.charAt(0) == '1' || (msg.charAt(0) == '2' && msg.charAt(1) <= '6'))) {
            count += numDecodes(msg.substring(2));
        }

        return count;
    }



    // Task: Given a string, compute recursively a new string where all the lowercase 'x' chars
    //   have been moved to the end of the string.
    // Pre: str is a string (possibly empty)
    // Post: return a new string where all lowercase 'x' chars have been moved to the end
    // Examples:
    //   moveXs("xxre") --> "rexx"
    //   moveXs("xxhixx") --> "hixxxx"
    //   moveXs("xhixhix") --> "hihixxx"
    public static String moveXs(String str) {
        if (str.length() <= 1) {
            return str;
        }

        char firstChar = str.charAt(0);

        if (firstChar == 'x') {
            return moveXs(str.substring(1)) + 'x';
        }

        else {
            return firstChar + moveXs(str.substring(1));
        }
    }



    // Newton's method for approximating square roots.
    // The next iteration is the average of the previous iteration and the
    // ratio of the number in question to the previous iteration.
    // In other words:
    //     x_i = ( x_(i-1) + number/x_(i-1) ) / 2
    // if i is 0 the approximation is simply half the number.
    // Pre: number & iterations are non-negative integers
    // Post: return an approximation of sqrt(number)
    // Note: number & iterations are integers, but the return value is double
    public static double newton(int number, int iterations) {
        if (iterations == 0) {
            return number / 2.0;
        }
        else {
            double previous = newton(number, iterations - 1);
            return (previous + number / previous) / 2.0;
        }
    }



    // Task: Determine the number of ways to get from the top-left corner of an NxM grid
    //   to the bottom-right corner of the grid. You can only move right or down from each
    //   grid position.
    // Pre: n>0 and m>0
    // Post: The number of paths is returned
    // Example: Given a 2 by 2 matrix, you should return 2, since there are two ways to get
    //   to the bottom-right: (1) right, then down; or (2) down, then right.
    //   Thus countTheWays(2,2) should return 2. Similarly, countTheWays(5,5) should return 70.
    public static int countTheWays (int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }

        return countTheWays(n - 1, m) + countTheWays(n, m - 1);
    }


    // Given an int array of size elements, determine if there are k elements that add up to sum.
    // The array holds integers, both positive and negative and zero.
    // It is not possible to add zero elements (that's when k==0) to any sum, not even zero.
    // It is not possible to add any elements from an empty array.
    public static boolean K_element_sum(int k, int sum, int[] arr, int size) {
        if (k == 0) {
            return sum == 0;
        }

        if (size == 0 || k < 0) {
            return false;
        }

        if(arr[size-1] == sum){
            if(k == 1){
                return true;
            }
        }

        if(K_element_sum(k - 1, sum - arr[size - 1], arr, size - 1)){
            return true;
        }
        else {
            return K_element_sum(k, sum, arr, size - 1);
        }
    }


    // This was an interview problem that was asked by Amazon.
    //
    // Given a string, determine whether any permutation of it is a palindrome.
    // For example, "carrace" should return true, since it can be rearranged to form racecar,
    // which is a palindrome. But "daily" should return false, since there's no rearrangement
    // that can form a palindrome.
    // The test is case-insensitive [look up Character.toUpperCase() and Character.toLowerCase()].
    //
    // You may write a single loop that examines each character of the string once, but the overall
    // solution must be recursive.
    // This function should not call the isPalindrome() function of this assignment.
    public static boolean palindrome_able(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (Character.toLowerCase(str.charAt(0)) == Character.toLowerCase(str.charAt(1))) {
            return palindrome_able(str.substring(2, str.length() - 1));
        }

        else {
            for (int i = 2; i < str.length(); i++) {
                char c = Character.toLowerCase(str.charAt(i));

                if(c == Character.toLowerCase(str.charAt(0))){
                    String s = str.substring(1,i) + str.substring(i+1);
                    return palindrome_able(s);
                }
                else if (c == Character.toLowerCase(str.charAt(1))) {
                    String s = Character.toLowerCase(str.charAt(0)) + str.substring(2,i) + str.substring(i+1);
                    return palindrome_able(s);
                }
            }
        }

        return false;
    }



    // Definition of a Node for linked list problems
    // DO NOT CHANGE THE DEFINITION OF THIS NODE
    public static class Node {
        public int value;
        public Node next;
    }




    // Task: Count the number of nodes with a nonzero value in a linked list
    // Pre: head points to the first node of the list, or it is null if the list is empty
    // Post: the number of nodes with a nonzero value in the linked list is returned, and
    //  the linked list is unchanged.
    public static int numOfTerms(Node head) {
        if (head == null) {
            return 0;
        }

        if (head.value != 0) {
            return 1 + numOfTerms(head.next);
        } else {
            return numOfTerms(head.next);
        }
    }



    // Task: Remove leading zeroes from a BigNum represented by a linked list.
    // Pre: tmp refers to the first node of a list, or is null if the list is empty
    // Post: returns a reference to the node that is the head of the altered list where
    //   all nodes at the end of the list which have a zero have been removed
    // Note 1: as discussed in lecture, a BigNum stores the digits of the number in reverse
    //         order, with the ones digit at the front of the list. We are deleting
    //         leading zeroes, so they will appear at the end of the list
    public static Node normalizeBigNum(Node tmp) {
        if (tmp == null || (tmp.value == 0 && tmp.next == null)) {
            return null;
        }

        Node current = tmp;
        Node lastNonZero = null;

        while (current != null) {
            if (current.value != 0) {
                lastNonZero = current;
            }
            current = current.next;
        }

        if (lastNonZero == null) {
            return null;
        }

        if (lastNonZero.next != null) {
            lastNonZero.next = null;
        }

        return tmp;
    }



    // Task: Return a string of the contents of the linked list in forward order and then
    //    the same values in reverse order.
    // Pre: tmp points to the first node of the list, or it is null if
    //  the list is empty
    // Post: returns a string of the values of all nodes in the linked list in forward
    //  order, and then the same values in reverse order, with a single space after each
    //  and every value. The linked list is unchanged.
    // Ex: if the list contains 1 2 3, we will return "1 2 3 3 2 1 "
    public static String echo2(Node tmp) {
        if (tmp == null) {
            return "";
        } else {
            String currentAndForward = tmp.value + " " + echo2(tmp.next);
            return currentAndForward + tmp.value + " ";
        }
    }



    // Task: Find out whether a linked list 'subList' is contained within another
    //   linked list 'superList'
    // Pre: superList and subList are head pointers to non-empty linked lists
    // Post: Return true or false depending on whether subList is contained in superList
    // A list is contained in another list if all the data elements appear in the
    // same relative order. For example...
    // If superList was 2->13->5->6->10->21 and subList was 13->5->10 then contains would be true.
    // If superList was 2->13->5->6->10->21 and subList was 5->13->10 then contains would be false.
    // If superList was 2->13->5->6->10 and subList was 13->7->10 then contains would return false.
    public static boolean contains(Node superList, Node subList) {
        if (subList == null) {
            return true;
        }
        if (superList == null) {
            return false;
        }
        if (superList.value == subList.value) {
            if (contains(superList.next, subList.next)) {
                return true;
            }
        }
        return contains(superList.next, subList);
    }




////////////////////////////////////////////
// CHALLENGE PROBLEM
//
// This problem is optional, and is for those who find recursive
// programming fun and interesting. This problem will not count
// against you if you do not attempt it or if you get it wrong.
// It also does not earn any extra credit if you get it right.
// It's just here for the challenge.
//

    // Task: Reverse the nodes in a linked list.
    // Pre: tmp points to the first node of the list, or it is null if the list is empty.
    // Post: the list has been reversed and a reference to the new first node is returned.
    // This must be accomplished without allocating any new nodes or deleting existing nodes.
    // In fact, you should only change the 'next' field of each node.
    // You must accomplish this task only with recursion and without any code to walk the list.
    public static Node reverseList(Node tmp) {
        return new Node();  // TODO replace this with your solution
    }


}
