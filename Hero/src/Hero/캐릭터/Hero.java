package Hero.캐릭터;

public class Hero extends Character {
    public void lv_plus(){
        lv += lv+1;
        quickness += 4.761904761904762;
        System.out.println("'"+name+"'레벨업!!!");
        System.out.println("'민첩성'레벨업!!!");
    }
}