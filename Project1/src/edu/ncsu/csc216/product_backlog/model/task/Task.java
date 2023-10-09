package edu.ncsu.csc216.product_backlog.model.task;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;

/**
 * Concrete class that represents a task tracked in the Product Backlog system.
 */
public class Task {
	
	/**Id for a task*/
	private int taskId;
	/**The title of the task*/
	private String title;
	/**The creator of the task*/
	private String creator;
	/**The owner of the task*/
	private String owner;
	/**True if the task has been verified by another member*/
	private boolean isVerified;
	/**A list of notes related to the task*/
	private ArrayList<String> notes;
	/**The possible type of tasks*/
	public enum Type { FEATURE, BUG, TECHNICAL_WORK, KNOWLEDGE_ACQUISITION };
	/**A constant string for the backlog state’s name*/
	public static final String BACKLOG_NAME = "Backlog";
	/**A constant string for the owned state’s name*/
	public static final String OWNED_NAME = "Owned";
	/**A constant string for the processing state’s name*/
	public static final String PROCESSING_NAME = "Processing";
	/**A constant string for the verifying state’s name*/
	public static final String VERIFYING_NAME = "Verifying";
	/** A constant string for the done state’s name*/
	public static final String DONE_NAME = "Done";
	/**A constant string for the rejected state’s name*/
	public static final String REJECTED_NAME = "Rejected";
	/**A constant string for the feature type*/
	public static final String FEATURE_NAME = "Feature";
	/**A constant string for the bug type */
	public static final String BUG_NAME = "Bug";
	/**A constant string for the technical work type */
	public static final String TECHNICAL_WORK_NAME = "Technical Work";
	/**A constant string for the knowledge acquisition type*/
	public static final String KNOWLEDGE_ACQUISITION_NAME = "Knowledge Acquisition";
	/**Initial for feature type*/
	public static final String T_FEATURE = "F";
	/**Initial for Bug Type*/
	public static final String T_BUG = "B";
	/**Initial for Technical Work type*/
	public static final String T_TECHNICAL_WORK = "TW";
	/**Initial for Knowledge Acquisition Type*/
	public static final String T_KNOWLEDGE_ACQUISITION = "KA";
	/**A constant String for a task without an owner*/
	public static final String UNOWNED = "unowned";
	
	/**
	 * Interface for states in the Task State Pattern.  All 
	 * concrete task states must implement the TaskState interface.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface TaskState {
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command c);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();
	
	}
	
	/**
	 * Concrete class that represents the backlog state of the Task 
	 */
	private class BacklogState implements TaskState{

		@Override
		public void updateState(Command c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * Concrete class that represents the owned state of the Task
	 */
	private class OwnedState implements TaskState{

		@Override
		public void updateState(Command c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	} 
	
	/**
	 * Concrete class that represents the verifying state of the Task
	 */
	private class VerifyingState implements TaskState{

		@Override
		public void updateState(Command c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * Concrete class that represents the processing state of the Task 
	 */
	private class ProcessingState implements TaskState {

		@Override
		public void updateState(Command c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * Concrete class that represents the done state of the Task
	 */
	private class DoneState implements TaskState{

		@Override
		public void updateState(Command c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * Concrete class that represents the canceled state of the Task 
	 */
	private class RejectedState implements TaskState{

		@Override
		public void updateState(Command c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * Constructs a Task from the provided id, title, creator, and note. 
	 * @param taskId The ID of the task
	 * @param title The title of the task
	 * @param type The type of task
	 * @param creator The creator of the task
	 * @param note The description of the task
	 */
	public Task(int taskId, String title, Type type, String creator, String note) {
		if(taskId == 0 || taskId < 0) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		if(title == null || creator == null || note == null) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		if (title.isEmpty() || creator.isEmpty() || note.isEmpty()) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		
		setTaskId(taskId);
	}
	
	/**
	 * Constructs a Task by providing all field values.
	 * @param taskId The ID for the task
	 * @param state The state of the task
	 * @param title The title of the task
	 * @param type The type of task
	 * @param creator The creator of the task
	 * @param owner The owner of the task
	 * @param verified If the task if verified 
	 * @param notes The notes describing the task
	 */
	public Task(int taskId, String state, String title, String type, String creator, String owner, String verified, ArrayList <String> notes){
		 /** intentionally left empty */
	}
	
	/**
	 * Sets the ID for the task
	 * @param taskId the ID for the task
	 */
	private void setTaskId (int taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * Sets the title for the task
	 * @param title the title for the task
	 */
	private void setTitle (String title) {
		this.title = title;
	}
	
	/**
	 * Sets the type of task
	 * @param type The type of task
	 */
	private void setType (Type type) {
		/**intentionally left empty*/
	}
	
	/**
	 * Sets the creator for the task
	 * @param creator the creator for the task
	 */
	private void setCreator (String creator) {
		this.creator = creator;
	}
	
	/**
	 * Sets the owner of the task
	 * @param owner the owner of the task
	 */
	private void setOwner (String owner) {
		 this.owner = owner;
	}
	
	/**
	 * Sets if the task has been verified or not
	 * @param verified if the task has been verified
	 */
	private void setVerified (String verified) {
		 /** intentionally left empty */
	}
	
	/**
	 * 	Sets the list of notes for the task
	 * @param notes The list of notes that describes the task
	 */
	private void setNotes(ArrayList<String> notes) {
		 /** intentionally left empty */
	}
	
	/**
	 * Method adds a note of type String to the list 
	 * @param note A note of type String
	 * @return the number of the notes on the list
	 */
	public int addNoteToList(String note) {
		return 1;
	}
	
	/**
	 * Gets the task ID
	 * @return The task ID
	 */
	public int getTaskId() {
		return 1;
	}
	
	/**
	 * Gets the State Name of the Task
	 * @return The State of the task
	 */
	public String getStateName() {
		return null;
	}
	
	/**
	 * Sets the State of the task
	 * @param state The state of the task
	 */
	private void setState(String state) {
		 /** intentionally left empty */
	}
	
	/**
	 * Sets the type of task from a String
	 * @param type The type of task in String form
	 */
	private void setTypeFromString(String type) {
		 /** intentionally left empty */
	}
	
	/**
	 * Gets the type of task
	 * @return The type of task
	 */
	public Type getType() {
		return null;
	}
	
	/**
	 * Gets the short version of the task type
	 * @return The short version of the task type
	 */
	public String getTypeShortName() {
		return null;
	}
	
	/**
	 * Gets the long version of the Type of task
	 * @return The long version of the type of task
	 */
	public String getTypeLongName() {
		return null;
	}
	
	/**
	 * Gets the owner of the task
	 * @return The task owner
	 */
	public String getOwner() {
		return null;
	}
	
	/**
	 * Gets the title of the task
	 * @return The title of the task
	 */
	public String getTitle() {
		return null;
	}
	
	/**
	 * Gets the creator of the task
	 * @return The creator of the task
	 */
	public String getCreator() {
		return null;
	}
	
	/**
	 * Checks if the task has been verified by another member of the team
	 * @return True if the task has been verified or false if it has not been verified.
	 */
	public boolean isVerified() {
		return false;
	}
	
	/**
	 * Gets the list of notes describing a task
	 * @return The list of notes describing a task
	 */
	public ArrayList<String> getNotes(){
		return null;
	}
	
	/**
	 * Gets the Notes in the list related to a task
	 * @return The notes in the list related to a task
	 */
	public String getNotesList() {
		return null;
	}
	
	/**
	 * Creates a string representation of the task
	 * @return A string representation of the task
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * Updates the state of the task when it transitions from one state to the other
	 * @param c The command to transition between one state to another.
	 */
	public void update(Command c) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Gets the array of notes related to a task
	 * @return A String array with the notes describing the task
	 */
	public String[] getNotesArray() {
		return null;
	}
	
}
