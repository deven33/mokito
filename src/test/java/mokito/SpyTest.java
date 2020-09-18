package mokito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void testSpy() {
		//Spy os like new keyword
		//events are really happen on spy opject unlike mock object
		//add new element on spy is real insertion in arraylist object
		//if we add element in mock arraylist then it wont added really
		List arrayListSpy = spy(ArrayList.class);
		//List arrayListmock = mock(ArrayList.class);
		arrayListSpy.add("Dummy");
		//arrayListmock.add("Dummy");
		verify(arrayListSpy).add("Dummy");
		//verify(arrayListmock).add("Dummy");
	}

}
