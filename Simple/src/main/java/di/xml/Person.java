package di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {
	public static void main(String[] args) {
		
		
		//스프링 어플리케이션 컨텍스트 객체
		ApplicationContext context = null;
		
		context = new FileSystemXmlApplicationContext("/src/main/java/di/xml/di.xml");
		
		//-------------------------------------------------------------------------------------
		
		//Spring 컨텍스트에 등록된 "car"라는 이름의 스프링빈 객체로 의존성 주입하기
		Car car = (Car) context.getBean("car");
		
		//Spring 컨텍스트에 등록된 "gTire"라는 이름의 스프링빈 객체로 의존성 주입하기
		car.setTire((Tire) context.getBean("gTire"));
		
		System.out.println(car);
		System.out.println(car.getInfo());
		
		System.out.println("---------------------------------");
		
		Car car1 = (Car) context.getBean("car");
		car1.setTire((Tire) context.getBean("sTire"));
		
		System.out.println("car1 : " + car1);
		System.out.println("car1 info : " + car1.getInfo());
		
		System.out.println("---------------------------------");
		
		Car car2 = (Car) context.getBean("car");
		car2.setTire((Tire) context.getBean("gTire"));
		
		System.out.println("car2 : " + car2);
		System.out.println("car2 info : " + car2.getInfo());
		
		
	}
	
	

}
