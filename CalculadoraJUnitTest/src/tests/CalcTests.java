package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import calculators.CalculadoraCientifica;

@RunWith(Suite.class)
@SuiteClasses({ CalculadoraTest.class, CalculadoraCientifica.class })
public class CalcTests {
}
