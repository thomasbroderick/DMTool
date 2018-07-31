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

import com.skilldistillery.dmtool.entities.Npc;

class NPCTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Npc n;
	
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("DMTool");

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		n = em.find(Npc.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		n = null;
	}

	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();

	}
	
	@Test
	void test_npc_mapping() {
		assertEquals("Lord Testerson", n.getName());
	}
	
	@Test
	void test_npc_mapping_to_campaign() {
		assertEquals("test campaign", n.getCampaign().getName());
	}
	
	

}
