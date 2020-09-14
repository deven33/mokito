package mokito;

import java.util.List;

public interface TodoService {
	public List<String> retrievetodo(String user);
	
	//for mehod call verification
	
	public void todoDelete(String todo);
}
