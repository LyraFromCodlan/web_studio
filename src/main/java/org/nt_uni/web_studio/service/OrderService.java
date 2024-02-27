package org.nt_uni.web_studio.service;

import org.nt_uni.web_studio.model.base.Order;
import org.nt_uni.web_studio.model.dto.input.OrderInput;
import org.nt_uni.web_studio.model.dto.input.SearchOptions;

import java.util.Collection;

public interface OrderService {
    Collection<Order> getOrdersInfoBy(SearchOptions input);
    Order getOrderInfoByCode(String code);
    Order registerOrder(OrderInput input);
    Order changeOrderStatus(OrderInput input);
    void deleteOrder(String code);
}
