package chapter01.Item1.solution4.before;


public class PartyAri implements Champion{

    private Skin skin;
    private String name;

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
