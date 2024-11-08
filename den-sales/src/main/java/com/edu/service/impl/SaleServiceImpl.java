package com.edu.service.impl;

import com.edu.model.Sale;
import com.edu.repository.ISaleRepo;
import com.edu.repository.IGenericJPARepo;
import com.edu.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale,Integer> implements ISaleService {

    //repo
    private final ISaleRepo repo;

    @Override
    protected IGenericJPARepo<Sale, Integer> getRepo() {
        return repo;
    }
}
