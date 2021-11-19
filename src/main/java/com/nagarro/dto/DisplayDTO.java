/**
 * DisplayDTO
 * 
 * @author shaziyahasan
 *
 * DTO for displaying results
 */

package com.nagarro.dto;

import java.io.Serializable;
import java.util.Date;

public class DisplayDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer bookCode;
	private String bookName;
	private String authorName;
	private Date addedOn;
	
	public DisplayDTO() {
		super();
	}

	public DisplayDTO(Integer bookCode, String bookName, String authorName, Date addedOn) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.authorName = authorName;
		this.addedOn = addedOn;
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "DisplayDTO [bookCode=" + bookCode + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", addedOn=" + addedOn + "]";
	}
}
