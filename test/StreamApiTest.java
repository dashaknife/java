import clothes.*;
import clothes.type.*;
import clothes.elements.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StreamApiTest {
    private ArrayList<Look> looks,looks1;
    Wardrobe wardrobe1, wardrobe2;
    @Before
    public void init() {
        looks = new ArrayList<>();
        looks.add(new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 300));
        looks.add(new Look("Tuesday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 100));
        looks.add(new Look("Wednesday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Blouse),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 200));
        looks1 = new ArrayList<>();
        looks1.add(new Look("Thursday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 50));
        looks1.add(new Look("Friday",   new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Undershirt),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 400));
        looks1.add(new Look("Saturday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Undershirt),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 150));
        looks1.add(new Look("Sunday",   new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Undershirt),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 500));

        wardrobe1 = new Wardrobe(looks);
        wardrobe2 = new Wardrobe(looks1);
    }
    @Test
    public void getJumperPriceSum_IsSumCorrect_True() {
        //GIVEN
        float expected = 400;

        //WHEN
        float actual = Wardrobe.getJumperPriceSum(looks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }
    @Test
    public void getJumperPriceSum_IsNull_True() {
        //GIVEN
        float expected = 0;

        //WHEN
        float actual = Wardrobe.getJumperPriceSum(null);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }
    @Test
    public void getJumperPriceSum_isEmpty_True() {
        //GIVEN
        looks = new ArrayList<>();
//        looks.add(new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Blouse),
//                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 300));
//        looks.add(new Look("Tuesday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Undershirt),
//                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 100));
//        looks.add(new Look("Wednesday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Blouse),
//                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 200));
        float expected = 0;
        //WHEN
        float actual = Wardrobe.getJumperPriceSum(looks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getMaxPrice_IsMaxCorrect_True() {
        //GIVEN
        double expected = 300;

        //WHEN
        float actual = Wardrobe.getMaxPrice(looks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getAveragePrice_IsAverageCorrect_True() {
        //GIVEN
        double expected = 200;

        //WHEN

        float actual = Wardrobe.getAveragePrice(looks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getGroupByCondition_isFilterCorrect_True() {
        //GIVEN
        Map<Boolean, List<Look>> expected = new HashMap<>();
        expected.put(Boolean.TRUE, Arrays.asList(looks.get(0)));
        expected.put(Boolean.FALSE, Arrays.asList(looks.get(1),looks.get(2)));

        //WHEN
        Map<Boolean, List<Look>> actual;
        actual = Wardrobe.getGroupByCondition(looks,p -> p.getUpperClothes().equals(TypeOfUpperClothes.Jumper.getUpper_s()) &&
                p.getPrice()>100);

        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostPopularTypeOfUpperCloth_IsPopularCorrect_True() {
        //GIVEN
        List<Wardrobe> wardrobeList = Arrays.asList(wardrobe1, wardrobe2);
        List<String> expected = Arrays.asList("Jumper", "Undershirt");

        //WHEN
        List<String> actual = Wardrobe.getMostPopularTypeOfUpperCloth(wardrobeList);

        //THEN
        Assert.assertEquals(actual, expected);
    }
}
