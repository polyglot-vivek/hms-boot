package com.nareshit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.nareshit.bean.EmailBean;

@Service
public class EmailService {

	@Autowired
	private MailSender sender;
	
	public boolean sendEmail(EmailBean mailBean) {
		boolean hasMailSent = false;
		SimpleMailMessage messageWindow = new SimpleMailMessage();
		messageWindow.setFrom("DotridgeService");
		messageWindow.setTo(mailBean.getTo());
		messageWindow.setSubject(mailBean.getSubject());
		messageWindow.setText(mailBean.getBody());
		
		sender.send(messageWindow);
		hasMailSent = true;
		return hasMailSent;
		
	}
}
