package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcUserDao extends JdbcDaoSupport implements UserDao{ // extends JdbcDaoSupport 추가
	private JdbcTemplate template;
	
	/* jdbc 템플릿 support 사용시 필요 X
	 * setter를 없애버림
	// 생성자 생성
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	*/
	
	// DB처리
	// JdbcTemplate 넣어주어야함
	// 메소드 생성
	public int insertUser(User dto) {
		String sql = "insert into dbtest values(?, ?, ?, ?, sysdate)";
		//return template.update(sql, dto.getId(), dto.getPasswd(), dto.getName(), dto.getTel());
		// template 변경
		return getJdbcTemplate().update(sql, dto.getId(), dto.getPasswd(), dto.getName(), dto.getTel());
	}
	
	public int deleteUser(String id) {
		String sql = "delete from dbtest where id=?";
		//return template.update(sql, id);
		return getJdbcTemplate().update(sql, id);
	}
	
	public int updateUser(User dto) {
		String sql = "update dbtest set passwd=?, tel=? where id=?";
		//return template.update(sql, dto.getPasswd(), dto.getTel(), dto.getId());
		return getJdbcTemplate().update(sql, dto.getPasswd(), dto.getTel(), dto.getId());
	}
	
	// select one
	public User getUser(String id) {
		String sql = "select * from dbtest where id=?";
		// 쿼리가 두개로 나뉨
		// return template.queryForObject(sql, new Object[] {id}, rowMapper);
		return getJdbcTemplate().queryForObject(sql, new Object[] {id}, rowMapper);
	}
	
	// select all
	public List<User> getUsers() {
		String sql = "select * from dbtest";
		// return template.query(sql, rowMapper);
		return  getJdbcTemplate().query(sql, rowMapper);
	}
	
	// rowMapper -> 스프링 임포트
	// 한번 만들면 필요할때 꺼내 쓸 수 있음
	RowMapper<User> rowMapper = new RowMapper<User>() { // 추상 메소드 하나를 재정의 해주어야함
		public User mapRow(ResultSet rs, int cnt) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setPasswd(rs.getString("passwd"));
			user.setName(rs.getString("name"));
			user.setTel(rs.getString("tel"));
			user.setLogtime(rs.getTimestamp("logtime"));
			return user;
		}
	};
	
	// select int (몇명인지)
	public int getCount() {
		String sql = "select count(*) from dbtest";
		// return template.queryForObject(sql, Integer.class); // int 로 만든 클래스로 만든 객체?
		 return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
}