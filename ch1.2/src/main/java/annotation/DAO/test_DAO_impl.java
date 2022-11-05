package annotation.DAO;

import org.springframework.stereotype.Repository;

@Repository("test_DAO_impl") /**相当于©Repository,但如果在 service 层使用©Resource (name="testDaoImpl”)， testDaoImpl不能省略。testDaoImpl为 IoC容器中的对象名**/
public class test_DAO_impl implements test_DAO {
	@Override
	public void save() {
		System.out.println("test dao save");
	}
}
