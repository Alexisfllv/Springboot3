package com.edu.repository;

import com.edu.dto.prod.IProcedureSale2DTO;
import com.edu.dto.prod.ProcedureSale1DTO;
import com.edu.model.Sale;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISaleRepo extends  IGenericJPARepo<Sale,Integer>{

    //funcion de prod creado psgrsql
    @Query(value = "select * from fn_sales()" , nativeQuery = true)
    List<Object[]> callProcedure1();

    //todo query nativo devuleve una lista de arreglo nativo
    /*
    [
        [valor1 , valor2]
        [valor1 , valor2]
        [valor1 , valor2]
        [valor1 , valor2]
        [valor1 , valor2]
    ]
     */

    // interfaz proyectada
    @Query(value = "select * from fn_sales()" , nativeQuery = true)
    List<IProcedureSale2DTO> callProcedure2();

}
