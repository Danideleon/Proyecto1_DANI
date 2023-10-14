package edu.ncsu.csc216.product_backlog.model.product;

import java.util.ArrayList;
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
	private int counter = 1; 
	/** List of tasks **/
	private List<Task> taskList;
	
	/**
	 * Constructor for the Product class
	 * @param productName The name of the product
	 */
	public Product(String productName) {
		setProductName(productName);
		emptyList();
		setTaskCounter();
	}
	
	/**
	 * Sets the name of the product 
	 * @param productName the name of the product
	 */
	public void setProductName(String productName) {
		 if(productName == null || productName.isEmpty()) {
			 throw new IllegalArgumentException ("Invalid product Name");
		 }
		 this.productName = productName;
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
		 int maxId = 0;
		 
		 //Find the max task ID in the task list
		 for (Task task : taskList) {
			 int taskId = task.getTaskId();
			 if (taskId > maxId) {
				 maxId = taskId;
			 }
		 }
		 
		 //set the task counter to the max ID + 1
		 counter = maxId + 1;
		 
		 //If the list is empty, set the counter to 1
		 if(maxId == 0) {
			 counter = 1;
		 }
	}
	
	/**
	 * Creates an empty List for tasks
	 */
	private void emptyList() {
		taskList = new ArrayList<>(); 
	}
	
	/**
	 * Adds the task to the list in sorted order by id
	 * @param task The task to be added to the list
	 */
	public void addTask (Task task) {
		 //Check if a task with the same id already exists
		 for(Task existingTask : taskList) {
			 if (existingTask.getTaskId() == task.getTaskId()) {
				 throw new IllegalArgumentException("Task cannot be added.");
			 }
		 }

		 int index = 0;
		//Find the index to insert the new task while maintaining sorted order
		for(Task existingTask : taskList) {
			if(task.getTaskId() > existingTask.getTaskId()) {
				index++;
			} else {
				break;
			}
		}
		
		//Add task at calculated index
		taskList.add(index, task);
	}
	
	/**
	 * Creates a new Task from the given information.
	 * @param title The title of the task
	 * @param type The type of task
	 * @param creator The creator of the task
	 * @param note The note describing the task
	 */
	public void addTask(String title, Type type, String creator, String note) {
		 //Create a new task with the next available id
		Task newTask = new Task (counter, title, type, creator, note);
		 
		addTask(newTask);
		 
	}
	
	/**
	 * Gets a list of tasks related to a product
	 * @return The list of tasks
	 */
	public List<Task> getTasks(){
		return taskList;
	}
	
	/**
	 * Gets a task by their ID
	 * @param id The task ID
	 * @return The task that matched the id
	 */
	public Task getTaskById(int id) {
		for (Task task : taskList) {
			if (task.getTaskId() == id) {
				return task;
			}
		}
		
		//if no task with given ID found
		return null;
	}
	
	/**
	 * FindS the Task with the given id and updates it by passing in the given Command
	 * @param id The ID of the task
	 * @param c The command to be passed
	 */
	public void executeCommand ( int id, Command c) {
		 Task taskToUpdate = getTaskById(id);
		 
		 taskToUpdate.update(c);
	}
	
	/**
	 * Removes the Task with the given id from the list.
	 * @param id The ID of the task to be removed
	 */
	public void deleteTaskById (int id) {
		Task taskToRemove = getTaskById(id);
		
		if(taskToRemove != null) {
			taskList.remove(taskToRemove);
		}
	}
	
}
