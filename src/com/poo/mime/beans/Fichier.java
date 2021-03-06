package com.poo.mime.beans;

import java.util.List;

/**
 * 
 * @author mratovo
 * 
 * mot random
 */
public class Fichier {
		
		private String name;
		private String extention;
		private String mime;
		private String contenu;
		private int taille;
		
		public Fichier () {
			this.name="";
			this.extention="";
			this.mime="";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fichier other = (Fichier) obj;
			if (extention == null) {
				if (other.extention != null)
					return false;
			} else if (!extention.equals(other.extention))
				return false;
			if (mime == null) {
				if (other.mime != null)
					return false;
			} else if (!mime.equals(other.mime))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		public String getExtention() {
			return extention;
		}
		
		/**
		 * 
		 * @param extention
		 * 
		 */
		public void setExtention(String extention) {
			this.extention = extention;
		}

		public String getMime() {
			return mime;
		}

		public void setMime(String mime) {
			this.mime = mime;
		}

		@Override
		public String toString() {
			return "Fichier [name=" + name + ", extention=" + extention + ", mime=" + mime + "]\n";
		}
		
		public void setContenu(String conten) {
			this.contenu=conten;
		}
		
		public String getContenu(){
			return this.contenu;
		}
		
		public void setTaille(int taille) {
			this.taille = taille;
		}
		
		public int getTaille() {
			return this.taille;
		}
		
}
