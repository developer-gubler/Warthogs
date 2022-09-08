package com.swa.warthogs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.swa.warthogs.data.Warthog;

public interface WarthogRepository extends PagingAndSortingRepository<Warthog, Long> {

}
