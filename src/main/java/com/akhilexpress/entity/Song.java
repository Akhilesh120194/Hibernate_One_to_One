package com.akhilexpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//MYSql doesn't support sequence generatioType
@Entity
public class Song {

	@Id
	@Column(name="songId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int songId;
	
	@Column(name="songName")
	private String songName;
	
	@Column(name="singer")
	private String artist;
	
	public Song() {
		
	}
	
	
	public Song(int songId, String songName, String artist) {
	
		this.songId = songId;
		this.songName = songName;
		this.artist = artist;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}


	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", artist=" + artist + "]";
	}
	
	
}
