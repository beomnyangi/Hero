package Hero.스레드.로그인;

import java.util.Hashtable;
import java.util.Scanner;

public class 로그인 extends Thread {
    Scanner scan = new Scanner(System.in);

    Hashtable<String, String> ht = new Hashtable<String, String>();

    String id;
    String pass;
    boolean id_result;
    boolean pass_result;
    int intvalue;

    public void run() {
        ht.put("beom", "qlqjs");
        //System.out.println(ht.get("beom"));
        while(true){
            System.out.println("\n로그인 하세요.\n");
            System.out.print("아이디 : ");
            id = scan.next();
            System.out.print("비밀번호 : ");
            pass = scan.next();
            System.out.println();
            id_result = ht.containsKey(id);

            if(id_result == true){
                pass_result = ht.containsValue(pass);
                if(pass_result == true){
                    System.out.println("로그인 성공");
                    break;
                }
                else if(pass_result == false){
                    System.out.println("비밀번호가 틀렸습니다.");
                    System.out.println("비밀번호를 확인 하시겠습니까?");
                    System.out.println("1.예 2.아니요");
                    intvalue = scan.nextInt();
                    while (intvalue != 1 && intvalue != 2) {
                        System.out.println("잘못된 값입니다");
                        System.out.println("다시 선택해 주세요");
                        intvalue = scan.nextInt();
                    }
                    if(intvalue == 1){
                        System.out.print("\n비밀번호 : ");
                        System.out.println(ht.get(id));
                        continue;
                    }
                    else if(intvalue == 2){
                        continue;
                    }
                    continue;
                }
            }
            else if(id_result == false){
                System.out.println("존재하지 않는 아이디입니다.");
                System.out.println("회원가입 하시겠습니까?");
                System.out.println("1.예 2.아니요");
                intvalue = scan.nextInt();
                while (intvalue != 1 && intvalue != 2) {
                    System.out.println("잘못된 값입니다");
                    System.out.println("다시 선택해 주세요");
                    intvalue = scan.nextInt();
                }
                if(intvalue == 1){
                    while(true){
                        System.out.print("설정 할 아이디 : ");
                        id = scan.next();
                        if(ht.containsKey(id) == false) {
                            System.out.print("설정 할 비밀번호 : ");
                            pass = scan.next();
                        }
                        if(ht.containsKey(id) == true){
                            System.out.println("존재하는 아이디 입니다. 다른 아이디로 설정 해 주세요");
                        }
                        else if(ht.containsKey(id) == false){
                            ht.put(id, pass);
                            System.out.println("회원가입 완료");
                            break;
                        }
                    }
                }
                else if(intvalue == 2){
                    continue;
                }

            }
        }
    }
}
