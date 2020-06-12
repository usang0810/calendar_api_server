package com.smsoftlab.calendar.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smsoftlab.calendar.model.service.CalendarService;
import com.smsoftlab.calendar.model.vo.Calendar;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/*")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value="getServerTime", method=RequestMethod.GET)
	public String getServerTime() {
		
		String serverTime = calendarService.getServerTime();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("msg", "success");
		map.put("time", serverTime);
		
		return new Gson().toJson(map);
	}
	
	@RequestMapping(value="getCalendarList", method=RequestMethod.GET)
	public String getCalendarList(String startDate, String endDate) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("startDate", startDate);
		inputMap.put("endDate", endDate);
		
		List<Calendar> calendarList = calendarService.getCalendarList(inputMap);
		
		map.put("code", 1);
		map.put("msg", "success");
		map.put("list", calendarList);
		
		return new Gson().toJson(map);
	}
	
	@RequestMapping(value="getCalendarInfo", method=RequestMethod.GET)
	public String getCalendarInfo(String idx) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(idx == null) {
			map.put("code", 0);
			map.put("msg", "idx is null, check your value");
		}else {
			Calendar info = calendarService.getcalendarInfo(Integer.parseInt(idx));
			map.put("code", 1);
			map.put("msg", "success");
			map.put("info", info);
		}
		
		return new Gson().toJson(map);
	}
	
	@RequestMapping(value="setCalendar", method=RequestMethod.POST)
	public String setCalendar(@RequestParam(value = "location", required = false) String location,
							@RequestParam(value = "content", required = false) String content,
							String title, String startDate, String endDate) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, String> inputMap = new HashMap<String, String>();
		if(title == null || startDate == null || endDate == null) {
			map.put("code", 0);
			map.put("msg", "parameter is not enough, check your value");
		}else {
			inputMap.put("location", location);
			inputMap.put("content", content);
			inputMap.put("title", title);
			inputMap.put("startDate", startDate);
			inputMap.put("endDate", endDate);
			
			int result = calendarService.setCalendar(inputMap);
			if(result > 0) {
				map.put("code", 1);
				map.put("msg", "success");
			}else {
				map.put("code", 0);
				map.put("msg", "insert error");
			}
		}
		
		return new Gson().toJson(map);
	}
	
	@RequestMapping(value="updateCalendar", method=RequestMethod.POST)
	public String updateCalendar(@RequestParam(value = "location", required = false) String location,
							@RequestParam(value = "content", required = false) String content,
							String idx, String title, String startDate, String endDate) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		if(idx == null || title == null || startDate == null || endDate == null) {
			map.put("code", 0);
			map.put("msg", "parameter is not enough, check your value");
		}else {
			inputMap.put("idx", Integer.parseInt(idx));
			inputMap.put("location", location);
			inputMap.put("content", content);
			inputMap.put("title", title);
			inputMap.put("startDate", startDate);
			inputMap.put("endDate", endDate);
			
			int result = calendarService.updateCalendar(inputMap);
			if(result > 0) {
				map.put("code", 1);
				map.put("msg", "success");
			}else {
				map.put("code", 0);
				map.put("msg", "update error");
			}
		}
		
		return new Gson().toJson(map);
	}
	
	@RequestMapping(value="deleteCalendar", method=RequestMethod.POST)
	public String deleteCalendar(String idx) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(idx == null) {
			map.put("code", 0);
			map.put("msg", "idx is null, please check your [idx] value");
		}else {
			int result = calendarService.deleteCalendar(Integer.parseInt(idx));
			if(result > 0) {
				map.put("code", 1);
				map.put("msg", "success");
			}else {
				map.put("code", 0);
				map.put("msg", "delete error");
			}
		}
		
		return new Gson().toJson(map);
	}
	
}
