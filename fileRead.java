import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class fileRead {
    public static void main(String[] args) {
        // Membuat JFrame
        final JFrame frame = new JFrame("Aplikasi Pembaca File txt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());

        // Membuat JTextArea untuk menampilkan isi file
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Membuat JButton untuk membaca file
        JButton readButton = new JButton("Baca File");

        // Menambahkan ActionListener ke tombol
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dialog untuk memilih file
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();

                    // Memeriksa apakah file memiliki ekstensi .txt
                    if (!fileName.toLowerCase().endsWith(".txt")) {
                        JOptionPane.showMessageDialog(frame, "Error! File harus format .txt", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Keluar dari metode jika file bukan .txt
                    }

                    // Membaca file yang dipilih
                    try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                        textArea.setText(""); // Membersihkan area teks
                        String line;
                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                    } catch (IOException ex) {
                        // Menangani error jika file tidak ditemukan
                        JOptionPane.showMessageDialog(frame, "Error: File tidak ditemukan atau tidak dapat dibaca.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Menambahkan komponen ke JFrame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(readButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}