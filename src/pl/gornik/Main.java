package pl.gornik;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int[] CURRENCY = {
            50_000,
            20_000,
            10_000,
            5_000,
            2_000,
            1_000,
            500,
            200,
            100,
            5,
            2,
            1 };

    public static void main(String[] args) {
        System.out.println("Change-Making Problem!");
        System.out.println("Enter price: ");
        int price = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Enter amount of cash: ");
        int amountOfCash = Integer.parseInt(SCANNER.nextLine());

        if (price > amountOfCash) System.out.println("Not enough cash.");
        else if (price == amountOfCash) System.out.println("Just enough.");
        else {
            int change = (amountOfCash - price) * 100;
            int[] countOfCurrency = getChange(change);
            int value;
            int count;

            System.out.println("Change: ");
            for (int i = 0; i < countOfCurrency.length; i++) {
                count = countOfCurrency[i];
                value = CURRENCY[i] / 100;
                if (count != 0) {
                    System.out.println(count + "x" + value);
                }
            }
        }
    }

    private static int[] getChange(int change) {
        int[] countOfCurrency = new int[CURRENCY.length];
        int i = 0;

        while (change > 0) {
            countOfCurrency[i] = change / CURRENCY[i];
            change -= countOfCurrency[i] * CURRENCY[i];
            i++;

            if (change == 0) break;
        }

        return countOfCurrency;
    }
}
