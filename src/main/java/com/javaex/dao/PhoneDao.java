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
	
	//리스트
	public List<PhoneVo> getList(){
		
		//쿼리문을 여기 직접 쓰는 게 아니라 xml만들어서 쓰고 그거 빼서 씀.
		//sqlSession.selectList("쿼리명", 넣어야 되는 데이터 하나만 가능 2개 이상은 vo같은 걸로 묶어야 됨);
		//sqlSession이 알아서 리스트 new해서 다 만들어줌.
		List<PhoneVo> pList = sqlSession.selectList("전체 리스트 가져오는 sql명");
		
		return pList;
	}
	
	//1명 정보
	public PhoneVo getPerson(int id) {
		PhoneVo pVo = sqlSession.selectOne("1명가져오는 sql명", id);
		
		return pVo;
	}

}
