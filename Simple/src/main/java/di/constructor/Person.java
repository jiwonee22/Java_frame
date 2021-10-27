package di.constructor;

import di.tire.GoldTire;
import di.tire.SilverTire;

public class Person {

	public static void main(String[] args) {
		
		Car car = new Car(new SilverTire());
		System.out.println(car.getTire());
		
		Car car2 = new Car(new GoldTire());
		System.out.println(car2.getTire());
		
		
	}
	
	
}
