package com.trait.helpers;
import java.util.List;

public interface IBasicCrudFunction <T>{
	public T save(T object);
    public Boolean delete(T object);
    public List<T> findAll();
}
