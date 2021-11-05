package com.hca.sakila.models;

import java.util.HashMap;

public class SnackCounter {
	
	private HashMap<String, Snack[]> snacks = new HashMap<String, Snack[]>();
	
	public SnackCounter() {
		super();

		snacks.put("drinks", 
				new Snack[] {
						new Snack("Coke", 5.99f),
						new Snack("Coke Icee", 5.99f),
						new Snack("Sweet Tea", 2.99f),
						new Snack("Bottled Water", 4.00f)						
				});
		snacks.put("salty", 
				new Snack[] {
						new Snack("Popcorn", 5.99f),
						new Snack("Buttered Popcorn", 6.99f),
						new Snack("Pickle", 2.00f),
						new Snack("Nachos", 7.99f)						
				});
		snacks.put("sweet", 
				new Snack[] {
						new Snack("M&Ms", 3.99f),
						new Snack("Peanut M&Ms", 3.99f),
						new Snack("Sour Patch Kids", 3.99f)					
				});
	}

	public Snack[] getSnacksByCategory(String category) {
		return snacks.get(category);		
	}

}
