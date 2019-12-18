package com.example.app;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exapmle.domain.ProductVO;

@Controller // ��Ʈ�ѷ� ����
public class SampleController {
	@RequestMapping("/doA") // �ּ��̸�, ���� �н�
	public void doingA() { // �޼ҵ�
		System.out.println("doA.........");
	}

	@RequestMapping("/doB")
	public void doB() {
		System.out.println("doB.........");
	}

	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg1) { // msg�� jsp�� �����ִ�
															// ������. msg1�� �Ű�����
		System.out.println("doC........." + msg1);
		return "result";
	}

	@RequestMapping("/doD")
	public String doD(Model model) {					// ����Ÿ���� model
		ProductVO vo = new ProductVO("�����", 1000000);  // vo�� �����ڷ� ���� �־���.
		model.addAttribute("vo", vo);					// vo��� ������ vo�� �־���.
		return "product";
	}
	
	@RequestMapping("/doE")
	public String doE() {					
		return "redirect:doD";				// �ּҸ� doD�� �̵�.
	}
	
	@RequestMapping("/doJSON")
	public @ResponseBody ArrayList<ProductVO> doJSON(){				// @ResponseBody json�����ͷ� ����� ��.
		ArrayList<ProductVO> array = new ArrayList<ProductVO>();
		ProductVO vo = new ProductVO("��Ź��", 100000);
		array.add(vo);
		vo=new ProductVO("�����", 50000);
		array.add(vo);
		return array;
	}
}
