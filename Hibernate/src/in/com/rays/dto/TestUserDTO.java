package in.com.rays.dto;

import java.util.Date;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUserDTO {

	public static void main(String[] args) {
		
		//testAdd();
		testUpdate();
		//testDelete();
		//testAuthenticate();
		 // testfindByPk();
		//testSearch();
		
		
		
	}
		
		private static void testSearch() {
		UserDTO dto = new UserDTO();
		UserModal modal = new UserModal();
		List list = modal.search(dto);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPass());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
		}
		
		
	}

		private static void testfindByPk() {
			UserModal modal = new UserModal();

			UserDTO dto = modal.findByPk(1);

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPass());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());

		
	}

		private static void testAuthenticate() {
		UserModal modal = new UserModal();
		UserDTO dto =modal.authenticate("sonali@gmail.com", "1234");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPass());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
		} else {
			System.out.println("Authentication failed..!!!!!!");
		}
	}

		private static void testDelete() {
			UserDTO  dto = new UserDTO();
			 dto.setId(3);
			UserModal modal = new UserModal();
			modal.delete( dto);
			
		
		
	}

		private static void testAdd() {
		
		UserDTO dto =new UserDTO();
		 dto.setId(4);
		 dto.setFirstName("ram");
		 dto.setLastName("patel");
		 dto.setLogin("ram@gmail.com");
		 dto.setPass("1234");
		 dto.setDob(new Date());
		 dto.setAddress("indore");
		UserModal model = new UserModal();
		model.add(dto);
	
	}
     private static void testUpdate() {
		UserDTO  dto = new UserDTO();
		 dto.setId(5);
		 dto.setFirstName("moni");
		 dto.setLastName("patel");
		 dto.setLogin("sonali@gmail.com");
		 dto.setPass("1234");
		 dto.setDob(new Date());
		 dto.setAddress("indore");
		 UserModal modal = new UserModal();
		 modal.update(dto);
		
		

	}
}

	