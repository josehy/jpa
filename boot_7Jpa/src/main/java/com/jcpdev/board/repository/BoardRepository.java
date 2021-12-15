package com.jcpdev.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jcpdev.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	//sql 은 JPQL
	
//	  @Query("select b,w from Board b left join b.writer w where b.writer.mno =:mno")
	  @Query("select b from Board b where b.writer.mno =:mno")
	 List<Board> getBoardWriter(@Param("mno") Long mno);
	  
	  @Query("select count(bidx) from Board b left join Users u on u.mno = b.writer.mno where u.mno = :mno")
	 Integer getBoardCountByWriter(@Param("mno") Long mno);
	
	  /* @Query("select b,r from Board b left join Comment r on r.board=b where b.bidx=:bidx"
	 * ) List<Object[]> getBoardComment(@Param("bidx") Long bno); //b,r 이 object 의
	 * 배열
	 * 
	 * @Query("select b,count(r) from Board b left join Comment r on r.board=b group by b"
	 * ) Page<Object[]> getCommentCount(Pageable pageable); //b,r 이 object 의 배열
	 * 
	 * @Query("select b,w,count(r) from Board b  left join b.writer w left join Comment r on r.board=b group by b"
	 * ) Page<Object[]> getBoardWithCommentCountWriter(Pageable pageable); //b,r 이
	 * object 의 배열
	 * 
	 * @Query("select b,w,count(r) from Board b left join b.writer w left join Comment r on r.board=b where b.bidx=:bidx"
	 * ) Object getBoardByIdx(@Param("bidx") Long bidx);
	 */
}

/* JPQL : JPA 에서 사용되는 객체지향 쿼리 (Java Persistance Query Languagge)
* 		: JPA를 사용하면 엔티티를 이용한다. 이때 엔티티를 중심으로 작성되는 쿼리이다.
* 	    : SQL을 추상화한 방식이다. SQL의 select 와 유사하다.
* 
*/
