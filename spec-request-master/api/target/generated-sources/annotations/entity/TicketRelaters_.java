package entity;

import entity.Employees;
import entity.Tickets;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-30T02:22:19")
@StaticMetamodel(TicketRelaters.class)
public class TicketRelaters_ { 

    public static volatile SingularAttribute<TicketRelaters, Employees> employeeId;
    public static volatile SingularAttribute<TicketRelaters, Integer> id;
    public static volatile SingularAttribute<TicketRelaters, Tickets> ticketId;
    public static volatile SingularAttribute<TicketRelaters, Integer> statusRead;

}