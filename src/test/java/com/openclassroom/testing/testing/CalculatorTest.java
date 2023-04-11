package com.openclassroom.testing.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;


import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class CalculatorTest {
	private Calculator 	calculatorTest ;
	private static  Instant startedAt;

	@BeforeEach
	public void initCalculator() {
		calculatorTest = new Calculator();
		System.out.println("Appel avant chaque test");

	}

	@AfterEach
	public void undefCalculator() {
		System.out.println("Appel après chaque test");
		calculatorTest = null;

	}

	@BeforeAll()
	public static  void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();	
	}

	@AfterAll
	public static void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endAt = Instant.now();
		long duration = Duration.between(startedAt, endAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tets : {0} ms",  duration));
	}
	
	@ParameterizedTest(name ="{0} x 0 doit être égale à 0")
	@ValueSource(ints = {1, 2, 42, 1011, 5089})
	public void multiply_shouldReturnZeroWithMultipleIntegers(int arg) {
		//ARRANGE (GIVEN) --tout est pret! 
		
		//ACT(WHEN)--Multiplier par zéro
		int actualResultat = calculatorTest.multiply(arg, 0);
		
		//ASSERT(THAN) --ça vaut toujours zéro
		assertThat(actualResultat ).isEqualTo(0);
		
	}
	
	@ParameterizedTest(name ="{0} + {1} should equals to {2}")
	@CsvSource({"1,1,2","2,3,5", "42,57,99"})
	public void add_shouldReturnZeroWithMultipleIntegers(int arg1, int arg2,int expectResult ) {
		//ARRANGE(GIVEN) --tout est pret! 
		
		//ACT(WHEN)--
		int actualResultat = calculatorTest.add(arg1,arg2);
		
		//ASSERT(THAN))--
		assertThat(actualResultat ).isEqualTo(expectResult);
		
		
	}
	
	@Timeout(1)
	@Test
	public void longCalcul_shouldComputeInLessThan1Second() {
		// Arrange (GIVEN)

		// Act(WHEN)
		calculatorTest.longCalculation();
		
		// Assert(THAN)
		// ...
	}
	
	@Test
	void addTwoPositiveNumbers() {
		//ARRANGE (GIVEN)
		int a = 2;
		int b = 3;
		//Calculator calculator = new Calculator();

		//ACT (WHEN)
		int somme = calculatorTest.add(a,b);

		//ASSERT (THAN)
		assertThat(somme ).isEqualTo(5);
		
	

	}

	@Test
	void multiplytwopositiveNumbers() {

		//ARRANGE (GIVEN)
		int a = 12;
		int b = 12;
		//Calculator calculator = new Calculator();

		//ACT( WHEN)
		int mult = calculatorTest.multiply(a,b);

		//ASSERT(THAN)
		assertThat( mult ).isEqualTo(144);
		
	}
	
	@Test
	public void digitsSet_shouldReturnsTheSetOfDigits_ofPositiveInteger() {
		// GIVEN
		final int number = 95897;

		// WHEN
		final Set<Integer> actualDigits = calculatorTest.digitsSet(number);

		// THEN
		final Set<Integer> exceptedDigits = Stream.of( 5, 7, 8,9).collect(Collectors.toSet());
		//assertEquals(exceptedDigits, actualDigits);
		assertThat(actualDigits).containsExactlyInAnyOrder( 9, 5, 8,7);
	}
	
	@Test
	public void digitsSet_shouldReturnsTheSetOfDigits_ofNegatifInteger() {
		// GIVEN
		final int number = -12434;

		// WHEN
		final Set<Integer> actualDigits = calculatorTest.digitsSet(number);

		// THEN
		final Set<Integer> exceptedDigits = Stream.of( 1, 2, 4, 3).collect(Collectors.toSet());
		//assertEquals(exceptedDigits, actualDigits);
		assertThat(actualDigits).containsExactlyInAnyOrder(  1, 2, 4, 3);
	}

	@Test
	public void digitsSet_shouldReturnsTheSetOfZero_ofZero() {
		// GIVEN
		final int number = 0;

		// WHEN
		final Set<Integer> actualDigits = calculatorTest.digitsSet(number);

		// THEN
		assertThat(actualDigits).containsExactlyInAnyOrder( 0);
	}
























	//	void test() {
	//		fail("Not yet implemented");
	//	}

}
