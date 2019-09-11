package com.ceantolentino.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ceantolentino.lookify.models.Song;
import com.ceantolentino.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Song this_song = lookifyService.findSong(id);
		model.addAttribute("song", this_song);
		return "details.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String create(@ModelAttribute("song") Song song) {
		return "create.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
		}else {
			lookifyService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist, RedirectAttributes error, Model model) {
		List<Song> songsByArtist = lookifyService.allSongsByArtist(artist);
		if(songsByArtist.isEmpty()) {
			error.addFlashAttribute("error", "The artist is not in your playlist yet!");
			return "redirect:/dashboard";
		} else {
			model.addAttribute("songs", songsByArtist);
			model.addAttribute("artist", artist);
			return "songs.jsp";
		}
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topSongs = lookifyService.topSongs();
		model.addAttribute("TopSongs", topSongs);
		return "topten.jsp";
	}
	
	@RequestMapping("/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		lookifyService.delete(id);
		return "redirect:/dashboard";
	}
	
	
}
