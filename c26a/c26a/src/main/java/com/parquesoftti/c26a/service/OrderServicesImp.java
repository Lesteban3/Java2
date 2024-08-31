package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Order;
import com.parquesoftti.c26a.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServicesImp implements OrderService{
    final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order update(Long id, Order order) {
        Order ordersTmp = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found"));
        ordersTmp.setCustomer(order.getCustomer());
        ordersTmp.setProduct(order.getProduct());
        ordersTmp.setOrderDate(order.getOrderDate());
        ordersTmp.setQuantity(order.getQuantity());



        return orderRepository.save(ordersTmp);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}