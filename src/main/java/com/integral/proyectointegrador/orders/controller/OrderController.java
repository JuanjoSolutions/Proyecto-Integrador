package com.integral.proyectointegrador.orders.controller;

import com.integral.proyectointegrador.orders.model.Order;
import com.integral.proyectointegrador.orders.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST: Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    // PATCH: Actualizar el estado de un pedido
    @PatchMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id,
                                                   @RequestParam String status) {
        Order updatedOrder = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(updatedOrder);
    }

    // GET: Listar TODOS los pedidos (nuevo endpoint)
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        // Llamamos al método findAll() de tu servicio para obtener todos los pedidos
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }
}


