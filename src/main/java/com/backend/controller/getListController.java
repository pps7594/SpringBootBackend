package com.backend.controller;


import com.backend.model.theObject;
import com.backend.service.theObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class getListController {
    @Autowired
    private theObjService service;



    @RequestMapping("/getObjectList")
    public void getObjectList() {


        if (service.getObjectList().isEmpty())
            System.out.println("Empty List");
        else
            service.getObjectList().forEach(System.out::println);

    }

    @RequestMapping("/getObjectById")
    public void getObject(String id) {
        if (id != null) System.out.println(service.getObject(id));
    }

}
