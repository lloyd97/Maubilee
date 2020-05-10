package com.maubilee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maubilee.exception.ResourceNotFoundException;
import com.maubilee.model.Job;
import com.maubilee.repository.JobRepository;

@RestController
@RequestMapping("/maubilee/")
public class JobController {

	@Autowired
	private JobRepository jobRepository;
	
	//get job
	@GetMapping("job")
	public List<Job> getAllJob(){
		return this.jobRepository.findAll();
	}
	
	//get job by id
	@GetMapping("/job/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable(value = "id") Long jobId)
		throws ResourceNotFoundException {
		Job job = jobRepository.findById(jobId)
					.orElseThrow(() -> new ResourceNotFoundException("Job not found for this id: "+ jobId));
		return ResponseEntity.ok().body(job);
	}
	
	//save job
	@PostMapping("job")
	public Job createJob(@RequestBody Job job) {
		return this.jobRepository.saveAndFlush(job);
	}
		
	//update job
	@PutMapping("/job/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable(value = "id") Long jobId,
			@Valid @RequestBody Job jobDetails) throws ResourceNotFoundException {
		Job job = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResourceNotFoundException("Job not found for this id :: " + jobId));
		job.setTitle(jobDetails.getTitle());
		job.setField(jobDetails.getField());
		job.setType(jobDetails.getType());
		job.setRegion(jobDetails.getRegion());
		job.setDescription(jobDetails.getDescription());
		job.setSalary(jobDetails.getSalary());
		job.setCompany(jobDetails.getCompany());
		job.setContact(jobDetails.getContact());
		job.setPicture(jobDetails.getPicture());
		final Job jobUpdated= jobRepository.save(job);
		return ResponseEntity.ok(jobUpdated);
	}
		
	//delete job
	@DeleteMapping("/job/{id}")
	public Map<String, Boolean> deleteJob(@PathVariable(value = "id") Long jobId)
			throws ResourceNotFoundException {
		Job job  = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResourceNotFoundException("Job not found for this id :: " + jobId));
		jobRepository.delete(job);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
