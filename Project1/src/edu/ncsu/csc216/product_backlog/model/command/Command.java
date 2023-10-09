/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.command;

/**
 * Command class creates objects that encapsulate user actions (or inputs)
 * that cause transitions to state of a Task to update.
 */
public class Command {
	
	/**A note describing a task*/
	private String note;
	/**The owner of the task*/
	private String owner;
	/**Error message if command is invalid*/
	private static final String COMMAND_ERROR_MESSAGE = "Invalid command";
	/**Enumeration for the type of commands*/
	public enum CommandValue {BACKLOG, CLAIM, PROCESS, VERIFY, COMPLETE, REJECT};

	/**
	 * Constructor for the Command class
	 * @param c The value of the command
	 * @param owner The owner of the task
	 * @param noteText The text describing the task
	 * @throws IllegalArgumentException If Command Value is null
	 * @throws IllegalArgumentException If NoteText is null or empty
	 * @throws IllegalArgumentException If Command Value is not equal to CLAIM and owner is null or empty
	 * @throws IllegalArgumentException If Command Value is equal to CLAIM and owner is null or empty 
	 */
	public Command(CommandValue c, String owner, String noteText) {
		if(c == null) {
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		}
		
		if(noteText == null || noteText.isEmpty()) {
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		}
		
		if (c != CommandValue.CLAIM && owner != null) {
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		}
		
		if(c == CommandValue.CLAIM && (owner == null || owner.isEmpty())) {
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		}
		
		this.note = noteText;
		this.owner = owner;
		
	}

	/**
	 * Gets the Command for the task
	 * @return the command associated with the task
	 */
	public CommandValue getCommand() {
		CommandValue c = null;
		return c;
	}
	
	/**
	 * Gets the note for the task
	 * @return the note for the task in text form
	 */
	public String getNoteText() {
		return note;
	}
	
	/**
	 * Gets the owner of the task
	 * @return the id of the task owner
	 */
	public String getOwner() {
		return owner;
	}
}
