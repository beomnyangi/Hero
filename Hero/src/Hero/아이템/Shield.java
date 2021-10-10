package Hero.아이템;

public class Shield extends Defense_Item {
    public Shield(){
        name = "방패";
        //ability = 4.761904761904762;
        ability = 100;
        accumulate += ability;
    }
}