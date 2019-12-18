package com.example.persistence;

import java.util.List;

import com.exapmle.domain.MemberVO;

public interface MemberDAO {
	public List<MemberVO> list();
	public void insert(MemberVO vo);
}
