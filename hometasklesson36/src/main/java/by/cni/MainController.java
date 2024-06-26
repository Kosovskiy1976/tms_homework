package by.cni;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final DataBaseServis dataBaseServis;

    @GetMapping("find/person")
    public String find(@RequestParam(name = "name") String name) {
        PersonEntity personByName = dataBaseServis.findPersonByName(name);
        return "";
    }

    @GetMapping("person/age")
    public String findPerson(@RequestParam(name = "age") Integer age) {
        List<PersonEntity> persons = dataBaseServis.findPersonByAge(age);
        return "";
    }

    @GetMapping("del/oder")
    public String del(@RequestParam(name = "id") int id) {
        dataBaseServis.deleteOder(id);
        return "";
    }

    @GetMapping("del/person")
    public String delete(@RequestParam(name = "id") int id) {
        dataBaseServis.deletePerson(id);
       return "";
    }

    @GetMapping("save/person")
    public String save(){
        dataBaseServis.savePerson();
        return "";
    }

    @GetMapping("save/oder")
    public String saveOder(@RequestParam(name = "id") int id){
        dataBaseServis.saveOder(id);
        return "";
    }

    @GetMapping("get/oder")
    public String getOder(@RequestParam(name = "id") int id){
        OrderEntity oderById = dataBaseServis.findOderById(id);
        System.out.println(oderById);
        return "";
    }

    @GetMapping("get/person")
    public String getPerson(@RequestParam(name = "id") int id){
        dataBaseServis.findPersonById(id);
        return "";
    }
    @GetMapping("person")
    public String getPersons(){
        dataBaseServis.getAll();
        return "";
    }


}
