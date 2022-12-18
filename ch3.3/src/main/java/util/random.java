package util;

import java.time.Instant;
import java.util.Random;

public class random {
	private static final Random random = new Random(Instant.now().getEpochSecond());
	public static boolean Bool() {return random.nextBoolean();}
	public static int Int() {return random.nextInt();}
	public static int Int(int a, int b) {return random.nextInt(a, b);}
	public static long Long() {return random.nextLong();}
	public static long Long(long a, long b) {return random.nextLong(a, b);}
	public static char ASCII_char() {return (char)random.nextInt(0x20, 0x7E);}
	public static String ASCII_string(final int l) {
		final var string_builder = new StringBuilder();
		for (var i = 0; i < l; ++i) {string_builder.append((char)random.nextInt(0x20, 0x7E));}
		return string_builder.toString();
	}

	public static String ASCII_string(final int lmin, final int lmax) {
		final var string_builder = new StringBuilder();
		final var l = random.nextInt(lmin, lmax);
		for (var i = 0; i < l; ++i) {string_builder.append((char)random.nextInt(0x20, 0x7E));}
		return string_builder.toString();
	}
}
