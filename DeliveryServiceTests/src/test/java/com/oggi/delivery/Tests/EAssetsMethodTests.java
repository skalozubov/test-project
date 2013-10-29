package com.oggi.delivery.Tests;

import com.oggi.delivery.mongo.TestDataReader;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * /e/assets method test suite
 */
public class EAssetsMethodTests extends DeliveryService {

    @DataProvider(name = "eAssetsMethodTestData")
    public static Object[][] getEAssetsMethodTestData() throws UnknownHostException {
        TestDataReader dataReader = new TestDataReader("e.assetsTestData");
        return dataReader.getTestData();
    }

    @Test(dataProvider = "eAssetsMethodTestData")
    public void getAdListGeneralTest(String entityId, String expectedResponse) {
        given()
                .param(QUERY_PARAM_ID, entityId).log().all()
                .expect()
                .statusCode(HttpStatus.SC_OK)
                .body(equalTo(expectedResponse))
                .response().headers(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_NAME, containsString(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_VALUE))
                .when()
                .get(E_ASSETS_METHOD_PATH);
    }
}
