package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.LostBreadwinner;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface LostBreadWinnerSerivce {
    Result Add(LostBreadwinner breadwinner);

    List<LostBreadwinner> getAll(int page, int size);

    LostBreadwinner getOne(Integer id);

    LostBreadwinner edit(Integer id, LostBreadwinner breadwinner);

    boolean delete(Integer id);
}
