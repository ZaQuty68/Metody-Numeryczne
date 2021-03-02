package com.example.roznickowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

public class RoznickoweApplication {

	public static void main(String[] args) {
		StartUpGUI startUpGUI = new StartUpGUI();
		startUpGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startUpGUI.setVisible(true);
	}

}
