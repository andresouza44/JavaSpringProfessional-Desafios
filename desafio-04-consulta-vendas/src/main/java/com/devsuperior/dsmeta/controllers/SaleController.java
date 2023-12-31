package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.awt.*;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMinDTO>> getReport(
			@RequestParam(name="minDate", defaultValue = "") String dataInicial,
			@RequestParam(name="maxDate",defaultValue = "") String dataFinal,
			@RequestParam(name="name", defaultValue = "") String name, Pageable pageable)
	 {
		 Page<SaleMinDTO> page = service.findAll(dataInicial,dataFinal, name, pageable);
		 return ResponseEntity.ok(page);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleSummaryDTO>> getSummary(
			@RequestParam(name="minDate", defaultValue = "") String minDate,
			@RequestParam(name="maxDate", defaultValue = "") String maxDate,
			Pageable pageable)
	 {
		Page<SaleSummaryDTO> page = service.getSummary(minDate, maxDate, pageable);
		return ResponseEntity.ok(page);
	}
}
