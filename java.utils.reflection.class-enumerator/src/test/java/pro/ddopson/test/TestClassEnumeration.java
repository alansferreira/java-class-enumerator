package pro.ddopson.test;

import pro.ddopson.ClassEnumerator;
import java.util.List;

import org.junit.Test;


public class TestClassEnumeration {
	@Test
	public void testFindByPackage() {
		System.out.println("Test class package name: "+TestClassEnumeration.class.getPackage());
		List<Class<?>> classes = ClassEnumerator.getClassesForPackage(TestClassEnumeration.class.getPackage());
		Class<?>[] expected = new Class<?>[] {
			pro.ddopson.test.ClassIShouldFindOne.class,
			pro.ddopson.test.ClassIShouldFindTwo.class,
			pro.ddopson.test.subpkg.ClassIShouldFindThree.class,
			TestClassEnumeration.class,
			TestClassEnumerationFindAll.class
		};
		
		for (Class<?> clazz : expected) {
			if (!classes.contains(clazz)) {
				assert false;
				System.out.println("FAIL: expected to find class '" + clazz.getName() + "'");
				return;
			}
		}
		if(classes.size() != expected.length) {
			assert false;
			System.out.println("FAIL: expected to find " + expected.length + " classes, but actually found " + classes.size());
			return;
		}
		
		assert true;
	}
}
