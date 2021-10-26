package selectKey.dao;

import org.apache.ibatis.annotations.Param;

import selectKey.dto.TestMember;

public interface SelectKeyDao {
	
	//DAO를 통해 Mapper로 여러 개의 매개변수를 전달 할 수 있다
	//	-> 전달되는 파라미터의 이름은 @Param("이름")으로 설정한다
//	public void insert(@Param("userid") String id, @Param("userpw") String pw);

	public void insert(TestMember tm);
}
