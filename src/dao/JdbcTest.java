package dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {
	public static void main(String[] args) {
		// ApplicationContext가 있어야함
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/dao/ApplicationContext.xml");
		
		
		// 느슨한결합으로 부모로 받음
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		
		
		// 인서트가 필요하기에 아이디를 만듬
		String id = "fff";
		User kim = new User();
		kim.setId(id);
		kim.setPasswd("111");
		kim.setName("김유신");
		kim.setTel("1111-1111");
		
		int result = 0;
		// delete
		result = userDao.deleteUser(id);
		if(result == 0) {
			System.out.println("탈퇴 실패");
		} else {
			System.out.println("탈퇴 성공");
		}
		
		
		//insert
		result = userDao.insertUser(kim);
		if(result == 0) {
			System.out.println("가입 실패");
		} else {
			System.out.println("가입 성공");
		}
		
		
		// update
		kim.setPasswd("999"); // 바꿀정보
		kim.setTel("9999-9999"); // 바꿀정보
		kim.setId(id); // 가져오는것
		
		result = userDao.updateUser(kim);
		if(result == 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println("수정 성공");
		}
		
		// select one
		User dto = userDao.getUser(id);
		System.out.println(dto.getId() + "\t" + dto.getPasswd() + "\t" + dto.getName() + "\t" + dto.getTel() + "\t" + dto.getLogtime());
		
		
		// select all
		List<User> users = userDao.getUsers();
		for(User user : users) {
			System.out.println(user.getId() + "\t" + user.getPasswd() + "\t" + user.getName() + "\t" + user.getTel() + "\t" + user.getLogtime());
		}
		
		// select int (몇명인지)
		int count = userDao.getCount();
		System.out.println("회원수 : " + count);
	}
}
