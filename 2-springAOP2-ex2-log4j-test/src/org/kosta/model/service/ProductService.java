package org.kosta.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductService {
	private Logger logger= LogManager.getLogger(getClass());
	public void findProduct() {
		logger.info("findProduct");
	}
	public void register() {
		logger.warn("register");
	}
	public void deleteProduct() {
		logger.debug("deleteProduct");
	}
}

