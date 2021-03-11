package com.spring.mysql.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository catRepository;
	
    // home controller - add form
    @GetMapping("/")
    public String Home() {
        return "index";
    }
    
    //delete controller
    @GetMapping("/del")
    public String del() {
    	return "del";
    }
    
    // update controller
    @GetMapping("/update")
    public String update() {
        return "update";
    }
    
    // get mapping for "/edit"
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int catId, Model model) {
        
        // find job by id from jobRepo
         Category category = catRepository.findById(catId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category:" + catId)); 
                // throw error
        
        // return jobCat
        model.addAttribute("category", category);
        
        return "update";
    }
    
    
     // Create - CRUD
    @PostMapping("/add")
    public String add(@RequestParam("catId") int catId, 
    				 @RequestParam("catCode") String catCode,
    				 @RequestParam("catName") String catName,
    				 @RequestParam("catDesc") String catDesc, Model model) {
    				 
    	Category category = new Category(catId, catCode, catName, catDesc);
    	catRepository.save(category);
        
        model.addAttribute("message", "New job category added");
        
        return "record";
    }
     
     // Read - CRUD
    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("category", catRepository.findAll());
        return "show";
    }
      
   // Update - CRUD
    @PostMapping("/edit")
    public String edit(@RequestParam("catId") int catId,
     		@RequestParam("catCode") String catCode,
    		@RequestParam("catName") String catName,
            @RequestParam("catDesc") String catDesc, Model model) {
        Category category = new Category(catId, catCode, catName, catDesc);
    	catRepository.save(category);
        
        model.addAttribute("message", "New job category added");
        
        return "record";    
    }
     
    // Delete - CRUD
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int catId, Model model) {
        catRepository.deleteById(catId);
        
        model.addAttribute("message", "One record is deleted");
        
        return "record";
    }
     

}
