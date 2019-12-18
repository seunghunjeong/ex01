package com.example.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exapmle.domain.MemberVO;

@Repository								// ����� ����
public class MemberDAOImpl {
	
	@Inject
	private SqlSession session;			// �����ͺ��̽� Connection ��ü
	private static final String namespace="memberMapper";
	
	
	public List<MemberVO> list() {
		return session.selectList(namespace + ".list");
	}
	
	public void insert(MemberVO vo) {
	}

}
