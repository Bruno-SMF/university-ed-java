package view;

import controller.ExtractURLsController;

public class ExtractURLsView {
	public static void main(String[] args) {
		try {
			ExtractURLsController urls = new ExtractURLsController("terra.com.br");
			urls.links("https://www.terra.com.br/");
		} catch(Exception e) {
			System.out.println("Falha ao carregar");
			e.printStackTrace();
		}
	}
}