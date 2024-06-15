package classes.web;

import classes.Film;
import classes.FilmServis;
import classes.errors.ViewedException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.UUID;

@Controller @RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final FilmServis filmServis;

    @GetMapping("home")
    public ModelAndView homeGet(@ModelAttribute(name = "filmmodel") Film film) {
        List<Film> films = filmServis.getAll();
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", films);
        return modelAndView;
    }

    @PostMapping("home")
    public ModelAndView homePost(
    @ModelAttribute(name = "filmmodel") @Valid Film film, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            filmServis.add(film);
        }
        if (!(film.getViewed() instanceof Boolean)) {
            throw new ViewedException("Enter true or false in field viewed");
        }
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", filmServis.getFilms());
        return modelAndView;
    }

    @GetMapping("del")
    public ModelAndView del(@RequestParam(name = "id") String uuid) {
        UUID id = UUID.fromString(uuid);
        filmServis.delete(id);
        ModelAndView modelAndView = new ModelAndView("films");
        modelAndView.addObject("films", filmServis.getFilms());
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
        modelAndView.addObject("films", filmServis.getFilms());
        return modelAndView;
    }

}
