package mokito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcerTest {

	@Test
	public void testHamcrestMatcher() {

		List<Integer> score = Arrays.asList(33, 44, 55, 66);
		//score has 4
		assertThat(score, hasSize(4));
		assertThat(score, hasItem(33));
		assertThat(score, everyItem(greaterThan(20)));
		assertThat(score, everyItem(lessThan(90)));
		
		//String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
	}

}
