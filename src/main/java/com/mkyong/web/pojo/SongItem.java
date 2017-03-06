package com.mkyong.web.pojo;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mkyong.web.config.CONFIG;


@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = "Song")
public class SongItem extends PojoBase {
	
	private String id;
	private int order;
	private String name;
	private String artist;
	private String link;
	private String cover;
	private String[] artist_list;
	private String total;
	private List<String> listTotal = new ArrayList<>();
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return CONFIG.MUSIC_ROOT + link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the cover
	 */
	public String getCover() {
		return CONFIG.PHOTO_ROOT + cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * @return the artist_list
	 */
	public String[] getArtist_list() {
		return artist_list;
	}
	/**
	 * @param artist_list the artist_list to set
	 */
	public void setArtist_list(String[] artist_list) {
		this.artist_list = artist_list;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
		listTotal.add(total);
	}
	/**
	 * @return the listTotal
	 */
	public List<String> getListTotal() {
		return listTotal;
	}
	/**
	 * @param listTotal the listTotal to set
	 */
	public void setListTotal(List<String> listTotal) {
		this.listTotal = listTotal;
		
	}
	
	
}
