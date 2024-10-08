package bank.management.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandlerAlpha {

    public static void saveAccount(String cardnoS, long money) {
        String q = cardnoS + "," + money + "%";
        try {
            PrintWriter input = new PrintWriter(new FileOutputStream("pasaMera_data.txt", true));
            input.println(q);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getCardNumbers() {
        ArrayList<String> cardNumbers = new ArrayList<>();
        try {
            Scanner read = new Scanner(new FileInputStream("pasaMera_data.txt"));
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    cardNumbers.add(parts[0]);
                }
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardNumbers;
    }

    public static ArrayList<Long> getAmounts() {
        ArrayList<Long> amounts = new ArrayList<>();
        try {
            Scanner read = new Scanner(new FileInputStream("pasaMera_data.txt"));
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String amountStr = parts[1].split("%")[0];
                    amounts.add(Long.parseLong(amountStr));
                }
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amounts;
    }

    public static void main(String[] args) {
        ArrayList<String> cardNumbers = FileHandlerAlpha.getCardNumbers();
        ArrayList<Long> amounts = FileHandlerAlpha.getAmounts();
        System.out.println("Card Numbers:");
        for (String cardNumber : cardNumbers) {
            System.out.println(cardNumber);
        }

        System.out.println("\nAmounts:");
        for (Long amount : amounts) {
            System.out.println(amount);
        }
    }
}
