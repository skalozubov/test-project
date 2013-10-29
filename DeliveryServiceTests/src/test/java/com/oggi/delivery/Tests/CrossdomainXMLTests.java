package com.oggi.delivery.Tests;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

public class CrossdomainXMLTests extends DeliveryService {

    @Test
    public void getCrossdomainXMLTest() {
        String expectedResponse =
                "<!DOCTYPE cross-domain-policy SYSTEM \"http://www.macromedia.com/xml/dtds/cross-domain-policy.dtd\">\n" +
                        "<cross-domain-policy>\n" +
                        "    <site-control permitted-cross-domain-policies=\"master-only\"/>\n" +
                        "    <allow-access-from domain=\"*\"/>\n" +
                        "    <allow-http-request-headers-from domain=\"*\" headers=\"*\"/>\n" +
                        "</cross-domain-policy>\n";
        expect()
                .statusCode(HttpStatus.SC_OK)
                .body(equalTo(expectedResponse))
        .when()
                .get(CROSSDOMAIN_XML);
    }
}
