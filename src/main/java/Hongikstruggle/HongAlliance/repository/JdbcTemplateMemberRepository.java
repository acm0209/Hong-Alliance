package Hongikstruggle.HongAlliance.repository;

import Hongikstruggle.HongAlliance.domain.Store;

import java.sql.Connection;
import java.util.List;

public class JdbcTemplateMemberRepository implements StoreRepository {

    Connection conn = JdbcConnection.getConnection();

    @Override
    public Store save(Store store){


        return null;
    }

    @Override
    public List<Store> findAll() {




        return null;
    }

}