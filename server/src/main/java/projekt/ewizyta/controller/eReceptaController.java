package projekt.ewizyta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.ewizyta.model.Lek;
import projekt.ewizyta.model.User;
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

//    @GetMapping("/api/recepty")
//    public List<eRecepta> getListOfAllSkierowanie() {
//        List<eRecepta> lista = receptaService.getAllSkierowania();
//        for(eRecepta skr : lista) {
//           System.out.println("Tak" + skr.getLekarstwa());
//        }
//
//        return lista;
//    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/lek_add")
    public Lek addLek(@RequestBody Lek lek) throws Exception{
        String tempNazwa = lek.getNazwa();


        //jezeli nazwa nie jest pusta
        if(tempNazwa != null && !"".equals(tempNazwa)) {
            Lek newLek = receptaService.fetchLekByNazwa(tempNazwa);


            //istnieje juz taki lek
            if(newLek != null) {
                throw new Exception("Taki lek juz istnieje w bazie");
            }
        }

        Lek lekObj = null;
        lekObj = receptaService.saveLek(lek);

        return lekObj;

    }
}