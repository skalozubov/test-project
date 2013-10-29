package com.oggi.delivery.Tests;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class DeliveryService {

    public static final String E_ASSETS_METHOD_PATH = "/e/assets";
    public static final String QUERY_PARAM_ID = "id";
    public static final String CROSSDOMAIN_XML = "/crossdomain.xml";
    String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_NAME = "Access-Control-Allow-Origin";
    String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_VALUE = "*";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigInitializer.SERVICE_HOST;
        RestAssured.port = ConfigInitializer.SERVICE_PORT;
    }

    @AfterClass
    public static void tearDown() {
    }
}
