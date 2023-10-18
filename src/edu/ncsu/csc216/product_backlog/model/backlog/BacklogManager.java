/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.backlog;

import java.io.IOException;
import java.util.List;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.io.ProductsReader;
import edu.ncsu.csc216.product_backlog.model.io.ProductsWriter;
import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Concrete class that maintains a list of Products, the active 
 * or current Product,and handles events from the GUI.
 */
public class BacklogManager {
	
	/**An instance of itself**/
	private static BacklogManager instance;
	/**List of products**/
	private List<Product>products;
	/**The current product being used**/
	private Product currentProduct;
	
	
	/**
	 * Constructor of the BacklogManager
	 */
	private BacklogManager() {
		
	}
	
	/**
	 * Creates the instance of BacklogManager to use in the GUI
	 * @return The instance of BacklogManager
	 */
	public static BacklogManager getInstance() {
		if (instance == null) {
			instance = new BacklogManager();
		}
		return instance;	
	}
	
	/**
	 * WriteS the Products to the file using the ProductsWriter class.
	 * @param filename The name of the file to be written on.
	 */
	public void saveToFile(String filename){
		if(currentProduct == null || currentProduct.getTasks().isEmpty()) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		
		try {
			ProductsWriter.writeProductsToFile(filename, products);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Uses the ProductsReader to read the given fileName
	 * @param filename The name of the file to be read from
	 */
	public void loadFromFile(String filename){
		
		List<Product> productsFromFile = ProductsReader.readProductsFile(filename);
		
		if(!productsFromFile.isEmpty()) {
			products.addAll(productsFromFile);
			currentProduct = productsFromFile.get(0);
		}
	}
	
	/**
	 * Find the Product with the given name in the list, make it the active or currentProduct.
	 * @param productName The name of the product to be used. 
	 */
	public void loadProduct(String productName) {
		for(Product product : products) {
			if(product.getProductName().equalsIgnoreCase(productName)) {
			currentProduct = product;
			return;
			}
		}
		
		throw new IllegalArgumentException("Product not available");
	}
	
	/**
	 * Checks if any of the products are duplicates 
	 * @param product The product to be checked
	 */
	private void isDuplicateProduct(String product) {
		
	}
	
	/**
	 * Creates an array to display the fields that describe a task 
	 * @return 2D String array that is used to populate the TaskTableModel
	 */
	public String[][] getTasksAsArray(){
		if(currentProduct == null) {
			return new String[0][0];
		}
		
		List<Task> tasks = currentProduct.getTasks();
		String [][] taskArray = new String [tasks.size()][4];
		
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			taskArray[i][0] = Integer.toString(task.getTaskId());
			taskArray[i][1] = task.getStateName();
			taskArray[i][2] = task.getTypeLongName();
			taskArray[i][3] = task.getTitle();
		}
		
		return taskArray;
	}
	
	/**
	 * Gets the Task with the specific ID
	 * @param taskId The ID of the task
	 * @return The task with the given ID
	 */
	public Task getTaskById(int taskId) {
		if(currentProduct == null) {
			return null;
		}
		
		List<Task> tasks = currentProduct.getTasks();
		for(Task task : tasks) {
			if(task.getTaskId() == taskId) {
				return task;
			}
		}
		
		return null;
	}
	
	/**
	 * Execute the command according to the task ID
	 * @param taskId The task ID
	 * @param c The command to be executed 
	 */
	public void executeCommand(int taskId, Command c) {
		if(currentProduct == null) {
			return;
		}
		
		List<Task> tasks = currentProduct.getTasks();
		for(Task task : tasks) {
			if(task.getTaskId() == taskId) {
				executeCommand(taskId, c);
				return;
			}
		}
	}
	
	/**
	 * Deletes a task according to the ID
	 * @param taskId The ID of the task to be deleted
	 */
	public void deleteTaskById(int taskId) {
		if(currentProduct == null) {
			return;
		}
		
		List<Task> tasks = currentProduct.getTasks();
		for(Task task : tasks) {
			if(task.getTaskId() == taskId) {
				tasks.remove(taskId);
				return;
			}
		}
	}
	
	/**
	 * Adds a task to the List of tasks related to an specific Product
	 * @param title The title of the task
	 * @param type The type of task 
	 * @param creator The creator of the task
	 * @param owner The owner of the task
	 */
	public void addTaskToProduct(String title, Type type, String creator, String owner) {
		if(currentProduct == null) {
			return;
		}
	}
	
	/**
	 * Gets the Name of the Product
	 * @return The product name for the Current Product
	 */
	public String getProductName() {
		if(currentProduct != null) {
			return currentProduct.getProductName();
		}
		
		return null;
	}
	
	/**
	 * Gets an array with the product names
	 * @return An array with the List of Products 
	 */
	public String[] getProductList() {
		String[] productList = new String [products.size()];
		
		for(int i = 0; i < products.size(); i++) {
			productList[i] = products.get(i).getProductName();
		}
		
		return productList;
	}
	
	/**
	 * Resets products to an empty list
	 */
	public void clearProducts() {
		products.clear();
		currentProduct = null;
	}
	
	/**
	 * Updates the currentProduct’s name to the given value. 
	 * @param updateName The updated name of the Product
	 */
	public void editProduct(String updateName) {
		if(currentProduct == null) {
			throw new IllegalArgumentException ("No product selected");
		}
		
		if(updateName == null || updateName.isEmpty()) {
			throw new IllegalArgumentException("Invalid Product name.");
		}
		
		String updateNameLower = updateName.toLowerCase();
		
		for (Product product : products) {
			if(product != currentProduct && product.getProductName().toLowerCase().equals(updateNameLower)) {
			throw new IllegalArgumentException("Product name already exists.");
			}
		}
		
		currentProduct.setProductName(updateName);
	}
	
	/**
	 * Creates a new Product with the given name and adds it to the end of the products list.
	 * @param productName The name of the Product to be added to the list.
	 */
	public void addProduct(String productName) {
		if(productName == null || productName.isEmpty()) {
			throw new IllegalArgumentException("Invalid product name.");
		}
		
		String productNameLower = productName.toLowerCase();
		
		for (Product product : products) {
			if (product.getProductName().toLowerCase().equals(productNameLower)) {
				throw new IllegalArgumentException("Invalid product name.");
			}
		}
		
		Product newProduct = new Product(productName);
		products.add(newProduct);
		loadProduct(productName);
	}
	/**
	 * Deletes the currentProduct
	 */
	public void deleteProduct() {
		if(currentProduct == null) {
			throw new IllegalArgumentException("No product selected");
		}
		
		products.remove(currentProduct);
		
		if(products.isEmpty()) {
			currentProduct = null;
		} else {
			currentProduct = products.get(0);
		}
	}
	
	/**
	 * Resets the Backlog Manager 
	 */
	protected void resetManager() {
		// TODO Auto-generated method stub
	}
}
