package br.com.donatti.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.donatti.entities.ErroPadraoVO;
import br.com.donatti.entities.RetornoPadraoErroVO;

/**
 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 21:58:35
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<RetornoPadraoErroVO> handleNoHandlerFoundException(IllegalArgumentException ex, WebRequest request) {
        List<ErroPadraoVO> lstErroPadrao = new ArrayList<>();
        lstErroPadrao.add(new ErroPadraoVO("Recurso não encontrado", HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(new RetornoPadraoErroVO(lstErroPadrao), HttpStatus.NOT_FOUND);
    }

}