package Hero.스레드.프린트;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 프린트_지연 extends Thread{
    String filename;
    int delay;
    public 프린트_지연(String filename, int delay){
        this.filename = filename;
        this.delay = delay;
    }
    public void run(){
        try{
            //파일 객체 생성
            File file = new File(filename);//파일경로 설정
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            int singleCh = 0;
            while((singleCh = filereader.read()) != -1){
                System.out.print((char)singleCh);
                Thread.sleep(delay);//지연시간 설정
            }
            filereader.close();
        }catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
