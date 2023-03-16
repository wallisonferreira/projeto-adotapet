package br.ufac.adotapet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<RequestMappingInfo> getRoutes() {
        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream().collect(Collectors.toList());
    }
}
