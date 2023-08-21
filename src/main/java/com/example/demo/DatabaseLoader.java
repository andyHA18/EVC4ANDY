package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Entidades.Producto;
import com.example.demo.Entidades.VentaLugar;
import com.example.demo.Entidades.VentaDetalle;
import com.example.demo.Repository.ProductoRepository;
import com.example.demo.Repository.VentaDetalleRepository;
import com.example.demo.Repository.VentaRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ProductoRepository repositoryP;
    private final VentaRepository repositoryV;
    private final VentaDetalleRepository repositoryD;

    public DatabaseLoader(ProductoRepository repositoryP, VentaRepository repositoryV,
            VentaDetalleRepository repositoryD) {
        this.repositoryP = repositoryP;
        this.repositoryV = repositoryV;
        this.repositoryD = repositoryD;
    }

    @Override
    public void run(String... strings) throws Exception {

        Producto pro1 = new Producto("CocaCola", 10);
        Producto pro2 = new Producto("Bimbo", 2.5);
        Producto pro3 = new Producto("Pepsi", 3);

        this.repositoryP.save(pro1);
        this.repositoryP.save(pro2);
        this.repositoryP.save(pro3);


        VentaLugar ven1 = new VentaLugar("Arequipa");
        VentaLugar ven2 = new VentaLugar("Lima");
        VentaLugar ven3 = new VentaLugar("Piura");

        this.repositoryV.save(ven1);
        this.repositoryV.save(ven2);
        this.repositoryV.save(ven3);


        VentaDetalle det1 = new VentaDetalle("A001",ven1, pro1, 2);
        VentaDetalle det2 = new VentaDetalle("A002",ven2, pro2, 10);
        VentaDetalle det3 = new VentaDetalle("A003",ven3, pro3, 5);

        this.repositoryD.save(det1);
        this.repositoryD.save(det2);
        this.repositoryD.save(det3);

    }

}