package com.oggi.delivery.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasXPath;


public class GetVASTMethodTests extends DeliveryService {

    @Test
    public void getVASTGeneralTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
        .expect()
                .statusCode(200)
                .body(hasXPath("/VAST/Ad/InLine/Creatives/Creative/Linear/Duration[text()='00:00:15']")).and()
                .body(hasXPath("/VAST/Ad/InLine/Creatives/Creative/Linear/MediaFiles/MediaFile"), containsString("http://straw.oggifinogi.com/GetWidget?campaignId=0c62d594-248c-4a72-84b8-13512455e888&playlistId=8b16efde-3735-4d58-a768-d92d90dc8b14&widgetId=bae6849a-d4bf-4a9c-aa32-6266716959fe"))
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTCmSiteResolvingTest() {
        String CmSiteValue = "testSite";
        String ExpectedImpression = "'http://ad.doubleclick.net/test_impression?pc=" + CmSiteValue + "'";
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
                .param("cm.site", CmSiteValue)
        .expect()
                .statusCode(200)
                .body(hasXPath("/VAST/Ad/InLine/Impression[1][text()=" + ExpectedImpression + "]"))
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTCBMacroResolvingTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
        .expect()
                .statusCode(200)
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTTimestampMacroResolvingTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
        .expect()
                .statusCode(200)
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTRandomMacroResolvingTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
        .expect()
                .statusCode(200)
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTApplyingChangesTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
        .expect()
                .statusCode(200)
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTFromCacheTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b14")
        .expect()
                .statusCode(200)
        .when()
                .get("/getVast");
    }

    @Test
    public void getVASTNotExistedTest() {
        given()
                .param("cid", "0c62d594-248c-4a72-84b8-13512455e888")
                .param("pid", "8b16efde-3735-4d58-a768-d92d90dc8b15")
        .expect()
                .statusCode(404)
        .when()
                .get("/getVast");
    }

    @AfterClass
    public void tearDownVAST() {
        System.out.println("tearDown()");
    }

}