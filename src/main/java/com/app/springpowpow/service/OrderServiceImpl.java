package com.app.springpowpow.service;

import com.app.springpowpow.domain.OrderDTO;
import com.app.springpowpow.domain.OrderVO;
import com.app.springpowpow.domain.ProductDTO;
import com.app.springpowpow.repository.OrderDAO;
import com.app.springpowpow.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;


    @Override
    public void insertOrder(OrderVO orderVO) {
        orderDAO.save(orderVO);
    }

    @Override
    public List<OrderDTO> selectAllOrders() {
        return orderDAO.findAll();
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long id) {
        return orderDAO.findById(id);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderDAO.deleteById(id);
    }

}