package AspectJ.DAO;

import org.springframework.stereotype.Repository;

@Repository("test_DAO")
public class test_DAO_impl implements test_DAO {

	@Override
	public void save() {
		System.out.println("save");
	}
	@Override
	public void modify() {
		System.out.println("modify");
	}
	@Override
	public void delete() {
		System.out.println("delete");
	}
}
