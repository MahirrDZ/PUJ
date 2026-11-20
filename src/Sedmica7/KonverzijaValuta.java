package Sedmica7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KonverzijaValuta {
    private JPanel panel;
    private JTextField Unos;
    private JComboBox ValuteComboBox;
    private JButton KonvertujButton;
    private JLabel iznosUKMLabel;
    private JLabel iznosNakonKonverzijeLabel;
    private JLabel ispisIznosaNakonKonverzijeLabel;
    private JComboBox IzComboBox;


    public static void main(String[] args) {
        JFrame frame = new JFrame("KonverzijaValuta");
        frame.setContentPane(new KonverzijaValuta().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public KonverzijaValuta() {
        String[] valute= {"BAM","EUR", "USD", "GBP"};
        ValuteComboBox.removeAllItems();
        IzComboBox.removeAllItems();
        for (String valuta1 : valute) {
            ValuteComboBox.addItem(valuta1);
            IzComboBox.addItem(valuta1);
        }

        IzComboBox.setSelectedItem("BAM");
        ValuteComboBox.setSelectedItem("EUR");


        KonvertujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konvertuj();
            }
        });
    }

    private void konvertuj() {
        String iznos=Unos.getText();
        iznos=iznos.replace(",", ".");
        if(iznos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Unesite iznos!");
            return;
        }
        try{
            double kurs=1;
            double iznosDouble=Double.parseDouble(iznos);
            if(!Double.isFinite(iznosDouble)||iznosDouble<0){
                JOptionPane.showMessageDialog(null, "Unesite pozitivan broj!");
                return;
            }else{
                double IzKursDouble=getKurs(IzComboBox.getSelectedItem().toString());
                double iznosBAM=iznosDouble*IzKursDouble;
                double Kurs=getKurs(ValuteComboBox.getSelectedItem().toString());
                double iznosKurse=iznosBAM/Kurs;
                ispisIznosaNakonKonverzijeLabel.setText(String.format("%.2f %s",iznosKurse, ValuteComboBox.getSelectedItem().toString()));
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Unesite validan broj!");
        }
    }

    private double getKurs(String valuta){
        switch (valuta){
            case "BAM":
                return 1;
            case "EUR":
                return 1.95;
            case "USD":
                return 1.79;
            case "GBP":
                return 1.55;
            default:
                return 1;
        }

    }


}
