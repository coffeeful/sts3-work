package com.icia.semi;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.semi.dto.SemiDto;
import com.icia.semi.dto.memberDto;
import com.icia.semi.service.SemiService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private SemiService sServ;

	// 구직페이지 메인
	@GetMapping("main")
	public String main(Integer pageNum, Model model, HttpSession session) {
		log.info("main()");

		String view = sServ.getContentList(pageNum, model, session);

		return view;
	}

	// 구직글 등록 페이지
	@GetMapping("jobFrm")
	public String jobFrm() {
		log.info("jobFrm()");

		return "jobFrm";
	}

	// 구직글 등록
	@PostMapping("jobProc")
	public String jobProc(@RequestPart List<MultipartFile> files, SemiDto content, HttpSession session,
			RedirectAttributes rttr) {
		log.info("jobProc()");
		String view = sServ.insertContent(files, content, session, rttr);
		return view;
	}

	// 상세페이지
	@GetMapping("detail")
	public String detail(Integer c_id, Model model) {
		log.info("detail()");
		sServ.getContent(c_id, model);
		return "detail";
	}

	// 수정 페이지 전환
	@GetMapping("updateFrm")
	public String updateFrm(Integer c_id, Model model) {
		log.info("updateFrm()");
		sServ.getContent(c_id, model);
		return "updateFrm";
	}

	// 수정 데이터 처리
	@PostMapping("updateProc")
	public String updateProc(@RequestPart List<MultipartFile> files, SemiDto content, HttpSession session,
			RedirectAttributes rttr) {
		log.info("updateProc()");
		String view = sServ.contentUpdate(files, content, session, rttr);
		return view;
	}

	// 삭제 데이터 처리
	@GetMapping("delete")
	public String deletContent(Integer c_id, HttpSession session, RedirectAttributes rttr) {
		log.info("deleteContent");
		String view = sServ.contentDelete(c_id, session, rttr);
		return view;
	}

	// 테스트 메인창
	@GetMapping("/")
	public String home() {

		return "home";

	}
	@GetMapping("login")
	public String login() {

		return "login";

	}

	
	// 로그인 기능
	@PostMapping("login")
	public String processLogin(memberDto member , HttpSession session ,RedirectAttributes rttr) {
			log.info("processLogin()");
		String loginSuccess = sServ.authenticate(member , session ,rttr);
		return loginSuccess;
	}
	//로그아웃 기능
	@PostMapping("logout")
	public String processLogout(HttpSession session , RedirectAttributes rttr) {
		log.info("processLogout");
		String logoutSuccess = sServ.logout(session , rttr);
		return logoutSuccess;
	}
	
	//회원가입
	@PostMapping("join")
	public String processMemberjoin(memberDto member, RedirectAttributes rttr) {
		log.info("processMemberjoin() : id - {}", member.getId());
		String view = sServ.join(member, rttr);

		return view;
	}

	// 회원가입 기능
	@GetMapping("join")
	public String memberjoinForm(Model model) {
		model.addAttribute("member", new memberDto());
		return "join";
	}

	@PostMapping("checkDuplicateId") // 아이디 중복 체크 확인
	@ResponseBody
	public String checkDuplicateId(String m_id) {
		log.info("checkDuplicateId: {}", m_id);
		String res = sServ.checkDuplicateId(m_id);

		return res;
	}
}
