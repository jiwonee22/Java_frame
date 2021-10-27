package di.setter;

import di.tire.GoldTire;
import di.tire.SilverTire;

public class Person {
	
	public static void main(String[] args) {
		
		Car car1 = new Car();
		car1.setTire(new GoldTire());
		System.out.println(car1.getTire());

		Car car2 = new Car();
		car2.setTire(new SilverTire());
		System.out.println(car2.getTire());
	}
}
