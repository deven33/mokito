package mokito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BusinessImplMockTest {

	@Test
	public void testRetrieveTodoRelatedtoSpring_usingMock() {
		
		List<String> todos = Arrays.asList("MVC Spring", "Hibernate","Spring Boot");
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrievetodo("Dummy")).thenReturn(todos);
		BusinessImpl businessImpl = 
				new BusinessImpl(todoServiceMock);
		List<String> filteredTodo = businessImpl.retrieveTodoRelatedtoSpring("Dummy");
		assertEquals(2, filteredTodo.size());
	}

}
