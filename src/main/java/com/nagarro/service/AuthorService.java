/**
 * AuthorService
 * 
 * @author shaziyahasan
 * 
 * Service class for handling author crud operations
 */

package com.nagarro.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dto.AuthorDTO;

@Service
public class AuthorService {

	@Autowired
	private RESTService RESTService;

	
	/* Method to fetch author of a given id*/
	
	@SuppressWarnings("static-access")
	public AuthorDTO getAuthorById(Integer authorId) throws NullPointerException {
		AuthorDTO author = RESTService.getAuthorById(authorId);
		return author;
	}
	
	
	/* Method to fetch authors */

	public List<AuthorDTO> getAuthors() throws NullPointerException {

		List<AuthorDTO> authors = null;

		try {	
			//get all authors
			authors = RESTService.getAuthors();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return authors;
	}

}
