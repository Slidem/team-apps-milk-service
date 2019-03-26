package com.teamapps.milkservice.rest.annotation;

import com.teamapps.milkservice.exception.IdEncodingException;
import org.hashids.Hashids;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class IdEncodingUtil {

    private static final Hashids HASHIDS = new Hashids();

    public static Integer decode(String encodedId) {
        try {
            return Math.toIntExact(HASHIDS.decode(encodedId)[0]);
        } catch (Exception e) {
            throw new IdEncodingException(e);
        }
    }

    public static String encode(Integer id) {
        try {
            return HASHIDS.encode(id);
        } catch (Exception e) {
            throw new IdEncodingException(e);
        }

    }
}
