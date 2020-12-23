import clothes.*;
import clothes.elements.Brand;
import clothes.elements.Color;
import clothes.elements.Size;
import clothes.type.TypeOfDownClothes;
import clothes.type.TypeOfUpperClothes;
import exception.WrongInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
public class WardrobeIT {
    ArrayList<Look> looks1,looks2;
    List<Wardrobe> wardrobeList;
    @Before
    public void setUp () {
        wardrobeList = new ArrayList<>();

        wardrobeList.add(mock(Wardrobe.class));
        wardrobeList.add(mock(Wardrobe.class));


        looks1 = new ArrayList<>();
        looks2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            looks1.add(mock(Look.class));
            looks2.add(mock(Look.class));
        }

        looks2.add(mock(Look.class));

    }

    @Test
    public void getJumperPriceSum_IsSumCorrect_True() {
        //GIVEN
        when(looks1.get(0).getPrice()).thenReturn(300f);
        when(looks1.get(0).getUpperClothes()).thenReturn("Jumper");

        when(looks1.get(1).getPrice()).thenReturn(100f);
        when(looks1.get(1).getUpperClothes()).thenReturn("Jumper");

        when(looks1.get(2).getPrice()).thenReturn(200f);
        when(looks1.get(2).getUpperClothes()).thenReturn("Blouse");


        float expected = 400;

        //WHEN
        float actual = Wardrobe.getJumperPriceSum(looks1);

        //THEN
        Assert.assertEquals(expected,actual,0);
        verify(looks1.get(2), times(0)).getPrice();
    }

    @Test
    public void ChangePrice_ChangePriceField_True(){
        when(looks1.get(0).getPrice()).thenReturn(200f);

        Sale sale1 = new Sale("Black Friday");
        Look look = new Look();
        sale1.changePrice(look, 200);

        Assert.assertEquals(looks1.get(0).getPrice(),look.getPrice(),0);
    }
    @Test(expected = WrongInputException.class)
    public void Input_IncorrectInput_ExceptionThrown()throws WrongInputException{
        doThrow(new WrongInputException("Not all data entered")).when(looks1.get(0)).input("");
        looks1.get(0).input("");
    }

    @Test
    public void getMostPopularTypeOfUpperCloth_IsPopularCorrect_True() {
        //GIVEN
        doReturn(true).when(looks1.get(0)).isExpensive();
        when(looks1.get(0).getUpperClothes()).thenReturn("Jumper");

        doReturn(false).when(looks1.get(1)).isExpensive();
        when(looks1.get(1).getUpperClothes()).thenReturn("Jumper");

        doReturn(false).when(looks1.get(2)).isExpensive();
        when(looks1.get(2).getUpperClothes()).thenReturn("Blouse");


        doReturn(false).when(looks2.get(0)).isExpensive();
        when(looks2.get(0).getUpperClothes()).thenReturn("Jumper");

        doReturn(true).when(looks2.get(1)).isExpensive();
        when(looks2.get(1).getUpperClothes()).thenReturn("Undershirt");

        doReturn(false).when(looks2.get(2)).isExpensive();
        when(looks2.get(2).getUpperClothes()).thenReturn("Undershirt");

        doReturn(true).when(looks2.get(3)).isExpensive();
        when(looks2.get(3).getUpperClothes()).thenReturn("Undershirt");


        when(wardrobeList.get(0).getLooks()).thenReturn(looks1);
        when(wardrobeList.get(1).getLooks()).thenReturn(looks2);

        List<String> expected = Arrays.asList("Jumper", "Undershirt");

        //WHEN
        List<String> result = Wardrobe.getMostPopularTypeOfUpperCloth(wardrobeList);

        //THEN
        Assert.assertEquals(expected,result);
        verify(looks2.get(3), times(1)).getUpperClothes();
    }


}