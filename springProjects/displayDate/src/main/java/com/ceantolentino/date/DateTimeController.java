package com.ceantolentino.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateTimeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("EEEEE',' 'the 'dd 'of 'MMMMM', ' yyyy");
		model.addAttribute("date", format.format(date));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
		model.addAttribute("time", format.format(time));
		return "time.jsp";
	}
}
