package com.trung.HeyStranger.service.base;

import com.trung.HeyStranger.model.AbstractModel;

public interface Service<E extends AbstractModel> {
    E insert(E object);
    E update(E object);
    int delete(int id);
}
