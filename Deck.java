import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>(); // 宣告變數cards-->型態:Card型態的ArrayList
	private ArrayList<Card> usedCard = new ArrayList<Card>();
	public int nUsed = 0;
	private ArrayList<Card> openCard = new ArrayList<Card>();
	public Random rnd = new Random();

	// implement the constructor
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();

		for (int i = 0; i < nDeck; i++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int k = 1; k <= 13; k++) {

					Card newCard = new Card(s, k);
					cards.add(newCard);
				}
			}
		}
		shuffle();
	}

	public void printDeck() {

		for (Card c : cards) {
			c.printCard();
		}
	}

	public Card getOneCard(boolean isOpened) {
		nUsed++;
		Card c = cards.get(nUsed - 1);
		usedCard.add(c);

		if (isOpened == true) {
			openCard.add(c);
		}
		if (nUsed == 52) {
			shuffle();
		}
		return c;
	}

	public void shuffle() {
		nUsed = 0;
		usedCard = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		for (int i = 0; i < 52; i++) {
			int index = rnd.nextInt(52);// between 0 (inclusive) and the
										// specified value (exclusive)

			Card temp = cards.get(index);
			cards.set(index, cards.get(i));
			cards.set(i, temp);
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	public ArrayList<Card> getOpenedCard() {
		return openCard;
	}
}