/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Processes a file containing product and task information 
 * and creates a List of Products and their associated Tasks.
 */
public class ProductsReader {
	
	/**
	 * The constructor for the Products Reader class
	 */
	public ProductsReader() {
		 /** intentionally left empty */
	}
	
	/**
	 * Receives a String with the file name to read from. 
	 * @param filename The name of the file to be read from.
	 * @return The list of products from the file 
	 */
	public static ArrayList<Product> readProductsFile (String filename){
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			File file = new File (filename);
			Scanner scanner = new Scanner(file);
			
			Product currentProduct = null; //Keeps track of current product
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if(!line.isEmpty()) {
					if(line.startsWith("#")) {
						currentProduct = processProduct(line);
						if(currentProduct != null) {
							products.add(currentProduct);
						}
					} else if(currentProduct != null) {
						//Tasks related to the product
						Task task = processTask(line);
						if(task != null) {
							currentProduct.addTask(task);
						}
					}
				}
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		return products;
	}
	
	/**
	 * Processes the product and the tasks related to it 
	 * @param productName The name of the product to be processed
	 * @return The Product from the file 
	 */
	private static Product processProduct(String productName) {
		String[] productToken = productName.split("\\r?\\n?#");
		
		if (productToken.length > 0) {
			//First element is product name
			String name = productToken[0].trim();
			return new Product(name);
		}
		
		return null;
	}
	
	/**
	 * Processes the task related to the product 
	 * @param taskName The name of the task
	 * @return The task related to their product 
	 */
	private static Task processTask(String taskName) {
		String[] taskToken = taskName.split("\\r?\\n?\\*");
		
		if (taskToken.length > 0) {
			//first element contains the information about the task 
			String taskInfo = taskToken[0].trim();
			
			//Split task info into individual fields
			String[] taskFields = taskInfo.split(",");
			
			if(taskFields.length == 8) {
					//Extract values for each parameter
					int id = Integer.parseInt(taskFields[0].trim());
					String state = taskFields[1].trim();
					String title = taskFields[2].trim();
					String type = taskFields[3].trim();
					String creator = taskFields[4].trim();
					String owner = taskFields[5].trim();
					String verified = taskFields[6].trim();
					
					//Process notes section
					ArrayList<String> notes = new ArrayList<>();
					for(int i = 1; i < taskToken.length; i++) {
						String[] noteToken = taskToken[i].split("\\r?\\n?-");
						if(noteToken.length > 0) {
							//Add note to the notes list
							notes.add(noteToken[0].trim());
						}
					}
					
					return new Task (id, state, title, type, creator, owner, verified, notes);
			}
		}
		
		return null;
	}
}

