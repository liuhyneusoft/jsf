package com.jfs.training.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PayJob {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Scheduled(cron = "0 0/1 * * * ?")
	public void work() {
		//execute every minutes
		logger.info("pay job start {}", date2String(new Date(), "yyyy-MM-dd HH:mm:ss"));
		//TODO do something
		logger.info("pay job  end {}", date2String(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	public static String date2String(Date date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return date == null ? null : df.format(date);
	}
}
