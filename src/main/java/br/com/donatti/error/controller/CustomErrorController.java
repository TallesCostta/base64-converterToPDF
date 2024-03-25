package br.com.donatti.error.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.donatti.utils.Constants;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 22:40:08
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(Constants.ERROR_PATH)
    public String handleError() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

}