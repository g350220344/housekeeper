package com.cindata.housekeeper.web.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.HtmlToPdf;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.model.PdfPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/Pdf")
public class CommunityPDF {

	@RequestMapping(value="/CommunityPDF", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String CommunityPDF(HttpServletRequest request, HttpServletResponse response){
		
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"), null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"), null);
		Long districtId = StringUtil.parseLong(request.getParameter("districtId"), null);
		Double d = Math.random();
		Long l = System.currentTimeMillis();
		String resultd = d.toString();
		String results = l.toString();
		String result = resultd + results;
		//boolean flag = HtmlToPdf.convert("http://tt.cindata.cn/housekeeper/page_home/change/details.html?communityId="+communityId+"&cityId="+cityId+"&districtId="+districtId+"#", "d:/"+s+".pdf");
		JSONResult res = new JSONResult();
		PdfPath pdfPath= null;
		
		try {
			String htmlPath = "http://tt.cindata.cn/housekeeper/page_home/change/details.html?communityId="+communityId+"&cityId="+cityId+"&districtId="+districtId+"#";
			//String PdfPath = "d:/"+result+".pdf";//本地
			String PdfPath = "/opt/housekeeper/temp/"+result+".pdf";//tt
			boolean flag = HtmlToPdf.convert(htmlPath, PdfPath);
			if(flag){
				pdfPath = new PdfPath();
				pdfPath.setPdfPath(PdfPath);
				pdfPath.setHtmlPath(htmlPath);
				 res.setData(pdfPath);
				 res.setMessage("ok");
				 res.setStatusCode(1);
				 res.setSuccess(true);	
			}else{
				 res.setData(pdfPath);
				 res.setMessage("no ok");
				 res.setStatusCode(2);
				 res.setSuccess(false);
			}
			} catch (Exception e) {
				e.printStackTrace();
			    res.setMessage("no ok");
				res.setStatusCode(2);
			    res.setSuccess(false);
			}
			String resultStr = CtrlerUtil.getRetBody(request, res);
			return resultStr;
	}
}
