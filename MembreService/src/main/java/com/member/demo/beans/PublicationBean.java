package com.member.demo.beans;

import java.util.Date;

import lombok.Data;

@Data
public class PublicationBean {

	private Long id;
	private Date date;
	private String type;
	private String titre;
	private String lien;
	private String sourcepdf;
	
}
