package com.edu.service;

import com.edu.dto.prod.IProcedureSale2DTO;
import com.edu.dto.prod.ProcedureSale1DTO;
import com.edu.model.Sale;

import java.util.List;
import java.util.Map;

public interface ISaleService extends  ICRUD<Sale,Integer> {

    //
    List<ProcedureSale1DTO>listadoCantidadFecha();

    //
    List<IProcedureSale2DTO>listadoCantidadFecha2();


    //3
    List<ProcedureSale1DTO>listadoCantidadFecha3();

    //procedimiento 4
    void callprocedure4();

    //
    //venta mas cara
    Sale getSaleMostExpensive();

    //mejorvendedor
    String getBestSeller();

    //Contar cantidad de ventas por vendedor
    Map<String , Long> getSaleCounterBySeller();

    //Obtener el producto mas vendido
    Map<String,Double> getMostSellProduct();
}
