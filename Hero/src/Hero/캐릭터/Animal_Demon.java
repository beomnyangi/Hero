package Hero.캐릭터;

public class Animal_Demon extends Npc {
    public Animal_Demon(String newvalue){
        this.name = newvalue;
    }
    public void setting(int newvalue){
        health = newvalue*8;
        attack = newvalue*8;
        defense = newvalue*8;
        quickness = newvalue*8;
        lv = newvalue;
    }
}