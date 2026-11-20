package Sedmica6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JPanel panel;
    private JTextField ResultsField;
    private JButton Clear;
    private JButton Jednako;
    private JButton ZeroButton;
    private JButton Decimal;
    private JButton modButton;
    private JButton SevenButton;
    private JButton FourButton;
    private JButton OneButton;
    private JButton ABS;
    private JButton PercentButton;
    private JButton Djeljenje;
    private JButton Mnozenje;
    private JButton Oduzimanje;
    private JButton Sabiranje;
    private JButton ThreeButton;
    private JButton SixButton;
    private JButton NineButton;
    private JButton EightButton;
    private JButton FiveButton;
    private JButton TwoButton;

    private double firstNumber=0;
    private double secondNumber=0;
    private String operator="";
    private boolean isNewOperation=true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void clear(){
        ResultsField.setText("0");
        firstNumber=0;
        secondNumber=0;
        operator="";
        isNewOperation=true;
    }

    private void setOperator(String op){
        if(!operator.isEmpty()){
            calculateResult();
        }
        firstNumber=Double.parseDouble(ResultsField.getText());
        operator=op;
        isNewOperation=true;

    }

    private void calculateResult(){
        secondNumber=Double.parseDouble(ResultsField.getText());
        double result=0;

        switch(operator){
            case "+":
                result=firstNumber+secondNumber;
                break;
            case "-":
                result=firstNumber-secondNumber;
                break;
            case "*":
                result=firstNumber*secondNumber;
            case "/":
                if(secondNumber!=0){
                    result=firstNumber/secondNumber;
                    break;
                }else{
                    result=0;
                    break;
                }
            case "%":
                result=firstNumber%secondNumber;
                break;
            default:
                result=0;
        }
        ResultsField.setText(String.valueOf(result));
        firstNumber=result;
        operator="";
        isNewOperation=true;
    }

    private void setDecimal(){
        if(isNewOperation){
            ResultsField.setText("0.");
            isNewOperation=false;

        }else {
            ResultsField.setText(ResultsField.getText() + ".");
        }
    }

    private void calculatePercent(){
        double result=Double.parseDouble(ResultsField.getText())/100;
        ResultsField.setText(String.valueOf(result));
    }

    private void setAbs(){
        double result=Math.abs(Double.parseDouble(ResultsField.getText()));
        ResultsField.setText(String.valueOf(result));
    }


    public Calculator(){
        ActionListener numberListener=new NumberListener();
        ZeroButton.addActionListener(numberListener);
        OneButton.addActionListener(numberListener);
        TwoButton.addActionListener(numberListener);
        ThreeButton.addActionListener(numberListener);
        FourButton.addActionListener(numberListener);
        FiveButton.addActionListener(numberListener);
        SixButton.addActionListener(numberListener);
        SevenButton.addActionListener(numberListener);
        EightButton.addActionListener(numberListener);
        NineButton.addActionListener(numberListener);

        Sabiranje.addActionListener(e->setOperator("+"));
        Oduzimanje.addActionListener(e->setOperator("-"));
        Mnozenje.addActionListener(e->setOperator("*"));
        Djeljenje.addActionListener(e->setOperator("/"));
        modButton.addActionListener(e->setOperator("%"));

        PercentButton.addActionListener(e->calculatePercent());
        ABS.addActionListener(e->setAbs());
        Decimal.addActionListener(e->setDecimal());

        Clear.addActionListener(e->clear());
        Jednako.addActionListener(e->calculateResult());
        ResultsField.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    private class NumberListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String value=((JButton) e.getSource()).getText();
            if(isNewOperation){
                ResultsField.setText(value);
                isNewOperation=false;
            }else{
                ResultsField.setText(ResultsField.getText()+value);
            }
        }
    }
}
