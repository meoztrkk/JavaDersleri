/*
 * bu class dieplayer dan implements alir. 
 * Ve kullanici etkilesimli olarak oyun oynanir.
 */

import java.util.Scanner;

public class UserDiePlayer implements DiePlayer {

	Scanner scanner = new Scanner(System.in); //ekrandan girdiyi okuruz

	@Override
	public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {
		boolean durum = true;
		//eger skorumuz 100 u gecerse durum false oluyor
		if (myScore >= DieGame.GOAL_SCORE) {
			durum = false;
		} else { 
			System.out.println("Roll or Hold (Cýkmak icin herhangi bir harf yazýn) ?"); //100 den az ise de soru sorar 
			if (scanner.nextLine() == "") {
				durum = true;//sadece entera basilirsa tekrar zar atar
			}
			else{
				durum = false;//degilse false doner
			}
		}
		return durum;
	} 

}
