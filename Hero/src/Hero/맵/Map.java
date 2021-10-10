package Hero.맵;

public class Map {
    String name;
    int difficulty;

    public void print_name() {
        System.out.println(name + "대륙을 선택 했습니다.");
    }

    public int value() {
        return difficulty;
    }
}
