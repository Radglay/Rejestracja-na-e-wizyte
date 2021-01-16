package projekt.ewizyta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.Lek;
import projekt.ewizyta.model.User;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.service.UserService;
import projekt.ewizyta.service.eReceptaService;

import java.util.List;

@RestController
public class eReceptaController {
    private int KODY = 1000;

    @Autowired
    eReceptaService receptaService;

    @Autowired
    UserService userService;

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

    //dostajemy (user_id, doctor_id, kod recepty, liste lekarstw)
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("api/recepta_add")
    public eRecepta addRecepta(@RequestBody eRecepta recepta) throws Exception {
        User tempUser = recepta.getUser_data();
        Doctor tempDoctor = recepta.getDoctor_data();
        KODY+=10;
        Long tempKod = (long)KODY;

        if(tempDoctor != null && tempUser != null) { //nie dostalismy null'i
            //szukanie w bazie
            User findUser = userService.fetchUserById(tempUser.getId());
            Doctor findDoctor = userService.fetchDoctorById(tempDoctor.getId());

            if(findUser == null) // nie ma takiego usera w bazie
                throw new Exception("Nie ma uzytkownika o takim id!");

            if(findDoctor == null) // nie ma takiego lekarza w bazie
                throw new Exception("Nie ma lekarza o takim id");
        }
        //jezeli wszystko jest dobrze

        recepta.setKod(tempKod);
        eRecepta receptaObj = null;
        receptaObj = receptaService.saveRecepta(recepta);

        return receptaObj;
    }



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