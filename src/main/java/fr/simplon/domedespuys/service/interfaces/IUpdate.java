package fr.simplon.domedespuys.service.interfaces;

public interface IUpdate <T,D> {
    T update(String id, D dto);
}
