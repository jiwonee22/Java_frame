package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * emp ���̺� ��ü ��ȸ
	 * 
	 * @return List�������� ��ȸ
	 */
	public List<Emp> selectAll();

	/**
	 * empno�� Emp ��ü ��ȸ�ϱ�
	 * 
	 * @param empno
	 * @return Emp ��ü
	 */
	public Emp selectByEmpno(int empno);
	
	/**
	 * ���ο� ���� ���� ����
	 * 
	 * @param newEmp -  ������ Emp ��ü
	 * @return ������� �� ��
	 */
	public int insertEmp(Emp newEmp);

	/**
	 * �Է¹��� ���� ��ȣ�� ���� ���� ����
	 * 
	 * @param deleteEmpno - ���� ��ȣ
	 * @return ������� �� ��
	 */
	public int deleteByEmpno(int deleteEmpno);

}
