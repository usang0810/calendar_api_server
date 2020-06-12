package com.smsoftlab.calendar.model.service;

import java.util.HashMap;
import java.util.List;

import com.smsoftlab.calendar.model.vo.Calendar;

public interface CalendarService {

	public abstract String getServerTime();

	public abstract List<Calendar> getCalendarList(HashMap<String, String> inputMap);

	public abstract int setCalendar(HashMap<String, String> inputMap);

	public abstract int updateCalendar(HashMap<String, Object> inputMap);

	public abstract int deleteCalendar(int idx);

	public abstract Calendar getcalendarInfo(int idx);

}
