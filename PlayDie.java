/*
 * oyunun basladigi class olur ve testlerimizi buranin uzerinden gerceklestiririz.
 */

import java.util.Scanner;

public class PlayDie {

	private static Scanner scan = new Scanner(System.in);//okuma nesnesi

	public static void main(String[] args) {
		
		//oyunculari tanimlariz
		DiePlayer hold20 = new HoldAt20DiePlayer();
		DiePlayer hold25 = new HoldAt25DiePlayer();
		DiePlayer race = new RaceToGoalDiePlayer();
		DiePlayer myDie = new MyDiePlayer(); 
		
		//players dizimiz
		DiePlayer[] players = {hold20,hold25};
		
		//oyunun oynandigi fonksiyon
		Play1000Game(players);		 
	}
	 
	
	
	static void Play1000Game(DiePlayer[] players) {

		/*
		 * oyuncularin isimlerini ekrana basariz
		 * ve getClass().getName() yazarak class isimlerini aliriz
		 */
		System.out.println("********** OYUNCULAR ***********");
		for (DiePlayer diePlayer : players) {
			System.out.println(diePlayer.getClass().getName());
		}
		System.out.println("****************************");

		System.out.println("  OYUN BAÞLADI");

		/*
		 * 1000 defa tekrarlanacagi icin her oyuncu icin 
		 * kazanma sayisini tutan dizi oluustururuz 
		 * ve ilk degerlerini sifirdan baslatiriz
		 */
		int[] kazanmaSayilari = new int[players.length];
		for (int i = 0; i < kazanmaSayilari.length; i++) {
			kazanmaSayilari[i] = 0;
		}

		/*
		 *1000 defa tekrarlayarak game nesnesi olusturuurz ve
		 *game.play() ile kazan kisinin indeksini aliriz
		 *kazanma sayilari dizisinde gecerli kisinin degerini bir arttiririz
		 */
		for (int i = 0; i < 1000; i++) { 
			DieGame game = new DieGame(players);
			int winner = game.play();
			kazanmaSayilari[winner]++;
		}
		
		/*
		 * en son ekrana puan tablosunu yazdiririz
		 * ve kazan kisinin indexini belirleriz
		 */
		System.out.println("********** PUAN TABLOSU ***********");
		int maxPoint = 0;
		int winnerIndex = 0;
		for (int i = 0; i < kazanmaSayilari.length; i++) {
			System.out.println(players[i].getClass().getName() + " --> " + kazanmaSayilari[i]);
			if (kazanmaSayilari[i] > maxPoint) {
				maxPoint = kazanmaSayilari[i];
				winnerIndex = i;
			}
		}
		System.out.println("****************************");

		/*
		 * kazanan kisinin adini yazariz
		 */
		System.out.println("1000 oyun sonunda " + players[winnerIndex].getClass().getName() + "  Kazandý !!!!!!!!!");
		System.out.println("  OYUN BÝTTÝ");
	} 
	
}
