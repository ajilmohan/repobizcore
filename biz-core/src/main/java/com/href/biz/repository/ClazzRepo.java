package com.href.biz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.href.biz.domain.Clazz;

public interface ClazzRepo extends JpaRepository<Clazz, Serializable>{

}
