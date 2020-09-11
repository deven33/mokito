	package mokito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	// every size() call will return 2
	@Test
	public void testOnetimeReturn() {
		List listMock = mock (List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	// 1st size() return->2 2nd size() return->3
	@Test
	public void testMultiReturn() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	//index 3 will return---> dev
	@Test
	public void testmockListGet() {
		List listMock = mock(List.class);
		when(listMock.get(3)).thenReturn("dev");
		assertEquals("dev", listMock.get(3));
	}
	
	// for any integer index retrun --> dev
	@Test
	public void testmockListGetAnyIndex() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("dev");
		assertEquals("dev", listMock.get(3));
	}
	
	// Exception Test
	@Test(expected = RuntimeException.class)
	public void testmockListException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("any Exception"));
		listMock.get(3);
	}
}
