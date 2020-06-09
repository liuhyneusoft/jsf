package com.jfs.training.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.training.param.TrainParam;
import com.jfs.training.service.TrainService;
import com.jsf.common.resp.JSFResponse;

 
@RestController
@RequestMapping("/train")
public class TrainingController {

	 @Autowired
	 private TrainService trainService;
	 
	@RequestMapping(value = "/{trainID}", method = { RequestMethod.GET })
	 public JSFResponse list(@PathVariable Long trainID){
		JSFResponse response = new JSFResponse();
		response.setValue("result", "hahahah");
		return response;
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	 public JSFResponse add(@RequestBody TrainParam param)  {
		JSFResponse response = new JSFResponse();
		trainService.saveTrain(param);
		return response;
	}
	
	@RequestMapping(value = "/accept/{trainID}", method = { RequestMethod.GET })
	 public JSFResponse accept(@PathVariable Long trainID){
		JSFResponse response = new JSFResponse();
		trainService.accept(trainID);
		return response;
	}
	
	@RequestMapping(value = "/reject/{trainID}", method = { RequestMethod.GET })
	 public JSFResponse reject(@PathVariable Long trainID){
		JSFResponse response = new JSFResponse();
		trainService.reject(trainID);
		return response;
	}
	
	
	
}
