/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab STMIK
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kliksaya {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Aplikasi GUI Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridBagLayout()); // Menggunakan GridBagLayout

        // Membuat label
        final JLabel label = new JLabel("Tekan tombol di bawah");
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0; // Kolom
        gbcLabel.gridy = 0; // Baris
        gbcLabel.insets = new Insets(10, 10, 10, 10); // Jarak antar komponen
        frame.add(label, gbcLabel);

        // Membuat tombol
        JButton button = new JButton("Klik Saya");
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 0; // Kolom
        gbcButton.gridy = 1; // Baris
        gbcButton.insets = new Insets(10, 10, 10, 10); // Jarak antar komponen
        frame.add(button, gbcButton);

        // Menambahkan ActionListener pada tombol
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        });

      
        frame.setVisible(true);
    }
}