/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import edu.ncsu.csc216.product_backlog.model.product.Product;

/**
 * Writes the given list of Products to the file name provided.
 */
public class ProductsWriter {

	/**
	 * The constructor for the ProductsWriter class
	 */
	public ProductsWriter() {
		 /** intentionally left empty */
	}
	
	/**
	 * Receives a String with the file name to write to and a List of Products to write to file.
	 * @param filename The name of the file to be written on
	 * @param productList The Product List to write to a file
	 * @throws IOException
	 */
	public static void writeProductsToFile(String fileName, List<Product> productList) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));
    	
    	for (Product product : productList) {
    		fileWriter.println(product.toString());
    	}
    	
    	fileWriter.close(); 
		}
	}

