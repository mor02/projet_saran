package com.poo.mime.test;

import javax.swing.JFrame;

import com.poo.mime.utils.JImage;

class TestImage extends JFrame {
	JImage image;

	TestImage(String s) {
		super("Test de JImage");
		this.setContentPane(image = new JImage(s));
	}

	public static void main(String[] argv) {
		TestImage aff = new TestImage(".\\res\bret.png");
		aff.pack();
		aff.setVisible(true);
	}
}