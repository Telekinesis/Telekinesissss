package com.ibm.crl.simpledao.executor.jdbctemplate;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateCreator {
	private static final ListableBeanFactory beanFactory = new DefaultListableBeanFactory();
	
	static{
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)beanFactory);
    	Resource resource = new ClassPathResource("jdbctemplate.xml");	         
    	reader.loadBeanDefinitions(resource);
	}
	
	public static JdbcTemplate create(){
		JdbcTemplate template = (JdbcTemplate)beanFactory.getBean("jdbcTemplateByLocalSource");
		return template;
	}
}
