package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class SpringBootMysqlApplicationTests {

	@Test(timeout=800)
	public void test() {
		for (int i=0;i<100000;i++)
		{
			System.out.println("Test");
		}
	}
	
	@Test(timeout=1200)
	public void test2() {
		for (int j=0;j<2000;j++)
		{
			System.out.println("test2");
		}
	}

}
