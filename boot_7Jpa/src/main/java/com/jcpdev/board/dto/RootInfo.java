package com.jcpdev.board.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootInfo {
	@JsonProperty
	private int currentCount;
	@JsonProperty
	private List<VaccineCenter> data;
}
