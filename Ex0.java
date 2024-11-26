/** 206541393
 * psudo-code for the ex0 :
 * function isPrime(n):
 *     if n <= 1:
 *         RETURN false
 *     if n == 2:
 *         RETURN true
 *     if n MOD 2 == 0:
 *         RETURN false
 *     for i FROM 3 TO √n
 *         if n MOD i == 0:
 *             RETURN false
 *     RETURN true
 * END FUNCTION
 *
 * A)
 * SET found = false
 *
 * FOR p1 FROM 2 TO (number / 2):
 *     SET p2 = number - p1
 *     if isPrime(p1) AND isPrime(p2):
 *         PRINT "a) number = p1 + p2"
 *         SET found = true
 *         BREAK loop
 * END FOR
 *
 *
 * B)
 * SET found2 = false
 * SET p3 = 2
 *
 * WHILE NOT found2:
 *     SET p4 = p3 + number
 *     if isPrime(p3) AND isPrime(p4):
 *         PRINT "b) number = p4 - p3"
 *         SET found2 = true
 *     INCREMENT p3
 * END WHILE
 *
 * C)
 * SET counter = 0
 *
 * FOR i FROM 2 TO (number - 1):
 *     if isPrime(i):
 *         INCREMENT counter
 * END FOR
 *
 * PRINT "c) counter prime numbers in [2, number)"
 *
 *D)
 * PRINT "d) number = "
 * SET temp = number
 * SET firstFactor = true
 *
 * FOR i FROM 2 TO temp:
 *     WHILE isPrime(i) AND temp MOD i == 0:
 *         if NOT firstFactor:
 *             PRINT "*"
 *         PRINT i
 *         SET temp = temp / i
 *         SET firstFactor = false
 *     END WHILE
 * END FOR
 *
 * PRINT newline
 */


import java.util.Scanner;

public class Ex0 {

    public static void main(String[] args) {
        // Record the start time
        long startTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural even number (n>4): ");
        int number = scanner.nextInt();
        if (number%2 != 0 || number <= 4 ) {
            System.out.println("Error: you should enter a natural even > 4, and smaller than 100000000 ");
            System.exit(0);
        }
//        a)
        boolean found = false;
        for (int p1 = 2; p1 <= number / 2; p1++) {
            if (isPrime(p1) && isPrime(number - p1)) {
                System.out.println("a) " + number + " = " +  p1 + " + "+ (number - p1));
                found = true;
                break;
            }
        }
//       b)
        boolean found2 = false;
        for (int p3 = 2; !found2; p3++) {
            int p4 = p3 + number;
            if (isPrime(p3) && isPrime(p4)) {
                System.out.println("b) " + number + " = " + p4 + " - " + p3);
                found2 = true;
            }
        }


        //c)

        int counter = 0;
        for (int i = 2; i < number;i++){
            if (isPrime(i)) {
                counter++;  //compute how many prime numbers between 2 to n

            }
        }
        System.out.println("c) " + counter + " prime numbers in [2," + number + ")" );


        //d)
        System.out.print("d) " + number + " = ");
        int temp = number;
        boolean firstfactor = true;
        for (int i = 2;i <= temp;i++){
           while(isPrime(i) && temp % i == 0){
               if (!firstfactor) {

                   System.out.print("*");
               }
               System.out.print(i);
               temp /= i;
               firstfactor =false;
           }
        }
        System.out.println();

        //e)
        long endTime = System.currentTimeMillis();  // record the end time

        double runTime =  (endTime - startTime) /1000.0;
        System.out.println("e) " + runTime + " seconds , the program runtime");

        //f)
        System.out.println("f) " + "206541393");

    }





//    check if prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false; //0 and 1 are not prime
        if (n==2) return true;    // 2 is the only even prime
        if (n % 2 == 0) return false; //number that divisible by 2 without remainder, its skips all evens numbers.

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

}



