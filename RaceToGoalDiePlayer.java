/*
 * DiePlayer implement edilir ve isRolling olayi gerceklestirilir
 */

public class RaceToGoalDiePlayer implements DiePlayer {
 
	/*
	 * kendi skorumuz veya max skor 71 den buyukse oyunu kazanana kadar oynariz.
	 * degilse de ozel kontrol ile devam ederiz 
	 */
	
	
	@Override
	public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {
		boolean durum = true;
		//skorlar 71 den buyukse
		if (myScore >= 71 || maxScore >= 71) {
			//oyunu kazanmissak false doner
			if (myScore >= DieGame.GOAL_SCORE) {
				durum = false;
			}
		}
		else {
			//oyunu kazanmissak false doner
			if (myScore >= DieGame.GOAL_SCORE) {
				durum = false;
			}
			//kural icin gerekli islem yapilir ve kontrol saglanir
			int kontrol = 21 + ((maxScore - myScore) / 8); 
			if (turnTotal >= kontrol) {
				durum = false;
			}
		} 
		return durum;

	} 

}
