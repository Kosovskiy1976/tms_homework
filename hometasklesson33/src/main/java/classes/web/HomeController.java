package classes.web;

import classes.Film;
import classes.FilmServis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.UUID;

@Controller @RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final FilmServis filmServis;
    private final List<Film> films;

    @GetMapping("home")
    public ModelAndView homeGet() {
        List<Film> films = filmServis.getAll();
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", films);
        return modelAndView;
    }

    @PostMapping("home")
    public ModelAndView homePost(@RequestParam(name = "name") String name,
                        @RequestParam(name = "description") String description,
                        @RequestParam(name = "yearOfRelease") Integer yearOfRelease,
                        @RequestParam(name = "viewed") Boolean viewed) {
        Film film = new Film(name, description, yearOfRelease, viewed);
        filmServis.add(film);
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", films);
        return modelAndView;
    }

    @GetMapping("del")
    public ModelAndView del(@RequestParam(name = "id") String uuid) {
        UUID id = UUID.fromString(uuid);
        filmServis.delete(id);
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", films);
        return modelAndView;
    }

    @GetMapping("edit")
    public ModelAndView editGet(@RequestParam(name = "id") String id) {
        UUID uuid = UUID.fromString(id);
        Film film = filmServis.getById(uuid);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("film", film);
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView editPost(@RequestParam(name = "name") String name,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "yearOfRelease") Integer yearOfRelease,
                           @RequestParam(name = "viewed") Boolean viewed,
                           @RequestParam(name = "id") UUID id) {

        Film film = new Film(name, description, yearOfRelease, viewed);
        filmServis.edit(id, film);
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", films);
        return modelAndView;
    }

}
