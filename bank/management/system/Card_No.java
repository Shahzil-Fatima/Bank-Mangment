package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

public class Card_No extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField p1, p2;
    String cardno;

    Card_No(String cardno) {
        this.cardno = cardno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 850, 800);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR Card no");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(330, 180, 400, 35);
        l3.add(label1);

        JLabel label2 = new JLabel("New Card no: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(250, 240, 100, 35);
        l3.add(label2);

        p1 = new JTextField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(400, 240, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New Card no: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(250, 280, 400, 35);
        l3.add(label3);

        p2 = new JTextField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(400, 285, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(420, 362, 150, 35);
        b1.setForeground(Color.DARK_GRAY);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(420, 406, 150, 35);
        b2.setForeground(Color.DARK_GRAY);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource() == b1) {
                String cardno1 = p1.getText();
                String cardno2 = p2.getText();

                if (cardno1.equals("") || cardno2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter both new card numbers");
                    return;
                }

                if (!cardno1.equals(cardno2)) {
                    JOptionPane.showMessageDialog(null, "New card numbers do not match");
                    return;
                }
                ArrayList<String> cardNumbers = FileHandlerAlpha.getCardNumbers();
                if (cardNumbers.contains(cardno1)) {
                    JOptionPane.showMessageDialog(null, "This card number already exists");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Card number changed successfully");
                setVisible(false);
                new main_Class(cardno);
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(cardno);
            }
        } catch (Exception j) {
            j.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Card_No("");
    }
}
