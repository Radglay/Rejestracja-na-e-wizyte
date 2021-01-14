package projekt.ewizyta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.service.eReceptaService;

import java.util.List;

@RestController
public class eReceptaController {

    @Autowired
    eReceptaService receptaService;


    @GetMapping("/api/recepty/{email}")
    public List<eRecepta> getListOfSkierowanie(@PathVariable String email) throws Exception {
        return receptaService.fetchByUserEmail(email);
    }

    @GetMapping("/api/recepty")
    public List<eRecepta> getListOfAllSkierowanie() {
        List<eRecepta> lista = receptaService.getAllSkierowania();
        for(eRecepta skr : lista) {
           System.out.println("Tak" + skr.getLekarstwa());
        }

        return lista;
    }
}