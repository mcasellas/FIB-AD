/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.fotOk;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author marccasellas
 */
@WebService(serviceName = "FotOkWS")
public class FotOkWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listImages")
    public List listImages() {
        //TODO write your implementation code here:
        return null;
    }
}
