package meta.stock.java;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private ModelService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {	
		List<ModeloClass> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index"; 
	}
	
	@RequestMapping("/new")
	public String showNewCarForm(Model model) {
		ModeloClass modelo = new ModeloClass();
		model.addAttribute("modelo", modelo);
		
		return "new_car";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCar(@ModelAttribute("modelo")ModeloClass modelo) {
		service.save(modelo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCarForm(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_car");
		
		Optional<ModeloClass> modelo  = service.getCar(id);
		mav.addObject("modelo", modelo);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCar(@PathVariable(name = "id")String id) {
		
		service.delete(Integer.valueOf(id));
		
		return "redirect:/";
	}


}
