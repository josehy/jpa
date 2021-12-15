package com.jcpdev.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcpdev.board.dto.BoardDTO;
import com.jcpdev.board.entity.Board;
import com.jcpdev.board.repository.BoardRepository;
import com.jcpdev.board.service.BoardService;

@RestController			//RESTful 서비스 동작을 하는 컨트롤러
public class BoardController {
	
	@Autowired
	BoardRepository repository;
	
	@Autowired
	BoardService service;
	
	@ResponseBody
	@GetMapping("/board") 
	public BoardDTO getOne(int idx) {  //idx는 파라미터 입니다.
		Optional<Board> result 
		= repository.findById(Long.valueOf(idx));
		return service.toDto(result.get());
	}
	
	//board 테이블 모든 데이터
	@GetMapping("/board/list")
	public List<BoardDTO> getList(){
		List<Board> list = repository.findAll();
		List<BoardDTO> result = new ArrayList<>();
		//list에 있는 각각 Board를 dto로 변환
		list.forEach(item -> {					//자바 람다식, item 변수는 임의 식별자
			result.add(service.toDto(item));
		});
		
		return result;
	}
	//이 핸들러메소드는 리턴이 View 가 아닙니다.
	//         리턴이 데이터. -> HTTP 응답으로 response body 에 데이터를 전송합니다.
	//스프링 부트 MVC는 메서드 반환값을 HttpMessageConverter 를 통해 
	// 자바객체를 json 형식으로 변환한 후 전달한다. 
	//스프링 부트는 필요한 라이브러리 jackson , json 을 자동으로 가져옵니다.
}





