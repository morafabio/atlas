package nl.bigo.atlas.controller;

import atlas.Atlas;
import atlas.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final Atlas atlas;

    public ApiController() {
        atlas = new Atlas();
    }

    @GetMapping("/find")
    @ResponseBody
    public City index(@RequestParam(name = "lat") double lat, @RequestParam(name = "lng") double lng) {
        return atlas.find(lat, lng);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<City> findAll(@RequestParam(name = "lat") double lat, @RequestParam(name = "lng") double lng,
                              @RequestParam(name = "limit", defaultValue = "10") int limit,
                              @RequestParam(name = "distance", defaultValue = "10") double distance)
    {
        return atlas.withLimit(limit).withMaxDistance(distance).findAll(lat, lng);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<City> findAll(@RequestParam(name = "lat") double lat, @RequestParam(name = "lng") double lng) {
        return atlas.findAll(lat, lng);
    }
}
