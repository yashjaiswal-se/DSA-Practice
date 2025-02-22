package BitManipulation;

import java.util.*;

public class SetBit {

    static String convert2Binary(int n) {
        String str = "";
        int copy = n;
        // Convert number to binary string
        while (copy > 0) {
            if (copy % 2 == 1) {
                str = "1" + str; // Prepend "1" to maintain correct order
            } else {
                str = "0" + str; // Prepend "0"
            }
            copy = copy / 2; // Reduce number by dividing by 2
        }

        // Edge case: If number is 0, set binary string as "0"
        if (str.isEmpty()) {
            str = "0";
        }
        return str;
    }

    public static void main(String[] args) {
        // we want to set our ith bit
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.println("Please enter the number:");
        int n = sc.nextInt();
        System.out.println("Please enter the bit position to check (starting from 0):");
        int i = sc.nextInt();

        String str = convert2Binary(n);
        System.out.println("Binary representation: " + str);

        // Efficient method
        if ((n & (1 << i)) != 0) {
            System.out.println("The bit is already set; ith bit is 1");
        } else {
            n = n | (1 << i);
            str = convert2Binary(n);
            System.out.println("The representation after setting the bit is " + str);
        }
        sc.close();
    }
}
