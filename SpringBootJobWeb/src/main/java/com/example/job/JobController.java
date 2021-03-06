package com.example.job;

import org.springframework.stereotype.Controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
	
	@Autowired 
	private JobRepository jobRepository;

	//To get the add-job.html page
	@GetMapping("/job")
	public String job(Job job)
	{
		return "add-job";
	}
	
	//add the job info
	@PostMapping("/add")
    public String add(@Valid Job job, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-job";
        }

        jobRepository.save(job);
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }
	
	//Get the edit request
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") int no, Model model) {
		    Job j = jobRepository.findById(no)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid Job ID:" + no));

		    model.addAttribute("job", j);
		    return "update-job";
		}
		
		//update the existing job info
		@PostMapping("/update/{id}")
		public String update(@PathVariable("id") int no, @Valid Job job,
		  BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        job.setJobId(no);
		        return "update-job";
		    }

		    jobRepository.save(job);
		    model.addAttribute("jobs", jobRepository.findAll());
		    return "index";
		}
		
		//delete a department info
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") int no, Model model) {
		    Job j= jobRepository.findById(no)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid Job ID:" + no));
		    jobRepository.delete(j);
		    model.addAttribute("users", jobRepository.findAll());
		    return "index";
		}
	
}
