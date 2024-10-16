package chapter01.Item1.solution4.after;

import chapter01.Item1.solution4.after.champion.Ari;
import chapter01.Item1.solution4.after.champion.Champion;
import chapter01.Item1.solution4.after.skin.Fire;
import chapter01.Item1.solution4.after.skin.KDA;
import chapter01.Item1.solution4.after.skin.Party;

public class Main {
    public static void main(String[] args) {
        Champion kdaAri = new Ari(new KDA());
        kdaAri.move();
        kdaAri.skillQ();

        Champion partyAri = new Ari(new Party());
        partyAri.move();
        partyAri.skillQ();

        Champion fireAri = new Ari(new Fire());
        fireAri.move();
        fireAri.skillQ();
    }
}
