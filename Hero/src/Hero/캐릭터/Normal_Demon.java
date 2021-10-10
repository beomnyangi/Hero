package Hero.캐릭터;

public class Normal_Demon extends Npc {
    public Normal_Demon(String newvalue){
        this.name = newvalue;
    }
    public void setting(int newvalue){
        health = newvalue*11;
        attack = newvalue*11;
        defense = newvalue*11;
        quickness = newvalue*11;
        lv = newvalue;
    }
}