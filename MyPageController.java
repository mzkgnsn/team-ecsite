package jp.co.internous.origami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.origami.model.domain.MstUser;
import jp.co.internous.origami.model.mapper.MstUserMapper;
import jp.co.internous.origami.model.session.LoginSession;

@Controller
@RequestMapping("/origami/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);
		return "my_page";
	}

}
