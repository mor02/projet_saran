package com.poo.mime.utils;

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompresser {

	public static boolean unzip(String filePath) {

		int count = 0;
		ZipInputStream zipIs = null;
		try {
			// Créez l'objet ZipInputStream pour lire le fichier zip.
			zipIs = new ZipInputStream(new FileInputStream(filePath));

			ZipEntry entry = null;
			// Parcourir chaque Entry (de haut en bas jusqu'à la fin)
			while ((entry = zipIs.getNextEntry()) != null) {
				if (entry.isDirectory()) {
					System.out.print("Directory: ");
				} else {
					count++;
					System.out.print("File: ");
				}
				System.out.println(entry.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				zipIs.close();
				if (count > 0) {
					return true;
				} else {
					return false;
				}

			} catch (Exception e) {
			}
		}
		if (count > 0) {
			return true;
		} else {
			return false;
		}

	}

}
