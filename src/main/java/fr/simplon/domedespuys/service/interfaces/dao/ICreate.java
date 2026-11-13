package fr.simplon.domedespuys.service.interfaces.dao;

public interface ICreate<T, D> {

    T create(D dto);
}
