## 스프링 데이터
+ 여러 데이터 스토어에 대해 높은 차원의 추상화를 제공하여 데이터 접근 레이어 구현을 쉽게 해준다.
+ 데이터 스토어에 따라 여러 프로젝트가 있다. 
+ spring data JPA : 데이터 접근에 JPA를 사용한다.

## 리포지토리 (repository)
+ 스프링 데이터는 도메인 엔티티 각각에 리포지토리 인터페이스를 하나씩 만든다.
+ 애플리케이션에서 사용할 리포지토리 인터페이스는 다음 중 하나를 상속한다.
	+ Repository   : mark interface (메소드 없음)
		ㄴ CrudRepository
			ㄴ PagingAndSortingRepository
+ CRUD , 페이지처리/정렬 수행하는 메소드를 선언한다.
	
+ Reposotory 인터페이스는 엔티티 클래스 타입과 엔티티 클래스의 기본키 타입을 제너릭 타입으로 한다.
+ 상속을 대신하여 @RepositoryDefinition 을 사용할 수 있다.

### 커스텀 리포지토리 인터페이스
+ 데이터 스토어에 대한 질의를 수행하는 질의 메서드를 정의한다.
+ 질의 메서드 이름 : findBy..., readBy...,queryBy..., countBy..., get....By 와 같은 형식
+ spring data는 이러한 질의 메서드에 대해 구체적인(예를 들면 mysql) 데이터 스토어에 따른 질의를 생성하는 빌더가 있다.
+ LessThan 또는 GreaterThan 키워드를 추가할수 있다.

## 스프링 데이터 JPA
+ 위의 리포지토리는 구체적인 데이터 스토어의 특성을 활용할 수 없다.- 범용적?
+ JpaRepository , MongoRepository 등은 데이터 스토어에 따른 기능을 추가한다.
+ 스프링 데이터는 애플리케이션에 정의한 리포지토리 인터페이스마다 각각 프록시를 생성한다. 그리고 리포지토리 인터페이스 메서드 호출을 가로채어 스프링데이터 JPA 디폴트 리포지토리 SimpleJpaRepository에 위임한다.


### ORM 프레임워크 : Relational(관계형) DBMS (오라클,Mysql)
+ 객체와 데이터베이스의 관계형 테이블의 유사성을 이용하여 데이터 접근을 쉽게 구현한다.
+ 객체-관계형 테이블 매핑을 구현하였다.

### hibernate 프레임워크
+ 자바 환경의 대표적인 ORM 프레임워크이다.
+ 하이버네이트가 JPA 스펙을 주도하였다.
+ 마이바티스와 다르게 쿼리를 직접 노출하지 않는 장점을 갖는다.

### Java Persistence API(JPA)
+ 하이버네이트의 장점을 자바의 표준 명세(SPEC)으로 만든것이다.
+ JPA의 구현체가 하이버네이트이다.(JPA provider)

### Spring Data JPA 
+ spring 에서 JPA로 데이터 접근을 할 수 있도록 만들어졌다. 쉽게 말하면 JPA를 인터페이스로 만들어 놓은 것이다.
+ GenericDao 구현체를 제공한다. -> 쿼리 메소드 실행할수 있다.
+ Spring Data 를 이용하여 hibernate 를 사용할 수 있다.
+ @Transaction 어노테이션으로 트랜잭션을 관리할수 있다.

### 개발 내용
+ repository 인터페이스 상속받는 인터페이스 작성만으로 스프링 데이터 JPA가 구현 객체를 동적으로 생성해서 주입
+ CRUD 처리를 위한 공통 인터페이스 제공
+ 공통 메소드 : 스프링 데이터 JPA가 제공하는 org.springframework.date.jpa.repository.JpaRepository 인터페이스에
  count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save 메소드

