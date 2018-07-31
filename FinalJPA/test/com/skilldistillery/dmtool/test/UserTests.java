package com.skilldistillery.dmtool.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.dmtool.entities.User;

class UserTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User u;
	
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("DMTool");

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		u = em.find(User.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		u = null;
	}

	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();

	}
	
	@Test
	void test_user_mapping() {
		assertEquals("admin@admin.com", u.getEmail());
	}
	
	

}
