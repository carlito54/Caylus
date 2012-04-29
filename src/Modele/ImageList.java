package Modele;

import java.awt.Image;
import java.util.HashMap;

public class ImageList {
	
	private HashMap<String, Image> ouvrierList;
	private HashMap<String, Image> maisonList;
	private HashMap<String, Image> marqueurList;
	
	public ImageList(HashMap<String, Image> ouvrierList,
			HashMap<String, Image> maisonList,
			HashMap<String, Image> marqueurList) {
		super();
		this.ouvrierList = ouvrierList;
		this.maisonList = maisonList;
		this.marqueurList = marqueurList;
	}


	HashMap<String, Image> getOuvrierList() {
		return ouvrierList;
	}

	void setOuvrierList(HashMap<String, Image> ouvrierList) {
		this.ouvrierList = ouvrierList;
	}

	HashMap<String, Image> getMaisonList() {
		return maisonList;
	}

	void setMaisonList(HashMap<String, Image> maisonList) {
		this.maisonList = maisonList;
	}

	HashMap<String, Image> getMarqueurList() {
		return marqueurList;
	}

	void setMarqueurList(HashMap<String, Image> marqueurList) {
		this.marqueurList = marqueurList;
	}
	
	
	

	
	
}
