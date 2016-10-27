package pro.ddopson.test;

import java.io.File;
import java.util.List;

import org.junit.Test;

import pro.ddopson.ClassEnumeratorFindAll;

public class TestClassEnumerationFindAll {
	@Test
	public void testFindAll() {
		try{
			
			File directory = new File(ClassLoader.getSystemResource("folder").getFile());
			
			System.out.println("Test class location: " );
			List<Class<?>> classes = ClassEnumeratorFindAll.processDirectory(directory);
			System.out.println("Number of classes found in directory file: "+classes.size());
		
			Class<?>[] expected = new Class<?>[] {
				pro.ddopson.ClassEnumerator.class,
				pro.ddopson.ClassEnumeratorFindAll.class,
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
		}catch(Exception ex){
			System.out.println("Exception occured"+ex);
		}
		
		assert true;
	}
}
