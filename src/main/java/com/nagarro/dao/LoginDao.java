/**
 * LoginDao
 * 
 * @author shaziyahasan
 *
 * Dao class for checking user in database
 */

package com.nagarro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.model.User;
import com.nagarro.service.PasswordHandlerService;

@Repository
public class LoginDao {

	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private PasswordHandlerService passwordService;
	
	public boolean checkUser(String username, String password) throws NullPointerException {
		try {
			User user = template.get(User.class, username);
			
			//decrypting the user password
			String decryptedPassword = passwordService.decryptPassword(user.getPassword());
			
			if (decryptedPassword.equals(password)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Got null value on checking for user in database");
			e.printStackTrace();
		}
		return false;
	}
}
