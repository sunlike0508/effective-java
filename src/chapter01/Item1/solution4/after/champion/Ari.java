package chapter01.Item1.solution4.after.champion;

import chapter01.Item1.solution4.after.skin.Skin;

public class Ari implements Champion {

    private Skin skin;
    private static final String name = "아리";

    public Ari(Skin skin) {
        this.skin = skin;
    }


    @Override
    public void move() {
        System.out.println(skin.getName() + " " + name + " 움직여");
    }


    @Override
    public void skillQ() {
        System.out.println(skin.getName() + " " +name + " Q 스킬 사용");
    }


    @Override
    public void skillW() {

    }
}
