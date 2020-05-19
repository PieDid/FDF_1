package com.intiformation.fdf1.lanceur;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.intiformation.fdf1.domain.Adresse;
import com.intiformation.fdf1.domain.Personne;
import com.intiformation.fdf1.repository.AdresseRepository;
import com.intiformation.fdf1.repository.CoursRepository;
import com.intiformation.fdf1.repository.PersonneRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class, 
								   DataSourceTransactionManagerAutoConfiguration.class, 
								   HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.intiformation.fdf1"})
@EnableJpaRepositories("com.intiformation.fdf1.repository")
public class TpEcoleFdf1Application implements CommandLineRunner{

	@Autowired
	private Environment appEnvironment; // pour pointer le fichier application.properties
	
	//déclaration + injection de couche DAO
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private CoursRepository coursRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	//@Autowired
	//private PersonneRepository<Personne> personneRepository;
	
	public static void main(String[] args) {
		ApplicationContext conteneurIoCSpring = SpringApplication.run(TpEcoleFdf1Application.class, args);
		System.out.println("... Lancement de l'application ...");	
	} // end main

	@Override
	public void run(String... args) throws Exception {
		System.out.println("... dans la méthode run()....");
		
//		/*________ Exposition (intégration) de l'id de user dans le ws __________*/
//		repositoryRestConfiguration.exposeIdsFor(User.class);
		
		/*===== TEST DE LA DAO ====*/
	
		//adresseTest(false);  // adresse
		personneTest(true);  // personne
		
		/*============================================*/
		/*================ Personne ==================*/
		/*============================================*/
		
		/*============================================*/
		/*================ Etudiant ==================*/
		/*============================================*/
		
		/*============================================*/
		/*================ Enseignant ================*/
		/*============================================*/
		
		/*============================================*/
		/*================== Cours ===================*/
		/*============================================*/
		
		/*==== Initialisation de la BDD ====*/
		initDataBase();
		
		
	} // end run
	
	/**
	 * initialise la BDD
	 */
	public void initDataBase() {
		
		/*___ adresse ___*/
		
		Adresse a1 = new Adresse("81, rue des Mesanges", "97438", "SAINTE-MARIE");
		Adresse a2 = new Adresse("58, Chemin Du Lavarin Sud", "06200", "NICE");
		Adresse a3 = new Adresse("35, rue des Soeurs", "93120", "LA COURNEUVE");
		Adresse a4 = new Adresse("23, boulevard Aristide Briand", "71200", "LE CREUSOT");
		Adresse a5 = new Adresse("30, rue La Boétie", "75017", "PARIS");
		Adresse a6 = new Adresse("10, rue Saint Germain", "92230", "GENNEVILLIERS");
		
		adresseRepository.save(a1);
		adresseRepository.save(a2);
		adresseRepository.save(a3);
		adresseRepository.save(a4);
		adresseRepository.save(a5);
		adresseRepository.save(a6);
		
		/*___ personne ___*/
		
		Personne p1 = new Personne("Fourquet", "Laure", "0547895264", "laure.audre@gmail.com", "123", adresseRepository.findById(1));
		Personne p2 = new Personne("Fernandes", "André", "0689575324", "andre.fernandes@gmail.com","123",adresseRepository.findById(2));
		Personne p3 = new Personne("Tulliez", "Marie", "0698575324", "marie.tulliez@gmail.com", "1234", adresseRepository.findById(3));
		
		personneRepository.save(p1);
		personneRepository.save(p2);
		personneRepository.save(p3);

		
	} // end initDataBase()
	
	/**
	 * teste les fonctions d'adresse
	 * @param display
	 */
	public void adresseTest(boolean display) {
		
		/*__________ Creation des adresses ___________*/
		
		Adresse a1 = new Adresse("81, rue des Mesanges", "97438", "SAINTE-MARIE");
		Adresse a2 = new Adresse("58, Chemin Du Lavarin Sud", "06200", "NICE");
		Adresse a3 = new Adresse("35, rue des Soeurs", "93120", "LA COURNEUVE");
		Adresse a4 = new Adresse("23, boulevard Aristide Briand", "71200", "LE CREUSOT");
		Adresse a5 = new Adresse("30, rue La Boétie", "75017", "PARIS");
		Adresse a6 = new Adresse("10, rue Saint Germain", "92230", "GENNEVILLIERS");
		
		/*__________ Ajout ___________*/
		
		adresseRepository.save(a1);
		adresseRepository.save(a2);
		adresseRepository.save(a3);
		adresseRepository.save(a4);
		adresseRepository.save(a5);
		adresseRepository.save(a6);
		
		/*__________ GetAll ___________*/
		
		
		List<Adresse> listeAdresse = adresseRepository.findAll();
		if(display) {
			System.out.println("\n== Adresse >>> GetAll =======================");
			for (Adresse a : listeAdresse) {
				System.out.println("\t > " + a);
			}
			System.out.println("=============================================\n\n");
		}
		
		/*__________ GetById ___________*/
		
		
		Adresse a = adresseRepository.findById(1);
		if(display) {
			System.out.println("== Adresse >>> GetById =======================");
			System.out.println("\t > " + a);
			System.out.println("==============================================\n\n");
		}
		
		/*__________ Update ___________*/
		a.setRue("68, rue des Chaligny");
		a.setCodePostal("06200");
		a.setVille("NICE");
		adresseRepository.save(a);
		a = adresseRepository.findById(1);
		if(display) {
			System.out.println("== Adresse >>> Update =======================");
			System.out.println("\t > " + a);
			System.out.println("=============================================\n\n");
		}
		/*__________ Delete ___________*/
		adresseRepository.deleteById(6);
		
		/*____________ Methodes Spécifiques : findByRue ___________*/
		
		
		listeAdresse = adresseRepository.findByRue("35, rue des Soeurs");
		if(display) {
			System.out.println("\n== Adresse >>> findByRue =======================");
			for (Adresse al : listeAdresse) {
				System.out.println("\t > " + al);
			}
			System.out.println("=============================================\n\n");
		}
		/*_________ Methodes Spécifiques : findByCodePostal _______*/
		
		
		listeAdresse = adresseRepository.findByCodePostal("06200");
		if(display) {
			System.out.println("\n== Adresse >>> findByCodePostal =======================");
			for (Adresse al : listeAdresse) {
				System.out.println("\t > " + al);
			}
			System.out.println("=============================================\n\n");
		}
		/*___________ Methodes Spécifiques : findByVille __________*/
		
		
		listeAdresse = adresseRepository.findByVille("NICE");
		if(display) {
			System.out.println("\n== Adresse >>> findByVille =======================");
			for (Adresse al : listeAdresse) {
				System.out.println("\t > " + al);
			}
			System.out.println("=============================================\n\n");
		}
		
		adresseRepository.deleteAll();
		
	} // end AdresseTest
	
	/**
	 * methode de test de Personne
	 * @param display
	 */
	public void personneTest(boolean display) {
		
		/*__________ Creation des adresses (à mettre dans personne) ___________*/
		
		Adresse a1 = new Adresse("81, rue des Mesanges", "97438", "SAINTE-MARIE");
		Adresse a2 = new Adresse("58, Chemin Du Lavarin Sud", "06200", "NICE");
		Adresse a3 = new Adresse("35, rue des Soeurs", "93120", "LA COURNEUVE");
		Adresse a4 = new Adresse("23, boulevard Aristide Briand", "71200", "LE CREUSOT");
		Adresse a5 = new Adresse("30, rue La Boétie", "75017", "PARIS");
		Adresse a6 = new Adresse("10, rue Saint Germain", "92230", "GENNEVILLIERS");
		
		/*__________ Creation des personnes ___________*/
		
		Personne p1 = new Personne("Fourquet", "Laure", "0547895264", "laure.audre@gmail.com", "123", a1);
		Personne p2 = new Personne("Fernandes", "André", "0689575324", "andre.fernandes@gmail.com","123",a2);
		Personne p3 = new Personne("Tulliez", "Marie", "0698575324", "marie.tulliez@gmail.com", "1234", a3);
		
		/*__________ Ajout ___________*/
		
		personneRepository.save(p1);
		personneRepository.save(p2);
		personneRepository.save(p3);
		
		/*__________ GetAll ___________*/
		
		
		List<Personne> listePersonne = personneRepository.findAll();
		if(display) {
			System.out.println("\n== Personne >>> GetAll =======================");
			for (Personne p : listePersonne) {
				System.out.println("\t > " + p);
			}
			System.out.println("=============================================\n\n");
		}
		
		/*__________ GetById ___________*/
		
		
		Personne p = personneRepository.findById(1);
		if(display) {
			System.out.println("== Personne >>> GetById =======================");
			System.out.println("\t > " + p);
			System.out.println("==============================================\n\n");
		}
		
		/*__________ Update ___________*/
		p.setNom("Tautou");
		p.setPrenom("Audrey");
		p.setEmail("audrey.tautou@gmail.com");
		p.setAdresse(a4);
		personneRepository.save(p);
		p = personneRepository.findById(1);
		if(display) {
			System.out.println("== Personne >>> Update =======================");
			System.out.println("\t > " + p);
			System.out.println("=============================================\n\n");
		}
		/*__________ Delete ___________*/
		personneRepository.deleteById(3);
		
		/*____________ Methodes Spécifiques : findByVille ___________*/
//		listePersonne = personneRepository.findAll();
//		if(display) {
//			System.out.println("\n== Personne >>> finByVille =======================");
//			for (Personne p2l : listePersonne) {
//				System.out.println("\t > " + p2l);
//			}
//			System.out.println("=============================================\n\n");
//		}
//		
		
		
	} // end personneTest
	
	
	
	
	/**
	 * creation du bean de la dataSource
	 * @return la datasource de type javax.sql.DataSource
	 * @return
	 */
	@Bean(name="dataSourceBean")
	public DataSource getDataSource() {
		
		// utilisation de l'implémentation de la DS de Spring DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// config de la datasource avec les props de application.properties
		dataSource.setDriverClassName(appEnvironment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(appEnvironment.getProperty("spring.datasource.url"));
		dataSource.setUsername(appEnvironment.getProperty("spring.datasource.username"));
		dataSource.setPassword(appEnvironment.getProperty("spring.datasource.password"));
		
		System.out.println("## bean de la datasource : " + dataSource);
		
		// renvoi de la datasource
		return dataSource;
		
	} // end getDataSource()
	
	/**
	 * création du bean de la sessionFactory. <br/>
	 * Injection du bean de la datasource dans la sessionFactory
	 * @param pDataSource : la dataSource à injecter
	 * @return : une sessionFactory d'hibernate org.hibernate.SessionFactory
	 * @throws IOException 
	 */
	@Autowired // injection du bean de la dataSource dans le param pDataSource
	@Bean(name="entityManagerFactory")
	public SessionFactory getSessionFactory(DataSource pDataSource) throws IOException {
		
		// 1. definition des propriétés d'hibernate de la sessionFactory
		//-> récup des propriétés du fichier application.properties
		Properties properties = new Properties();
		//properties.put(<prop natives d'hibernate>,<valeurs définies dans application.properties>) 		
		properties.put("hibernate.dialect", appEnvironment.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", appEnvironment.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", appEnvironment.getProperty("spring.jpa.hibernate.ddl-auto"));
		
		// 2. définition de la sessionFactory : utilisation de l'implémentation de Spring 'LocalSessionFactoryBean'
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		// 3. config de la session factory
		
		// 3.1. packages contenant les classes entités
		sessionFactoryBean.setPackagesToScan(new String[] {"com.intiformation.fdf1.domain"});
		
		// 3.2. injection de la datasource
		sessionFactoryBean.setDataSource(pDataSource);
		
		// 3.3. définition des propriétés hibernate
		sessionFactoryBean.setHibernateProperties(properties);
		
		// 3.4. validation de la config globale du bean de la sessionFactory
		sessionFactoryBean.afterPropertiesSet();
		
		// 3.5. récup de l'objet de la sessionFactory
		SessionFactory sessionFactory = sessionFactoryBean.getObject();
		
		System.out.println("## ------> session Factory : " + sessionFactory);
		
		return sessionFactory;
		
	} // end getSessionFactory()
	
	/**
	 * création du bean du gestionnaire des transactions. <br/>
	 * injection du bean de la session Factory
	 * @return
	 */
	@Autowired // pour injecter le bean de la sessionFactory dans le paramètre pSessionFactory
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory pSessionFactory) {
		
		// création du bean du tx manager
		HibernateTransactionManager txManager = new HibernateTransactionManager(pSessionFactory);
		
		System.out.println("## ------> tx manager : " +txManager);
		
		// renvoi du tx manager
		return txManager;
		
	} // end getTransactionManager()

} // end class Application
