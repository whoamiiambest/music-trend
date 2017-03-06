package com.mkyong.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.mkyong.web.Dao.Impl.SongItemDaoImpl;
import com.mkyong.web.pojo.SongItem;
import com.mkyong.web.service.SongItemService;

@Configuration
public class SongItemServiceImpl implements SongItemService {
	
	@Autowired
	private SongItemDaoImpl songItemDaoImpl ;

	@Override
	public void updateTop100ZingSongData(List<SongItem> listSongItem) {
		for (SongItem song : listSongItem) {
			songItemDaoImpl.update(song);
		}
	}

	@Override
	public List<SongItem> getSongDataFromDB() {
		List<SongItem> listSongItems = songItemDaoImpl.findAll();
		return listSongItems;
	}

	@Override
	public void UpdateSongItem(SongItem item) {
		songItemDaoImpl.update(item);
	}

	@Override
	public SongItem GetSongItem(String id) {
		return songItemDaoImpl.GetSongItem(id);
	}

}
