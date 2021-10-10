package Hero.메인;

import Hero.Utility.*;
import java.util.Scanner;

import Hero.스레드.로그인.*;
import Hero.스레드.지연.지연;
import Hero.스레드.프린트.*;
import Hero.스레드.소리재생.*;
import Hero.아이템.Item;

import static Hero.Utility.Gameplay_Utility.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Utility utility = new Utility();
        Gameplay_Utility gameplay_utility = new Gameplay_Utility();
        Item item = new Item();


        지연 지연_1000 = new 지연(1000);
        프린트_지연 프린트_게임설명 = new 프린트_지연("D:\\teamnova\\5주 - java 스레드, 해시 테이블\\게임2_Hero\\프린트\\프린트_게임설명.txt",100);
        프린트_지연 프린트_주인공혼잣말 = new 프린트_지연("D:\\teamnova\\5주 - java 스레드, 해시 테이블\\게임2_Hero\\프린트\\프린트_주인공혼잣말.txt",100);
        게임시작bgm 게임시작bgm = new 게임시작bgm();
        승리소리 승리소리 = new 승리소리();
        로그인 로그인 = new 로그인();

        int newvalue;
        int win = 0;

        게임시작bgm.start();

        로그인.start();
        try {
            로그인.join();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("로그인 에러");
        }

        utility.hero_print();
        지연_1000.delay();

        프린트_게임설명.start();
        try {
            프린트_게임설명.join();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("프린트_게임설명 에러");
        }
        /*
        System.out.println("지구를 모두 정복해 정상적인 사람들을 노예로 부리며 살아가는 악마들.\n" +
                "주인공은 자유를 다시 찾기 위해서 악마들로 부터 탈출을 결심하게 된다.\n" +
                "주인공이 되어 대륙마다 존재하는 악마들을 물리치고 7개 대륙을 모두 정복해 사람들에게 자유를 주자\n");
         */

        System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
        utility.enter();


        /*
        ////////////////////////////게임 시작
         */
        /*
        주인공 이름 설정
         */
        gameplay_utility.hero_create();

        System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
        utility.enter();

        프린트_주인공혼잣말.start();
        try {
            프린트_주인공혼잣말.join();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("프린트_게임설명 에러");
        }
        /*
        System.out.println("'이대로 평생 악마들에게 노예생활 하다가는 허무하게 죽게 생겼네...'\n\n"+
                "\"여러분!!! 이렇게 노예생활 하다 허무하게 죽는건 너무 억울하지 않습니까!!!\"\n"+
                "\"오늘 밤 악마들을 물리치고 우리의 자유를 다시 찾아봅시다!!!\"\n\n"+
                "\"...... \t 악마들과 싸우려면 혼자 하게나...악마들은 너무 강력해...\"\n\n\n\n"+
                "'어쩔 수 없다...혼자 물리쳐야겠군...'\n\n"+
                "그날 밤 자유를 찾아 악마들과 싸우러 나선다.\n");
         */

        System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
        utility.enter();

        item.item_setting();
        /*
        대륙 선택
         */

        /*
        대륙 선택
         */
        //win = 7;
        System.out.println("'어떤 대륙에있는 악마들을 먼저 물리칠까...?'");
        while(true){
            if(win == 7){
                System.out.println("대륙을 모두 정복하여 자유를 되찾았습니다!!!");
                System.out.println("게임을 끝내려면 엔터를 누르세요.");
                게임시작bgm.setStop(true);
                utility.enter();
                승리소리.start();
                utility.victory_print();
                지연_1000.delay();
                System.exit(0);
            }

            utility.print("                              어떤 대륙을 정복 하시겠습니까?\n"+
                    "       1.북아메리카 2.남아메리카 3.남극 4.아프리카 5.유럽 6.아시아 7.오세아니아 8.도움말\n");
            newvalue = scan.nextInt();
            if(newvalue > 0 && newvalue < 9) {
                switch (newvalue) {
                    case 1:
                        if(north_america_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!north_america_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            north_america_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 2:
                        if(south_america_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!south_america_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            south_america_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 3:
                        if(south_pole_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!south_pole_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            south_pole_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 4:
                        if(africa_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!africa_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            africa_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 5:
                        if(europe_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!europe_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            europe_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 6:
                        if(asia_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!asia_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            //gameplay_utility.item_setting();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            asia_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 7:
                        if(oceania_victory){
                            System.out.println("정복한 대륙입니다. 다른 대륙을 정복하세요!!!");
                            break;
                        }
                        if(!oceania_victory) {
                            gameplay_utility.continent_selection(newvalue);
                            System.out.println("게임을 계속 진행하려면 엔터를 누르세요.");
                            utility.enter();
                            if(!demon_victory) {
                                gameplay_utility.demon_appearance();
                            }
                            if(!animal_demon_victory && demon_victory) {
                                gameplay_utility.animal_demon_appearance();
                            }
                            if(!great_demon_victory && demon_victory && animal_demon_victory){
                                gameplay_utility.great_demon_appearance();
                            }
                        }
                        if(great_demon_victory) {
                            대륙_정복소리 대륙_정복소리 = new 대륙_정복소리();
                            대륙_정복소리.start();
                            win++;
                            oceania_victory = true;
                            System.out.println("\n정복 완료!!!");
                            demon_victory = false;
                            animal_demon_victory = false;
                            great_demon_victory = false;
                        }
                        break;
                    case 8:
                        utility.print("                                     난이도(1~7)\n" +
                                "1.북아메리카(5) 2.남아메리카(4) 3.남극(3) 4.아프리카(6) 5.유럽(2) 6.아시아(7) 7.오세아니아(1)\n\n"+
                                "                        정복할 대륙을 다시 선택 하려면 엔터를 누르세요.\n");
                        utility.enter();
                        break;
                }
            }
            else{
                System.out.print("잘 못 선택 하셨습니다. 다시 선택해 주세요.");
            }
        }
    }
}