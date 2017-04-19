package ie.gmit.sw.ai;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HelloWorldApp {
	public static void main(String... args) throws InterruptedException, ExecutionException { // creating thread pool to execute task which implements Callable ExecutorService es = Executors.newSingleThreadExecutor(); System.out.println("submitted callable task to calculate factorial of 10"); Future result10 = es.submit(new FactorialCalculator(10)); System.out.println("submitted callable task to calculate factorial of 15"); Future result15 = es.submit(new FactorialCalculator(15)); System.out.println("submitted callable task to calculate factorial of 20"); Future result20 = es.submit(new FactorialCalculator(20)); System.out.println("Calling get method of Future to fetch result of factorial 10"); long factorialof10 = result10.get(); System.out.println("factorial of 10 is : " + factorialof10); System.out.println("Calling get method of Future to get result of factorial 15"); long factorialof15 = result15.get(); System.out.println("factorial of 15 is : " + factorialof15); System.out.println("Calling get method of Future to get result of factorial 20"); long factorialof20 = result20.get(); System.out.println("factorial of 20 is : " + factorialof20); } } class FactorialCalculator implements Callable<Long> { private int number; public FactorialCalculator(int number){ this.number = number; } @Override public Long call() throws Exception { return factorial(number); } private long factorial(int n) throws InterruptedException { long result = 1; while (n != 0) { result = n * result; n = n - 1; Thread.sleep(100); } return result; } 
		// creating thread pool to execute task which implements Callable 
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		System.out.println("submitted callable task to calculate factorial of 10"); 
		Future<Long> result10 = es.submit(new FactorialCalculator(10));

		System.out.println("submitted callable task to calculate factorial of 15"); 
		Future<Long> result15 = es.submit(new FactorialCalculator(15));

		System.out.println("submitted callable task to calculate factorial of 20"); 
		Future<Long> result20 = es.submit(new FactorialCalculator(20));
		
		System.out.println("Calling get method of Future to fetch result of factorial 10"); 
		long factorialof10 = result10.get(); System.out.println("factorial of 10 is : " + factorialof10);

		System.out.println("Calling get method of Future to get result of factorial 15"); 
		long factorialof15 = result15.get(); 
		System.out.println("factorial of 15 is : " + factorialof15);

		System.out.println("Calling get method of Future to get result of factorial 20"); 
		long factorialof20 = result20.get(); 
		System.out.println("factorial of 20 is : " + factorialof20);
	}
}
