package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.Setting;

public class SettingClient {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		Setting setting = em.find(Setting.class, 1);

		System.out.println(setting);

		em.close();
		emf.close();
		
		
	}

}

