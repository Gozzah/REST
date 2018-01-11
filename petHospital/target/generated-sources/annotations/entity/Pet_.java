package entity;

import entity.Event;
import entity.Owner;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-10T16:54:38")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile CollectionAttribute<Pet, Event> eventCollection;
    public static volatile SingularAttribute<Pet, String> death;
    public static volatile SingularAttribute<Pet, String> species;
    public static volatile SingularAttribute<Pet, String> name;
    public static volatile SingularAttribute<Pet, String> birth;
    public static volatile SingularAttribute<Pet, Integer> id;
    public static volatile SingularAttribute<Pet, Owner> ownerId;

}