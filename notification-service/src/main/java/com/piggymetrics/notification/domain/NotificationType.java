package com.piggymetrics.notification.domain;

import lombok.Getter;

/**
 * 通知类型
 */
@Getter
public enum NotificationType {

	BACKUP("backup.email.subject", "backup.email.text", "backup.email.attachment"),
	REMIND("remind.email.subject", "remind.email.text", null);

	private String subject; // 主题
	private String text; // 文本
	private String attachment; // 附件

	NotificationType(String subject, String text, String attachment) {
		this.subject = subject;
		this.text = text;
		this.attachment = attachment;
	}
}
