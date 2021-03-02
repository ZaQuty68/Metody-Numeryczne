package com.example.roznickowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartUpGUI extends JFrame implements ActionListener {
    JLabel l1, l2;
    JButton ok;
    JTextField n, b;

    public StartUpGUI(){
        setSize(300, 300);
        setName("StartUp");
        setTitle("StartUp");
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        int szer_okna = getSize().width;
        int wys_okna = getSize().height;
        setLocation((szer-szer_okna)/2, (wys-wys_okna)/2);
        setResizable(false);
        setLayout(null);

        l1 = new JLabel("Wprowadź n:");
        l1.setBounds(10, 10, 260, 30);
        add(l1);

        n = new JTextField();
        n.setBounds(10, 50, 260, 30);
        add(n);

        l2 = new JLabel("Wprowadź b:");
        l2.setBounds(10,90, 260, 30);
        add(l2);

        b = new JTextField();
        b.setBounds(10, 130, 260, 30);
        add(b);

        ok = new JButton("OK");
        ok.setBounds(10, 170, 260, 30);
        add(ok);
        ok.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        Object zrodlo = e.getSource();
        if(zrodlo == ok){
            if(n.getText().matches("^[0-9]+$")){
                if(Integer.parseInt(n.getText()) >= 1){
                    if(b.getText().matches("^[0-9]+$")){
                        if(Integer.parseInt(b.getText()) > 0){
                            Euler euler = new Euler(Integer.parseInt(n.getText()), Integer.parseInt(b.getText()));
                            EulerMod eulerMod = new EulerMod(Integer.parseInt(n.getText()), Integer.parseInt(b.getText()));
                            Heun heun = new Heun(Integer.parseInt(n.getText()), Integer.parseInt(b.getText()));
                            this.dispose();
                            WynikGUI wynikGUI = new WynikGUI(euler.WynikL(), euler.WynikB(), eulerMod.WynikL(), eulerMod.WynikB(), heun.WynikL(), heun.WynikB());
                            wynikGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            wynikGUI.setVisible(true);
                        }
                        else{
                            l2.setText("Proszę podaj liczbę większą od 0!");
                            l2.setForeground(Color.RED);
                        }
                    }
                    else{
                        l2.setText("Proszę padaj liczbę całkowitą większą od 0!");
                        l2.setForeground(Color.RED);
                    }
                }
                else{
                    l1.setText("N musi być większe bądź równe 1!");
                    l1.setForeground(Color.RED);
                }
            }
            else{
                l1.setText("Proszę podaj liczbę naturalną!");
                l1.setForeground(Color.RED);
            }
        }
    }
}
