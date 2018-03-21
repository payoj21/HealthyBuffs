package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import models.InventoryFacade;


@Controller
public class PharmacistUploadController {
	
   @RequestMapping(value = "/pharmacistUpload", method = RequestMethod.GET)
   public ModelAndView patient() {
      return new ModelAndView("pharmacistUpload", "command", new InventoryFacade());
   }
   
   @RequestMapping(value = "/pharmacistUploadPost", method = RequestMethod.POST)
   public String addInventory(@ModelAttribute("MVCSpring")InventoryFacade press, 
      ModelMap model) {
	  press.updateDB(press);
	 
      model.addAttribute("inventory_id", press.getInventory_id());
      model.addAttribute("cost", press.getCost());
      model.addAttribute("quantity", press.getQuantity());
      
      
      return "result_inventory";
   }
}