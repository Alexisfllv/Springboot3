package com.edu.service.impl;

import com.edu.dto.prod.IProcedureSale2DTO;
import com.edu.dto.prod.ProcedureSale1DTO;
import com.edu.model.Sale;
import com.edu.model.SaleDetail;
import com.edu.repository.ISaleRepo;
import com.edu.repository.IGenericJPARepo;
import com.edu.service.ISaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
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

    @Override
    public List<ProcedureSale1DTO> listadoCantidadFecha3() {
        return repo.callProcedure3();
    }

    //PROCEDIMIENTO ALMACENADO
    @Override
    public void callprocedure4() {
        repo.callProcedure4();
    }

    //querie

    @Override
    public Sale getSaleMostExpensive() {
        return  repo.findAll()
                .stream()
                .max(Comparator.comparing( e ->
                {
                    return e.getTotal();
                }
                ))
                .orElse(new Sale());
    }

    @Override
    public String getBestSeller() {
        Map<String, Double> byuser = repo.findAll()
                .stream()
                .collect(Collectors
                        .groupingBy
                                (s -> s.getUser().getUsername(),Collectors.summingDouble(Sale -> Sale.getTotal())));
        //sout val max
        log.info(byuser.toString());
        //map<,> max();
        return Collections.max(byuser.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();
    }

    @Override
    public Map<String, Long> getSaleCounterBySeller() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(s -> s.getUser().getUsername(),Collectors.counting()));

        // [get.userName , get.total]
    }

    @Override
    public Map<String, Double> getMostSellProduct() {
        Stream<Sale> saleStream = repo.findAll().stream();
        Stream<List<SaleDetail>> listStream =  saleStream.map(Sale -> Sale.getDetails());
        Stream<SaleDetail> streamDetail = listStream.flatMap(Collections -> Collections.stream());
        Map<String, Double> byProduct = streamDetail
                .collect(Collectors.groupingBy(d -> d.getProduct().getName(),Collectors.summingDouble(SaleDetail -> SaleDetail.getQuantity())));

        log.info(byProduct.toString());
        return byProduct.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry:: getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,LinkedHashMap::new
                ));
    }
}
