/**
 * Logout Controller
 * 
 * @author shaziyahasan
 * 
 * Controller for logging out
 */

package com.nagarro.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model m, HttpServletResponse response) {
		try {
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Expires", "0");
			response.setDateHeader("Expires", -1);
			m.addAttribute("logoutMessage", "Logged out Successfully!");
			session.removeAttribute("username");
			session.invalidate();

			// redirect to login page
			return new ModelAndView("login");
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}
}