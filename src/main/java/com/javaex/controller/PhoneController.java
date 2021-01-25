package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	
	//mybatis패키지 아이콘 폴더 아닌 거로 바꾸기 > 프로젝트명 > properties > java build path > resources
	// > mybatis 있는 패키지 > exclude(**) 더블클릭해서 삭제하고 적용하면 됨.
	
	//***오류 찾기
	//1.오류나면 맨위의 맨끝에 있는 문구 보고 오류 찾아보기
	//2.코드 바뀌면 수시로 ctrl+shift+O로 import 정리하기
	
	//필드 
	@Autowired
	private PhoneDao phoneDao;
	
	// 생성자
	// 메소드 겟셋
	/* 메소드 일반 (기능 1개씩 --> 기능마다 url 부여) */
	
	//리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("list");
		
		//dao를 통해 리스트 가져옴
		List<PhoneVo> phoneList = phoneDao.getList();
		System.out.println(phoneList.toString());
		
		model.addAttribute("pList", phoneList); 
		
		return "list"; 
	}
	
	//등록폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("writeForm");
		
		return "writeForm";
	}
	
	//등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company") String company) { 
		System.out.println("write");
		
		PhoneVo pVo = new PhoneVo(name, hp, company);
		System.out.println(pVo.toString());
		
		phoneDao.phoneInsert(pVo);
		
		return "redirect:/phone/list";
	}
	
	//삭제 delete --> @RequestMapping 약식
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete2(@RequestParam("personId") int id) {
		System.out.println("delete");
		
		phoneDao.phoneDelete(id);
		
		return "redirect:/phone/list";
	}
	
	/*
	//삭제 delete --> @PathVariable (이것도 테스트 완료)
	@RequestMapping(value="/delete/{personId}", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("personId") int id) {
		System.out.println("delete");
		
		phoneDao.phoneDelete(id);
		
		return "redirect:/phone/list";
	}
	*/
	
	//수정폼 modifyForm
	@RequestMapping(value="/modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam("personId") int id, Model model) { 
		//먼저 데이터 들어오나 확인
		System.out.println("modifyForm");
		System.out.println(id);
		
		PhoneVo pVo = phoneDao.getPerson(id);
		
		model.addAttribute("pVo", pVo);
		
		return "modifyForm";		
	}
	
	//수정폼 modifyForm2 --> HashMap 사용. mybatis에서 map으로 넘긴 거 vo로 받음.
	//계속 쓸 거 같으면 vo 만들고 1번만 쓸 거면 map으로 쓸 수 있음.
	@RequestMapping(value="/modifyForm2", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm2(@RequestParam("personId") int id, Model model) { 
		System.out.println("modifyForm2");
		System.out.println(id);
		
		//Map<키(의 자료형), 값(데이터의 자료형)>
		Map<String, Object> personMap = phoneDao.getPerson2(id);
		model.addAttribute("pMap", personMap);
		
		return "modifyForm2";
	}
	
	//수정 modify --> 자동으로 파라미터 다 받아서 vo에 넣게 하기 --> @ModelAttribute(이거 생략하고 PhoneVo pVo만 써도 됨)
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PhoneVo pVo) {
		System.out.println("modify");
		
		phoneDao.phoneUpdate(pVo);
		
		return "redirect:/phone/list";
	}
	
	//수정 modify 2 --> Map 사용(테스트O)
	@RequestMapping(value="/modify2", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify2(@RequestParam("personId") int id,
						@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("modify2");
		
		phoneDao.phoneUpdate2(id, name, hp, company);
		
		return "redirect:/phone/list";
	}
	
}
