import java.util.Scanner;

public class Luhn {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long number = scanner.nextLong();
        int digits = 0;
        long copyOfNumber = number;


        while (copyOfNumber > 0) {
            copyOfNumber = copyOfNumber / 10;
            digits++;
        }


        long numberForDoubled = number / 10;
        System.out.println("number without digit =" + numberForDoubled);

        int checkDigit = (int) (number % 10);
        System.out.println("Check digit = " + checkDigit);


        int sumOfDubled = 0;


        for (int i = 1; i < digits; i = i + 2) {
            int digit = (int) ((numberForDoubled % 10) * 2);

            if (digit > 9) {
                int sumofDigits = 0;
                for (int j = 0; j < 2; j++) {
                    sumofDigits += digit % 10;
                    digit = digit / 10;
                }
                sumOfDubled += sumofDigits;
            } else {
                sumOfDubled = (int) (sumOfDubled + (numberForDoubled % 10) * 2);
            }

            numberForDoubled = numberForDoubled / 100;
        }

        System.out.println("Sum in this form is: " + sumOfDubled);


        int sumOfSimple = 0;
        long numberForSimple = number / 100;
        for(int i=0; i<digits; i=i+2){
            sumOfSimple=(int)(sumOfSimple+(numberForSimple%10));
            numberForSimple=numberForSimple/100;
        }


        System.out.println("Sum for undoubled numbers "+ sumOfSimple);


        int totalSum=sumOfDubled+sumOfSimple+checkDigit;

        if(totalSum%10==0){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }


}
