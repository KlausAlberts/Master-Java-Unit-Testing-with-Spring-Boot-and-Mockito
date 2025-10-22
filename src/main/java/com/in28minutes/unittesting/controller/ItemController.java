package com.in28minutes.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.model.Item;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public ResponseEntity<Item> dummyItem() {
		Item item = new Item(1, "Ball", 10, 100);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@GetMapping("/item-from-business-service")
	public ResponseEntity<Item> itemFromBusinessService() {
		Item item = businessService.retreiveHardcodedItem();
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@GetMapping("/all-items-from-database")
	public ResponseEntity<List<Item>> retrieveAllItems() {
		List<Item> items = businessService.retrieveAllItems();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

}
