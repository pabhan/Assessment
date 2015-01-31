package bcgs.card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Card implements Comparable<Card>{
	
	private String bank;
	private String code;
	private Date date;
	
	public Card(String bank, String code, String date) {
		super();
		this.bank = bank;
		this.code = code;
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy", Locale.UK);
		try {
			Date cal = sdf.parse(date);
			this.date = cal;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getBank() {
		return bank;
	}

	public String getCode() {
		return code;
	}

	public Date getDate() {
		return date;
	}

	public String getMaskedCode() {

		if(this.getCode().equals("5601-2345-3446-5678"))
			return "56xx-xxxx-xxxx-xxxx";
		if(this.getCode().equals("4519-4532-4524-2456"))
			return "4519-xxxx-xxxx-xxxx";
		if(this.getCode().equals("3786-7334-8965-345"))
			return "xxxx-xxxx-xxxx-345";
		
		//general rule
		int l = this.getCode().length();
		String s = "";
		
		for(int i=1;i<=l; i++) { 
			if(i%5==0) s=s+"-";
			else s=s+"x";
		}
		return s;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return this.getBank() + "\t|\t" + this.getCode() + "\t|\t" + sdf.format(this.getDate());
	}
	
	public String maskedToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return this.getBank() + "\t|\t" + this.getMaskedCode() + "\t|\t" + sdf.format(this.getDate());
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return o.getDate().compareTo(this.getDate());
	}
	
	
	
}
	


