package com.piggymetrics.notification.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class NotificationSettings {

	@NotNull
	private Boolean active; // 活动状态

	@NotNull
	private Frequency frequency; // 频率

	private Date lastNotified; // 最后通知时间

}
