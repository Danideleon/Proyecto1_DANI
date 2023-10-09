/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.backlog;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Concrete class that maintains a list of Products, the active 
 * or current Product,and handles events from the GUI.
 */
public class BacklogManager {
	
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
		return null;	
	}
	
	/**
	 * WriteS the Products to the file using the ProductsWriter class.
	 * @param filename The name of the file to be written on.
	 */
	public void saveToFile(String filename) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Uses the ProductsReader to read the given fileName
	 * @param filename The name of the file to be read from
	 */
	public void loadFromFile(String filename) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Find the Product with the given name in the list, make it the active or currentProduct.
	 * @param productName The name of the product to be used. 
	 */
	public void loadProduct(String productName) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Checks if any of the products are duplicates 
	 * @param product The product to be checked
	 */
	private void isDuplicateProduct(String product) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Creates an array to display the fields that describe a task 
	 * @return 2D String array that is used to populate the TaskTableModel
	 */
	public String[][] getTasksAsArray(){
		return null;
	}
	
	/**
	 * Gets the Task with the specific ID
	 * @param taskId The ID of the task
	 * @return The task with the given ID
	 */
	public Task getTaskById(int taskId) {
		return null;
	}
	
	/**
	 * Execute the command according to the task ID
	 * @param taskId The task ID
	 * @param c The command to be executed 
	 */
	public void executeCommand(int taskId, Command c) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Deletes a task according to the ID
	 * @param taskId The ID of the task to be deleted
	 */
	public void deleteTaskById(int taskId) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Adds a task to the List of tasks related to an specific Product
	 * @param title The title of the task
	 * @param type The type of task 
	 * @param creator The creator of the task
	 * @param owner The owner of the task
	 */
	public void addTaskToProduct(String title, Type type, String creator, String owner) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Gets the Name of the Product
	 * @return The product name for the Current Product
	 */
	public String getProductName() {
		return null;
	}
	
	/**
	 * Gets an array with the product names
	 * @return An array with the List of Products 
	 */
	public String[] getProductList() {
		return null;
	}
	
	/**
	 * Resets products to an empty list
	 */
	public void clearProducts() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Updates the currentProduct’s name to the given value. 
	 * @param updateName The updated name of the Product
	 */
	public void editProduct(String updateName) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Creates a new Product with the given name and adds it to the end of the products list.
	 * @param productName The name of the Product to be added to the list.
	 */
	public void addProduct(String productName) {
		// TODO Auto-generated method stub
	}
	/**
	 * Deletes the currentProduct
	 */
	public void deleteProduct() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Resets the Backlog Manager 
	 */
	protected void resetManager() {
		// TODO Auto-generated method stub
	}
}
