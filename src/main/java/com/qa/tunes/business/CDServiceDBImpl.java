package com.qa.tunes.business;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.tunes.persistence.CD;
import com.qa.tunes.util.JSONUtil;

@Stateless
@Default
public class CDServiceDBImpl implements CDService {

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllCDs() {
        Query query = manager.createQuery("Select m FROM CD m");
        Collection<CD> cds = (Collection<CD>) query.getResultList();
        return util.getJSONForObject(cds);
    }

    @Override
    public String createCD(String cd) {
        CD aCD = util.getObjectForJSON(cd, CD.class);
        manager.persist(aCD);
        return "{\"message\": \"cd sucessfully added\"}";
    }

    @Override
    public String updateCD(Long id, String cd) {
        CD updatedCD = util.getObjectForJSON(cd, CD.class);
        CD cdInDB = findCD(id);
        updatedCD.setId(id);
        if (cdInDB != null) {
            cdInDB = updatedCD;
            manager.merge(cdInDB);
        }
        return "{\"message\": \"cd sucessfully updated\"}";
    }

    @Override
    public String deleteCD(Long id) {
        CD cdInDB = findCD(id);
        if (cdInDB != null) {
            manager.remove(cdInDB);
        }
        return "{\"message\": \"cd sucessfully deleted\"}";
    }

    private CD findCD(Long id) {
        return manager.find(CD.class, id);
    }

}
