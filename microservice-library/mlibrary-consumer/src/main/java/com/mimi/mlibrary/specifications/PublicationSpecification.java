package com.mimi.mlibrary.specifications;

import com.mimi.mlibrary.model.entity.publication.Criteria;
import com.mimi.mlibrary.model.entity.publication.Publication;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Use Specification interface for Publication in order to do
 * a research according several criteria.
 */
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

        if( criteria.getLibId() != 0 ) {
            predicate.getExpressions().add( cBuilder.equal( root.join("copies",  JoinType.LEFT).get("library").get("id"),  criteria.getLibId() ) );

        }

        if( criteria.getAuthorName() != null ) {
            predicate.getExpressions().add( cBuilder.or(
                    cBuilder.equal( root.get("author").get("firstname"), criteria.getAuthorName()),
                    cBuilder.equal( root.get("author").get("lastname"), criteria.getAuthorName()),
                    cBuilder.equal( root.get("author").get("alias"), criteria.getAuthorName())
            ));
        }

        if( criteria.getTitle() != null ) {
            predicate.getExpressions().add( cBuilder.like( root.get("title"), "%" + criteria.getTitle() + "%") );
        }

        if( criteria.getCategory() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("category"), criteria.getCategory() ) );
        }

        if( criteria.getPubDate() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("publicationDate"), criteria.getPubDate() ) );
        }

        if( criteria.getEditorName() != null ) {
            predicate.getExpressions().add( cBuilder.equal( root.get("editor").get("name"), criteria.getEditorName()  ) );
        }

        return predicate;
    }
}
