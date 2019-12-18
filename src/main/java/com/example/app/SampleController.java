package com.example.app;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exapmle.domain.ProductVO;

@Controller // 컨트롤러 선언
public class SampleController {
	@RequestMapping("/doA") // 주소이름, 서블릿 패스
	public void doingA() { // 메소드
		System.out.println("doA.........");
	}

	@RequestMapping("/doB")
	public void doB() {
		System.out.println("doB.........");
	}

	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg1) { // msg는 jsp에 보내주는
															// 변수명. msg1은 매개변수
		System.out.println("doC........." + msg1);
		return "result";
	}

	@RequestMapping("/doD")
	public String doD(Model model) {					// 변수타입이 model
		ProductVO vo = new ProductVO("냉장고", 1000000);  // vo에 생성자로 값을 넣어줌.
		model.addAttribute("vo", vo);					// vo라는 변수에 vo를 넣어줌.
		return "product";
	}
	
	@RequestMapping("/doE")
	public String doE() {					
		return "redirect:doD";				// 주소를 doD로 이동.
	}
	
	@RequestMapping("/doJSON")
	public @ResponseBody ArrayList<ProductVO> doJSON(){				// @ResponseBody json데이터로 만들어 줌.
		ArrayList<ProductVO> array = new ArrayList<ProductVO>();
		ProductVO vo = new ProductVO("세탁기", 100000);
		array.add(vo);
		vo=new ProductVO("냉장고", 50000);
		array.add(vo);
		return array;
	}
}
