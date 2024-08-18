package data;

import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class HitCheckServiceBean {

    @PersistenceContext(unitName = "studsPU")
    private EntityManager entityManager;

    public List<HitCheckData> getAll() {
        Query query = entityManager.createQuery("select entity from HitCheckEntity entity");
        List<HitCheckEntity> resultList = query.getResultList();
        return resultList.stream()
                .map(HitCheckEntity::getHitCheckData)
                .collect(Collectors.toList());
    }

    public void add(HitCheckData hitCheckData) {
        HitCheckEntity entity = new HitCheckEntity(hitCheckData);
        entityManager.persist(entity);
    }

    public void clean() {
        entityManager.createNativeQuery("truncate table hit_checks").executeUpdate();
    }
}
