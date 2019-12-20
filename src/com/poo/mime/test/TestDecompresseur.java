package com.poo.mime.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.poo.mime.utils.Decompresser;


public class TestDecompresseur {

	public static void main(String[] args) {
		System.out.println("debut test");
		File zipfile = new File("C://Users//amgharm//Documents");
	    File folder = new File("CLI.zip");
	    

	    try {
			Decompresser.unzip(zipfile, folder);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
