package pl.gornik;

import java.util.Scanner;

public class Main2 {
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
    private static final int[] CURRENCY_IN_REGISTER = { 0, 30, 20, 20, 0, 30, 20, 10, 0, 20, 30, 0 };
    private static boolean possible = true;

    public static void main(String[] args) {
        System.out.println("Change-Making Problem!");
        System.out.println("Enter price: ");
        double price = Double.parseDouble(SCANNER.nextLine());
        System.out.println("Enter amount of cash: ");
        double amountOfCash = Double.parseDouble(SCANNER.nextLine());

        if (price > amountOfCash) System.out.println("Not enough cash.");
        else if (price == amountOfCash) System.out.println("Just enough.");
        else {
            int change = (int) ((amountOfCash - price) * 100);
            int[] countOfCurrency = getChange(change);
            int count;
            int value;
            String end;

            System.out.println("Change: ");
            if (possible) {
                for (int i = 0; i < countOfCurrency.length; i++) {
                    count = countOfCurrency[i];
                    if (count == 0) continue;

                    if (CURRENCY[i] / 100 >= 1) {
                        value = CURRENCY[i] / 100;
                        end = "zł";
                    } else {
                        value = CURRENCY[i];
                        end = "gr";
                    }

                    System.out.println(count + " x " + value + end);
                }
            } else {
                System.out.println("Cannot return change!");
            }
        }
    }

    private static int[] getChange(int change) {
        int[] countOfCurrency = new int[CURRENCY.length];
        int i = 0;
        int count;

        while (change > 0) {
            count = change / CURRENCY[i];
            if (CURRENCY_IN_REGISTER[i] >= count) {
                countOfCurrency[i] = count;
            } else {
                countOfCurrency[i] = CURRENCY_IN_REGISTER[i];
            }

            change -= countOfCurrency[i] * CURRENCY[i];
            CURRENCY_IN_REGISTER[i] -= count;
            i++;

            if (change == 0) break;
            if (i == 12) {
                possible = false;
                break;
            }
        }

        return countOfCurrency;
    }
}
