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
	/**Current State of the task**/
	private TaskState currentState;
	/**The creator of the task*/
	private String creator;
	/**Type of task**/
	private Type taskType;
	/**The owner of the task*/
	private String owner;
	/**True if the task has been verified by another member*/
	private boolean isVerified;
	/**A list of notes related to the task*/
	private ArrayList<String> notes;
	/**The possible type of tasks*/
	public enum Type {FEATURE, BUG, TECHNICAL_WORK, KNOWLEDGE_ACQUISITION };
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
	private TaskState backlogState = new BacklogState();
	private TaskState ownedState = new OwnedState();
	private TaskState processingState = new ProcessingState();
	private TaskState verifyingState = new VerifyingState();
	private TaskState doneState = new DoneState();
	private TaskState rejectedState = new RejectedState();
	
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
		 * valid action for the given state.  
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

		private String stateName;
		
		private BacklogState() {
			this.stateName = BACKLOG_NAME;
		}
		
		@Override
		public void updateState(Command c) {
			switch(c.getCommand()) {
			case CLAIM:
				currentState = ownedState;
				break;
			case REJECT:
				currentState = rejectedState;
				break;
			default:
				throw new UnsupportedOperationException("Invalid Command");
			}		
		}

		@Override
		public String getStateName() {
			return stateName;
		}
		
	}
	
	/**
	 * Concrete class that represents the owned state of the Task
	 */
	private class OwnedState implements TaskState{

		private String stateName;
		
		private OwnedState() {
			this.stateName = OWNED_NAME;
		}
		@Override
		public void updateState(Command c) {
			switch(c.getCommand()) {
			case PROCESS:
				currentState = processingState;
				break;
			case REJECT:
				currentState = rejectedState;
				break;
			case BACKLOG:
				currentState = backlogState;
				break;
			default:
				throw new UnsupportedOperationException("Invalid Command");
			}
			
		}

		@Override
		public String getStateName() {
			return stateName;
		}
		
	} 
	
	/**
	 * Concrete class that represents the verifying state of the Task
	 */
	private class VerifyingState implements TaskState{

		private String stateName;
		
		private VerifyingState() {
			this.stateName = VERIFYING_NAME;
		}
		@Override
		public void updateState(Command c) {
			switch(c.getCommand()) {
			case COMPLETE:
				currentState = doneState;
				break;
			case PROCESS:
				currentState = processingState;
				break;
			default:
				throw new UnsupportedOperationException("Invalid Command");
			}
			
		}

		@Override
		public String getStateName() {
			return stateName;
		}
		
	}
	
	/**
	 * Concrete class that represents the processing state of the Task 
	 */
	private class ProcessingState implements TaskState {

		private String stateName;
		
		private ProcessingState() {
			this.stateName = PROCESSING_NAME;
		}
		@Override
		public void updateState(Command c) {
			switch(c.getCommand()) {
			case PROCESS:
				currentState = processingState;
				break;
			case VERIFY:
				currentState = verifyingState;
				break;
			case COMPLETE:
				currentState = doneState;
				break;
			case BACKLOG:
				currentState = backlogState;
				break;
			default:
				throw new UnsupportedOperationException("Invalid Command");
			}
			
		}

		@Override
		public String getStateName() {
			return stateName;
		}
		
	}
	
	/**
	 * Concrete class that represents the done state of the Task
	 */
	private class DoneState implements TaskState{

	private String stateName;
		
		private DoneState() {
			this.stateName = DONE_NAME;
		}
		@Override
		public void updateState(Command c) {
			switch(c.getCommand()) {
			case PROCESS:
				currentState = processingState;
				break;
			case BACKLOG:
				currentState = backlogState;
				break;
			default:
				throw new UnsupportedOperationException("Invalid Command");
			}
			
		}

		@Override
		public String getStateName() {
			return stateName;
		}
		
	}
	
	/**
	 * Concrete class that represents the canceled state of the Task 
	 */
	private class RejectedState implements TaskState{

	private String stateName;
		
		private RejectedState() {
			this.stateName = REJECTED_NAME;
		}
		@Override
		public void updateState(Command c) {
			switch(c.getCommand()) {
			case BACKLOG:
				currentState = backlogState;
				break;
			default:
				throw new UnsupportedOperationException("Invalid Command");
			}
			
		}

		@Override
		public String getStateName() {
			return stateName;
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
		setTaskId(taskId);
		setTitle(title);
		setType(type);
		setCreator(creator);
		
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
		 setTaskId(taskId);
		 setState(state);
		 setTitle(title);
		 setTypeFromString(type);
		 setCreator(creator);
		 setOwner(owner);
		 setVerified(verified);
		 setNotes(notes);
		 	 
	}
	
	/**
	 * Sets the ID for the task
	 * @param taskId the ID for the task
	 */
	private void setTaskId (int taskId) {
		if(taskId <= 0) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.taskId = taskId;
	}
	
	/**
	 * Sets the title for the task
	 * @param title the title for the task
	 */
	private void setTitle (String title) {
		if(title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.title = title;
	}
	
	/**
	 * Sets the type of task
	 * @param type The type of task
	 */
	private void setType (Type type) {
		this.taskType = type; 
	}
	
	/**
	 * Sets the creator for the task
	 * @param creator the creator for the task
	 */
	private void setCreator (String creator) {
		if(creator == null || creator.isEmpty()) {
			throw new IllegalArgumentException("Invalid task information.");
		}
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
		if(isVerified == true) {
			verified = "True";
		}
		if(isVerified == false) {
			verified = "False";
		}
	}
	
	/**
	 * 	Sets the list of notes for the task
	 * @param notes The list of notes that describes the task
	 */
	private void setNotes(ArrayList<String> notes) {
		 this.notes = notes;
	}
	
	/**
	 * Method adds a note of type String to the list 
	 * @param note A note of type String
	 * @return the number of the notes on the list
	 */
	public int addNoteToList(String note) {
		if(note == null || note.isEmpty()) {
			throw new IllegalArgumentException("Invalid task information.");	
		}
		else {
			String finalNote = "[" + currentState + "] " + note;
			notes.add(finalNote);
			return notes.size();
		}
		
	}
	
	/**
	 * Gets the task ID
	 * @return The task ID
	 */
	public int getTaskId() {
		return this.taskId;
	}
	
	/**
	 * Gets the State Name of the Task
	 * @return The State of the task
	 */
	public String getStateName() {
		String stateName;
		try {
			stateName = currentState.getStateName();
		} catch(UnsupportedOperationException e) {
			throw e;
		}
		return stateName;
	}
	
	/**
	 * Sets the State of the task
	 * @param state The state of the task
	 */
	private void setState(String state) {
		switch(state) {
		case BACKLOG_NAME :
			currentState = backlogState;
			break;
		case OWNED_NAME :
			currentState = ownedState;
			break;
		case PROCESSING_NAME :
			currentState = processingState;
			break;
		case VERIFYING_NAME :
			currentState = verifyingState;
			break;
		case DONE_NAME :
			currentState = doneState;
			break;
		case REJECTED_NAME :
			currentState = rejectedState;
			break;
		default:
			throw new IllegalArgumentException("Invalid task information");
		}
	}
	
	/**
	 * Sets the type of task from a String
	 * @param type The type of task in String form
	 */
	private void setTypeFromString(String type) {
		switch(type) {
		case FEATURE_NAME:
			taskType = Type.FEATURE;
			break;
		case BUG_NAME :
			taskType = Type.BUG;
			break;
		case TECHNICAL_WORK_NAME :
			taskType = Type.TECHNICAL_WORK;
			break;
		case KNOWLEDGE_ACQUISITION_NAME :
			taskType = Type.KNOWLEDGE_ACQUISITION;
			break;
		default:
			throw new IllegalArgumentException("Invalid task information");
		}
	}
	
	/**
	 * Gets the type of task
	 * @return The type of task
	 */
	public Type getType() {
		return this.taskType;
	}
	
	/**
	 * Gets the short version of the task type
	 * @return The short version of the task type
	 */
	public String getTypeShortName() {
		switch (taskType) {
		case FEATURE :
			return T_FEATURE;
		case BUG :
			return T_BUG;
		case TECHNICAL_WORK : 
			return T_TECHNICAL_WORK;
		case KNOWLEDGE_ACQUISITION:
			return T_KNOWLEDGE_ACQUISITION;
		default:
			throw new IllegalArgumentException("Invalid task information");
		}
	}
	
	/**
	 * Gets the long version of the Type of task
	 * @return The long version of the type of task
	 */
	public String getTypeLongName() {
		switch (taskType) {
		case FEATURE :
			return FEATURE_NAME;
		case BUG :
			return BUG_NAME;
		case TECHNICAL_WORK : 
			return TECHNICAL_WORK_NAME;
		case KNOWLEDGE_ACQUISITION:
			return KNOWLEDGE_ACQUISITION_NAME;
		default:
			throw new IllegalArgumentException("Invalid task information");
		}
	}
	
	/**
	 * Gets the owner of the task
	 * @return The task owner
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * Gets the title of the task
	 * @return The title of the task
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Gets the creator of the task
	 * @return The creator of the task
	 */
	public String getCreator() {
		return this.creator;
	}
	
	/**
	 * Checks if the task has been verified by another member of the team
	 * @return True if the task has been verified or false if it has not been verified.
	 */
	public boolean isVerified() {
		if(currentState == doneState || currentState == processingState) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gets the list of notes describing a task
	 * @return The list of notes describing a task
	 */
	public ArrayList<String> getNotes(){
		return this.notes;
	}
	
	/**
	 * Gets the Notes in the list related to a task
	 * @return The notes in the list related to a task
	 */
	public String getNotesList() {
		String noteString = "";
		
		for(String note : notes) {
			noteString += note + "\n";
		}
		
		return noteString;
	}
	
	@Override
	public String toString() {
		return taskId + "," + currentState + "," + title + "," + getTypeShortName() + "," + creator + "," + owner + "," + isVerified;
	}
	
	/**
	 * Updates the state of the task when it transitions from one state to the other
	 * @param c The command to transition between one state to another.
	 */
	public void update(Command c) {
		try {
			currentState.updateState(c);
		} catch(UnsupportedOperationException e) {
			throw e;
		}
	}
	
	/**
	 * Gets the array of notes related to a task
	 * @return A String array with the notes describing the task
	 */
	public String[] getNotesArray() {
		String[] notesArray = new String[notes.size()];
		
		for(int i = 0; i < notes.size(); i++) {
			notesArray[i] = notes.get(i);
		}
		return notesArray;
	}
	
}
