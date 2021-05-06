/*
 * DiePlayer implement edilir ve isRolling olayi gerceklestirilir
 */

public class MyDiePlayer implements DiePlayer {
	
	/*
	 * kendi stratejimizi olustururuz.
	 * skor 65 den fazlaysa kazanana kadar oynasin 
	 * azsa da 5 den buyuk atana kadar zar atsin
	 * */
	
	
	@Override
	public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) { 
		boolean durum = true;
		//65 kontrolunu sagliyoruz
		if (maxScore > 65) {
			//oyunu kazanmissak false doner
			if (myScore >= DieGame.GOAL_SCORE) {
				durum = false;
			}
		}
		else {
			//zarin 5 den fazla olmasi durumunda false doner
			if (rolls >= 5) {
				durum = false;
			}
		} 
		return durum;
	}  
}
