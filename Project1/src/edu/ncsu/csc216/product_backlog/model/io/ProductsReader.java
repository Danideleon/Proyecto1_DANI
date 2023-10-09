/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import java.util.ArrayList;

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
		return null;
	}
	
	/**
	 * Processes the product and the tasks related to it 
	 * @param productName The name of the product to be processed
	 * @return The Product from the file 
	 */
	private static Product processProduct(String productName) {
		return null;
	}
	
	/**
	 * Processes the task related to the product 
	 * @param taskName The name of the task
	 * @return The task related to their product 
	 */
	private static Task processTask(String taskName) {
		return null;
	}
}

