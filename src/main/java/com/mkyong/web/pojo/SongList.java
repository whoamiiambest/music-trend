package com.mkyong.web.pojo;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SongList {

	private String msg;
	ArrayList<SongItem> data = new ArrayList<SongItem>();

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public ArrayList<SongItem> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(ArrayList<SongItem> data) {
		this.data = data;
	}

}