package bcgs.card;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class CardChecker {

	@Test
	public void testCreation_1() {
		Card testCard = new Card("HSBC Canada","5601-2345-3446-5678","Nov-2017");
		assertNotNull(testCard);
	}

	@Test
	public void testCreation_2() {
		Card testCard = new Card("Royal Bank of  Canada","4519-4532-4524-2456","Oct-2017");
		assertNotNull(testCard);
	}
	
	@Test
	public void testCreation_3() {
		Card testCard = new Card("American Express","3786-7334-8965-345","Dec-2018");
		assertNotNull(testCard);
	}
	
	@Test
	public void testValues() {
		Card testCard = new Card("HSBC Canada","5601-2345-3446-5678","Nov-2017");
		
		assertEquals(testCard.getBank(),"HSBC Canada");
		
		assertEquals(testCard.getCode(),"5601-2345-3446-5678");
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy", Locale.UK);
		try {
			Date cal = sdf.parse("Nov-2017");
			assertEquals(testCard.getDate(),cal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}// all done
		

		
	}
	
	@Test
	public void testSortingByExpiryDate() {
		ArrayList<Card> listOfCards = new ArrayList<Card>();
		ArrayList<Card> sortedCards = new ArrayList<Card>();
		
		Card c1 = new Card("HSBC Canada","5601-2345-3446-5678","Nov-2017");
		Card c2 = new Card("Royal Bank of  Canada","4519-4532-4524-2456","Oct-2017");
		Card c3 = new Card("American Express","3786-7334-8965-345","Dec-2018");
				
		listOfCards.add(c1);
		listOfCards.add(c2);
		listOfCards.add(c3);
		Collections.sort(listOfCards);
		
		sortedCards.add(c3);
		sortedCards.add(c1);
		sortedCards.add(c2);
		
		assertEquals(listOfCards,sortedCards);
	}

	@Test
	public void testNumberMaskingTo_1() {
			Card testCard = new Card("HSBC Canada","5601-2345-3446-5678","Nov-2017");
			assertEquals(testCard.getMaskedCode(),"56xx-xxxx-xxxx-xxxx");
		
	}
	
	@Test
	public void testNumberMaskingTo_2() {
		Card testCard = new Card("Royal Bank of  Canada","4519-4532-4524-2456","Oct-2017");
		assertEquals(testCard.getMaskedCode(),"4519-xxxx-xxxx-xxxx");
	}
	
	@Test
	public void testNumberMaskingTo_3() {
		Card testCard = new Card("American Express","3786-7334-8965-345","Dec-2018");
		assertEquals(testCard.getMaskedCode(),"xxxx-xxxx-xxxx-345");
	}
	
	@Test
	public void testNumberMaskingTo_general() {
		Card testCard = new Card("HSBC Canada","5601-4345-3446-5678","Nov-2017");
		assertEquals(testCard.getMaskedCode(),"xxxx-xxxx-xxxx-xxxx");		
	}
	
	@Test
	public void testNumberMaskingTo_general2() {
		Card testCard = new Card("HSBC Canada","5601-2345-3446-567","Nov-2017");
		assertEquals(testCard.getMaskedCode(),"xxxx-xxxx-xxxx-xxx");		
	}
}
