package Probook.DemoSpringHibernate.daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Probook.DemoSpringHibernate.pojos.Customer;

@Repository("custdao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired(required=true)
	private HibernateTemplate hibernateTemplate;

	public CustomerDaoImpl() {}

	@Override
	@Transactional(readOnly=false)
	public void save(final Customer c) {
		//anonymous approach
		/*hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
				Integer iRef = (Integer) session.save(c);
				return iRef;
			}
		});*/

		// short cut approach
		hibernateTemplate.save(c);
	}

	@Override
	public void delete(int eno) {
	}

	@Override
	public Customer get(int eno) {
		return null;
	}

	@Override
	public void update(Customer e) {
	}
}
