package com.jcpdev.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private Long bidx;
	private String subject;
	private String content;
	private Long writerMno;
	private String writerEmail;		//board의 상세보기 출력(옵션)
	private String writerName;		//board의 상세보기 출력(옵션)
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
}
