package com.training.martynenka;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class GroupingAndCountingTest {

    private final String TEXT_1 = "Я люблю море.Я лечу – на море.Я лечу плавать: в море.";
    private final String RESULT_1 = "В:  в 1\nЛ:  лечу 2\n\tлюблю 1\nМ:  море 3\nН:  на 1\nП:  плавать 1\nЯ:  я 3\n";
    private final String TEXT_2 = "1  2 слово 3 2 сЛово 1 1 2";
    private final String RESULT_2 = "1:  1 3\n2:  2 3\n3:  3 1\nС:  слово 2\n";
    private final String TEXT_3 = "Жили-были старик со старухой и была у старика со старухой курочка-Ряба, однажды снесла  курочка-ряба яичко,";
    private final String RESULT_3 = "Б:  была 1\nЖ:  жили-были 1\nИ:  и 1\nК:  курочка-ряба 2\nО:  однажды 1\nС:  снесла 1\n\tсо 2\n\tстарик 1\n\tстарика 1\n\tстарухой 2\nУ:  у 1\nЯ:  яичко 1\n";
    private final String TEXT_4 = "В России расположены города : Москва, Воронеж, Белгород, Орёл ...";
    private final String RESULT_4 = "Б:  белгород 1\nВ:  в 1\n\tворонеж 1\nГ:  города 1\nМ:  москва 1\nО:  орёл 1\nР:  расположены 1\n\tроссии 1\n";

    private GroupingAndCounting groupingAndCounting;

    @Before
    public void init() {
        groupingAndCounting = new GroupingAndCounting();
    }

    @Test
    public void toDoTest1() {
        Assert.assertEquals(RESULT_1, groupingAndCounting.groupAndCount(TEXT_1));
    }

    @Test
    public void toDoTest2() {
        Assert.assertEquals(RESULT_2, groupingAndCounting.groupAndCount(TEXT_2));
    }

    @Test
    public void toDoTest3() {
        Assert.assertEquals(RESULT_3, groupingAndCounting.groupAndCount(TEXT_3));
    }

    @Test
    public void toDoTest4() {
        Assert.assertEquals(RESULT_4, groupingAndCounting.groupAndCount(TEXT_4));
    }
}