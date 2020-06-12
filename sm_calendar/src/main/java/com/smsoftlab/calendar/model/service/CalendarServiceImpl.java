package com.smsoftlab.calendar.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsoftlab.calendar.model.dao.CalendarDAO;
import com.smsoftlab.calendar.model.vo.Calendar;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarDAO calendarDAO;
	
	@Override
	public List<Calendar> getCalendarList(HashMap<String, String> inputMap) {
		return calendarDAO.getCalendarList(inputMap);
	}

	@Override
	public String getServerTime() {
		return calendarDAO.getServerTime();
	}

	@Override
	public int setCalendar(HashMap<String, String> inputMap) {
		return calendarDAO.setCalendar(inputMap);
	}

	@Override
	public int updateCalendar(HashMap<String, Object> inputMap) {
		return calendarDAO.updateCalendar(inputMap);
	}

	@Override
	public int deleteCalendar(int idx) {
		return calendarDAO.deleteCalendar(idx);
	}

	@Override
	public Calendar getcalendarInfo(int idx) {
		return calendarDAO.getCalendarInfo(idx);
	}
}
