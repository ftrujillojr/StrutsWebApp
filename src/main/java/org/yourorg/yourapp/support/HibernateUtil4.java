/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorg.yourapp.support;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * This bootstrap works for Hibernate 4.3.11.Final One Session Factory will be
 * created in HibernateResourceAbstract.java and destroyed in SerletContext.java
 * on shutdown.
 *
 * http://www.codejava.net/frameworks/hibernate/building-hibernate-sessionfactory-from-service-registry
 *
 */
public class HibernateUtil4 {

    private static SessionFactory sessionFactory;
    private static boolean debug = true;

    public HibernateUtil4() {
    }

    public static void setDebug(boolean debug) {
        HibernateUtil4.debug = debug;
    }

    /**
     * This will pass back a Singleton instance of SessionFactory
     *
     * @return
     */
    public static SessionFactory getSessionFactory()  {
        if (sessionFactory == null) {
            try {
                // loads configuration and mappings
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

                //configuration.setProperty("hibernate.connection.password", "@ChangeMe123");
                if (debug) {
                    System.out.println("*** Hibernate Configuration loaded");
                }

                ServiceRegistry serviceRegistry
                        = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                if (debug) {
                    System.out.println("*** Hibernate serviceRegistry created");
                }

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                if (debug) {
                    System.out.println("*** Hibernate sessionFactory created");
                }

            } catch (Exception ex) {
                StringBuilder sb = new StringBuilder();
                sb.append(ex.getMessage());
                System.out.println(sb.toString());
            }
        }

        if (sessionFactory != null && debug) {
            System.out.println("\n*** Hibernate: sessionFactory returned.\n");
        }
        return sessionFactory;
    }

    /**
     * ServletContext.java will call this method.
     */
    public static void shutdown() {
        if (sessionFactory != null) {
            getSessionFactory().close();
            if (debug) {
                System.out.println("*** Hibernate shutdown!");
            }
            sessionFactory = null;
        }
    }
}
