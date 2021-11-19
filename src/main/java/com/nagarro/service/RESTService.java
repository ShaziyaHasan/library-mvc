/**
 * RESTService
 * 
 * @author shaziyahasan
 * 
 * Service class for calling REST endpoints
 */

package com.nagarro.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.dto.AuthorDTO;
import com.nagarro.dto.BookDTO;

@Service
public class RESTService {

	// APIs
	private static final String GET_ALL_BOOKS_API = "http://localhost:8084/book";
	private static final String GET_BOOK_BY_ID_API = "http://localhost:8084/book/{id}";
	private static final String SAVE_BOOK_API = "http://localhost:8084/book";
	private static final String UPDATE_BOOK_API = "http://localhost:8084/book/{id}";
	private static final String DELETE_BOOK_API = "http://localhost:8084/book/{id}";
	private static final String GET_AUTHORS_API = "http://localhost:8084/author/";
	private static final String GET_AUTHOR_BY_ID_API = "http://localhost:8084/author/{id}";

	static RestTemplate template = new RestTemplate();
	static ObjectMapper mapper = new ObjectMapper();

	/* Endpoint Handler for fetching all book records */
	public List<BookDTO> getBooks() throws JsonParseException, JsonMappingException, IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		// hitting the endpoint
		String result = template.exchange(
				GET_ALL_BOOKS_API, HttpMethod.GET, entity, String.class).getBody();

		// mapping the json string array to list of book dto
		List<BookDTO> books = Arrays.asList(mapper.readValue(result, BookDTO[].class));

		return books;
	}

	/* Endpoint Handler for fetching book of a particular id */

	public static BookDTO getBookById(Integer id) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);
		BookDTO bookFound = template.getForObject(GET_BOOK_BY_ID_API, BookDTO.class, param);
		return bookFound;
	}

	/* Endpoint Handler for saving a book */

	public HttpStatus addBook(BookDTO bookToSave) throws HttpClientErrorException {
		ResponseEntity<BookDTO> bookSaved = template.postForEntity(
				SAVE_BOOK_API, bookToSave, BookDTO.class);
		HttpStatus status = bookSaved.getStatusCode();
		return status;
	}

	/* Endpoint Handler for updating a book */

	public void updateBook(BookDTO updatableBook) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", updatableBook.getBookCode());

		template.put(UPDATE_BOOK_API, updatableBook, param);
	}
	
	/* Endpoint Handler for deleting a book */

	public void deleteBook(Integer id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);

		template.delete(DELETE_BOOK_API, param);
	}

	/* Endpoint Handler for fetching author of a particular id */

	public static AuthorDTO getAuthorById(Integer id) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);

		AuthorDTO author = template.getForObject(
				GET_AUTHOR_BY_ID_API, AuthorDTO.class, param);
		return author;
	}

	/* Endpoint Handler for fetching all author records */

	public List<AuthorDTO> getAuthors() throws JsonParseException, JsonMappingException, IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		// hitting the endpoint
		String result = template.exchange(
				GET_AUTHORS_API, HttpMethod.GET, entity, String.class).getBody();

		// mapping the json string array to list of author
		List<AuthorDTO> authors = Arrays.asList(mapper.readValue(result, AuthorDTO[].class));
		return authors;
	}

}
