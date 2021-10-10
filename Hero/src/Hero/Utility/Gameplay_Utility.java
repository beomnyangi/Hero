package Hero.Utility;

import Hero.스레드.전투.*;
import Hero.캐릭터.*;
import Hero.아이템.*;
import Hero.맵.*;

import java.util.Random;
import java.util.Scanner;

public class Gameplay_Utility {
    Utility utility = new Utility();
    Item item = new Item();

    int 악마전투 = 0;
    int 동물악마전투 = 0;
    int 대악마전투 = 0;

    public static boolean demon_victory = false;
    public static boolean animal_demon_victory = false;
    public static boolean great_demon_victory = false;

    public static boolean oceania_victory = false;
    public static boolean europe_victory = false;
    public static boolean south_pole_victory = false;
    public static boolean south_america_victory = false;
    public static boolean north_america_victory = false;
    public static boolean africa_victory = false;
    public static boolean asia_victory = false;

    public static boolean sword_flag = false;
    public static boolean ax_flag = false;
    public static boolean bow_flag = false;
    public static boolean magic_wand_flag = false;
    public static boolean shield_flag = false;
    /*
    캐릭터 생성
     */
    public static Hero hero = new Hero();
    public static Normal_Demon normal_demon = new Normal_Demon("악마");
    public static Animal_Demon animal_demon = new Animal_Demon("동물 악마");
    public static Great_Demon great_demon = new Great_Demon("대악마");
    /*
    대륙 생성
     */
    Oceania oceania = new Oceania();
    Europe europe = new Europe();
    South_Pole south_pole = new South_Pole();
    South_America south_america = new South_America();
    North_America north_america = new North_America();
    Africa africa = new Africa();
    Asia asia = new Asia();
    /*
    아이템 생성
     */
    public static Sword sword = new Sword();
    public static Ax ax  = new Ax();
    public static Bow bow = new Bow();
    public static Magic_Wand magic_wand = new Magic_Wand();
    public static Shield shield = new Shield();

    public void hero_create(){
        Scanner scan = new Scanner(System.in);
        int newvalue;
        System.out.print("캐릭터 이름을 정해주세요 : ");
        hero.name = scan.next();
        System.out.println("캐릭터 이름을 '"+hero.name+"'님으로 하시겠습니까?");
        System.out.println("1.예 2.아니요");
        while(true){
            newvalue = scan.nextInt();
            if(newvalue == 1){
                //hero.setting();
                hero.health=100;
                break;
            }
            else if(newvalue == 2){
                System.out.print("캐릭터 이름을 다시 정해주세요 : ");
                hero.name = scan.next();
                System.out.println("캐릭터 이름을 '"+hero.name+"'님으로 하시겠습니까?");
                System.out.println("1.예 2.아니요");
            }
            else{
                System.out.print("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
            }
        }
    }
    public void continent_selection(int newvalue){
        switch (newvalue) {
            case 1:
                normal_demon.setting(north_america.value());
                animal_demon.setting(north_america.value());
                great_demon.setting(north_america.value());
                north_america.print_name();
                break;
            case 2:
                normal_demon.setting(south_america.value());
                animal_demon.setting(south_america.value());
                great_demon.setting(south_america.value());
                south_america.print_name();
                break;
            case 3:
                normal_demon.setting(south_pole.value());
                animal_demon.setting(south_pole.value());
                great_demon.setting(south_pole.value());
                south_pole.print_name();
                break;
            case 4:
                normal_demon.setting(africa.value());
                animal_demon.setting(africa.value());
                great_demon.setting(africa.value());
                africa.print_name();
                break;
            case 5:
                normal_demon.setting(europe.value());
                animal_demon.setting(europe.value());
                great_demon.setting(europe.value());
                europe.print_name();
                break;
            case 6:
                normal_demon.setting(asia.value());
                animal_demon.setting(asia.value());
                great_demon.setting(asia.value());
                asia.print_name();
                break;
            case 7:
                normal_demon.setting(oceania.value());
                animal_demon.setting(oceania.value());
                great_demon.setting(oceania.value());
                oceania.print_name();
                break;
        }
    }
    /*
    public void item_setting(){
        Scanner scan = new Scanner(System.in);

        int newvalue;

        //무기 설정
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

    */

    public void demon_appearance() {
        악마_전투 악마_전투 = new 악마_전투();
        악마_전투.start();
        try {
            악마_전투.join();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("게임플레이유틸리티악마전투에러");

        }
    }
    public void animal_demon_appearance() {
        동물악마_전투 동물악마_전투 = new 동물악마_전투();
        동물악마_전투.start();
        try {
            동물악마_전투.join();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("게임플레이유틸리티동물악마에러");
        }
    }
    public void great_demon_appearance() {
        대악마_전투 대악마_전투 = new 대악마_전투();
        대악마_전투.start();
        try {
            대악마_전투.join();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("게임플레이유틸리티대악마에러");
        }
    }
}
