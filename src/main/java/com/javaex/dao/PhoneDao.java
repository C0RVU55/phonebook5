package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhoneVo;

@Repository
public class PhoneDao {
	
	//필드 (효율적으로 관리하기 위해 알아서 new되게 함)
	@Autowired
	private SqlSession sqlSession;
	
	/*
	쿼리문을 여기 직접 쓰는 게 아니라 xml에 써놓고 그거 빼서 씀. sqlSession이 알아서 리스트 new해서 다 만들어줌.
	sqlSession.selectList("쿼리명", 넣어야 되는 데이터 하나만 가능 2개 이상은 vo같은 걸로 묶어야 됨);
	*/
	
	//리스트
	public List<PhoneVo> getList(){
		List<PhoneVo> pList = sqlSession.selectList("phonebook.selectList2");
		
		//여기 값은 sqlSession으로 받은 거니까 dao에서 받은 값이랑 controller에서 나오는 값이랑 비교해봐야 됨
		System.out.println(pList.toString());
		
		return pList;
	}
	
	//등록
	public void phoneInsert(PhoneVo pVo) {
		//데이터 잘 들어왔나 먼저 확인 --> insert 들어가기 전이라 personId는 0인 게 맞음
		System.out.println("[dao]insert 받은 데이터 : "+pVo); 
		
		//DB에 데이터 넘겨서 처리
		sqlSession.insert("phonebook.insert", pVo); 
	}
	
	//삭제
	public int phoneDelete(int personId) {
		System.out.println("[dao]delete : "+personId);
		int count = sqlSession.delete("phonebook.delete", personId);
		
		System.out.println("삭제 "+count+"건 완료");
		return count;
	}
	
	//1명 정보 가져오기
	public PhoneVo getPerson(int id) {
		System.out.println("[dao]getPerson() : "+id);
		
		//select니까 받는 자료형 정해야 됨
		PhoneVo pVo = sqlSession.selectOne("phonebook.selectOne", id);
		System.out.println("[dao]getPerson() : "+pVo.toString());
		
		return pVo;
	}
	
	//수정
	public int phoneUpdate(PhoneVo pVo) {
		System.out.println("[dao]update : "+pVo);
		
		int count = sqlSession.update("phonebook.update", pVo);
		
		System.out.println("[dao]수정 "+count+"건 완료");
		return count;
	}


}
