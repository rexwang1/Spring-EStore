package pk.habsoft.demo.estore.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class VerifierBean implements BeanFactoryPostProcessor, PriorityOrdered {

	@Override
	public int getOrder() {
		// This will first post processor to be run after context initialization
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// Get Environment bean which contain all properties
		Environment env = beanFactory.getBean(Environment.class);
		System.err.println("Processing VerifierBean:postProcessBeanFactory()");
		if (env.getProperty("estore.property") == null) {
			//throw new ApplicationContextException("Application proprty missing : " + "estore.property");
		}

	}

}
