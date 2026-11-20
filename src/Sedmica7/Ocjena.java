package Sedmica7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ocjena {
    private JPanel panel1;
    private JTextField Ime;
    private JTextField Projekat1;
    private JTextField Projekat2;
    private JTextField ZavrsniTest;
    private JTextField Ukupno;
    private JTextField Ocjena;
    private JTextField Polozio;
    private JButton CalculateButton;
    int projekat1, projekat2, zavrsniTest, ukupno;

    public Ocjena() {
        CalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projekat1=Integer.parseInt(Projekat1.getText());
                projekat2=Integer.parseInt(Projekat2.getText());
                zavrsniTest=Integer.parseInt(ZavrsniTest.getText());
                ukupno=projekat1+projekat2+zavrsniTest;
                Ukupno.setText(String.valueOf(ukupno));
                int ocjena=(ukupno>=95)?10:(ukupno>=85)?9:(ukupno>=75)?8:(ukupno>=65)?7:(ukupno>=55)?6:5;
                Ocjena.setText(String.valueOf(ocjena));
                Polozio.setText(ukupno>=55?"Polozio":"Nije polozio");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ocjena");
        frame.setContentPane(new Ocjena().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
