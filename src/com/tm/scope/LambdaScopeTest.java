package com.tm.scope;

import java.util.function.Consumer;

public class LambdaScopeTest {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {

			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x); // Statement A
				System.out.println("y = " + y);
				System.out.println("this.x = " + this.x);
				System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
			};

			myConsumer.accept(x);

		}
	}

	public static void main(String... args) {
		LambdaScopeTest st = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}
/*
 * This example generates the following output:
 * 
 * x = 23 y = 23 this.x = 1 LambdaScopeTest.this.x = 0 If you substitute the
 * parameter x in place of y in the declaration of the lambda expression
 * myConsumer, then the compiler generates an error:
 * 
 * Consumer<Integer> myConsumer = (x) -> { // ... }
 */
