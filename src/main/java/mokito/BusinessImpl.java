package mokito;

import java.util.ArrayList;
import java.util.List;
// BusinessImpl is SUI
// Todoservice is Dependancy 
public class BusinessImpl {
	private TodoService todoService;

	public BusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodoRelatedtoSpring(String user) {
		List<String> filterTodos = new ArrayList<String>();
		List<String> todos = todoService.retrievetodo(user);
		for(String todo : todos) {
			if(todo.contains("Spring")) {
				filterTodos.add(todo);
			}
		}
		return filterTodos;
	}
}
