package com.skynet.translator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skynet.translator.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
