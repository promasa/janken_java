package app;

import java.util.*;

public class Game {
	public enum Result {
		WIN,
		LOSE,
		DRAW;
		
		@Override
		public String toString() {
			return this.name().toLowerCase();
		}
	}

	public static final String COMAND = "0:グ- 1:チョキ 2:パー";
	public static final String RULE_TEXT = "\n\n---じゃんけんだお---\n"
											+ "手を数字で選択してね\n"
											+ COMAND + "\n";
	public static final String DRAW_TEXT = "\nあいこ- " 
											+ COMAND + "\n";
	public static final String COMAND_ERR_TEXT ="~~~~~~~~~~error~~~~~~~~~~~\n"
												+ " 0,1,2,から選択してください\n"
												+ "~~~~~~~~~~~~~~~~~~~~~~~~~~";

	public static Result judge(Janken mine, Janken other) {
		if (mine == Janken.ROCK) {
			if(other == Janken.PAPER) return Result.LOSE;
			if(other == Janken.SCISSORS) return Result.WIN;
			
			return Result.DRAW;
		}
		if(mine == Janken.PAPER) {
            if(other == Janken.ROCK)     return Result.WIN;
            if(other == Janken.SCISSORS) return Result.LOSE;

			return Result.DRAW;
		}
			// mine == Janken.SCISSORS
            if(other == Janken.PAPER) return Result.WIN;
            if(other == Janken.ROCK) return Result.LOSE;

            return Result.DRAW;
	}

	public static void fight() {
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		Result result = Result.DRAW;
		while(result == Result.DRAW) {
			System.out.println(count > 0 ? DRAW_TEXT : RULE_TEXT);
			try {
				int num = Integer.parseInt(scan.next());
				Janken myHand = Janken.gedHand(num);
				Janken otherHand = Janken.choose();
				result = Game.judge(myHand, otherHand);
			} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.err.println(COMAND_ERR_TEXT);
				count--;
			}
			count ++;
		}
		scan.close();
		System.out.println("結果 : " + result);
	}


}
