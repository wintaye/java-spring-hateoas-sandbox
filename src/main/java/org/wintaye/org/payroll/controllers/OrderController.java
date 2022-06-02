package org.wintaye.org.payroll.controllers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wintaye.org.payroll.models.Order;
import org.wintaye.org.payroll.models.Status;
import org.wintaye.org.payroll.models.datamodels.OrderRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    OrderRepository orderRepository;
    OrderModelAssembler assembler;

    OrderController(OrderRepository orderRepository, OrderModelAssembler assembler){
        this.orderRepository = orderRepository;
        this.assembler = assembler;
    }

    @GetMapping("/orders")
    CollectionModel<EntityModel<Order>> all(){
        List<EntityModel<Order>> orders = orderRepository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(orders, linkto(methodOn(OrderController.class).all)()).withSelfRel());
    }

    @GetMapping("/orders/{id}")
    EntityModel<Order> one(@PathVariable Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order){
        order.setStatus(Status.IN_PROGRESS);
        Order newOrder = orderRepository.save(order);

        return ResponseEntity.created(linkTo(methodOn(OrderController.class).one(newOrder.getId())).toUri()).body(assembler.toModel(newOrder));
    }



}
