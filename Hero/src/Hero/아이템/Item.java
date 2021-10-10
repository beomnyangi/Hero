package Hero.아이템;

import Hero.Utility.Utility;

import java.util.Scanner;

import static Hero.Utility.Gameplay_Utility.*;

public class Item {
    Utility utility = new Utility();
    public String name;
    public double ability;
    public double accumulate;
    public double mounting(){
        return accumulate;
    }
    public void ability_plus(){
        accumulate += ability;
        System.out.println("'"+name+"'레벨업!!! ");
        if(accumulate > 100){
            accumulate = 100;
        }
    }
    public void state(){
        System.out.println("'"+name+"'사용중("+Math.round(accumulate)+"/100)");
    }
    public void item_setting(){
        Scanner scan = new Scanner(System.in);

        int newvalue;
        /*
        무기 설정
         */
        while(true){
            utility.print("                                     아이템 설정\n" +
                    //"             1.검 2.도끼 3.활 4.마법 지팡이 5.방패 6.현재 상태 7.나가기\n"+
                    "             1."+sword.name+" 2."+ax.name+" 3."+bow.name+" 4."+magic_wand.name+" 5."+shield.name+" 6.현재 상태 7.나가기\n");
            newvalue = scan.nextInt();
            if (newvalue > 0 && newvalue < 8) {
                switch (newvalue) {
                    case 1:
                        System.out.println("검을 사용 하시겠습니까?");
                        System.out.println("1.예 2.아니요");
                        while (true) {
                            newvalue = scan.nextInt();
                            if(sword_flag && newvalue == 1){
                                System.out.println("이미 검을 사용중입니다.");
                                break;
                            }
                            if (newvalue == 1) {
                                hero.attack = (int) Math.round(sword.mounting());
                                sword_flag = true;
                                ax_flag = false;
                                bow_flag = false;
                                magic_wand_flag = false;
                                break;
                            } else if (newvalue == 2) {
                                break;
                            }
                            else{
                                System.out.print("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
                            }
                        }

                        break;
                    case 2:
                        System.out.println("도끼를 사용 하시겠습니까?");
                        System.out.println("1.예 2.아니요");
                        while (true) {
                            newvalue = scan.nextInt();
                            if(ax_flag && newvalue == 1){
                                System.out.println("이미 도끼를 사용중입니다.");
                                break;
                            }
                            if (newvalue == 1) {
                                hero.attack = (int) Math.round(ax.mounting());
                                sword_flag = false;
                                ax_flag = true;
                                bow_flag = false;
                                magic_wand_flag = false;
                                break;
                            } else if (newvalue == 2) {
                                break;
                            }
                            else{
                                System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("활을 사용 하시겠습니까?");
                        System.out.println("1.예 2.아니요");
                        while (true) {
                            newvalue = scan.nextInt();
                            if(bow_flag && newvalue == 1){
                                System.out.println("이미 활을 사용중입니다.");
                                break;
                            }
                            if (newvalue == 1) {
                                hero.attack = (int) Math.round(bow.mounting());
                                sword_flag = false;
                                ax_flag = false;
                                bow_flag = true;
                                magic_wand_flag = false;
                                break;
                            } else if (newvalue == 2) {
                                break;
                            }
                            else{
                                System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("마법 지팡이를 사용 하시겠습니까?");
                        System.out.println("1.예 2.아니요");
                        while (true) {
                            newvalue = scan.nextInt();
                            if(magic_wand_flag && newvalue == 1){
                                System.out.println("이미 마법 지팡이를 사용중입니다.");
                                break;
                            }
                            if (newvalue == 1) {
                                hero.attack = (int) Math.round(magic_wand.mounting());
                                sword_flag = false;
                                ax_flag = false;
                                bow_flag = false;
                                magic_wand_flag = true;
                                break;
                            } else if (newvalue == 2) {
                                break;
                            }
                            else{
                                System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("방패를 사용 하시겠습니까?");
                        System.out.println("1.예 2.아니요");
                        while (true) {
                            newvalue = scan.nextInt();
                            if(shield_flag && newvalue == 1){
                                System.out.println("이미 방패를 사용중입니다.");
                                break;
                            }
                            if (newvalue == 1) {
                                hero.defense = (int) Math.round(shield.mounting());
                                shield_flag = true;
                                break;
                            } else if (newvalue == 2) {
                                break;
                            }
                            else{
                                System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
                            }
                        }
                        break;
                    case 6:
                        if(sword_flag){
                            sword.state();
                        }
                        if(ax_flag){
                            ax.state();
                        }
                        if(bow_flag){
                            bow.state();
                        }
                        if(magic_wand_flag){
                            magic_wand.state();
                        }
                        if(shield_flag){
                            shield.state();
                        }
                        if(!sword_flag && !ax_flag && !bow_flag && !magic_wand_flag && !shield_flag){
                            System.out.println("사용중인 아이템이 없습니다");
                        }
                        System.out.println("다시 선택하려면 엔터를 누르세요.");
                        utility.enter();
                        break;
                    case 7:
                        System.out.println("나가려면 엔터를 누르세요.");
                        utility.enter();
                        break;
                }
                if (newvalue == 7) {
                    break;
                }
            }
            else {
                System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
            }

        }
    }
}