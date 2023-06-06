package jpabook.jpashop5.service;

import jpabook.jpashop5.api.OrderApiController;
import jpabook.jpashop5.domain.Order;
import jpabook.jpashop5.repository.OrderRepository;
import jpabook.jpashop5.service.query.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {

    private final OrderRepository orderRepository;

    /**
     * open-session-in-view 가 false 여도 트랜잭션안에서 처리해주므로 잘 동작함
     * @return
     */
    public List<OrderDto> ordersV3() {

        List<Order> orders = orderRepository.findAllWithItem();

        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());
        return result;
    }
}
