import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {
    @Test
    public void test1() {
        //Every branch / Multiple Condition (i < timesList.size()) T, (hr < 0 || hr > 24) TX
        //Multiple Condition (hr < 0) T
        Time time = new Time(-1,30,30);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The hours are smaller than the minimum");
        }
    }

    @Test
    public void test2() {
        //Every branch / Multiple Condition (hr < 0 || hr > 24) FT
        //Multiple Condition (hr < 0) F
        Time Time = new Time(25,30,30);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The hours are grater than the maximum");
        }
    }

    @Test
    public void test3() {
        //Every branch / Multiple Condition (hr < 0 || hr > 24) FF
        // Multiple Condition (hr < 24) T, (min < 0 || min > 59) TX
        //Multiple condition (min<0 || min>59) FT
        Time Time = new Time(10,-1,0);
        Time Time2 = new Time(10,60,60);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The minutes are not valid!");
        }
    }

    @Test
    public void test4() {
        //Every branch / Multiple Condition (min < 0 || min > 59) FF
        // Multiple Condition (sec >= 0 && sec <= 59) TT
        Time Time = new Time(10,0,0);
        List<Time> TimesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        TimesList.add(Time);
        result = SILab2.function(TimesList);
        assertEquals(result.get(0).intValue(),Time.getHours()*3600 + Time.getMinutes()*60 + Time.getSeconds());
    }

    @Test
    public void test5() {
        //Every branch / Multiple Condition (sec >= 0 && sec <= 59) TF
        // Multiple Condition (hr == 24 && min == 0 && sec == 0) FXX
        //Multiple condition (sec >= 0 && sec <= 59) FX
        Time Time = new Time(10,0,60);
        Time Time2 = new Time(10,0,-1);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The seconds are not valid");
        }
    }

    @Test
    public void test6() {
        //Every branch / Multiple Condition (hr < 24) F
        // Multiple Condition (hr == 24 && min == 0 && sec == 0) TTT
        Time Time = new Time(24,0,0);
        List<Time> TimesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        TimesList.add(Time);
        result = SILab2.function(TimesList);
        assertEquals(result.get(0).intValue(),Time.getHours()*3600 + Time.getMinutes()*60 + Time.getSeconds());
    }

    @Test
    public void test7() {
        //Every branch / Multiple condition (hr == 24 && min == 0 && sec == 0) TTF,
        //(hr == 24 && min == 0 && sec == 0) TFX
        Time Time = new Time(24,1,0);
        Time Time3 = new Time(24,0,60);
        Time Time2 = new Time(24,60,-1);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time3);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The time is greater than the maximum");
        }
    }
    @Test
    public void test8() {
        //Multiple condition (i < timesList.size()) F
        List<Time> TimesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result = SILab2.function(TimesList);
        assertEquals(result.size(),0);
    }
    /*
    @Test
    public void test9() {
        //Multiple condition (min<0 || min>59) FT
        Time Time = new Time(10,60,60);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The minutes are not valid!");
        }
    }

    @Test
    public void test10() {
        //Multiple condition (sec >= 0 && sec <= 59) FX
        Time Time = new Time(10,0,-1);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The seconds are not valid");
        }
    }

    @Test
    public void test11() {
        //Multiple condition (hr == 24 && min == 0 && sec == 0) TTF, (hr == 24 && min == 0 && sec == 0) TFX
        Time Time = new Time(24,0,60);
        Time Time2 = new Time(24,60,-1);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The time is greater than the maximum");
        }
    }

    @Test
    public void test12() {
        //Multiple condition (hr == 24 && min == 0 && sec == 0) TFX
        Time Time = new Time(24,60,-1);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The time is greater than the maximum");
        }
    }
    */
}
