/**
 * BookDTO
 * 
 * @author shaziyahasan
 *
 * DTO class for Book
 */
 
package com.nagarro.dto;

import java.util.Date;

public class BookDTO {

	private Integer bookCode;
	private String bookName;
	private Integer authorId;
	private Date addedOn;
	
	public BookDTO() {
		super();
	}

	public BookDTO(Integer bookCode, String bookName, Integer authorId) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.authorId = authorId;
	}

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "BookDTO [bookCode=" + bookCode + ", bookName=" + bookName + ", authorId=" + authorId + ", addedOn="
				+ addedOn + "]";
	}
	
	
}
