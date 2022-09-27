package ru.rktit.someservice.tests;

import io.restassured.internal.common.assertion.Assertion;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.rktit.someservice.apiHelper.Endpoints;

public class SomeTest extends BaseTest{

    @Test
    void findPetByID(){
        //petHelper.get(Endpoints.NEW_PET,resp200,0);
        JSONObject body = new JSONObject()
                .put("id",0)
                .put("category",new JSONObject().put("name","birds"))
                .put("name","Карыч")
                .put("status","available");

    String id = petHelper.post(Endpoints.NEW_PET,body.toString(),resp200)
            .jsonPath()
            .getString("id");
    String name = petHelper.get(Endpoints.PET_ID,resp200,id)
            .jsonPath()
            .getString("name");
    Assertions.assertEquals("Карыч",name);
    }

    @Test
    void findPetByID1(){

        petHelper.get(Endpoints.NEW_PET,resp200,1);
    }
    @Test
    void findPetByID2(){

        petHelper.get(Endpoints.NEW_PET,resp200,2);
    }
}
