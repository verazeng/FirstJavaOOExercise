import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
/**
 * Created by hzeng on 6/26/14.
 */
public class LengthTest {
    private Length lenM = Length.getLength(1.2, Unit.M);
    private Length lenCM = Length.getLength(5.2, Unit.CM);
    private Length lenMM = Length.getLength(10.2, Unit.MM);

    @Test
    public  void  testNewLengthObject()
    {
        assertThat(lenM.getValue(), is(1.2));
        assertThat(lenM.getUnit(), equalTo("m"));

        assertThat(lenCM.getValue(), is(5.2));
        assertThat(lenCM.getUnit(), equalTo("cm"));

        assertThat(lenMM.getValue(), is(10.2));
        assertThat(lenMM.getUnit(), equalTo("mm"));
    }

    @Test
    public  void testAdd()
    {
        //test left operand unit M
        Length lenMAddM = lenM.add(lenM);
        assertThat(lenMAddM.getValue(), is(2.4));
        assertThat(lenMAddM.getUnit(), equalTo("m"));

        Length lenMAddCM = lenM.add(lenCM);
        assertThat(lenMAddCM.getValue(), is(125.2));
        assertThat(lenMAddCM.getUnit(), equalTo("cm"));

        Length lenMAddMM = lenM.add(lenMM);
        assertThat(lenMAddMM.getValue(), is(1210.2));
        assertThat(lenMAddMM.getUnit(), equalTo("mm"));


        //test left operand unit CM
        Length lenCMAddM = lenCM.add(lenM);
        assertThat(lenCMAddM.getValue(), is(125.2));
        assertThat(lenCMAddM.getUnit(), equalTo("cm"));

        Length lenCMAddCM = lenCM.add(lenCM);
        assertThat(lenCMAddCM.getValue(), is(10.4));
        assertThat(lenCMAddCM.getUnit(), equalTo("cm"));

        Length lenCMAddMM = lenCM.add(lenMM);
        assertThat(lenCMAddMM.getValue(), is(62.2));
        assertThat(lenCMAddMM.getUnit(), equalTo("mm"));


        //test left operand unit MM
        Length lenMMAddM = lenMM.add(lenM);
        assertThat(lenMMAddM.getValue(), is(1210.2));
        assertThat(lenMMAddM.getUnit(), equalTo("mm"));

        Length lenMMAddCM = lenMM.add(lenCM);
        assertThat(lenMMAddCM.getValue(), is(62.2));
        assertThat(lenMMAddCM.getUnit(), equalTo("mm"));

        Length lenMMAddMM = lenMM.add(lenMM);
        assertThat(lenMMAddMM.getValue(), is(20.2));
        assertThat(lenMMAddMM.getUnit(), equalTo("mm"));
    }

    @Test
    public  void testSubtract()
    {
        //test left operand unit M
        Length lenM1 = Length.getLength(2.5, Unit.M);
        Length lenMSubM = lenM1.subtract(lenM);
        assertThat(lenMSubM.getValue(), is(1.3));
        assertThat(lenMSubM.getUnit(), equalTo("m"));

        Length lenMSubCM = lenM.subtract(lenCM);
        assertThat(lenMSubCM.getValue(), is(114.8));
        assertThat(lenMSubCM.getUnit(), equalTo("cm"));

        Length lenMSubMM = lenM.subtract(lenMM);
        assertThat(lenMSubMM.getValue(), is(1189.8));
        assertThat(lenMSubMM.getUnit(), equalTo("mm"));


        //test left operand unit CM
        Length lenCM1 = Length.getLength(10.5, Unit.CM);
        Length lenCMSubM = lenCM.subtract(lenM);
        assertThat(lenCMSubM.getValue(), is(-114.8));
        assertThat(lenCMSubM.getUnit(), equalTo("cm"));

        Length lenCMSubCM = lenCM.subtract(lenCM1);
        assertThat(lenCMSubCM.getValue(), is(-5.3));
        assertThat(lenCMSubCM.getUnit(), equalTo("cm"));

        Length lenCMSubMM = lenCM.subtract(lenMM);
        assertThat(lenCMSubMM.getValue(), is(41.8));
        assertThat(lenCMSubMM.getUnit(), equalTo("mm"));


        //test left operand unit MM
        Length lenMM1 = Length.getLength(20.5, Unit.MM);
        Length lenMMSubM = lenMM.subtract(lenM);
        assertThat(lenMMSubM.getValue(), is(-1189.8));
        assertThat(lenMMSubM.getUnit(), equalTo("mm"));

        Length lenMMSubCM = lenMM.subtract(lenCM);
        assertThat(lenMMSubCM.getValue(), is(-41.8));
        assertThat(lenMMSubCM.getUnit(), equalTo("mm"));

        Length lenMMSubMM = lenMM.subtract(lenMM1);
        assertThat(lenMMSubMM.getValue(), is(-10.3));
        assertThat(lenMMSubMM.getUnit(), equalTo("mm"));
    }

    @Test
    public  void testDivide()
    {
        double divider = 2.5;

        Length lenMDiv = lenM.divide(divider);
        assertThat(lenMDiv.getValue(), is(0.48));
        assertThat(lenMDiv.getUnit(), equalTo("m"));

        Length lenCMDiv = lenCM.divide(divider);
        assertThat(lenCMDiv.getValue(), is(2.08));
        assertThat(lenCMDiv.getUnit(), equalTo("cm"));

        Length lenMMDiv = lenMM.divide(divider);
        assertThat(lenMMDiv.getValue(), is(4.08));
        assertThat(lenMMDiv.getUnit(), equalTo("mm"));
    }

    @Test
    public  void testMultiply()
    {
        double multiplier = 5.5;

        Length lenMMul = lenM.multiply(multiplier);
        assertThat(lenMMul.getValue(), is(6.6));
        assertThat(lenMMul.getUnit(), equalTo("m"));

        Length lenCMMul = lenCM.multiply(multiplier);
        assertThat(lenCMMul.getValue(), is(28.6));
        assertThat(lenCMMul.getUnit(), equalTo("cm"));

        Length lenMMMul = lenMM.multiply(multiplier);
        assertThat(lenMMMul.getValue(), closeTo(56.1, 0.01));
        assertThat(lenMMMul.getUnit(), equalTo("mm"));
    }
}
