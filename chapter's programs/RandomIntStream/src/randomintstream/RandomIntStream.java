/*
In the name of Allah, the Gracious, the Merciful
 */
package randomintstream;

import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author ibrahim
 */
public class RandomIntStream {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		
		// roll a die 6,000,000 times and summarize the result
		System.out.printf("%-6s%s%n", "Face", "Frequency");
		random.ints(6_000_000, 1, 7)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), 
						Collectors.counting()))
				.forEach((face, frequency) -> 
				System.out.printf("%-6d%d%n", face, frequency));
	}
	
}
