package com.token.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templatemaster")
public class TemplateMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "template_id")
	private Long templateId;
	@Column(name = "message")
	private String message;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
