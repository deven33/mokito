package mokito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class BusinessImplMockTest {

	// USing Simple Mock
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

	
// USing BDD- its make test more readable

@Test
public void testRetrieveTodoRelatedtoSpring_usingBDDMock() {
	
	//Given
	List<String> todos = Arrays.asList("MVC Spring", "Hibernate","Spring Boot");
	TodoService todoServiceMock = mock(TodoService.class);
	given(todoServiceMock.retrievetodo("Dummy")).willReturn(todos);
	BusinessImpl businessImpl = 
			new BusinessImpl(todoServiceMock);
	
	//when
	List<String> filteredTodo = businessImpl.retrieveTodoRelatedtoSpring("Dummy");
	
	//then
	assertThat(filteredTodo.size(), is(2));
}


//verify method call 

	@Test
	public void testDeleteodoRelatedtoSpring_usingBDD() {

		//Given
		List<String> todos = Arrays.asList("MVC Spring", "Hibernate","Spring Boot");
		TodoService todoServiceMock = mock(TodoService.class);
		given(todoServiceMock.retrievetodo("Dummy")).willReturn(todos);
		BusinessImpl businessImpl = 
				new BusinessImpl(todoServiceMock);
		
		//when
		businessImpl.deleteTodoNotRelatedtoSpring("Dummy");
		
		//then    then is similar to varify
			verify(todoServiceMock).todoDelete("Spring Boot");
			
			// 2nd approach to verify
			verify(todoServiceMock, never()).todoDelete("Spring Boot");
			// will be true is function callled 2 times
			verify(todoServiceMock, times(2)).todoDelete("Hibernate");
	}
	
	
	//Argument Captor 

		@Test
		public void testDeleteodoRelatedtoSpring_ArgumentCaptor() {
			//Declare Argument Captor
			ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
			
			//Given
			List<String> todos = Arrays.asList("MVC Spring", "Hibernate","Spring Boot");
			TodoService todoServiceMock = mock(TodoService.class);
			given(todoServiceMock.retrievetodo("Dummy")).willReturn(todos);
			BusinessImpl businessImpl = 
					new BusinessImpl(todoServiceMock);
			
			//when
			businessImpl.deleteTodoNotRelatedtoSpring("Dummy");
			
			//then    then is similar to varify
					//define argument captor for specific method call
			then(todoServiceMock).should().todoDelete(argumentCaptor.capture());
					//capture the argument
			System.out.println(argumentCaptor.getValue());
			System.out.println(argumentCaptor.getAllValues().size());
			assertThat(argumentCaptor.getValue(), is("Hibernate"));
			assertThat(argumentCaptor.getAllValues().size(), is(1));
		}

}