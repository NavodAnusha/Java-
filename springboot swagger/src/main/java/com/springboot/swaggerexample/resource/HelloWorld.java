package com.springboot.swaggerexample.resource;

import com.springboot.swaggerexample.config.product.ProductService;
import com.springboot.swaggerexample.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/product")
@Api(value = "HelloWorld Resource", description = "shows hello world")
public class HelloWorld {

    private ProductService productService;

    @ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World"),
                    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(code = 404, message = "The resource you were trying to reach is not find")
            }
    )
    @GetMapping
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public String hello() {
        return "Hello World";
    }


    @ApiOperation(value = "Returns Hello World")

    @PostMapping("/post")
    public String showProduct(@RequestBody final String hello) {
        return hello;
    }

    @ApiOperation(value = "Returns Hello World")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello) { return hello; }

    @ApiOperation(value = "Returns Hello World")
    @DeleteMapping("/Delete")
    public String helloDelete(@RequestBody final String hello) {return hello;}

    @ApiOperation( value = "Return Hello World")
    @PatchMapping("/Patch")
    public String helloPatch(@RequestBody final String hello ) {return hello;}

    }

