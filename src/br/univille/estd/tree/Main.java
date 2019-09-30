package br.univille.estd.tree;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		File fileC         = new File("C:", false, true);
		File fileAndroid   = new File("   /AndroidSDK", false, true);
		File fileEclipse   = new File("   /eclipse", false, true);
		File fileDownloads = new File("   /downloads", false, true);
		
		File fileGimp2  = new File(500,  "Gimp 2.exe", true, false);
		File fileJava   = new File(1500, "   java.exe", true, false);
		File fileArtigo = new File(80,   "   artigo.pdf", true, false);
		File fileMySQL  = new File(1000, "   mysql-driver-jdbc.jar", true, false);
		File fileTCC    = new File(100,  "tcc.doc", true, false);

		Tree<File> tree = new Tree<File>();

		Position<File> root				= tree.addRoot(fileC);
		Position<File> childAndroid		= tree.addChild(root, fileAndroid);
		Position<File> childEclipse		= tree.addChild(root, fileEclipse);
		Position<File> childGimp2		= tree.addChild(root, fileGimp2);
		Position<File> childTCC			= tree.addChild(root, fileTCC);

		Position<File> childDownloads 	= tree.addChild(root, fileDownloads);
		Position<File> childJava 		= tree.addChild(childDownloads, fileJava);
		Position<File> childArtigo 		= tree.addChild(childDownloads, fileArtigo);
		Position<File> childMySQL 		= tree.addChild(childDownloads, fileMySQL);
		
		Iterator<Position<File>> iteratorRoot = root.getChildren();
		TreeUtils.toStringPostOrder(tree, root);
		System.out.println(TreeUtils.toStringPreOrder(tree, root));
	}
}