package com.benjamin.heystranger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stranger {

    private String name;
    private String avatar;
    private boolean isOnline;

    public Stranger(String name) {
        this.name = name;
    }
}
