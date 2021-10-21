package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	
	//DB 접속 및 SQL수행객체 생성하기
	private static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	public static void main(String[] args) {
		
		//마이바티스 실행 객체
				SqlSession sqlSession = null;
					
				//DB 접속 및 SQL수행객체 생성하기
				sqlSession = sqlSessionFactory.openSession(true); //매개변수가 true일 경우 Auto Commit
				
				//------------------------------------------------------------------------------------------
				
				//마이바티스의 매퍼와 자바프로그램의 DAO인터페이스가 매핑된다(연결된다)
				EmpDao empDao = sqlSession.getMapper(EmpDao.class);
				
				System.out.println("마이바티스 로드 완료");
				
				//------------------------------------------------------------------------------------------
				
				List<Emp> list1 = empDao.selectAll();
				
				System.out.println("--- 직원 전체 목록 ---");
				for(Emp e : list1) {
					System.out.println(e);
				}
				
				//------------------------------------------------------------------------------------------
				
				System.out.println("--- 새로운 직원 정보 삽입 ---");
				
				Emp newEmp = new Emp();
				
				Scanner sc1 = new Scanner(System.in);
				
				System.out.print("사원 번호 : ");
				newEmp.setEmpno(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("사원 이름 : ");
				newEmp.setEname(sc1.nextLine());
				
				System.out.print("직급 : ");
				newEmp.setJob(sc1.nextLine());
				
				System.out.print("매니저 번호 : ");
				newEmp.setMgr(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("입사일 : ");
				String param = sc1.nextLine();
				
				//날짜 형식의 문자열 -> java.util.Date 변환 객체
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
				Date hiredate = null;
				try {
					hiredate = sdf.parse(param);
				} catch (ParseException e1) {
					e1.printStackTrace();
					System.err.println("yyyy-MM-dd 형식으로 입력 바랍니다");
				}
				
				newEmp.setHiredate(hiredate);
				
				sc1.nextLine();
				System.out.print("월급 : ");
				newEmp.setSal(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("상여금 : ");
				newEmp.setComm(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("부서 번호 : ");
				newEmp.setDeptno(sc1.nextInt());
				
				
				//중복 확인
				Emp res1 = empDao.selectByEmpno(newEmp.getEmpno());
				
				
				if(res1 == null) {
					System.out.println("회원번호 중복 없음");
					int rows = empDao.insertEmp(newEmp);
					System.out.println(rows);
					
				} else {
					System.out.println("이미 존재하는 직원 번호입니다");
				}
				
				//-------------------------------------------------------------
				
				System.out.println("--- 직원정보 삭제하기 ---");
				
				Scanner sc2 = new Scanner(System.in);
				
				System.out.print("삭제할 회원 번호 : ");
				int deleteEmpno = sc2.nextInt();
				
				
				//존재하는 회원 번호인지 확인
				Emp res2 = empDao.selectByEmpno(deleteEmpno);
				
				if(res2 == null) {
					System.out.println("일치하는 회원 정보가 없습니다");
					
				} else {
					int rows = empDao.deleteByEmpno(deleteEmpno);
					System.out.println(rows);
					System.out.println("삭제되었습니다");
				}
				
				//-------------------------------------------------------------

				//삭제됐는지 리스트로 다시 확인하기
				List<Emp> list2 = empDao.selectAll();
				
				System.out.println("--- 직원 전체 목록 ---");
				for(Emp e : list2) {
					System.out.println(e);
				}
				

				
		
	}
}
