package com.smsoftlab.calendar.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smsoftlab.calendar.model.vo.Calendar;

@Repository
public class CalendarDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Calendar> getCalendarList(HashMap<String, String> inputMap) {
		return sqlSession.selectList("calendarMapper.getCalendarList", inputMap);
	}

	public String getServerTime() {
		return sqlSession.selectOne("calendarMapper.getServerTime");
	}

	public int setCalendar(HashMap<String, String> inputMap) {
		return sqlSession.insert("calendarMapper.setCalendar", inputMap);
	}

	public int updateCalendar(HashMap<String, Object> inputMap) {
		return sqlSession.update("calendarMapper.updateCalendar", inputMap);
	}

	public int deleteCalendar(int idx) {
		return sqlSession.delete("calendarMapper.deleteCalendar", idx);
	}

	public Calendar getCalendarInfo(int idx) {
		return sqlSession.selectOne("calendarMapper.getCalendarInfo", idx);
	}
}
