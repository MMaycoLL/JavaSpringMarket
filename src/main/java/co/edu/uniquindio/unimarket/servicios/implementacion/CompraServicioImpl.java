package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.EnvioRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    private final EnvioRepo envioRepo;
    private final ProductoRepo productoRepo;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

        return 0;
    }


    @Override
    public List<CompraGetDTO> listarComprasUsuarios(int idUsuario) {
        List<Compra> compras = compraRepo.findByUsuarioIdUsuario(idUsuario);
        List<CompraGetDTO> compraGetDTOs = new ArrayList<>();

        for (Compra compra : compras) {
            CompraGetDTO dto = convertir(compra);
            compraGetDTOs.add(dto);
        }

        return compraGetDTOs;
    }

    @Override
    public CompraGetDTO obtenerCompra(int idCompra) {
        Compra compra = compraRepo.findById(idCompra).orElse(null);
        if (compra == null) {
            return null;
        }

        return convertir(compra);
    }

    private CompraGetDTO convertir(Compra compra) {
        CompraGetDTO dto = new CompraGetDTO();
        dto.setIdCompra(compra.getIdCompra());
        dto.setFechaCompra(compra.getFechaCompra());
        dto.setTotalCompra(compra.getTotalCompra());
        dto.setIdUsuario(compra.getUsuario().getIdPersona());
        dto.setMetodoPago(compra.getMetodoPago());

        List<DetalleCompraDTO> detalleCompraDTOs = new ArrayList<>();
        for (DetalleCompra detalleCompra : compra.getDetalleCompra()) {
            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
            detalleCompraDTO.setCantidad(detalleCompra.getCantidad());
            detalleCompraDTO.setPrecioCompra(detalleCompra.getPrecioCompra());
            detalleCompraDTO.setIdProducto(detalleCompra.getProducto().getIdProducto());
            detalleCompraDTOs.add(detalleCompraDTO);
        }

        dto.setDetalleCompraDTO(detalleCompraDTOs);
        return dto;
    }

}

