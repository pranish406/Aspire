package Probook.DemoSpringHibernate.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Probook.DemoSpringHibernate.config.SpringHibernateConfig;
import Probook.DemoSpringHibernate.daos.CustomerDao;
import Probook.DemoSpringHibernate.pojos.Customer;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringHibernateConfig.class})
public class SpringHibernateTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void testSpringHibernate() {
		CustomerDao custDao = (CustomerDao) context.getBean("custdao");
		Customer c = new Customer();
		c.setCno(2);
		c.setCname("Pratap");
		c.setAddress("Pune");
		c.setPhone(7799108899L);
		custDao.save(c);
		System.out.println("Record inserted successfully...");
	}
}
