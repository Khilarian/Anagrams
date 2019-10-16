import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Kirill Rumakin
 * @since 16.10.2019
 * 
 * This class combines all types of operation in one.
 *
 */
public class Mutator {

	private String result;
	
	private Map<String, Operation> operation = new HashMap<String,Operation>();
	
	public Mutator() {
		this.load(new AnagramOnlyChar());
	}
	
	private void load(Operation operation) {
		this.operation.put(operation.operation(), operation);
	}
	
	public void mutateText(Text text, String operation) {
		result = this.operation.get(operation).handleText(text);
	}
	
	public String getResult() {
		return result;
	}
}
