/**
 * 
 * @author Kirill Rumakin
 * @since 16.10.2019
 *
 * Interface for all actions for all texts operations;
 *
 */
public interface Operation {

	/*
	 * @return type of operation
	 */
	String operation();
	
	/*
	 * @return result of operation
	 */
	String handleText(Text text);
}
