package com.piggymetrics.notification.domain;

import java.util.stream.Stream;

/**
 * 频率枚举
 */
public enum Frequency {

	WEEKLY(7), MONTHLY(30), QUARTERLY(90);

	private int days;

	Frequency(int days) {
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	/**
	 * days转换为Frequency类型
	 * @param days
	 * @return
	 */
	public static Frequency withDays(int days) {
		return Stream.of(Frequency.values())
				.filter(f -> f.getDays() == days)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
