package app;
import java.util.*;

public enum Janken {
	ROCK,
	SCISSORS,
	PAPER;
	
	private static final Random random = new Random();
	private static final Janken[] values = Janken.values();
	
	public static Janken choose() {
		return values[
			random.nextInt(values.length)
		];
	}
	public static Janken gedHand(int num) {
		return values[num];
	} 

}