package com.mkyong.web.service;

import java.util.List;

import com.mkyong.web.pojo.SongItem;

public interface SongItemService {
	/**
	 * 
	 * @param listSongItem
	 */
	public void updateTop100ZingSongData(List<SongItem> listSongItem);
	
	/**
	 * 
	 * @return
	 */
	public List<SongItem> getSongDataFromDB();
	
	/**
	 * 
	 * @param item
	 */
	public void UpdateSongItem(SongItem item);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public SongItem GetSongItem(String id);
}
