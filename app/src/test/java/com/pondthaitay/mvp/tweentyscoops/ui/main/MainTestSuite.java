package com.pondthaitay.mvp.tweentyscoops.ui.main;

import com.pondthaitay.mvp.tweentyscoops.ui.main.frangment.MainFragmentPresenterTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorMetricPlusTest.class,
        CalculatorMetricMinusTest.class,
        CalculatorMetricDivideTest.class,
        CalculatorMetricMultiplyTest.class,
        MainActivityPresenterTest.class,
        MainFragmentPresenterTest.class
})
public class MainTestSuite {
}
