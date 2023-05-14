package com.example.serviceweb10;

import com.example.serviceweb10.CalculatorWs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

    public AddResponse sum(int a, int b) {

        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);

        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Add"));

        return response;
    }


    public MultiplyResponse multiply(int a, int b) {
        Multiply request = new Multiply();
        request.setIntA(a);
        request.setIntB(b);
        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Multiply"));
        return response;
    }

    public DivideResponse divide(int a, int b) {
        Divide request = new Divide();
        request.setIntA(a);
        request.setIntB(b);
        DivideResponse response = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Divide"));
        return response;
    }

    public SubtractResponse subtract(int a, int b) {
        Subtract request = new Subtract();
        request.setIntA(a);
        request.setIntB(b);
        SubtractResponse response = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Subtract"));
        return response;
    }
}
