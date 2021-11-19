/**
 * LoginService
 * 
 * @author shaziyahasan
 * 
 * Service class for handling login
 */

package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public boolean checkUser(String username, String password) {
		if (username.length() > 0 && password.length() > 0
				&& !username.equals("") && !password.equals("")) {
			return loginDao.checkUser(username, password);
		} 
			return false;
		}
	}
