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

import com.skilldistillery.dmtool.entities.Monster;

class MonsterTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Monster m;
	
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("DMTool");

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		m = em.find(Monster.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		m = null;
	}

	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();

	}
	
	@Test
	void test_monster_mapping() {
		assertEquals("Goblin", m.getName());
	}
	
	@Test
	void test_monster_mapping_to_user() {
		assertEquals("admin@admin.com", m.getUser().getEmail());
	}
	
	

}
