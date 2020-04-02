package com.token.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_master")
public class SMSMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sms_template_id")
	private Long smsTemplateId;
	@Column(name = "message")
	private String message;

	public Long getSmsTemplateId() {
		return smsTemplateId;
	}

	public void setSmsTemplateId(Long smsTemplateId) {
		this.smsTemplateId = smsTemplateId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
