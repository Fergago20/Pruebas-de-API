package ni.edu.uam.ejemplo_api.controller;

import ni.edu.uam.ejemplo_api.models.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @PostMapping("/{descuento}")
    public Map<String,String> AgregarProducto(@RequestBody Producto producto,
                                             @PathVariable double descuento){
        double precioFinal = producto.getPrecio() - (producto.getPrecio() * descuento / 100);
        return Map.of(
                "nombre", producto.getNombre(),
                "precio", String.valueOf(precioFinal),
                "descuento", "El descuento es de " + format("%.2f", descuento)
        );
    }
}
