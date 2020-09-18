package powermock;


import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.*;
import org.powermock.modules.junit4.PowerMockRunner;

//step 1  initialize Runner
@RunWith(PowerMockRunner.class)
public class MockingPrivateMethodsTest {
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;

	// power Mock
	@Test
	public void testPrivateMethodCall_usingPowerMock() throws Exception {
		
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		//int result = systemUnderTest.privateMethodUnderTest();  // can't import private
		
		// injecttor name and private method name
		long result = (Long)Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		System.out.println(result);
	}


}