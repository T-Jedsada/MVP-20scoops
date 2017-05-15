package com.pondthaitay.mvp.tweentyscoops.ui.main;

import com.pondthaitay.mvp.tweentyscoops.manager.Calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorMetricPlusTest {

    private int[] numbers = new int[3];
    private Calculator calculator = Calculator.getInstance();

    public CalculatorMetricPlusTest(int n1, int n2, int n3) {
        numbers[0] = n1;
        numbers[1] = n2;
        numbers[2] = n3;
    }

    @Parameterized.Parameters(name = "test case {index}: {0}+{1}={2}")
    public static List<Object[]> setupData() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {2, 2, 4},
                {2, 3, 5},
        });
    }

    @Test
    public void plus() throws Exception {
        assertThat(calculator.plus(numbers[0] , numbers[1]), is(numbers[2]));
    }
}
