/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.unique;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author MyLappy
 */
@WebService(serviceName = "Calculator")
public class Calculator {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumber")
    public int getNumber(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        int sum=num1+num2;
        return sum;
    }

    /**
     * This is a sample web service operation
     */
    
}
