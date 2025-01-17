package tn.enis.member.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.enis.member.beans.PublicationBean;

@FeignClient(name = "PUBLICATION-SERVICE")
public interface PublicationProxyService {

    @GetMapping("/publications/{id}")
    public PublicationBean findPublicationById(@PathVariable(name="id") Long id) ;
}
