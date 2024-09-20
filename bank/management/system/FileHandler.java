package bank.management.system;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandler {

    private static ArrayList<String> personalData = new ArrayList<>();

    public static void saveData(String name, String fname,
            String pincode, String gender, String email,
            String marital, String address, String city) {
        String data = "Name:" + name + " " +
                "Father Name:" + fname + " " +
                "Pincode:" + pincode + "" +
                "Gender:" + gender + "" +
                "Email:" + email + " " +
                "Marital Status:" + marital + " " +
                "Address:" + address + " " +
                "City:" + city;
        personalData.add(data);
    }

    public static String MyData(int i) {
        if (i >= 0 && i < personalData.size()) {
            return personalData.get(i);
        } else {
            System.out.println("Index out of bounds.");
            return null;
        }
    }

}