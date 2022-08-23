package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MyBatisTest {
	// 메인이 들어갈 부분
	public static void main(String[] args) {
		// 세션을 가져옴
		SqlSession session = SqlMapClient.getSession();
		
		int result = 0;
		// 바구니
		String id = "www"; // 없는 아이디
		
		// 삭제부분 추가
		result = session.delete("User.deleteUser", id);
		if(result == 0) {
			System.out.println("탈퇴 실패");
		} else {
			System.out.println("탈퇴 성공");
		}
		
		
		// 가입
		User kim = new User();
		kim.setId(id);
		kim.setPasswd("111");
		kim.setName("김유신");
		kim.setTel("1234-5678");
		
		// insert, delete, updaet
		// 이부분이 가입
		result = session.insert("User.insertUser", kim); // 문자열안이 아이디, kim 이라는 데이터를 던져줌
		if(result == 0) {
			System.out.println("가입 실패");
		} else {
			System.out.println("가입 성공");
		}
		
		
		// select All 전체 출력
		// 하나면 selectone
		// 전체면 selectlist
		// 전체출력이기에 List로 받음
		List<User> users = session.selectList("User.getUsers");
		for(User user : users) {
			System.out.println(user.getId() + "\t" + user.getPasswd() + "\t" + user.getName() 
								+ "\t" + user.getTel() + "\t" + user.getLogtime());
		}
		
		// update
		// 바꿀 값
		kim.setPasswd("123");
		kim.setTel("9876-5432");
		result = session.update("User.updateUser", kim); // 매게변수로 kim을던짐
		if(result == 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println("수정 성공");
		}
		
		// select One
		User user = session.selectOne("User.getUser", id);
		System.out.println(user.getId() + "\t" + user.getPasswd() + "\t" + user.getName() 
							+ "\t" + user.getTel() + "\t" + user.getLogtime());
		
		
		session.close();
	}
}
