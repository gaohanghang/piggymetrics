package com.piggymetrics.notification.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 收件人
 */
@Document(collection = "recipients") // 对应MongoDB表 收件人
@Data
public class Recipient {

	@Id
	private String accountName; // 用户名

	@NotNull
	@Email
	private String email; // 邮件地址

	@Valid
	private Map<NotificationType, NotificationSettings> scheduledNotifications; // 预定通知

}
