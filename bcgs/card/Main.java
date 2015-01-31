package bcgs.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	//MAIN METHOD
		public static void main(String [ ] args)
		{
		      Card c1 = new Card("HSBC Canada","5601-2345-3446-5678","Nov-2017");
		      Card c2 = new Card("Royal Bank of  Canada","4519-4532-4524-2456","Oct-2017");
		      Card c3 = new Card("American Express","3786-7334-8965-345","Dec-2018");
		      ArrayList<Card> cardsList = new ArrayList<Card>();
		      
		      cardsList.add(c1);
		      cardsList.add(c2);	      
		      cardsList.add(c3);
		      
		      //sorting cards according to their expiry date
		      Collections.sort(cardsList);

		      //printing cards with masked code
		      Iterator<Card> c = cardsList.iterator();
		      while(c.hasNext()) System.out.println(c.next().maskedToString()+"\n");		      
		}
		
}
