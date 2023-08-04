package com.newstar.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newstar.basic.entity.UserEntity;

// description : Repository - 레이어드 아키텍처 상의 데이터 접근 영역 //
// description : 데이터베이스와 관련된 작업들을 담당하는 구역 //

// description : @Repository - 해당 클래스가 Repository 영역 임을 명시 //
// description : @Component를 포함하고 있어서 Spring으로 등록할 수 있음 //
@Repository
// description : JpaRepository<E, PK> - JPS를 이용한 리포지토리 생성 시에 //
// description : 반드시 상속하여야하는 인터페이스 //
// description : 기본적인 CRUD, Sort와 관련된 메서드를 포함하고 있음 //
public interface UserRepository extends JpaRepository<UserEntity, String> {
  // description : Query method //
  
  // description : JpaRepository에서 제공하는 기본 Query method //
  // description : Save(Entity e) : 레코드 삽입 및 수정 작업 //
  // description : findAll : 모든 레코드를 조회 //
  // description : findById : 기본키 조건으로 레코드를 조회 //
  // description : existsById : 기본키 조건으로 레코드가 존재하는지 확인 //
  // description : deleteById : 기본키 조건으로 레코드를 삭제하는 작업 //
  // description : delete : Entity 기준으로 레코드를 삭제하는 작업 //

  // description : Custom Query method //
  // description : 개발자가 직접 필요한 쿼리를 지정할 수 있는 방법 //
  // description : 규칙에 따라 메서드를 선언하면 쿼리를 자동으로 생성 //
  // description : findBy : 조회할 때 사용 - 해당 문구 뒤에 조건을 추가함 //
  // description : And, Or : 조건에 And 혹은 Or 연산을 추가 할 때 사용 //
  // description : Like : Like 연산을 추가 할 때 사용 //
  List<UserEntity> findByNickname(String nickname);
  List<UserEntity> findByNicknameOrAddress (String nickname, String address);
}
