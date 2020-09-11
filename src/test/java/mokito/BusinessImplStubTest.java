package mokito;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class BusinessImplStubTest {

	@Test
	public void testRetrieveTodoRelatedtoSpring_usingStub() {
		
		TodoService todoServiceStub = new TodoServiceStub();
		BusinessImpl businessImpl = 
				new BusinessImpl(todoServiceStub);
		List<String> filteredTodo = businessImpl.retrieveTodoRelatedtoSpring("Dummy");
		assertEquals(2, filteredTodo.size());
	}

}
