package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GamePlayer {
	
	private int gamerTagId;
	private String gamerNickname;
	private int highScore;
}
