/**
 * Author
 * 
 * @author shaziyahasan
 *
 * POJO class for Author
 */

package com.nagarro.dto;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3433283206467489644L;
	
	private Integer authorId;
	private String authorName;
	
	
	public AuthorDTO() {
		super();
	}

	public AuthorDTO(Integer authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}
}
