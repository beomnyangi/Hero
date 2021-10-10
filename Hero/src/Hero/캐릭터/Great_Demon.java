package Hero.캐릭터;

public class Great_Demon extends Npc {
    public Great_Demon(String newvalue){
        this.name = newvalue;
    }
    public void setting(int newvalue){
        health = newvalue*14;
        attack = newvalue*14;
        defense = newvalue*14;
        quickness = newvalue*14;
        lv = newvalue;
    }
}