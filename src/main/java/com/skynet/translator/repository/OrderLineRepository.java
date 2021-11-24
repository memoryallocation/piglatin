package com.skynet.translator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skynet.translator.entity.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
