package ni.edu.uam.ejemplo_api.controller;

import ni.edu.uam.ejemplo_api.models.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @PostMapping
    public Map<String,String> AgregarProducto(@RequestBody Producto producto){
        double descuento = producto.getPrecio() * 0.10; // Aplicar un descuento del 10%
        return Map.of(
                "nombre", producto.getNombre(),
                "precio", String.valueOf(producto.getPrecio()),
                "descuento", "El descuento es de " + format("%.2f", descuento)
        );
    }
}
