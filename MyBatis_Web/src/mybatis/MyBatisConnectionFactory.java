package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	
	//SqlSession객체를 생성하는 팩토리객체
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		//마이바티스 Configuration XML 파일의 경로
		String res = "mybatis/mybatis-config.xml";
		
		
		try {
			//resource에 필요한 파일을 불러와서 reader형태로 변환해서 반환함.
			//Configuration XML파일을 이용한 입력 스트림 생성
			Reader reader = Resources.getResourceAsReader(res);
			
			//싱글톤 유지 코드
			if(sqlSessionFactory == null) {
				
				//입력 스트림으로 읽어들인 설정파일을 이용하여  SqlsessionFactory객체 생성
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//private 생성자
	private MyBatisConnectionFactory() {}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
}
