package com.udla.greeting.consumer;

import com.udla.greeting.api.IGreetingService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "greeting", name = "saludar", description = "Invoca el servicio de saludo")
public class SaludarCommand implements Action {

    @Reference
    private IGreetingService greetingService;

    @Argument(index = 0, name = "nombre", description = "Nombre de la persona a saludar", required = true, multiValued = false)
    private String nombre;

    @Override
    public Object execute() throws Exception {
        if (greetingService == null) {
            return "Servicio no disponible.";
        }
        return greetingService.saludar(nombre);
    }
}
