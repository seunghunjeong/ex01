package com.example.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exapmle.domain.MemberVO;

@Repository								// 저장소 선언
public class MemberDAOImpl {
	
	@Inject
	private SqlSession session;			// 데이터베이스 Connection 객체
	private static final String namespace="memberMapper";
	
	
	public List<MemberVO> list() {
		return session.selectList(namespace + ".list");
	}
	
	public void insert(MemberVO vo) {
	}

}
