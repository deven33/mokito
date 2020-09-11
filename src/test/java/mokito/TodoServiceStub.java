package mokito;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{

	public List<String> retrievetodo(String user) {
		return Arrays.asList("MVC Spring", "Hibernate","Spring Boot");
	}

}
