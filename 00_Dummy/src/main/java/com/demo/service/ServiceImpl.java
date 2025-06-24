package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.repository.Repositories;

@Service
public class ServiceImpl {
	private final Repositories repositories;
	
	public ServiceImpl(Repositories repositories) {
		this.repositories = repositories;
	}

	public void test() {
		System.out.println("running......................");
	}
}
