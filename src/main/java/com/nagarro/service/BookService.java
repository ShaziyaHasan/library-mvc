/**
 * BookService
 * 
 * @author shaziyahasan
 * 
 * Service class for handling book crud operations
 */

package com.nagarro.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nagarro.dto.AuthorDTO;
import com.nagarro.dto.BookDTO;
import com.nagarro.dto.DisplayDTO;

@Service
public class BookService {

	@Autowired
	private RESTService RESTService;

	@Autowired
	private AuthorService authorService;

	/* Service Method to handle fetching of all books */

	public List<DisplayDTO> getBooks() throws NullPointerException {

		List<BookDTO> books = null;
		List<DisplayDTO> booksToShow = new ArrayList<DisplayDTO>();

		try {
			// get all books
			books = RESTService.getBooks();

			// for each book, fetch the author details
			for (BookDTO book : books) {

				AuthorDTO authorOfBook = authorService.getAuthorById(book.getAuthorId());

				DisplayDTO displayBook = new DisplayDTO(book.getBookCode(), book.getBookName(),
						authorOfBook.getAuthorName(), book.getAddedOn());

				booksToShow.add(displayBook);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return booksToShow;
	}

	/* Service Method to handle saving a book */

	public HttpStatus addBook(BookDTO bookToSave) {
		return RESTService.addBook(bookToSave);
	}

	/* Service Method to handle saving a book */

	public DisplayDTO getBookById(Integer id) throws NullPointerException {
		DisplayDTO bookToDisplay = null;
		BookDTO bookFetched = RESTService.getBookById(id);

		if (bookFetched != null) {
			AuthorDTO author = authorService.getAuthorById(bookFetched.getAuthorId());

			bookToDisplay = new DisplayDTO(bookFetched.getBookCode(), bookFetched.getBookName(), author.getAuthorName(),
					bookFetched.getAddedOn());
		}
		return bookToDisplay;
	}

	/* Service Method to update a book */

	public void updateBook(BookDTO updatableBook) {
		RESTService.updateBook(updatableBook);
	}

	/* Service Method to delete a book */

	public void deleteBook(Integer id) {
		RESTService.deleteBook(id);
	}

}
