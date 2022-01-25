package Hongikstruggle.HongAlliance.repository;

import Hongikstruggle.HongAlliance.domain.Store;

import java.util.List;

public interface StoreRepository {

    Store save(Store store);
    List<Store> findAll();

}
