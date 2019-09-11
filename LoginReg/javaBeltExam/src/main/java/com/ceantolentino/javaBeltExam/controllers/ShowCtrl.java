package com.ceantolentino.javaBeltExam.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ceantolentino.javaBeltExam.models.Rating;
import com.ceantolentino.javaBeltExam.models.Show;
import com.ceantolentino.javaBeltExam.services.ShowService;

@Controller
public class ShowCtrl {
	@Autowired
	private ShowService showService;
	
	@GetMapping("/shows")
	public String shows(Model model) {
		
		
		model.addAttribute("allShows", showService.getAllShows());
		return "shows/index.jsp";
	}
	
	@GetMapping("/shows/new")
	public String newShow(@ModelAttribute("newShow") Show show) {
		return "shows/create.jsp";
	}
	
	@PostMapping("/createShow")
	public String createShow(@ModelAttribute("newShow") Show show,
			@RequestParam("title") String title,
			@RequestParam("network") String network,
			RedirectAttributes errors) {
		if(showService.getShowByTitle(title)==null) {
			if(title.equals(network)) {
				errors.addFlashAttribute("showError", "*Title and Network cannot be the same.");
				return "redirect:/shows/new";
			}else {
				show.setTitle(title);
				show.setNetwork(network);
				showService.createNewShow(show);
				return "redirect:/shows";
			}
		}else {
			errors.addFlashAttribute("showError", "*This show is already added to the database");
			return "redirect:/shows/new";
		}
	}
	
	@GetMapping("/shows/{id}")
	public String viewShow(@PathVariable("id") Long id, Model model, @ModelAttribute("newRating") Rating rating) {
		Show show = showService.getShowById(id);
		model.addAttribute("thisShow", show);
		model.addAttribute("usersRated", showService.getAllUsersRated(show));
		return "shows/view.jsp";
	}
	
	@PostMapping("/shows/{id}")
	public String rateShow(@Valid @ModelAttribute("newRating") Rating rating, BindingResult results, @PathVariable("id") Long id) {
		if(results.hasErrors()) {
			return "redirect:/shows/"+id;
		}else {
			Show show = showService.getShowById(id);
			if(show.getAvgRating()>0) {
				int totalUsers = show.getUsers_who_rated().size();
				double currentRating = show.getAvgRating()*totalUsers;
				
				Rating newRating = showService.rateAShow(rating);
				
				double tempRating = (currentRating+newRating.getRating());
				BigDecimal bd = new BigDecimal(tempRating/(totalUsers+1)).setScale(2, RoundingMode.HALF_UP);
				show.setAvgRating(bd.doubleValue());
				showService.createNewShow(show);
			}else {
				Rating newRating = showService.rateAShow(rating);
				show.setAvgRating(newRating.getRating());
				showService.createNewShow(show);
			}
			return"redirect:/shows/"+id;
		}
	}
	
	@GetMapping("/shows/{id}/edit")
	public String editShow(@PathVariable("id") Long id, Model model) {
		model.addAttribute("show", showService.getShowById(id));
		return "shows/edit.jsp";
	}
	
	@PostMapping("/shows/{id}/edit")
	public String edit(@PathVariable("id") Long id, @RequestParam("title") String title, @RequestParam("network") String network) {
		Show show = showService.getShowById(id);
		show.setTitle(title);
		show.setNetwork(network);
		showService.createNewShow(show);
		return "redirect:/shows";
		
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		showService.deleteShow(id);
		return "redirect:/shows";
	}
}
