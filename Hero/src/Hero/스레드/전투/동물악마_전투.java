package Hero.스레드.전투;

import Hero.Utility.Utility;
import Hero.스레드.소리재생.*;
import Hero.스레드.지연.지연;
import Hero.아이템.Item;

import java.util.Random;
import java.util.Scanner;

import static Hero.Utility.Gameplay_Utility.*;

public class 동물악마_전투 extends Thread {
    Item item = new Item();
    Utility utility = new Utility();
    지연 지연_1000 = new 지연(500);

    Scanner scan = new Scanner(System.in);
    Random rd = new Random();
    int newvalue;
    int attack_newvalue;
    int random;

    public void run() {
        /*
        동물악마와의 전투
         */
        System.out.println("\n'" + animal_demon.name + "(Lv:" + animal_demon.lv + ")'가 나타났다. '" + animal_demon.name + "(Lv:" + animal_demon.lv + ")'가 나를 공격하기 시작했다!!!");
        while (true) {
            주인공_칼공격소리 주인공_칼공격소리 = new 주인공_칼공격소리();
            주인공_악마방어소리 주인공_악마방어소리 = new 주인공_악마방어소리();
            주인공_악마피하기소리 주인공_악마피하기소리 = new 주인공_악마피하기소리();
            동물악마_공격소리 동물악마_공격소리 = new 동물악마_공격소리();
            utility.print("                                    '" + animal_demon.name + "(Lv:" + animal_demon.lv + ")'\n" +
                    "              (체력 : " + animal_demon.health + "/100, 공격력 : " + animal_demon.attack + "/100, 방어력 : " + animal_demon.defense + "/100, 민첩성 : " + Math.round(animal_demon.quickness) + "/100)\n" +
                    "                      1.공격 2.방어 3.피하기 4.무기 설정 5.현재 상태\n");
            newvalue = scan.nextInt();
            if (newvalue > 0 && newvalue < 6) {
                switch (newvalue) {
                    case 1:
                        random = rd.nextInt(3) + 1;
                        if (random == 1) {
                            animal_demon.health += -hero.attack();
                            //주인공_칼공격소리 주인공_칼공격소리 = new 주인공_칼공격소리();
                            주인공_칼공격소리.start();
                            지연_1000.delay();
                            System.out.println("'" + animal_demon.name + "' 체력 " + -hero.attack);
                            지연_1000.delay();
                        } else if (random == 2) {
                            attack_newvalue = hero.attack();
                            //주인공_칼공격소리 주인공_칼공격소리 = new 주인공_칼공격소리();
                            주인공_칼공격소리.start();
                            지연_1000.delay();
                            animal_demon.defense(attack_newvalue);
                            //주인공_악마방어소리 주인공_악마방어소리 = new 주인공_악마방어소리();
                            주인공_악마방어소리.start();
                            지연_1000.delay();
                        } else if (random == 3) {
                            attack_newvalue = hero.attack();
                            //주인공_칼공격소리 주인공_칼공격소리 = new 주인공_칼공격소리();
                            주인공_칼공격소리.start();
                            지연_1000.delay();
                            animal_demon.miss(attack_newvalue);
                            //주인공_악마피하기소리 주인공_악마피하기소리 = new 주인공_악마피하기소리();
                            주인공_악마피하기소리.start();
                            지연_1000.delay();
                        }
                        random = rd.nextInt(2) + 1;
                        if (random == 1) {
                            hero.health += -animal_demon.attack();
                            //동물악마_공격소리 동물악마_공격소리 = new 동물악마_공격소리();
                            동물악마_공격소리.start();
                            지연_1000.delay();
                            System.out.println("'" + hero.name + "' 체력 " + -animal_demon.attack);
                            지연_1000.delay();
                        } else if (random == 2) {
                            //return;
                        }
                        break;
                    case 2:
                        attack_newvalue = animal_demon.attack();
                        //동물악마_공격소리 동물악마_공격소리 = new 동물악마_공격소리();
                        동물악마_공격소리.start();
                        지연_1000.delay();
                        hero.defense(attack_newvalue);
                        //주인공_악마피하기소리 주인공_악마피하기소리 = new 주인공_악마피하기소리();
                        주인공_악마방어소리.start();
                        지연_1000.delay();
                        break;
                    case 3:
                        attack_newvalue = animal_demon.attack();
                        //동물악마_공격소리 = new 동물악마_공격소리();
                        동물악마_공격소리.start();
                        지연_1000.delay();
                        hero.miss(attack_newvalue);
                        주인공_악마피하기소리.start();
                        지연_1000.delay();
                        break;
                    case 4:
                        item.item_setting();
                        break;
                    case 5:
                        hero.state();
                        System.out.println("\n다시 선택하려면 엔터를 누르세요.\n");
                        utility.enter();
                        break;
                }

                if (animal_demon.health <= 0) {
                    System.out.println("\n처치 완료!!!");
                    지연_1000.delay();
                    hero.lv_plus();
                    레벨업소리 레벨업소리 = new 레벨업소리();
                    레벨업소리.start();
                    지연_1000.delay();
                    if (sword_flag) {
                        sword.ability_plus();
                        레벨업소리 레벨업소리1 = new 레벨업소리();
                        레벨업소리1.start();
                        지연_1000.delay();
                    }
                    if (ax_flag) {
                        ax.ability_plus();
                        레벨업소리 레벨업소리2 = new 레벨업소리();
                        레벨업소리2.start();
                        지연_1000.delay();
                    }
                    if (bow_flag) {
                        bow.ability_plus();
                        레벨업소리 레벨업소리3 = new 레벨업소리();
                        레벨업소리3.start();
                        지연_1000.delay();
                    }
                    if (magic_wand_flag) {
                        magic_wand.ability_plus();
                        레벨업소리 레벨업소리4 = new 레벨업소리();
                        레벨업소리4.start();
                        지연_1000.delay();
                    }
                    if (shield_flag) {
                        shield.ability_plus();
                        레벨업소리 레벨업소리5 = new 레벨업소리();
                        레벨업소리5.start();
                        지연_1000.delay();
                    }
                    animal_demon_victory = true;
                    break;
                }
                if (hero.health <= 0) {
                    주인공_사망소리 주인공_사망소리 = new 주인공_사망소리();
                    주인공_사망소리.start();
                    utility.demon_print();
                    System.out.println("사망...");
                    지연_1000.delay();
                    while (true) {
                        System.out.println("1.이어서 다시 도전 하시겠습니까? 2.다른 지역부터 먼저 정복 하시겠습니까? 3.게임을 종료 하시겠습니까?");
                        newvalue = scan.nextInt();
                        if (newvalue == 1) {
                            System.out.println("다시 도전 하려면 엔터를 누르세요.");
                            utility.enter();
                            hero.health = 100;
                            break;
                        } else if (newvalue == 2) {
                            System.out.println("다른 지역부터 먼저 정복 하려면 엔터를 누르세요.");
                            utility.enter();
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                            break;
                        } else if (newvalue == 3) {
                            System.out.println("게임을 종료 하려면 엔터를 누르세요.");
                            utility.enter();
                            utility.end_print();
                            지연_1000.delay();
                            System.exit(0);
                            게임시작bgm.setStop(true);
                        } else {
                            System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
                        }
                    }
                    if (newvalue == 2) {
                        break;
                    }
                }
            } else {
                System.out.println("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
            }
        }


    }
}
