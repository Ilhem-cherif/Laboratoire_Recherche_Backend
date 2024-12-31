package com.member.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.member.demo.beans.PublicationBean;

@FeignClient(name="PUBLICATION")
public interface PublicationServiceProxy {
	@GetMapping("/publications/{id}")
	public PublicationBean findPublicationById(@PathVariable(name="id") Long id);

}
