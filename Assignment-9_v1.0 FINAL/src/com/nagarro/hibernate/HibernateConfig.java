package com.nagarro.hibernate;

import java.util.logging.Level;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nagarro.FlightLauncher;
import com.nagarro.util.Constant;

/**
 * This class builds a Hibernate session factory.
 * @author khushbupatel
 *
 */
public class HibernateConfig {

	private static SessionFactory sessionFactory;
	
		static
		{
			try
			{
				StandardServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().configure(Constant.HIBERNATE_CFG_XML).build();
				Metadata metadata=new MetadataSources(serviceRegistry).getMetadataBuilder().build();
				sessionFactory=metadata.getSessionFactoryBuilder().build();	
			}
			catch (Exception e) 
			{
				FlightLauncher.logger.log(Level.SEVERE, Constant.ERROR_HIBERNATE_SESSION_FACTORY, e);
				System.exit(0);
			}
	}
		
	/**
	 * 
	 * @return session factory object
	 */
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}
