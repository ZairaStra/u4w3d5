package zairastra.dao;

import jakarta.persistence.EntityManager;

public class LoansDAO {
    private EntityManager entityManager;

    public LoansDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
}
