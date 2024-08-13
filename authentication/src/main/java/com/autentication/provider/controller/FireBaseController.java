package com.autentication.provider.controller;

import com.autentication.provider.entiry.User;
import com.autentication.provider.firebase.CRUDservice;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireBaseController {


    @Autowired
    private CRUDservice cruDservice;


//    @GetMapping("/getuser")
//    public void getUser(@RequestParam String userId){
//        try{
//            cruDservice.getUser(userId);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    @GetMapping("/getuser")
    public User getUser(@RequestParam String DocumentId) {
        try {
            return cruDservice.getUser(DocumentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
