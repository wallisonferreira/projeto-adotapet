package br.ufac.adotapet.repository.criteria.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.repository.criteria.PetRepositoryCustom;
import br.ufac.adotapet.repository.criteria.params.PetFilterMultiParam;
import br.ufac.adotapet.repository.criteria.params.PetFilterParam;

public class PetRepositoryCustomImpl implements PetRepositoryCustom {

    private EntityManager entityManager;

    public PetRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Pet> getWithFilter(PetFilterParam params) {

        /**
         * First, we get a CriteriaBuilder reference, which we can use to create
         * different parts of the query
         */
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        /**
         * Using the CriteriaBuilder, we create a CriteriaQuery<Pet>, which describes
         * what we want to do in the query. Also, it declares the type of a row in the
         * result
         */
        CriteriaQuery<Pet> query = criteriaBuilder.createQuery(Pet.class);
        /**
         * With CriteriaQuery<Pet> we declare the starting point of the query (Pet
         * entity), and we store it in the Pet variable for later use
         */
        Root<Pet> pet = query.from(Pet.class);

        /**
         * Create a dinamic list of predicates
         */
        List<Predicate> predicates = new ArrayList<>();
        /**
         * Next, with CriteriaBuilder we create predicates against our Pet entity.
         * Note, that these predicates don't have any effect yet
         */

        if (params.getSex() != null) {
            predicates.add(criteriaBuilder.equal(pet.get("sex"), params.getSex()));
        }
        if (params.getColor() != null) {
            predicates.add(criteriaBuilder.equal(pet.get("color"), params.getColor()));
        }
        if (params.getRace() != null) {
            predicates.add(criteriaBuilder.equal(pet.get("race"), params.getRace()));
        }
        if (params.getSize() != null) {
            predicates.add(criteriaBuilder.equal(pet.get("size"), params.getSize()));
        }
        if (params.getSpecie() != null) {
            predicates.add(criteriaBuilder.equal(pet.get("specie"), params.getSpecie()));
        }
        /**
         * We apply both predicates to our CriteriaQuery.
         * CriteriaQuery.where(Predicate…) combines its arguments in a logical and. This
         * is the point when we tie these predicates to the query
         */

        /**
         * Verify the predicates to add in where clause
         */
        if (!predicates.isEmpty()) {
            query.where(predicates.stream().toArray(Predicate[]::new));
        }
        /**
         * After that, we create a TypedQuery<Pet> instance from our CriteriaQuery
         */
        TypedQuery<Pet> queryResult = this.entityManager.createQuery(query);
        /**
         * Finally, we return all matching Pet entities
         */
        return queryResult.getResultList();
    }

    @Override
    public List<Pet> getWithMultiFilter(PetFilterMultiParam params) {
        
        /**
         * First, we get a CriteriaBuilder reference, which we can use to create
         * different parts of the query
         */
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        /**
         * Using the CriteriaBuilder, we create a CriteriaQuery<Pet>, which describes
         * what we want to do in the query. Also, it declares the type of a row in the
         * result
         */
        CriteriaQuery<Pet> query = criteriaBuilder.createQuery(Pet.class);
        /**
         * With CriteriaQuery<Pet> we declare the starting point of the query (Pet
         * entity), and we store it in the Pet variable for later use
         */
        Root<Pet> pet = query.from(Pet.class);
        /**
         * Create a dinamic list of predicates
         */
        List<Predicate> predicates = new ArrayList<>();
        /**
         * Next, with CriteriaBuilder we create predicates against our Pet entity.
         * Note, that these predicates don't have any effect yet
         */

        if (params.getSex() != null && !params.getSex().isEmpty()) {
            predicates.add((pet.get("sex").in(params.getSex())));
            //predicates.add(criteriaBuilder.equal(pet.get("sex"), params.getSex()));
        }
        if (params.getColor() != null && !params.getColor().isEmpty()) {
            predicates.add(pet.get("color").in(params.getColor()));
            //predicates.add(criteriaBuilder.equal(pet.get("color"), params.getColor()));
        }
        if (params.getRace() != null && !params.getRace().isEmpty()) {
            predicates.add(pet.get("race").in(params.getRace()));
            //predicates.add(criteriaBuilder.equal(pet.get("race"), params.getRace()));
        }
        if (params.getSize() != null && !params.getSize().isEmpty()) {
            predicates.add(pet.get("size").in(params.getSize()));
            //predicates.add(criteriaBuilder.equal(pet.get("size"), params.getSize()));
        }
        if (params.getSpecie() != null && !params.getSpecie().isEmpty()) {
            predicates.add(pet.get("specie").in(params.getSpecie()));
            //predicates.add(criteriaBuilder.equal(pet.get("specie"), params.getSpecie()));
        }

        /**
         * We apply both predicates to our CriteriaQuery.
         * CriteriaQuery.where(Predicate…) combines its arguments in a logical and. This
         * is the point when we tie these predicates to the query
         */

        /**
         * Verify the predicates to add in where clause
         */
        if (!predicates.isEmpty()) {
            query.where(predicates.stream().toArray(Predicate[]::new));
        }
        /**
         * After that, we create a TypedQuery<Pet> instance from our CriteriaQuery
         */
        TypedQuery<Pet> queryResult = this.entityManager.createQuery(query);
        /**
         * Finally, we return all matching Pet entities
         */
        return queryResult.getResultList();
    }
}
