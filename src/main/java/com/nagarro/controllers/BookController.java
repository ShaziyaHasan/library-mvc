/**
 * BookController
 * 
 * @author shaziyahasan
 *
 * Controller for adding a book, editing and deleting functionality
 */

package com.nagarro.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.nagarro.dto.BookDTO;
import com.nagarro.dto.DisplayDTO;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	
	/* GET method for home page */

	@RequestMapping("/home")
	public ModelAndView homePage(Model m, HttpSession session) {
		m.addAttribute("loginSuccess", "Logged In Successfully");
		ModelAndView model = new ModelAndView("home", "booksInTable", bookService.getBooks());
		return model;
	}


	/* POST method for editing a page */

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String editBook(@RequestParam("bookCode") Integer bookCode,
			@RequestParam("bookName") String bookName,
			@RequestParam("authorId") Integer id) {
		
		BookDTO updatableBook = new BookDTO(bookCode, bookName, id);
		bookService.updateBook(updatableBook);
		return "redirect:/home";
	}
	
	
	/* GET method for add page */

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addPage(HttpSession session) {
		ModelAndView model = new ModelAndView("add","authorsList",authorService.getAuthors());
		return model;
	}

	
	/* POST method for add page */

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(@RequestParam(value = "bookCode") Integer bookCode,
			@RequestParam(value = "bookName") String bookName,
			@RequestParam(value = "authorId") Integer authorId,
			HttpSession session) {

		//book obj to save
		BookDTO bookToSave = new BookDTO(bookCode, bookName, authorId);
		
		HttpStatus status = bookService.addBook(bookToSave);
		
		if (status == HttpStatus.CONFLICT) {
			return "redirect:/error";
		} 
		return "redirect:/home";
	}

	
	/* GET method for edit page */

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") Integer id) {
		
		//get book to be updated 
		DisplayDTO bookDisplayed = bookService.getBookById(id);
		
		//add authors list and book attributes to the model
		ModelAndView model = new ModelAndView("edit", "book", bookDisplayed);
		model.addObject("authors", authorService.getAuthors());
		
		return model;
	}
	
	
	/* GET method for deleting book */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Integer id) {
		
		//service method to delete book  
		bookService.deleteBook(id);
		
		return "redirect:/home";
	}
}
