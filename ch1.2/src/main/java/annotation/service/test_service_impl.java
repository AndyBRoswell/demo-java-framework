package annotation.service;

import annotation.DAO.test_DAO;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("test_service_impl")
public class test_service_impl implements test_service {
	@Resource(name="test_DAO_impl") /**相当于@Autowired, @Autowired默认按照Bean类型注入**/
	private test_DAO test_DAO; // instead of operator new
	@Override
	public void save() {
		test_DAO.save();
		System.out.println("test service save");
	}
}
