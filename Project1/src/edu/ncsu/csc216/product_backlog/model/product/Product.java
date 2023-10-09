package edu.ncsu.csc216.product_backlog.model.product;

import java.util.List;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Concrete class that maintains a its name and a list of associated Tasks.
 */
public class Product {
	
	/** Product's name*/
	private String productName;
	/** Keeps count of the number of products*/
	private int counter; 
	
	/**
	 * Constructor for the Product class
	 * @param productName The name of the product
	 */
	public Product(String productName) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Sets the name of the product 
	 * @param productName the name of the product
	 */
	public void setProductName(String productName) {
		 /** intentionally left empty */
	}
	
	/**
	 * Gets the name of the product
	 * @return the name of the product 
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 *  finds the largest task id in the task list 
	 *  and sets the counter field to the max + 1.
	 */
	private void setTaskCounter() {
		 /** intentionally left empty */
	}
	
	/**
	 * Creates an empty List for tasks
	 */
	private void emptyList() {
		 /** intentionally left empty */
	}
	
	/**
	 * Adds the task to the list in sorted order by id
	 * @param task The task to be added to the list
	 */
	public void addTask (Task task) {
		 /** intentionally left empty */
	}
	
	/**
	 * Creates a new Task from the given information.
	 * @param title The title of the task
	 * @param type The type of task
	 * @param creator The creator of the task
	 * @param note The note describing the task
	 */
	public void addTask(String title, Type type, String creator, String note) {
		 /** intentionally left empty */
	}
	
	/**
	 * Gets a list of tasks related to a product
	 * @return The list of tasks
	 */
	public List<Task> getTasks(){
		return null;
	}
	
	/**
	 * Gets a task by their ID
	 * @param id The task ID
	 * @return The task that matched the id
	 */
	public Task getTaskById(int id) {
		return null;
	}
	
	/**
	 * FindS the Task with the given id and updates it by passing in the given Command
	 * @param id The ID of the task
	 * @param c The command to be passed
	 */
	public void executeCommand ( int id, Command c) {
		 /** intentionally left empty */
	}
	
	/**
	 * Removes the Task with the given id from the list.
	 * @param id The ID of the task to be removed
	 */
	public void deleteTaskById (int id) {
		 /** intentionally left empty */
	}
	
}
