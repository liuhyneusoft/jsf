package com.jfs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.user.service.FuncService;
import com.jfs.user.service.UserService;
import com.jsf.common.entity.SkillEntity;
import com.jsf.common.resp.JSFResponse;
import com.jsf.common.vo.MentoVo;

@RestController
@RequestMapping("/fun")
public class FuncController {

	
	@Autowired
	private FuncService funcService;
	@RequestMapping(value = "/skills", method = { RequestMethod.GET })
    public JSFResponse skills(){
		JSFResponse cr = new JSFResponse();
		List<SkillEntity> vos = funcService.getSkills();
		cr.setValue("result", vos);
        return cr;
    }
	@RequestMapping(value = "/del/skill", method = { RequestMethod.GET })
    public JSFResponse delskills(@RequestParam(name = "id") Long id){
		JSFResponse cr = new JSFResponse();
		List<SkillEntity> vos = funcService.delSkill(id);
		cr.setValue("result", vos);
        return cr;
    }
	@RequestMapping(value = "/add/skill", method = { RequestMethod.GET })
    public JSFResponse addskills(@RequestParam(name = "skillName") String skillName){
		JSFResponse cr = new JSFResponse();
		funcService.addSkill(skillName);
		 
        return cr;
    }
	
	@Autowired
	private UserService us;
	@RequestMapping(value = "/mentors", method = { RequestMethod.GET })
    public JSFResponse getMentors(){
		JSFResponse cr = new JSFResponse();
		List<MentoVo> vos = us.getMentors();
		cr.setValue("result", vos);
        return cr;
    }
	
	@RequestMapping(value = "/mentors/param", method = { RequestMethod.GET })
    public JSFResponse param(@RequestParam(name = "name") String name, @RequestParam(name = "skill") String skill){
		JSFResponse cr = new JSFResponse();
		List<MentoVo> vos = us.getMentorsParam(name, skill);
		cr.setValue("result", vos);
        return cr;
    }
	@RequestMapping(value = "/apply/mentor", method = { RequestMethod.GET })
    public JSFResponse apply(@RequestParam(name = "userID") String userID, @RequestParam(name = "mentorMail") String mentorMail){
		JSFResponse cr = new JSFResponse();
		us.apply(userID, mentorMail);
        return cr;
    }
	
	
	@RequestMapping(value = "/trainings", method = { RequestMethod.GET })
    public JSFResponse trainings(@RequestParam(name = "userID") String userID){
		return us.trains(userID);
    }
	
	@RequestMapping(value = "/confirm", method = { RequestMethod.GET })
    public JSFResponse confirm(@RequestParam(name = "id") String id){
		JSFResponse cr = new JSFResponse();
		us.confirm(id);
        return cr;
    }
	
	@RequestMapping(value = "/reject", method = { RequestMethod.GET })
    public JSFResponse reject(@RequestParam(name = "id") String id){
		JSFResponse cr = new JSFResponse();
		us.reject(id);
        return cr;
    }
	
	
}
