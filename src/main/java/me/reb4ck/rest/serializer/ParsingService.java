package me.reb4ck.rest.serializer;

public interface ParsingService {
    <T> T parse(String url, Class<T> tClass);
}
