package com.wcs.start.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.start.start.annotation.ParameterValid;
import com.wcs.start.start.annotation.PathAndQueryParamValid;

/**
 * 参数校验类controller
 *
 * @author pro
 */
@RestController
public class ValidController {

    @GetMapping("/hello")
    public String test() {
        return "ok";
    }

    @PathAndQueryParamValid
    @GetMapping("/path/{isInt}/{isString}")
    public String pathGet(@PathVariable @ParameterValid( msg = "isInt must be more than 2", isMin = true, min = 2) Integer isInt,
                          @PathVariable @ParameterValid( msg = "isString is empty", isInfrared = true) String isString) {

        return "ok";
    }

    @GetMapping("/query")
    @PathAndQueryParamValid
    public String queryGet(@RequestParam @ParameterValid( msg = "isInt must be more than 2 ", isMin = true, min = 2) Integer isInt,
                           @RequestParam @ParameterValid( msg = "isString is empty") String isString) {

        return "ok";
    }

}
