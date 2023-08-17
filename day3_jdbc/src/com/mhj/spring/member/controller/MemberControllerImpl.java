package com.mhj.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mhj.spring.member.service.MemberService;
import com.mhj.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;

	public MemberControllerImpl() {
		System.out.println("Public MemberControllerImpl()");

	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
		System.out.println("this");
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);
		
		List<MemberVO> membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("membersList", membersList);
		
		return mav;
	}
	

	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getViewName(request));
		return mv;
	}
	
	@Override
	public void addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId(request.getParameter("id"));
		memberVO.setPwd(request.getParameter("pwd"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setEmail(request.getParameter("email"));
		
		memberService.addMember(memberVO);
		
		response.sendRedirect(request.getContextPath() + "/member/listMembers.do");
	}
	
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");	// 요청주소를 꺼내기 위한 명칭
		
		System.out.println("contextPath : " + contextPath + " " + "uri : " + uri);
//		 					contextPath : 		/pro21_mvc			uri : null
		
		// trim() : 문자열의 앞 뒤 공백값
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
			System.out.println("uri = request.getRequestURI(); => " + uri);
//																	/pro21_mvc/test/login.do
		}
		
		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
			System.out.println("begin = contextPath.length(); => " + begin);
		}
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
			System.out.println("end = uri.indexOf(\";\"); => " + end);
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
			System.out.println("end = uri.indexOf(\"?\"); => " + end);
		} else {
			end = uri.length();
			System.out.println("end = uri.length(); => " + end);
		}
		
		String fileName = uri.substring(begin, end);
		System.out.println("String fileName = uri.substring(begin, end); => " + fileName);
		
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			System.out.println("fileName = fileName.substring(0, fileName.lastIndexOf(\".\")); => " + fileName);
		} 
		
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
			System.out.println("fileName = fileName.substring(0, fileName.lastIndexOf(\"/\")); => " + fileName);
		}
		
		System.out.println("return fileName; => " + fileName);
		
		return fileName;
	}

}
