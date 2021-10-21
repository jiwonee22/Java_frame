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
	
	//DB ���� �� SQL���ఴü �����ϱ�
	private static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	public static void main(String[] args) {
		
		//���̹�Ƽ�� ���� ��ü
				SqlSession sqlSession = null;
					
				//DB ���� �� SQL���ఴü �����ϱ�
				sqlSession = sqlSessionFactory.openSession(true); //�Ű������� true�� ��� Auto Commit
				
				//------------------------------------------------------------------------------------------
				
				//���̹�Ƽ���� ���ۿ� �ڹ����α׷��� DAO�������̽��� ���εȴ�(����ȴ�)
				EmpDao empDao = sqlSession.getMapper(EmpDao.class);
				
				System.out.println("���̹�Ƽ�� �ε� �Ϸ�");
				
				//------------------------------------------------------------------------------------------
				
				List<Emp> list1 = empDao.selectAll();
				
				System.out.println("--- ���� ��ü ��� ---");
				for(Emp e : list1) {
					System.out.println(e);
				}
				
				//------------------------------------------------------------------------------------------
				
				System.out.println("--- ���ο� ���� ���� ���� ---");
				
				Emp newEmp = new Emp();
				
				Scanner sc1 = new Scanner(System.in);
				
				System.out.print("��� ��ȣ : ");
				newEmp.setEmpno(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("��� �̸� : ");
				newEmp.setEname(sc1.nextLine());
				
				System.out.print("���� : ");
				newEmp.setJob(sc1.nextLine());
				
				System.out.print("�Ŵ��� ��ȣ : ");
				newEmp.setMgr(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("�Ի��� : ");
				String param = sc1.nextLine();
				
				//��¥ ������ ���ڿ� -> java.util.Date ��ȯ ��ü
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
				Date hiredate = null;
				try {
					hiredate = sdf.parse(param);
				} catch (ParseException e1) {
					e1.printStackTrace();
					System.err.println("yyyy-MM-dd �������� �Է� �ٶ��ϴ�");
				}
				
				newEmp.setHiredate(hiredate);
				
				sc1.nextLine();
				System.out.print("���� : ");
				newEmp.setSal(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("�󿩱� : ");
				newEmp.setComm(sc1.nextInt());
				
				sc1.nextLine();
				System.out.print("�μ� ��ȣ : ");
				newEmp.setDeptno(sc1.nextInt());
				
				
				//�ߺ� Ȯ��
				Emp res1 = empDao.selectByEmpno(newEmp.getEmpno());
				
				
				if(res1 == null) {
					System.out.println("ȸ����ȣ �ߺ� ����");
					int rows = empDao.insertEmp(newEmp);
					System.out.println(rows);
					
				} else {
					System.out.println("�̹� �����ϴ� ���� ��ȣ�Դϴ�");
				}
				
				//-------------------------------------------------------------
				
				System.out.println("--- �������� �����ϱ� ---");
				
				Scanner sc2 = new Scanner(System.in);
				
				System.out.print("������ ȸ�� ��ȣ : ");
				int deleteEmpno = sc2.nextInt();
				
				
				//�����ϴ� ȸ�� ��ȣ���� Ȯ��
				Emp res2 = empDao.selectByEmpno(deleteEmpno);
				
				if(res2 == null) {
					System.out.println("��ġ�ϴ� ȸ�� ������ �����ϴ�");
					
				} else {
					int rows = empDao.deleteByEmpno(deleteEmpno);
					System.out.println(rows);
					System.out.println("�����Ǿ����ϴ�");
				}
				
				//-------------------------------------------------------------

				//�����ƴ��� ����Ʈ�� �ٽ� Ȯ���ϱ�
				List<Emp> list2 = empDao.selectAll();
				
				System.out.println("--- ���� ��ü ��� ---");
				for(Emp e : list2) {
					System.out.println(e);
				}
				

				
		
	}
}
