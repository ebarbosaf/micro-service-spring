package com.payroll.servicies;

import com.payroll.entities.Payment;
import com.payroll.entities.Worker;
import com.payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
    @Autowired
    private RestTemplate paymentConfig;
    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker =  workerFeignClient.getWorkerById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyInCome(), days);
    }
}
