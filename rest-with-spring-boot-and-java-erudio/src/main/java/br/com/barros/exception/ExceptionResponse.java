package br.com.barros.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details, Integer Status) {}
