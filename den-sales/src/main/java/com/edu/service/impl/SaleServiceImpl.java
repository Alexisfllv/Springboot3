package com.edu.service.impl;

import com.edu.dto.prod.IProcedureSale2DTO;
import com.edu.dto.prod.ProcedureSale1DTO;
import com.edu.model.Sale;
import com.edu.repository.ISaleRepo;
import com.edu.repository.IGenericJPARepo;
import com.edu.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale,Integer> implements ISaleService {

    //repo
    private final ISaleRepo repo;

    @Override
    protected IGenericJPARepo<Sale, Integer> getRepo() {
        return repo;
    }


    //
    @Override
    public List<ProcedureSale1DTO> listadoCantidadFecha() {

        //
        List<ProcedureSale1DTO> list = new ArrayList<>();

        repo.callProcedure1().forEach(e -> {
            ProcedureSale1DTO dto = new ProcedureSale1DTO();
            dto.setQuantityfn(Integer.parseInt(String.valueOf(e[0])));
            dto.setDatetimefn(String.valueOf(e[1]));
            list.add(dto);
        });

        return list;
    }

    //INTERFAZ PROYECTADA

    @Override
    public List<IProcedureSale2DTO> listadoCantidadFecha2() {
        return repo.callProcedure2();
    }
}
