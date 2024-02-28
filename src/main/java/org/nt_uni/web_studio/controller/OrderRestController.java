package org.nt_uni.web_studio.controller;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.mapper.OrderMapper;
import org.nt_uni.web_studio.model.base.Order;
import org.nt_uni.web_studio.model.dto.input.OrderInput;
import org.nt_uni.web_studio.model.dto.input.SearchOptions;
import org.nt_uni.web_studio.model.dto.output.OrderOutput;
import org.nt_uni.web_studio.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("order")
public class OrderRestController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("info")
    public ResponseEntity getOrdersInfoBy(@RequestBody SearchOptions input){
        try {
            Collection<Order> orders = orderService.getOrdersInfoBy(input);
            List<OrderOutput> outputs = orders.stream().map(orderMapper::mapEntityToDto).collect(Collectors.toList());

            return new ResponseEntity<>(outputs, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("info/{code}")
    public ResponseEntity getOrderInfoByCode(@PathVariable(name = "code") String code){

        try {
            Order order = orderService.getOrderInfoByCode(code);
            OrderOutput output = orderMapper.mapEntityToDto(order);
            return new ResponseEntity<>(output, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("register")
    public ResponseEntity registerOrder(@RequestBody OrderInput input){
        try {
            Order order = orderService.registerOrder(input);
            OrderOutput output = orderMapper.mapEntityToDto(order);
            return new ResponseEntity<>(output,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("changeStatus")
    public ResponseEntity changeOrderStatus(@RequestBody OrderInput input){
        try {
            Order order = orderService.changeOrderStatus(input);
            OrderOutput output = orderMapper.mapEntityToDto(order);
            return new ResponseEntity<>(output, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("delete/{code}")
    public ResponseEntity deleteOrder(@PathVariable("code") String code){
        try{
            orderService.deleteOrder(code);
            return new ResponseEntity<>("Order was deleted successfully",HttpStatus.ACCEPTED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
