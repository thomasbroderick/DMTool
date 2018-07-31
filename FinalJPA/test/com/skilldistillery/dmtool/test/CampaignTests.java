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

import com.skilldistillery.dmtool.entities.Campaign;

class CampaignTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Campaign c;
	
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("DMTool");

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		c = em.find(Campaign.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		c = null;
	}

	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();

	}
	
	@Test
	void test_campaign_mapping() {
		assertEquals("test campaign", c.getName());
	}
	
	@Test
	void test_camp_mapping_to_player() {
		assertEquals("Legolas the Original", c.getPlayers().get(0).getName());
	}
	
	

}
