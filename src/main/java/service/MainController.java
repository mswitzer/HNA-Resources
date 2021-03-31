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
	public String subject(@RequestParam(name="subject", required=true) String name, Model model,
	@RequestParam(name="subjectId", required=true) int subjectId) {
			ArrayList<ClassConnector> classList = databaseClasses.ClassInfo(subjectId);
			model.addAttribute("subject", name);
			model.addAttribute("subjectId", subjectId);
			model.addAttribute("classList", classList);
		return "subject";
	}




@GetMapping("/class/{classId}")
	public String classPage(@PathVariable("classId") int classId, Model model) {
		ArrayList<ClassConnector> linkList = databaseClasses.LinkInfo(classId);
		model.addAttribute("classId", classId);
		model.addAttribute("linkList", linkList);
		return "classPage";
	}




}