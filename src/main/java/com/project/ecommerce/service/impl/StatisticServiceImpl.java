package com.project.ecommerce.service.impl;

import com.project.ecommerce.repository.ProductRepo;
import com.project.ecommerce.repository.UserRepo;
import com.project.ecommerce.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public long countAllUser() {
        return userRepo.count();
    }

    @Override
    public long countAllProduct() {
        return productRepo.count();
    }
}
