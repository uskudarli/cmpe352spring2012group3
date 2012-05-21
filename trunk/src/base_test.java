import static org.junit.Assert.*;

import org.junit.Test;


public class base_test {

	@Test
	public void test() {
		Base tester = new Base();
		assertEquals("Result", false, tester.isPrime(3));
		
		assertEquals("Result", true, tester.isPrime(7));
		
		assertEquals("Result", false, tester.isPrime(1));
      
		assertEquals("Result", false, tester.isPrime(-18));
	}

}
