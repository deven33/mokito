package powermock;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//step 1  initialize Runner
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {
	// prepare Test => the class using the constructor to create the object  (ArrayList.class)
	//Override the constructor
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Mock
	ArrayList mockList;

	// power Mock
	@Test
	public void testRetrieveTodoRelatedtoSpring_usingPowerMock() throws Exception {
		
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(mockList.size()).thenReturn(2);
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		System.out.println(size);
	}


}