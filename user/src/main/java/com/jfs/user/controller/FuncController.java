package com.jfs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.user.service.UserService;
import com.jsf.common.resp.JSFResponse;
import com.jsf.common.vo.MentoVo;

@RestController
@RequestMapping("/fun")
public class FuncController {

	@Autowired
	private UserService us;
	@RequestMapping(value = "/mentors", method = { RequestMethod.GET })
    public JSFResponse getMentors(){
		JSFResponse cr = new JSFResponse();
		List<MentoVo> vos = us.getMentors();
		cr.setValue("result", vos);
        return cr;
    }
}
