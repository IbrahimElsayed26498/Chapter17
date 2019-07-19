/*
In the name of Allah, the Gracious, the Merciful
 */
package arraysandstreams2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author ibrahim
 */
public class ArraysAndStreams2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String[] strings = 
			{"Red", "Orange", "Yellow", "green", "Blue", "indigo", "Violet"};
		
		// display original strings
		System.out.printf("Original strings: %s%n", Arrays.asList(strings));
		
		// strings in uppercase
		System.out.printf("strings in uppercase: %s%n", 
			Arrays.stream(strings)
				  .map(String::toUpperCase)
				  .collect(Collectors.toList()));
		
		// collectors less than "n" (case insenstive) sorted ascending
		System.out.printf("strings greater than m sorted ascending: %s%n",
			Arrays.stream(strings)
				  .filter(s -> s.compareToIgnoreCase("n") < 0)
				  .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				  .collect(Collectors.toList()));
	}
	
}
