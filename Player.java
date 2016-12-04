import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	Scanner sc = new Scanner(System.in);
	private String name;
	private int chips;
	private int bet = 0;
	private ArrayList<Card> oneRoundCard;

	public static void main(String[] args) {

	}

	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}

	public String get_name() {

		return name;

	}

	public void say_hello() {

		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");

	}

	public int make_bet() {
		bet = 1;
		if (chips >= 1) {
			
			return bet;
			
		} 
		else {
			
			System.out.println("無剩餘籌碼，無法下注");
			return 0;
		}
	}

	public void setOneRoundCard(ArrayList<Card> cards) {

		oneRoundCard = cards;

	}

	public boolean hit_me() {

		if (getTotalValue() <= 16) {

			return true;

		} 
		else {

			return false;
		}
	}

	public int getTotalValue() {
		int sum = 0;

		for (Card c : oneRoundCard) {
			int r = c.getRank();
			if (r == 11 || r == 12 || r == 13) {

				sum += 10;

			} 
			else if (r != 1) {

				sum += r;

			} 
			else if (r == 1) {

				if ((sum + 11) <= 21) {

					sum += 11;

				} 
				else {

					sum += 1;
				}
			}
		}
		return sum;

	}

	public void increase_chips(int diff) {
		
		chips += diff;
	}

	public int get_current_chips() {

		return chips;
	}
}
