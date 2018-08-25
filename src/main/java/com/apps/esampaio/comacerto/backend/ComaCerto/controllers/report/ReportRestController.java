package com.apps.esampaio.comacerto.backend.ComaCerto.controllers.report;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps.esampaio.comacerto.backend.ComaCerto.services.report.ReportService;
import com.apps.esampaio.comacerto.backend.ComaCerto.util.DateUtil;

@RestController
@RequestMapping("/reports")
public class ReportRestController {
	
	
	
	@RequestMapping(path="/meals",method = RequestMethod.POST, produces = "application/pdf", headers = { "version=v1" })
	public byte[] generateMealReportV1(@RequestBody GenerateMealReportRequest request ) throws Exception {
		System.out.println("Gerando relatórios");
		Date initialDate = DateUtil.dateForFormat(request.getInitialDate());
		Date finalDate = DateUtil.dateForFormat(request.getFinalDate());
		ByteArrayOutputStream resultStream = new ReportService("v1").generateMealReport(request.getMeals(), initialDate, finalDate );
		return resultStream.toByteArray();
	}
	
	
} 