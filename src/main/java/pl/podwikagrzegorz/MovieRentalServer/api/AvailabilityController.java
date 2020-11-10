package pl.podwikagrzegorz.MovieRentalServer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.podwikagrzegorz.MovieRentalServer.service.ServerResponse;

@RestController
public class AvailabilityController {

    @GetMapping
    public @ResponseBody
    ServerResponse isServerAvailable() {
        return ServerResponse.OK;
    }
}
