package com.poo.mime.test;
/**
 * author Saran 
 * @param 
 */



import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class FenetreProjet extends JFrame  {
	
	private String titre;
	
	
	private JLabel valueLabel = new JLabel("afficher tous les resultats: ");
	private JLabel valueSecondLabel= new JLabel("fichiers ou dossier à analyser");
	private JLabel valueTroisiemeLabel= new JLabel ("");
	
	
	private JTextField ajouterField = new JTextField(20);
	private JTextField supprimerField = new JTextField(20);
	private JTextField resultatField = new JTextField(20);
	private JTextField resultatsField = new JTextField(20);
	
	private JButton ajouterUnFichier = new JButton("ajouter");
	private JButton supprimerUnFichier = new JButton("supprimer");
	private JButton afficherResultat = new JButton("Chercher");
	private JButton toutResultats = new JButton("les resultats");
	
	private JPanel rightPanel = new JPanel();
	
	

	public 	FenetreProjet(String titre) {
		super(titre);
		init();
		initSecond();
		initTrois();

		//lesActions();
    }
	
	private void initSecond() {
		//Layout avec alignement
		GridLayout grid = new GridLayout(3, 3);
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		Container contentPane = getContentPane();
		contentPane.setLayout(flow);
		
		contentPane.setLayout(grid);
		
		
		contentPane.add(valueTroisiemeLabel);
		contentPane.add(resultatField);
		contentPane.add(afficherResultat);
		
		
		
		//Quelques polices, couleurs
		Font font = new Font(Font.MONOSPACED, Font.ITALIC, 16);
		
		
		valueTroisiemeLabel.setFont(font);
		valueTroisiemeLabel.setForeground(Color.BLUE);
		contentPane.setBackground(Color.PINK);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void initTrois() {
		//Layout avec alignement
		GridLayout grid = new GridLayout(3, 3);
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		Container contentPane = getContentPane();
		contentPane.setLayout(flow);
		
		contentPane.setLayout(grid);
		
		
		
		contentPane.add(resultatsField);
		//contentPane.add(toutResultats);
		//contentPane.add(valueLabel);
		
		
		
		//Quelques polices, couleurs
		Font font = new Font(Font.MONOSPACED, Font.ITALIC, 12);
		
		valueLabel.setFont(font);
		valueLabel.setForeground(Color.BLUE);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

		
		
		
	
	private void init() {
	//Layout avec alignement
	GridLayout grid = new GridLayout(1, 3);
	FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
	Container contentPane = getContentPane();
	contentPane.setLayout(flow);
	
	contentPane.setLayout(grid);

//	contentPane.add(valueSecondLabel);
//	contentPane.add(ajouterField);
//	contentPane.add(ajouterUnFichier);
//	contentPane.add(supprimerUnFichier);

	//Quelques polices, couleurs
			Font font = new Font(Font.MONOSPACED, Font.ITALIC, 12);
			
			valueSecondLabel.setFont(font);
			valueSecondLabel.setForeground(Color.BLUE);
			
			pack();
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	/**
	 *
	 *protected void lesActions() {
	 *	ajouterUnFichier.addActionListener(new actionAjouter());
	 *	supprimerUnFichier.addActionListener(new actionSupprimer());
	 *	afficherResultat.addActionListener(new actionResultat());
	 *	toutResultats.addActionListener(new actionAfficherTout());
	 *	}
     *
	*/
	
	
	
	
	
	
	public static void main(String[] args) {
		new FenetreProjet("projet test des fichiers");
	
	}  
}

