package Hero.캐릭터;

public class Character {
    public String name;
    public int health;
    public int attack;
    public int defense;
    public double quickness;
    public int lv;

    public int attack(){
        System.out.println("'"+name+"' 공격!!! "+attack);
        return attack;
    }
    public void defense(int newvalue){
        newvalue = newvalue-defense;
        if(newvalue <= 0){
            newvalue = 0;
        }
        health += -newvalue;
        System.out.println("'"+name+"' 방어!!!");
        if(newvalue != 0) {
            System.out.println("'" + name + "' 체력 " + -newvalue);
        }
    }
    public void miss(int newvalue){
        newvalue = newvalue-(int)Math.round(quickness);
        if(newvalue <= 0){
            newvalue = 0;
        }
        health += -newvalue;
        System.out.println("'"+name+"' 피하기!!!");
        if(newvalue != 0) {
            System.out.println("'" + name + "' 체력 " + -newvalue);
        }
    }
    public void state(){
        System.out.println("'"+name+"(Lv:"+lv+")' : 현재 상태");
        System.out.println("체력 : "+health+"/100");
        System.out.println("공격력 : "+attack+"/100");
        System.out.println("방어력 : "+defense+"/100");
        System.out.println("민첩성 : "+Math.round(quickness)+"/100\n");
    }
}