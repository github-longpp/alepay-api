package com.icom.alepayorder.controller;

import com.icom.alepayorder.dao.UserDao;
import com.icom.alepayorder.dao.UserRepository;
import com.icom.alepayorder.dto.OrderRequest;
import com.icom.alepayorder.dto.OrderRequestSendAlePay;
import com.icom.alepayorder.dto.OrderResponse;
import com.icom.alepayorder.dto.PaymentRequest;
import com.icom.alepayorder.entity.User;
import com.icom.alepayorder.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/sendOrder")
    public ResponseEntity sendOrder(@RequestBody OrderRequest orderRequest) throws URISyntaxException {
        OrderRequestSendAlePay orderRequestSendAlePay = new OrderRequestSendAlePay();
        orderRequestSendAlePay.setAmount(orderRequest.getAmount());
        orderRequestSendAlePay.setUserId(orderRequest.getUserId());
        orderRequestSendAlePay.setCustomMerchantId("icom123");
        orderRequestSendAlePay.setOrderCode(RandomUtils.randomOrderCode());
        orderRequestSendAlePay.setOrderDescription("description");
        orderRequestSendAlePay.setTokenKey("dhklHv7DCqvvxtH4pQWDQhaTXGkTpo");

//        final String url = "http://localhost:8080/order/recieveOrder";
//        URI uri = new URI(url);
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<OrderRequestSendAlePay> requestBody = new HttpEntity<>(orderRequestSendAlePay, headers);
//
//        OrderResponse result = restTemplate.postForObject(uri, requestBody, OrderResponse.class);
//        System.out.println(result);
//        if (result != null) {
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } else
//            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(orderRequestSendAlePay, HttpStatus.OK);

    }

//     @PostMapping(value = "/recieveOrder")
//     public ResponseEntity recieveOrder(@RequestBody OrderRequestSendAlePay orderRequestSendAlePay) {
//         OrderResponse orderResponse = null;
//         User user = userDao.getUserById(orderRequestSendAlePay.getUserId());
//         if (user != null) {
//             orderResponse = new OrderResponse("000", "Thành Công", "CheckoutUrl", "TransactionCode");
//             return new ResponseEntity<>(orderResponse, HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(orderResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @PostMapping(value = "/recievePayment")
//     public ResponseEntity recievePayment(@RequestBody PaymentRequest paymentRequest) {
//         if (paymentRequest.getStatus().equals("000")) {
//             System.out.println("==== Lưu vào db ====");
//             return new ResponseEntity<>(paymentRequest, HttpStatus.OK);
//         } else {
//             System.out.println("=== Do something ====");
//         }
//         return new ResponseEntity<>("==== transaction fail ====", HttpStatus.INTERNAL_SERVER_ERROR);
//     }
 }
