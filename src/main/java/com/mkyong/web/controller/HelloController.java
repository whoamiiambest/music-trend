package com.mkyong.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.config.CONFIG;
import com.mkyong.web.pojo.SongItem;
import com.mkyong.web.pojo.SongList;
import com.mkyong.web.service.impl.SongItemServiceImpl;

@Configuration
@Controller
@RequestMapping(value = "/Service")
public class HelloController {
	@Autowired
	private SongItemServiceImpl songItemServiceImpl;

	@RequestMapping(value = "/ShowHomePage", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("home");
		List<SongItem> listSongItems = songItemServiceImpl.getSongDataFromDB();
		// List<String, List<Map<String, Object>>> listMap

		List<Map<String, Object>> listMap = new ArrayList<>();
		for (int i = 0; i < listSongItems.size(); i++) {
			SongItem song = listSongItems.get(i);
			List<Map<String, Object>> listMapSongItem = new ArrayList<Map<String, Object>>();
			Map<String, Object> mapSongItem = new HashMap<String, Object>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			Map<String, Object> map2 = new HashMap<String, Object>();
			Map<String, Object> map3 = new HashMap<String, Object>();
			Map<String, Object> map4 = new HashMap<String, Object>();
			Map<String, Object> map5 = new HashMap<String, Object>();

			map0.put("id", song.getId());
			map1.put("name", song.getName());
			map2.put("link", song.getLink());
			map3.put("src", song.getCover());
			map4.put("artirst", song.getArtist());
			map5.put("total", song.getTotal());

			listMapSongItem.add(map0);
			listMapSongItem.add(map1);
			listMapSongItem.add(map2);
			listMapSongItem.add(map3);
			listMapSongItem.add(map4);
			listMapSongItem.add(map5);

			mapSongItem.put("songItem", listMapSongItem);
			listMap.add(mapSongItem);
		}
		model.addObject("songData", listMap);

		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/UpdateTop100ZingSong", method = RequestMethod.GET)
	public String getSongData() throws IOException {
		URL url = new URL(CONFIG.GET_TOP_100SONG_ZING_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		System.out.println("Output from Server .... \n");
		String output = "";
		String jsonData = "";

		while ((output = br.readLine()) != null) {
			System.out.println(output);
			jsonData = output;
		}
		conn.disconnect();

		ObjectMapper mapper = new ObjectMapper();

		SongList songList = new SongList();
		songList = mapper.readValue(jsonData, SongList.class);

		ArrayList<SongItem> listSong = songList.getData();
		songItemServiceImpl.updateTop100ZingSongData(listSong);
		//this.updateData();
		return "Update success";
	}

	@ResponseBody
	@RequestMapping(value = "/UpdateTotalListener", method = RequestMethod.GET, headers = "Accept=application/json")
	private void UpdateTotalListener() throws IOException {
		List<SongItem> listSong = songItemServiceImpl.getSongDataFromDB();
		for (SongItem song : listSong) {
			List<String> totalList = song.getListTotal();
			if (song != null && song.getId() != null) {
				if (totalList.size() < 8) {
					URL url = new URL(CONFIG.GET_TOTAL_LISTEN_URL + song.getId());
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					BufferedReader in = null;
					// The changed part
					if (conn.getHeaderField("Content-Encoding") != null
							&& conn.getHeaderField("Content-Encoding").equals("gzip")) {
						in = new BufferedReader(new InputStreamReader(new GZIPInputStream(conn.getInputStream())));
					} else {
						in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					}
					if (conn.getResponseCode() != 200) {
						throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
					}
					String inputLine;
					String total;
					String jsonData = "";
					while ((inputLine = in.readLine()) != null) {
						jsonData = inputLine;
					}
					
					try {
						JSONObject jsonObj = new JSONObject(jsonData);
						total = jsonObj.getString("total");
						System.out.println("ID : " + song.getId() + " Total : " + total);
						song.setListTotal(song.getListTotal());
						song.setTotal(total);
						songItemServiceImpl.UpdateSongItem(song);
						conn.disconnect();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}

	}


	@RequestMapping(value = "/detail", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView Detail(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("detail");
		String id = request.getParameter("id");
		SongItem song = songItemServiceImpl.GetSongItem(id);
		List<String> totalListener = song.getListTotal();

		int lastListener = Integer.parseInt(totalListener.get(totalListener.size() - 1).replaceAll(",", ""));
		int firstListener = Integer.parseInt(totalListener.get(0).replaceAll(",", ""));
		int increaseListener = lastListener - firstListener;
		List<Map<String, Object>> listMap = new ArrayList<>();

		for (int i = 0; i < totalListener.size() - 1; i++) {
			int rateTotal = Integer.parseInt(totalListener.get(i + 1).replaceAll(",", ""))
					- Integer.parseInt(totalListener.get(i).replaceAll(",", ""));
			int percent = rateTotal * 100 / increaseListener;
			int height = 4 * percent;

			List<Map<String, Object>> listMapSongItem = new ArrayList<Map<String, Object>>();
			Map<String, Object> mapdata = new HashMap<String, Object>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map0.put("percent", percent);
			map1.put("height", height);
			listMapSongItem.add(map0);
			listMapSongItem.add(map1);
			mapdata.put("info", listMapSongItem);
			listMap.add(mapdata);
		}
		model.addObject("name", song.getName());
		model.addObject("data", listMap);
		System.out.println(id);
		return model;
	}

	public void updateData() {
		try {
			this.UpdateTotalListener();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}