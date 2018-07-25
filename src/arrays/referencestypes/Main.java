package arrays.referencestypes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ////////////////
        // Value Types//
        ////////////////
        int a = 10;
        int b = a;

        System.out.printf("%d %d\n", a, b);

        // Changing b value does not affect a, since each one of them holds a value
        b++;
        System.out.printf("%d %d\n", a, b);

        ////////////////////
        //Reference Types//
        ///////////////////
        int[] arrayA = {0, 0, 0, 0};
        int[] arrayB = arrayA;

        System.out.printf("%s %s\n", Arrays.toString(arrayA), Arrays.toString(arrayB));

        // Changing arrayB affects arrayA, since both hold references for the same object.
        arrayB[0]++;
        System.out.printf("%s %s\n", Arrays.toString(arrayA), Arrays.toString(arrayB));
    }
}
