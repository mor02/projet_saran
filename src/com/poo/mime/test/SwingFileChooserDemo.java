package com.poo.mime.test;
/* From http://java.sun.com/docs/books/tutorial/index.html */

/*
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.poo.mime.beans.ResultatAnalyse;
import com.poo.mime.impl.Analyseur;

/*
 * SwingFileChooserDemo.java is a 1.4 application that uses these files:
 * images/Open16.gif images/Save16.gif
 */
public class SwingFileChooserDemo extends JPanel implements ActionListener {
  static private final String newline = "\n";

  JButton openButton, saveButton;

  public JTextArea log;

  JFileChooser fc;

  public SwingFileChooserDemo() {
    super(new BorderLayout());

    //Create the log first, because the action listeners
    //need to refer to it.
    log = new JTextArea(5, 20);
    log.setMargin(new Insets(5, 5, 5, 5));
    log.setEditable(false);
    JScrollPane logScrollPane = new JScrollPane(log);

    //Create a file chooser
    fc = new JFileChooser();

    //Uncomment one of the following lines to try a different
    //file selection mode. The first allows just directories
    //to be selected (and, at least in the Java look and feel,
    //shown). The second allows both files and directories
    //to be selected. If you leave these lines commented out,
    //then the default mode (FILES_ONLY) will be used.
    //
    //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    //Create the open button. We use the image from the JLF
    //Graphics Repository (but we extracted it from the jar).
    openButton = new JButton("Ouvrir",
        createImageIcon("images/Open16.gif"));
    openButton.addActionListener(this);

    //Create the save button. We use the image from the JLF
    //Graphics Repository (but we extracted it from the jar).
    saveButton = new JButton("Charger analyse");
    saveButton.addActionListener(this);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel(); //use FlowLayout
    buttonPanel.add(openButton);
    buttonPanel.add(saveButton);

    //Add the buttons and the log to this panel.
    add(buttonPanel, BorderLayout.PAGE_START);
    add(logScrollPane, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e) {

    //Handle open button action.
    if (e.getSource() == openButton) {
      int returnVal = fc.showOpenDialog(SwingFileChooserDemo.this);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        //This is where a real application would open the file.
        log.append("Opening: " + file.getName() + "." + newline);
        Analyseur analyseur = new Analyseur();
        ResultatAnalyse rTmp = analyseur.analysePrincaple(file.getAbsolutePath());
        //1. Affichage au niveau de l'interface graphique
        log.append(" Nom  : " + rTmp.getFichieraAnalyser().getName()+"\r\n");
        log.append(" Extention : " + rTmp.getFichieraAnalyser().getExtention()+"\r\n");
        log.append(" Mime : " + rTmp.getFichieraAnalyser().getMime()+"\r\n");
        log.append(" Taille  : " + rTmp.getFichieraAnalyser().getTaille()+"\r\n");
        log.append(" Resultat : " + rTmp.getResultatAnalyse());
        //2. Sauvegarde du resultat obtenu au niveau d'un fichier 
        
        String sfile = ".\\res\\save_analyse_graphique.csv";

		OutputStreamWriter out = null;
		PrintWriter pw = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(sfile));
			pw = new PrintWriter(out);
		} catch (FileNotFoundException e2) {
			System.out.println(e2.getMessage());
		}
				pw.write("Nom : " + rTmp.getFichieraAnalyser().getName() + "-" + "Extension : "+ rTmp.getFichieraAnalyser().getExtention() + "-"
						+ "Mime :" +rTmp.getFichieraAnalyser().getMime() + ";" + "Taille : " +rTmp.getFichieraAnalyser().getTaille() + ";"
						+ "Resultat :" + rTmp.getResultatAnalyse());
		pw.flush();
		pw.close();
      } else {
        log.append("Open command cancelled by user." + newline);
      }
      log.setCaretPosition(log.getDocument().getLength());

      //Handle save button action.
    } else if (e.getSource() == saveButton) {
      //int returnVal = fc.showSaveDialog(SwingFileChooserDemo.this);
//      if (returnVal == JFileChooser.APPROVE_OPTION) {
//        File file = fc.getSelectedFile();
//        //This is where a real application would save the file.
//        log.append("Saving: " + file.getName() + "." + newline);
    	  String sfile = ".\\res\\save_analyse_graphique.csv";

    		List<String> liste = readFile(new File(sfile));
    		for(String s : liste) {
    			log.append(s);
    			
    		}
//      } else {
//        log.append("Save command cancelled by user." + newline);
//      }
      log.setCaretPosition(log.getDocument().getLength());
    }
  }

  /** Returns an ImageIcon, or null if the path was invalid. */
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = SwingFileChooserDemo.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      return null;
    }
  }

  /**
   * Create the GUI and show it. For thread safety, this method should be
   * invoked from the event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);

    //Create and set up the window.
    JFrame frame = new JFrame("Mode Graphique");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new SwingFileChooserDemo();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
    
    
  }

	public static List<String> readFile(File file) {

		List<String> result = new ArrayList<String>();

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);

			br = new BufferedReader(fr);

			for (String line = br.readLine(); line != null; line = br.readLine()) {
				result.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
