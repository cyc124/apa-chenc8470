import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class TwelvesBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 12;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public TwelvesBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size()==2)
			return containsPairSum12(selectedCards);
		if (selectedCards.size()==1)
			return containsKorQ(selectedCards);
	return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Integer> indexes=new ArrayList<Integer>();
		List<Integer> selected= new ArrayList<Integer>();
		indexes=cardIndexes();
		for (int i=0; i<indexes.size()-1;i++)
		{
			for (int j=i+1; j<indexes.size();j++)
			{
				selected.clear();
				selected.add(indexes.get(i));
				selected.add(indexes.get(j));
				if (containsPairSum12( selected))
				{
					return containsPairSum12(selected);
				}
			}
		}
		for (int i=0; i<indexes.size();i++)
		{		
			selected.clear();
			selected.add(indexes.get(i));
			if (containsKorQ(selected))
			{
				return containsKorQ(selected);
			}
		
			
		}
		return false;			
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum12(List<Integer> selectedCards) {
		if (selectedCards.size()==2)
		{
			if (cardAt(selectedCards.get(0)).pointValue()+cardAt(selectedCards.get(1)).pointValue()==12)
			{
				return true;
			}
		}
		return false;
			/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsKorQ(List<Integer> selectedCards) {
			
		if(cardAt(selectedCards.get(0)).pointValue()==0)
			{
				return true;
			}
			
		
		return false;	
	
	/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}
}
