package com.chainsys.collegefeeregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.service.PaymentService;

@RestController
@RequestMapping("api")
public class PaymentController {

	@Autowired
	PaymentService obj;

	
}
