package com.accolite.demo.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.demo.model.Order;
import com.accolite.demo.service.impl.OrderMServiceImpl;


@RestController
@RequestMapping("/order")
public class OrderMController {
	
	
		
		@Autowired
		OrderMServiceImpl orderService;
		
		@PostMapping("/create")
		public ResponseEntity<String> createOrder() { 
		String response = orderService.createOrder();	
		 return ResponseEntity.ok(response);
		}
		
		
		@PostMapping("/add")
		public ResponseEntity<Order> createOrder(@RequestBody @Validated Order order) { //@Validator
		Order order2 = orderService.addOrder(order);
		if(Objects.nonNull(order)) {
			return ResponseEntity.ok(order2);
			}
		else {
			System.out.println("Error handling  put all required feilds");
			return ResponseEntity.ok(order2);	
		}
		
		 
		}
		
		
		@GetMapping("/get/{id}")
		public Object getOrderById(@PathVariable("id") @NonNull int id) {
			Order order = (Order) orderService.getOrderById(id);
			if(Objects.nonNull(order)) {
				return ResponseEntity.ok(order);
			}
			else {
				//return ResponseEntity.notFound();
				return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
			}
			
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Order> updateOrder(
				@PathVariable("id") @NonNull Integer id,
				@RequestBody  Map<String, Integer> orderdet2
				) {
			Integer quantity = orderdet2.get("quantity");
			Order order = (Order) orderService.getOrderById(id);
			order.setQuantity(quantity);
			orderService.updateOrder(order);
			
			return ResponseEntity.ok(order);
			
		}

		@PutMapping("/update2/{id}")
		public ResponseEntity<Order> updateOrder2(
				@PathVariable("id") @NonNull Integer id,
				@RequestBody  Map<String, String> orderdet1
				) {
			String product = orderdet1.get("product");
			Order order = (Order) orderService.getOrderById(id);
			order.setProduct(product);
			orderService.updateOrder(order);
			
			return ResponseEntity.ok(order);
			
		}
		
		
		@DeleteMapping("/delete/{id}")
		public String deleteOrder(@PathVariable("id") @NonNull int id) {
		return orderService.deleteOrder(id);
		}

	


}
