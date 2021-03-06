package com.example.organization;

import org.springframework.stereotype.Controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrgController {
	
	@Autowired 
	private OrgRepository orgRepository;

	//To get the add-job.html page
	@GetMapping("/org")
	public String job(Organization org)
	{
		return "add-org";
	}
	
	//add the job info
	@PostMapping("/add")
    public String add(@Valid Organization org, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-org";
        }

        orgRepository.save(org);
        model.addAttribute("organizations", orgRepository.findAll());
        return "index";
    }
	
	//Get the edit request
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") int no, Model model) {
		    Organization org = orgRepository.findById(no)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid Organization ID:" + no));

		    model.addAttribute("organization", org);
		    return "update-org";
		}
		
		//update the existing job info
		@PostMapping("/update/{id}")
		public String update(@PathVariable("id") int no, @Valid Organization org,
		  BindingResult result, Model model) {
		    if (result.hasErrors()) {
		    	org.setOrgId(no);
		        return "update-org";
		    }

		    orgRepository.save(org);
		    model.addAttribute("organizations", orgRepository.findAll());
		    return "index";
		}
		
		//delete a department info
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") int no, Model model) {
		    Organization org= orgRepository.findById(no)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid Job ID:" + no));
		    orgRepository.delete(org);
		    model.addAttribute("users", orgRepository.findAll());
		    return "index";
		}
	
}
