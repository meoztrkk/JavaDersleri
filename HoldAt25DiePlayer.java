/*
 * DiePlayer implement edilir ve isRolling olayi gerceklestirilir
 */

public class HoldAt25DiePlayer implements DiePlayer {
 
	/*
	 * bu strateji de turdaki puanimiz 25 yada daha fazlasi olursa atmayi durduyoruz.
	 * yani tanimladigimiz durum degiskeni false oluyor
	 * ve myScore da 100 den fazla ise false doner.
	 */
	
	@Override
	public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) { 
		boolean durum = true;
		if (turnTotal >= 25) {
			durum = false;
		}
		if (myScore >= DieGame.GOAL_SCORE) {
			durum = false;
		}  
		return durum;
	} 

}
