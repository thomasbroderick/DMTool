package com.skilldistillery.dmtool.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.Monster;
import com.skilldistillery.dmtool.entities.User;

public class ImageReader {
MonsterServiceImpl msi;
  public static void main(String[] args) {
    String fileName = "monster_images.txt";
    ImageReader pr = new ImageReader();
    pr.readImages(fileName);
  }

  private void readImages(String fileName) {
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
      EntityManager em = emf.createEntityManager();

      

      
	  
    try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
      String line;
      while ((line = bufIn.readLine()) != null) {
        String[] imagesRecord = line.split(",");
        Monster m = new Monster();
        User u = new User();
        u.setId(1);
        u.setRole("admin");
        int mid = Integer.parseInt(imagesRecord[0]);
        m.setUser(u);
        m.setId(mid);
        m.setImageUrl(imagesRecord[1]);
        em.getTransaction().begin();

        Monster managed = em.find(Monster.class, mid);

        managed.setImageUrl(imagesRecord[1]);

        em.getTransaction().commit();
        
      }
      System.out.println("done");
      em.close();
      emf.close();
    }
    catch (IOException e) {
      System.err.println(e);
    }
  }

}
