package controller;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.face.DeptDao;
import dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class MyBatisEx {
	
	public static void main(String[] args) {
		
		//���̹�Ƽ�� ���� ��ü
		SqlSession sqlSession = null;
		
		//DB ���� �� SQL���ఴü �����ϱ�
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		//DB ���� �� SQL���ఴü �����ϱ�
		sqlSession = sqlSessionFactory.openSession(true); //�Ű������� true�� ��� Auto Commit
		
		//------------------------------------------------------------------------------------------
		
		//���̹�Ƽ���� ���ۿ� �ڹ����α׷��� DAO�������̽��� ���εȴ�(����ȴ�)
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		System.out.println("���̹�Ƽ�� �ε� �Ϸ�");
		
		//------------------------------------------------------------------------------------------
		
		//���̹�Ƽ���� �̿��� SQL ����
		Dept dept = deptDao.selectByDeptno(20);
		System.out.println(dept);
		
		//------------------------------------------------------------------------------------------
		
		//��ü �μ����� ��ȸ
		List<Dept> list = deptDao.selectAll();
		
		System.out.println("\n--- ��ü ��� -----");
		for(Dept d : list) {
			System.out.println(d);
		}
		
		//------------------------------------------------------------------------------------------
		
		String str = "ACCOUNTING";
//		Dept result1 = deptDao.selectByDname(str);
//		Dept result1 = deptDao.selectByDname("SALES");
		Dept result1 = deptDao.selectByDname("OPERATIONS");
		
		System.out.println("\n--- �μ����� �̿��� ��ȸ -----");
		System.out.println(result1);
		
		//------------------------------------------------------------------------------------------
		
		Dept data = new Dept();
		data.setDname("RESEARCH");
		
		Dept result2 = deptDao.selectByDnameDept(data);
		System.out.println("\n--- �μ���(DTO)�� �̿��� ��ȸ -----");
		System.out.println(result2);
		
		//------------------------------------------------------------------------------------------
		
		System.out.println("\n--- ���ο� �μ� ���� ���� -----");
		Dept input = new Dept();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�μ� ��ȣ? ");
		input.setDeptno(sc.nextInt());

		sc.nextLine(); //���� ����
		System.out.print("�μ� �̸�? ");
		input.setDname(sc.nextLine());
		
		System.out.print("��ġ? ");
		input.setLoc(sc.nextLine());
		
		//�ߺ� Ȯ��
		Dept res = deptDao.selectByDeptno(input.getDeptno());
//		System.out.println(res);
		
		if(res == null) { //�ߺ� ������ ����
			
			//�μ� ���� ����
			int rows = deptDao.insert(input);
			System.out.println("SQL ���� ���� ������� �� �� : " + rows);
			
			//DB Commit
//			sqlSession.commit();
			
			//���� ��� Ȯ��
			Dept insertResult = deptDao.selectByDeptno(input.getDeptno());
			
			System.out.println("\n--- ���� ��� -----");
			System.out.println(insertResult);
			
		} else {
			System.out.println("�̹� �����ϴ� �μ� ��ȣ�Դϴ�");
		}
		
		
	}


}