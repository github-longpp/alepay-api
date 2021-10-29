package com.icom.alepayorder.controller;

import com.icom.alepayorder.dao.UserDao;
import com.icom.alepayorder.dao.UserRepository;
import com.icom.alepayorder.dto.OrderRequest;
import com.icom.alepayorder.entity.User;
import com.icom.alepayorder.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private UserRepository userRepository;

    @PostMapping(value = "/sendOrder")
    public ResponseEntity sendOrder(@RequestBody OrderRequest orderRequest) throws NoSuchAlgorithmException, InvalidKeyException {
        User user = userDao.getUserById(orderRequest.getUserId());
        StringBuilder data = new StringBuilder();
        data.append("amount=" + orderRequest.getAmount());
        data.append("&buyerAddress=" + user.getAddress());
        data.append("&buyerCity=" + user.getCity());
        data.append("&buyerCountry=" + user.getCountry());
        data.append("&buyerEmail=" + user.getEmail());
        data.append("&buyerName=" + user.getFullName());
        data.append("&buyerPhone=" + user.getPhone());
        data.append("&cancelUrl=" + orderRequest.getCancelUrl());
        data.append("&currency=" + environment.getProperty("order.currency"));
        data.append("&customMerchantId=" + environment.getProperty("order.customMerchantId"));
        data.append("&orderCode=" + Utils.randomOrderCode());
        data.append("&orderDescription=" + environment.getProperty("order.orderDescription"));
        data.append("&returnUrl=" + orderRequest.getReturnUrl());
        data.append("&tokenKey=" + environment.getProperty("order.tokenKey"));

        System.out.println(data.toString());

        byte[] checksumKey = environment.getProperty("order.checksumKey").getBytes();

        String signature = Utils.generateHmac256(data.toString(), checksumKey);
        return new ResponseEntity<>(signature, HttpStatus.OK);

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
