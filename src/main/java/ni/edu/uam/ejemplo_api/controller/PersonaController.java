package ni.edu.uam.ejemplo_api.controller;

import ni.edu.uam.ejemplo_api.models.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
    @RequestMapping("/api/personas")
public class PersonaController {

    @PostMapping()
    public Map<String, String> validacionEdad(@RequestBody Persona persona) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("nombre", persona.getNombre());
        if (persona.getEdad() >= 18) {
            respuesta.put("mensaje", persona.getNombre() + " Es mayor de edad");
        } else {
            respuesta.put("mensaje", persona.getNombre() + "Es menor de edad");
        }
        return respuesta;
    }
}
