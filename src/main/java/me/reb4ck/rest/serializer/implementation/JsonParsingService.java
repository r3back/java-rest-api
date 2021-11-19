package me.reb4ck.rest.serializer.implementation;

import me.reb4ck.rest.serializer.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("parsingService")
public final class JsonParsingService implements ParsingService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T parse(String url, Class<T> tClass) {
        return restTemplate.getForObject(url, tClass);
    }
}
