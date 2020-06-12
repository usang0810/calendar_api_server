package com.smsoftlab.calendar.model.vo;

public class Calendar {
	private int idx;
	private String location;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String writeDate;
	private String modifyDate;
	
	public Calendar() {}

	public Calendar(int idx, String location, String title, String content, String startDate, String endDate, String writeDate,
			String modifyDate) {
		super();
		this.idx = idx;
		this.location = location;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.writeDate = writeDate;
		this.modifyDate = modifyDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Calendar [idx=" + idx + ", location=" + location + ", title=" + title + ", content=" + content
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", writeDate=" + writeDate + ", modifyDate="
				+ modifyDate + "]";
	}
	
}
