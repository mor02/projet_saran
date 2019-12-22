package com.poo.mime.utils;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.MediaTracker;

public class JImage extends JPanel {
	private String nomFichier;
	private Image image;
	private Dimension dimImage;
	private MediaTracker tracker;

	public JImage(String nomFichier) {
		this.nomFichier = nomFichier;
		image = getToolkit().getImage(nomFichier);
		tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
		}
		dimImage = new Dimension((int) (image.getWidth(this)), (int) (image.getHeight(this)));
		//System.out.println(dimImage);
		setPreferredSize(dimImage);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	public Dimension getDimImage() {
		return dimImage;
	}

}

