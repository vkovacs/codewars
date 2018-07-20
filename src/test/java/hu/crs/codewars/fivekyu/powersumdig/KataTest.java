package hu.crs.codewars.fivekyu.powersumdig;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;
import org.junit.Test;

public class KataTest {
	private static void testing(long act, long exp) {
		assertEquals(exp, act);
	}

	@Test
	public void test1() {
		IntStream.range(0, 10)
				.forEach( i -> {
					LocalDateTime start = LocalDateTime.now();
		testing(Kata.powerSumDigTerm(1), 81);
		testing(Kata.powerSumDigTerm(2), 512);
		testing(Kata.powerSumDigTerm(3), 2401);
		testing(Kata.powerSumDigTerm(4), 4913);
		LocalDateTime end = LocalDateTime.now();
		System.out.println(start.until(end, ChronoUnit.MILLIS));
		});

	}
}
