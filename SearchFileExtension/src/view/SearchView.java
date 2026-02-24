package view;

import controller.SearchController;

public class SearchView {
	public static void main(String[] args) {
		SearchController search = new SearchController();
		search.searchFiles("C:\\Users\\", ".txt");
	}
}