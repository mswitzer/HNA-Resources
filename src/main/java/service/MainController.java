package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping("/subject")
	public String subject(@RequestParam(name="subject", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("subject", name);
		return "subject";
	}





	@GetMapping("/subject/{category}")
	public String category(@PathVariable("category") String category, Model model){
		model.addAttribute("category", category);
		return "subject";

	}




}