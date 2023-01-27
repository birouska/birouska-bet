package com.birouskabet.better.controller;

import com.birouskabet.better.entity.Better;
import com.birouskabet.better.repository.BetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;



@Controller
@RequiredArgsConstructor
@RequestMapping("/better")
public class BetterController {

	@Autowired
	BetterRepository betterRepo;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Object> addBetter(@RequestBody Better better) {
		ResponseEntity<Object> result;

		if (better == null) {
			result = ResponseEntity.badRequest().build();
		} else {
			Better betterFounded = betterRepo.findByPersonalId(better.getPersonalId());
			if (betterFounded == null) {
				Better betterSave = betterRepo.save(better);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/better").path("/{id}")
						.buildAndExpand(betterSave.getId()).toUri();
				result = ResponseEntity.created(uri).build();
			} else {
				result = ResponseEntity.badRequest().build();
			}
		}
		return result;
	}

	@GetMapping
	public ResponseEntity<List<Better>> listBetter() {
		return ResponseEntity.ok().body(betterRepo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Better> getById(@PathVariable Long id) {

		Optional<Better> betterFounded = betterRepo.findById(id);
  
		if (!betterFounded.isPresent()) return ResponseEntity.notFound().build();

		return ResponseEntity.ok().body(betterFounded.get());
	}

}

