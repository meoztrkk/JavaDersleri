
public class DieGame {
	public static final int GOAL_SCORE = 100;//kazanma puani
	private DiePlayer[] players;//oyuncu dizisi
	private int[] playersScor;//scor dizimiz

	Die zar = new Die();//zar atmamiz icin gerekli class

	/*
	 * classýmýzýn constructoridir
	 * burada players dizisini ve playersScor dizisini baslatiyoruz
	 * playersScor dizisinin ilk elemanlari 0 olacak sekilde ayarliyoruz
	 */
	public DieGame(DiePlayer[] players) {
		this.players = players;
		this.playersScor = new int[players.length];
		for (int i = 0; i < players.length; i++) {
			this.playersScor[i] = 0;
		}
	}

	/*oyunun basladigi yerdir
	 * sonsuz bir dongu kurulur
	 * her oyuncu icin playTurn() fonksiyonu cagrilir
	 * bu fonksiyon sonucunda aldigi puan skor dizisine eklenir
	 * her tur sonunda continuecontrol() fonksiyonu ile de 
	 * oyunun kazananin olup olmadigina bakilir
	 * kazanan varsa da index degeri return edilir
	 */
	public int play() {
		while (true) {
			int i = 0;
			for (DiePlayer diePlayer : players) {//oyuncularin icinde dolasan foreach
				playersScor[i] += playTurn(diePlayer, i);//her oyuncu icin oyunun oynatlip puanin eklenmesi
				i++;
			}
			printScores();//skoru ekrana yazar
			if (ContinueControl() >= 0) {//kazanan varsa indeksi return eder
				return ContinueControl();
			}
		}
	}

	/*
	 * burada oyuncu bir tur oyun oynar 
	 * ve aldigi puan return edilir
	 */
	int playTurn(DiePlayer p, int playerNum) {
		int turnTotal = 0;//turda alacagi toplam puan
		 
		while (true) {//kaybedene kadar calismasi lazým onun icin while dongusu
			int sayi = zar.nextRoll();//zar atar
			if (sayi == 1) {//sonuc 1 gelirse tur puani sifir olur ve donguden cikar
				turnTotal = 0 ;
				break;
			}
			turnTotal += sayi;//tur puanina zarda gelen sonuc eklenir
			
			/*
			 * isrolling ve oyunu kazanma durumu kontrol edilir
			 * kazanadiysa donguden cikilir
			 */
			if (!p.isRolling(playersScor[playerNum], turnTotal, getMaxScore(), sayi)) {
				break;
			}
			if ((turnTotal + playersScor[playerNum]) > GOAL_SCORE) {
				break;
			}
		}
		return turnTotal;
	}
	
	
	

	/*
	 * skordizisinde dolasarak maximum skoru return eder
	 */
	int getMaxScore() {
		int maxPoint = 0;
		for (int i = 0; i < playersScor.length; i++) {
			if (playersScor[i] > maxPoint) {
				maxPoint = playersScor[i];
			}
		}
		return maxPoint;
	}

	/*
	 *skor tablosunu ekrana yazar
	 */
	void printScores() {
		System.out.println("**********Soccer Table***********");
		System.out.println();
		for (int i = 0; i < playersScor.length; i++) {
			System.out.println(players[i].getClass().getName() + " : " + playersScor[i]);
		}
		System.out.println();
		System.out.println("****************************");
	}
 
	/*
	 * scor dizisinde donerek 100 puani
	 * gecen biri varmi diye bakar
	 * eger gecen varsa oyunu kazanmis demektir
	 * o yuzden onun indexini return eder
	 */
	private int ContinueControl() {
		for (int i = 0; i < playersScor.length; i++) {
			if (playersScor[i] >= GOAL_SCORE) {
				return i;
			}
		}
		return -1;
	}

}
