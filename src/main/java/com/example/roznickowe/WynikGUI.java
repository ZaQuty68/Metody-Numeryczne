package com.example.roznickowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class WynikGUI extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton ok;

    public WynikGUI(List<Double> wynikEL, double wynikEB, List<Double> wynikEML, double wynikEMB, List<Double> wynikHL, double wynikHB){
        setSize(500, 450);
        setName("Wynik");
        setTitle("Wynik");
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        int szer_okna = getSize().width;
        int wys_okna = getSize().height;
        setLocation((szer-szer_okna)/2,(wys-wys_okna)/2);
        setResizable(false);
        setLayout(null);

        l1 = new JLabel("Metoda Eulera:");
        l1.setBounds(10, 10, 450, 30);
        add(l1);

        String el = "";
        int i = 1;
        for(double d: wynikEL){
            el = el + "y" + i + ": " +  Math.round(d * 100000.0) / 100000.0 + " ";
            i++;
        }
        l2 = new JLabel("Przybliżone rozwiązenie = " + el);
        l2.setBounds(10, 50, 450, 30);
        add(l2);

        l3 = new JLabel("Błąd maksymalny = " + Math.round(wynikEB * 100000.0) / 100000.0);
        l3.setBounds(10, 90, 450, 30);
        add(l3);

        l4 = new JLabel("Zmodyfikowana metoda Eulera:");
        l4.setBounds(10, 130, 450, 30);
        add(l4);

        String eml = "";
        i = 1;
        for(double d: wynikEML){
            eml = eml + "y" + i + ": " +  Math.round(d * 100000.0) / 100000.0 + " ";
            i++;
        }
        l5 = new JLabel("Przybliżone rozwiązenie = " + eml);
        l5.setBounds(10, 170, 450, 30);
        add(l5);

        l6 = new JLabel("Błąd maksymalny = " + Math.round(wynikEMB * 100000.0) / 100000.0);
        l6.setBounds(10, 210, 450, 30);
        add(l6);

        l7 = new JLabel("Metoda Heuna:");
        l7.setBounds(10, 250, 450, 30);
        add(l7);

        String hl = "";
        i = 1;
        for(double d: wynikHL){
            hl = hl + "y" + i + ": " +  Math.round(d * 100000.0) / 100000.0 + " ";
            i++;
        }
        l8 = new JLabel("Przybliżone rozwiązenie = " + hl);
        l8.setBounds(10, 290, 450, 30);
        add(l8);

        l9 = new JLabel("Błąd maksymalny = " + Math.round(wynikHB * 100000.0) / 100000.0);
        l9.setBounds(10, 330, 450, 30);
        add(l9);

        ok = new JButton("Wróć");
        ok.setBounds(10, 370, 100, 30);
        add(ok);
        ok.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object zrodlo = e.getSource();
        if(zrodlo == ok){
            this.dispose();
            StartUpGUI startUpGUI = new StartUpGUI();
            startUpGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startUpGUI.setVisible(true);
        }
    }
}
