import java.util.Random;

public class Die {
	
	/*
	 * random 1 ile 6 arasinda sayi olusturarak 
	 * zar atma islemini gerceklestirir.
	 */
	public int nextRoll () {
		Random rnd = new Random();
		return rnd.nextInt(6) +1;
	}
}
