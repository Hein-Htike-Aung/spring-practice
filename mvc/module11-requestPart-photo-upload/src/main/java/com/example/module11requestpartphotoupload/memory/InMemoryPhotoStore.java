package com.example.module11requestpartphotoupload.memory;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class InMemoryPhotoStore {

    private Map<String, Byte[]> photos = new HashMap<>();

    public void save(String originalFileName, byte[] bytes) {
        // using commons.lang3 ArrayUtils
        this.photos.put(originalFileName, ArrayUtils.toObject(bytes));
    }

    public Set<String> getFileNames(){
        return this.photos.keySet();
    }

    public byte[] getFile(String name) {
        return ArrayUtils.toPrimitive(this.photos.get(name));
    }
}
