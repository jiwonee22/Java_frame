package di.dependency;

import di.tire.GoldTire;
import di.tire.Tire;

public class Car {
	
	private Tire tire;
	
	public Car() {
		
		//의존성이 발생한다
		tire = new GoldTire();
//		tire = new SilverTire();
	}
	
	public String getTire() {
		return tire.getProduct() + "장착";
	}

}
