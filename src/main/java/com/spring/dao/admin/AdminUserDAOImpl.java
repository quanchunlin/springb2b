package com.spring.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.admin.AdminUser;
import com.spring.model.admin.AdminUserAuthentication;

@Repository
public class AdminUserDAOImpl implements AdminUserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	static final String ADMIN_USER_MAPPER = "com.spring.mappers.AdminUserMapper.";

	@Override
	public String getTime() {

		return sqlSession.selectOne(ADMIN_USER_MAPPER + "getTime");
	}
	@Override
	public void createAdminUser(AdminUser adminUser) throws Exception {
	
		sqlSession.insert(ADMIN_USER_MAPPER + "createAdminUser", adminUser);
	}
	@Override
	public int hasAdminUserByUsername(String username) {

		return sqlSession.selectOne(ADMIN_USER_MAPPER + "hasAdminUserByUsername", username);
	}
	@Override
	public AdminUser getAdminUserByUsername(String username) {

		return sqlSession.selectOne(ADMIN_USER_MAPPER + "getAdminUserByUsername", username);
	}
	@Override
	public AdminUser getAdminUserAuthentication(AdminUserAuthentication adminUserAuthentication) {
		
		return sqlSession.selectOne(ADMIN_USER_MAPPER + "getAdminUserAuthentication", adminUserAuthentication);
	}
	@Override
	public int modifyPassword(AdminUserAuthentication adminUserAuthentication) throws Exception {
		
		return sqlSession.update(ADMIN_USER_MAPPER + "modifyPassword", adminUserAuthentication);
	}
	@Override
	public int modifyAdminUser(AdminUser adminUser) throws Exception {
		
		return sqlSession.update(ADMIN_USER_MAPPER + "modifyAdminUser", adminUser);
	}
	@Override
	public int modifyAdminUserAndPassword(AdminUser adminUser) throws Exception {
		
		return sqlSession.update(ADMIN_USER_MAPPER + "modifyAdminUserAndPassword", adminUser);
	}
	@Override
	public List<AdminUser> getAdminUsers(AdminUser adminUser) {
		
		return sqlSession.selectList(ADMIN_USER_MAPPER + "getAdminUsers", adminUser);
	}
	@Override
	public int deleteAdminUser(AdminUser adminUser) throws Exception {
		
		return sqlSession.update(ADMIN_USER_MAPPER + "deleteAdminUser", adminUser);
	}
	
}