package com.payroll.servicies;

import com.payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workwerId, Integer days) {
        return new Payment("Bob", 200.00, days);
    }
}
