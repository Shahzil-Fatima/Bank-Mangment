package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Data extends JFrame implements ActionListener {
    private String cardno;
    private JLabel label1;
    private JLabel label4;
    private JButton button;

    Data(String cardno) {
        this.cardno = cardno;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        label1 = new JLabel();
        label1.setBounds(20, 140, 400, 200);
        add(label1);

        JLabel label2 = new JLabel("My Data");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        JLabel label3 = new JLabel("Card Number: " + cardno);
        label3.setBounds(20, 80, 300, 20);
        add(label3);

        label4 = new JLabel();
        label4.setBounds(20, 400, 300, 20);
        add(label4);

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);

        if (checkCardNumberExists(cardno)) {
            String personalData = FileHandler.MyData(getCardIndex(cardno));
            label1.setText(personalData);
        } else {
            label1.setText("Personal data not found for card number: " + cardno);
        }
    }

    private boolean checkCardNumberExists(String cardno) {
        ArrayList<String> cardNumbers = FileHandlerAlpha.getCardNumbers();
        return cardNumbers.contains(cardno);
    }

    private int getCardIndex(String cardno) {
        ArrayList<String> cardNumbers = FileHandlerAlpha.getCardNumbers();
        return cardNumbers.indexOf(cardno);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Data("");
    }
}