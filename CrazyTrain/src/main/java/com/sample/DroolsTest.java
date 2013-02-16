package com.sample;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * This is a class to launch rules.
 * 
 * @author Aditi Srinivas
 */
public class DroolsTest {

	/**
	 * The main method
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KnowledgeBase kbase = readKnowledgeBase();
			StatefulKnowledgeSession ksession = kbase
					.newStatefulKnowledgeSession();
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
					.newFileLogger(ksession, "test");

			// Create an object of class computer
			Computer comp1 = new Computer();
			comp1.setCpu(5);
			comp1.setMemory(2);
			comp1.setPrice(800);
			comp1.setCheap(false);
			comp1.setHot(false);
			comp1.setModel("M 1 :: E-fencing");

			// insert the object into the session
			ksession.insert(comp1);
			// Create an object of class computer
			Computer comp2 = new Computer();
			comp2.setCpu(3);
			comp2.setMemory(8);
			comp2.setPrice(1500);
			comp2.setCheap(false);
			comp2.setHot(false);
			comp2.setGraphicsCardType('a');
			comp2.setModel("M 2 :: Durex");

			// insert the object into the session
			ksession.insert(comp2);

			// Create an object of class computer
			Computer comp3 = new Computer();
			comp3.setCpu(1);
			comp3.setMemory(1);
			comp3.setPrice(400);
			comp3.setCheap(false);
			comp3.setHot(false);
			comp3.setModel("M 3 :: Oatmeal");

			// insert the object into the session
			ksession.insert(comp3);

			// Create an object of class computer
			Computer comp4 = new Computer();
			comp4.setCpu(4);
			comp4.setMemory(16);
			comp4.setPrice(3000);
			comp4.setCheap(false);
			comp4.setHot(false);
			comp4.setGraphicsCardType('p');
			comp4.setModel("M 4 :: Metallica");
			// insert the object into the session
			ksession.insert(comp4);

			// Create an object of class computer
			Computer comp5 = new Computer();
			comp5.setCpu(5);
			comp5.setMemory(32);
			comp5.setPrice(8000);
			comp5.setCheap(false);
			comp5.setHot(false);
			comp5.setModel("M 5 :: Aero plane");

			// insert the object into the session
			ksession.insert(comp5);

			// Create an object of class computer
			Computer comp6 = new Computer();
			comp6.setCpu(2);
			comp6.setMemory(2);
			comp6.setPrice(5500);
			comp6.setCheap(false);
			comp6.setHot(false);
			comp6.setGraphicsCardType('p');
			comp6.setModel("M 6 :: Mercedes");
			// insert the object into the session
			ksession.insert(comp6);

			// fire all rules
			ksession.fireAllRules();
			ksession.dispose();
			logger.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * This method reads the rules from the drl file
	 * 
	 * @return
	 * @throws Exception
	 */
	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// give the source of the drl file
		kbuilder.add(ResourceFactory.newClassPathResource("MyRules.drl"),
				ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		// add package to rules
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

}