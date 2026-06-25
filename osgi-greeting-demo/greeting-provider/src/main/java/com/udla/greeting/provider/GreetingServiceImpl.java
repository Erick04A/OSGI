package com.udla.greeting.provider;

import com.udla.greeting.api.IGreetingService;
import org.osgi.service.component.annotations.Component;

@Component(service = IGreetingService.class, immediate = true)
public class GreetingServiceImpl implements IGreetingService {

    @Override
    public String saludar(String nombre) {
        return "Hola, " + nombre + "! Saludo desde GreetingProvider (Bundle activo).";
    }
}
