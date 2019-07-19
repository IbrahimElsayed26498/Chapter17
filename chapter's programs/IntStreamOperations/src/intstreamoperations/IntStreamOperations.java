/*
In the name of Allah, the Gracious, the Merciful
 */
package intstreamoperations;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.function.*;
/**
 *
 * @author ibrahim
 */
public class IntStreamOperations {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
		
		//display original values
		System.out.print("Original values: ");
		IntStream.of(values).
				forEach(value -> System.out.printf("%d ", value));
		System.out.println();
		
		// count min, max, sum and avarage of the values
		System.out.printf("%nCount: %d%n", IntStream.of(values).count());
		System.out.printf("%nMin: %d%n", IntStream.of(values).min().getAsInt());
		System.out.printf("%nMax: %d%n", IntStream.of(values).max().getAsInt());
		System.out.printf("%nSum: %d%n", IntStream.of(values).sum());
		System.out.printf("%nAverage: %f%n", IntStream.of(values).average().getAsDouble());
		
		// sum of values with reduce method
		System.out.printf("%nSum via reduce method: %d%n",
				IntStream.of(values).reduce(0, (x, y) -> x + y));
		
		// sum of square of values with reduce method
		System.out.printf("Sum of squares via reduce method: %d%n",
				IntStream.of(values).reduce(0, (x, y) -> x + y * y));
		
		// product of square of values with reduce method
		System.out.printf("Product via reduce method: %d%n",
				IntStream.of(values).reduce(1, (x, y) ->  x * y));
		
		// even values display in sorted order
		System.out.printf("%nEven values displayed in sorted order: ");
		IntStream.of(values)
				.filter(value -> value % 2 == 0)
				.sorted()
				.forEach(value -> System.out.printf("%d ", value));
		System.out.println();
		
		// odd values multiplied by 10 displayed in sorted order
		System.out.printf(
				"Odd values multiplied by 10 displayed in sorted order: ");
		IntStream.of(values)
				.filter(value -> value % 2 != 0)
				.map(value -> value * 10)
				.sorted()
				.forEach(value -> System.out.printf("%d ", value));
		System.out.println();
		// sum range of integer from 1 to 10, exclusive
		System.out.printf("%nSum of integer from 1 to 9: %d%n",
				IntStream.range(1, 10).sum());
		
		// sum range of integers from 1 to 10, inclusive
		System.out.printf("Sum of integer from 1 to 10: %d%n",
				IntStream.rangeClosed(1, 10).sum());
	}
	
}
