package com.mkyong.web.Dao.Impl;

import com.mkyong.web.Dao.SongItemDao;
import com.mkyong.web.pojo.SongItem;

public class SongItemDaoImpl extends MongDBDaoImpl<String, SongItem> implements SongItemDao {
	@Override
	public SongItem GetSongItem(String id) {
		// TODO Auto-generated method stub
	    SongItem song = (SongItem) mongoOperation.findById(id, entityClass);
	    return song;
	}
    

	
}
