package application;

import java.io.File;
import java.util.Scanner;

public class Recursos3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o caminho da pasta: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("FOLDERS:");
		
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		System.out.println();
		
		File[] files = path.listFiles(File::isFile);
		
		System.out.println("FILES:");
		
		for(File file : files) {
			System.out.println(file);
		}
		
		//---------------------------------
		
		boolean success = new File(strPath + "\\subdir").mkdir();
		
		System.out.println("Diretório criado com sucesso: " + success);
		sc.close();

	}

}
