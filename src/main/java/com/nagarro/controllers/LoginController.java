/**
 * LoginController
 * 
 * @author shaziyahasan
 *
 * Controller for login functionality
 */

package com.nagarro.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagarro.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	/* GET method for login */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	/* POST method for Login */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpSession session, Model m) {

		// check if user already exists
		if (loginService.checkUser(username, password)) {
			session.setAttribute("username", username);

			// redirect to home page
			return "redirect:/home";
		}

		// if user not found
		m.addAttribute("loginFailed", "Login Failed");
		return "login";
	}
}