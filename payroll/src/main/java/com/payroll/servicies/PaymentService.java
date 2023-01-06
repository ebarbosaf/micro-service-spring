package com.payroll.servicies;

import com.payroll.entities.Payment;
import com.payroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private RestTemplate paymentConfig;
    @Value("${hr-worker.host}")
    private String workerHost;
    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> workerVariables = new HashMap<>();
        workerVariables.put("id", String.valueOf(workerId));
        Worker worker = paymentConfig.getForObject(workerHost + "/{id}", Worker.class,  workerVariables);
        return new Payment(worker.getName(), worker.getDailyInCome(), days);
    }
}
