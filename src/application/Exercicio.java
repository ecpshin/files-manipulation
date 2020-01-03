package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com caminho do arquivo (.csv): ");
		String str = sc.next();

		
		File file = new File("c:\\temp\\out\\");
				
		String[] dados = new String[3];

		try (BufferedReader br = new BufferedReader(new FileReader(str))) {

			String line = br.readLine();
			
			boolean f = new File(str).mkdir();
			
            if(f) {
            	System.out.print(f);
            }
            
			double valor = 0.0, total = 0.0;
			int qtde = 0;
			
			if(!file.exists()) {
            	boolean b = new File("c:\\temp\\out").mkdir();            	
            }
			
			while (line != null) {

				dados = line.split(",");

				valor = Double.parseDouble(dados[1]);
				qtde = Integer.parseInt(dados[2]);
				total = qtde * valor;
				String v = dados[0] + ", $" + String.format("%.2f", total);
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\out\\summary.txt", true))) {
                    
					bw.write(v);
					bw.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				}

				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		} finally {
			if(sc != null) {
				sc.close();
			}
		}

	}// end main

}
