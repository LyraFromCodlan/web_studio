package org.nt_uni.web_studio.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.mapper.OrderMapper;
import org.nt_uni.web_studio.dao.*;
import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.base.Order;
import org.nt_uni.web_studio.model.dto.input.OrderInput;
import org.nt_uni.web_studio.model.dto.input.SearchOptions;
import org.nt_uni.web_studio.model.process.Status;
import org.nt_uni.web_studio.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;
    private final ApplicationTypeRepository applicationTypeRepository;
    private final BusinessProcessRepository businessProcessRepository;
    private final StageRepository stageRepository;
    private final OrderMapper orderMapper;

    @Override
    public Collection<Order> getOrdersInfoBy(SearchOptions input) {
        Collection<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Order getOrderInfoByCode(String code) {
        Order order = orderRepository.findByCodeIgnoreCase(code);
        return order;
    }

    @Override
    public Order registerOrder(OrderInput input) {
        Order order = new Order();
        ApplicationType applicationType = applicationTypeRepository.findByCodeIgnoreCase(input.getApplicationTypeCode());
        Status status = statusRepository.findByCodeIgnoreCase("REGISTERED");
        orderMapper.mapDtoToEntity(input, applicationType, status,  order);
        order = orderRepository.save(order);
        order.setCode("5"+"0".repeat(10-order.getId().toString().length())+order.getId());
        order = orderRepository.save(order);
        return order;
    }

    @Override
    public Order changeOrderStatus(OrderInput input) {
        Order order = orderRepository.findByCodeIgnoreCase(input.getOrderCode());
        if(order != null){
            ApplicationType applicationType = applicationTypeRepository.findByCodeIgnoreCase(input.getApplicationTypeCode());
            Status status = statusRepository.findByCodeIgnoreCase(input.getStatusCode());
            orderMapper.mapDtoToEntity(input, applicationType, status,  order);
            order = orderRepository.save(order);
        }
        return order;
    }

    @Override
    public void deleteOrder(String code) {
        Order order = orderRepository.findByCodeIgnoreCase(code);
        orderRepository.delete(order);
    }
}
