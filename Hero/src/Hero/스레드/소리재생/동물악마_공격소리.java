package Hero.스레드.소리재생;

import Hero.소리재생.소리재생;

public class 동물악마_공격소리 extends Thread {
    소리재생 소리재생 = new 소리재생("D:\\teamnova\\5주 - java 스레드, 해시 테이블\\게임2_Hero\\소리\\동물악마_공격소리.wav");
    public void run(){
        소리재생.play();
    }
}
