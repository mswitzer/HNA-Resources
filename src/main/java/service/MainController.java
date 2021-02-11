package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import hello.DataBase;
import hello.ClassConnector;

@Controller
public class MainController {

	//public ArrayList<ClassConnector> databaseClasses = new ArrayList<ClassConnector>();

	DataBase databaseClasses = new DataBase();

	@GetMapping("/subject")
	public String subject(@RequestParam(name="subject", required=false, defaultValue="World") String name, Model model,
	@RequestParam(name="subjectId", required=false, defaultValue="World") int subjectId) {
		ArrayList<ClassConnector> classList = databaseClasses.ClassInfo();
		model.addAttribute("subject", name);
		model.addAttribute("subjectId", subjectId);
		model.addAttribute("classList", classList);
		return "subject";
	}





	@GetMapping("/subject/{category}")
	public String category(@PathVariable("category") String category, Model model){
		model.addAttribute("category", category);
		return "subject";

	}




}