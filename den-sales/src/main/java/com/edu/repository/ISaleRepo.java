package com.edu.repository;

import com.edu.dto.prod.IProcedureSale2DTO;
import com.edu.dto.prod.ProcedureSale1DTO;
import com.edu.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

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

    // 3 forma
    @Query(name = "Sale.fn_sales",nativeQuery = true)
    List<ProcedureSale1DTO> callProcedure3();

    // PROCEDIMIENTO
    @Procedure(procedureName = "pr_sales")
    void callProcedure4();

    //parametros
    @Procedure(procedureName = "pr_sales(:param1 , :param2)")
    void callProcedure5(@Param("param1")String param1, @Param("param2")String param2);



}
