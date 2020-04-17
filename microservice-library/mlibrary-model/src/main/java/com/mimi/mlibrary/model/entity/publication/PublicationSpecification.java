package com.mimi.mlibrary.model.entity.publication;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class PublicationSpecification implements Specification<Publication> {

    private Criteria criteria;

    public PublicationSpecification( Criteria criteria ) {
        super();
        this.criteria = criteria;
    }


    @Override
    public Predicate toPredicate( Root<Publication> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder ) {

        //Predicate predicate = cBuilder.disjunction();
        Predicate predicate = cBuilder.conjunction();

        //final Join<Publication, Library> pub = root.join("library",  JoinType.LEFT);


                                                            //and (c.available= true) group by c.library
        if( criteria.getLibId() != 0 ) {


            predicate.getExpressions().add( cBuilder.equal( root.join("copies",  JoinType.LEFT).get("library").get("id"),  criteria.getLibId() ) );

        }

        if( criteria.getAuthorName() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("author").get("firstname"), criteria.getAuthorName() ) );

        }

        if( criteria.getTitle() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("title"), criteria.getTitle() ) );
        }


        if( criteria.getCategory() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("category"), criteria.getCategory() ) );
        }


        /*if( criteria.getTitle() != null && criteria.getAuthorName() != null ) {
            predicate.getExpressions().add( cBuilder.and( cBuilder.equal( root.get("title"), criteria.getTitle() ),
                    cBuilder.equal( root.get("author").get("firstname"), criteria.getAuthorName() )));
        }*/

        if( criteria.getPubDate() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("publicationDate"), criteria.getPubDate() ) );
        }

        if( criteria.getEditorName() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("editor").get("name"), criteria.getEditorName()  ) );
        }

        return predicate;
    }
}
